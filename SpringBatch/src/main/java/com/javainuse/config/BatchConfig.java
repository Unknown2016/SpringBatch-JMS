package com.javainuse.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javainuse.listener.JobCompletionListener;
import com.javainuse.step.Processor;
import com.javainuse.step.Reader;
import com.javainuse.step.Writer;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		Job j1 = jobBuilderFactory.get("processJob").incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
		System.out.println("*****job = " + j1);
		return j1;
	}

	@Bean
	public Step orderStep1() {
		Step s1 = stepBuilderFactory.get("orderStep1").<String, String>chunk(1).reader(new Reader())
				.processor(new Processor()).writer(new Writer()).build();

		System.out.println("*****step = " + s1);

		return s1;
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}
