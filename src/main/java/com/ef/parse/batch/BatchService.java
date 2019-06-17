package com.ef.parse.batch;

import com.ef.parse.model.LogDO;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.springframework.validation.DataBinder;

import javax.persistence.EntityManagerFactory;
import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@EnableBatchProcessing
//@Configuration
public class BatchService {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    EntityManagerFactory emf;

    private static final String DELIMITER = "|";
    private static final String FORMATTER = "yyyy-MM-dd HH:mm:ss.SSS";


    @Bean
    public FlatFileItemReader<LogDO> reader() {

        FlatFileItemReader<LogDO> reader = new FlatFileItemReader<>();

        reader.setResource(new ClassPathResource("access.log"));

        reader.setLineMapper(new DefaultLineMapper<LogDO>() {{
            setLineTokenizer(new DelimitedLineTokenizer(DELIMITER) {{
                setNames(new String[] { "date", "ip", "request", "status", "userAgent" });
            }});
            setFieldSetMapper(new CustomBeanWrapperFieldSetMapper<LogDO>() {{
                setTargetType(LogDO.class);
            }});
        }});

        return reader;
    }


    @Bean
    public JpaItemWriter<LogDO> writer() {

        JpaItemWriter<LogDO> writer = new JpaItemWriter();

        writer.setEntityManagerFactory(emf);

        return writer;
    }

    @Bean(name="importLogJob")
    public Job importUserJob(JobExecutionListener listener) {
        return jobBuilderFactory.get("importLogJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<LogDO, LogDO>chunk(10000)
                .reader(reader())
                .writer(writer())
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobExecutionListener() {


            @Override
            public void beforeJob(JobExecution jobExecution) {
                /**
                 * As of now empty but can add some before job conditions
                 */
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

                    System.out.println("!!! JOB FINISHED! Time to verify the result");

                }
            }
        };
    }

    public class CustomBeanWrapperFieldSetMapper<T> extends BeanWrapperFieldSetMapper<T> {

        @Override
        protected void initBinder(DataBinder binder) {

            DateFormat format = new SimpleDateFormat(FORMATTER);

            binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

                @Override
                public void setAsText(String text) throws IllegalArgumentException {
                    if (!StringUtils.isEmpty(text)) {
                        try {
                            setValue(format.parse(text));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        setValue(null);
                    }
                }

                @Override
                public String getAsText() throws IllegalArgumentException {
                    Object date = getValue();
                    if (date != null) {
                        return format.format((Date) getValue());
                    } else {
                        return "";
                    }
                }
            });
        }
    }
}
