package com.javainuse.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.javainuse.entity.Stock;
import com.javainuse.listener.NotificationListener;
import com.javainuse.model.StockModel;
import com.javainuse.step.StockProcessor;
import com.javainuse.step.StockWriter;

@Configuration
public class BatchConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	StockProcessor empProcessor;

	@Autowired
	StockWriter employeeWriter;

	@Value("${csvfile}")
	String csvfile;

	@Bean
	public FlatFileItemReader<StockModel> csvAnimeReader() {
		System.out.println("Bean: FlatFileItemReader **********");
		FlatFileItemReader<StockModel> reader = new FlatFileItemReader<StockModel>();
		reader.setResource(new ClassPathResource(csvfile));
		reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<StockModel>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "SYMBOL", "SERIES", "OPEN", "HIGH", "LOW", "CLOSE", "LAST", "PREVCLOSE",
								"TOTTRDQTY", "TOTTRDVAL", "TIMESTAMP", "TOTALTRADES", "ISIN" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<StockModel>() {
					{
						setTargetType(StockModel.class);
					}
				});
			}
		});
		return reader;
	}

	// @Bean
	// ItemProcessor<Employee, Employee> csvAnimeProcessor() {
	// System.out.println("Bean: AnimeProcessor **********");
	// return new AnimeProcessor();
	// }

	// @Bean
	// public JdbcBatchItemWriter<Employee> csvAnimeWriter() {
	// System.out.println("Bean: CsvAnimeWriter **********");
	// JdbcBatchItemWriter<Employee> csvAnimeWriter = new
	// JdbcBatchItemWriter<Employee>();
	// csvAnimeWriter.setItemSqlParameterSourceProvider(new
	// BeanPropertyItemSqlParameterSourceProvider<Employee>());
	// csvAnimeWriter.setSql(
	// "INSERT INTO Employee(id, name, position, office, age, startDate, salary)
	// VALUES (:id, :name, :position, :office, :age, :startDate, :salary)");
	// csvAnimeWriter.setDataSource(dataSource);
	// return csvAnimeWriter;
	// }

	// end reader, writer, and processor

	// begin job info
	@Bean
	public Step csvFileToDatabaseStep() {
		Step step = stepBuilderFactory.get("csvFileToDatabaseStep").<StockModel, Stock>chunk(3).reader(csvAnimeReader())
				// .processor(csvAnimeProcessor())
				.processor(empProcessor).writer(employeeWriter).build();

		return step;
	}

	@Bean
	Job csvFileToDatabaseJob(NotificationListener listener) {
		return jobBuilderFactory.get("csvFileToDatabaseJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(csvFileToDatabaseStep()).end().build();
	}
	// end job info
}
