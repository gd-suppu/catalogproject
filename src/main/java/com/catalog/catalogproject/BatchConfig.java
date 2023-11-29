package com.catalog.catalogproject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    private String[] FIELDS = new String[]{
            "uniq_id","sku","name_title","description","list_price","sale_price","category","category_tree","average_product_rating","product_url","product_image_urls","brand","total_number_reviews","Reviews"
    };
    @Bean
    public FlatFileItemReader<CatalogInput> reader() {
        return new FlatFileItemReaderBuilder<CatalogInput>()
                .name("CatalogDataReader")
                .resource(new ClassPathResource("jcpsample.csv"))
                .delimited()
                .names(FIELDS)
                .targetType(CatalogInput.class)
                .build();
    }

    @Bean
    public CatalogProcessor processor() {
        return new CatalogProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<CatalogInput> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<CatalogInput>()
                .sql("INSERT INTO product (uniq_id,sku,name_title,description,list_price) VALUES (:uniqId, :sku,:nameTitle,:description,:listPrice)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository, Step step1, JobCompletionNotificationListener listener) {
        return new JobBuilder("importUserJob", jobRepository)
                .listener(listener)
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
                      FlatFileItemReader<CatalogInput> reader, CatalogProcessor processor, JdbcBatchItemWriter<CatalogInput> writer) {
        return new StepBuilder("step1", jobRepository)
                .<CatalogInput, CatalogInput> chunk(3, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
