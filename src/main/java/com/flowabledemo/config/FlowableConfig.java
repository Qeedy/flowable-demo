package com.flowabledemo.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class FlowableConfig {

	@Bean
	public SpringProcessEngineConfiguration springProcessEngineConfiguration(DataSource dataSource,
			PlatformTransactionManager transactionManager) throws IOException {
		SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		config.setDataSource(dataSource);
		config.setTransactionManager(transactionManager);
		config.setDatabaseSchemaUpdate("true");
		config.setAsyncExecutorActivate(true);
		config.setDeploymentResources(resourcePatternResolver.getResources("classpath*:processes/*.bpmn20.xml"));
		config.buildProcessEngine();
		return config;
	}

	@Bean
    public RuntimeService runtimeService(ProcessEngineConfiguration processEngineConfiguration) {
        return processEngineConfiguration.getRuntimeService();
    }

	@Bean
	public TaskService taskService(ProcessEngineConfiguration processEngineConfiguration) {
		return processEngineConfiguration.getTaskService();
	}

	@Bean
	public RepositoryService repositoryService(ProcessEngineConfiguration processEngineConfiguration) {
		return processEngineConfiguration.getRepositoryService();
	}
}
