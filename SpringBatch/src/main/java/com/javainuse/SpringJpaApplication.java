package com.javainuse;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ComponentScan("com.javainuse")
@EnableBatchProcessing
@EnableAutoConfiguration
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);

		SpringJpaApplication obj = new SpringJpaApplication();
		obj.runBatchTask();

	}

	private void runBatchTask() {

		// load the batch config file
		String[] batchConfig = { "batch-task.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(batchConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

		// load the job bean
		Job job = (Job) context.getBean("deleteTask");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Job Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Completed");
	}
}
