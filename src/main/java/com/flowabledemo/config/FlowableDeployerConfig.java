package com.flowabledemo.config;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;


@Configuration
public class FlowableDeployerConfig {
	
	@Autowired
    private RepositoryService repositoryService;
	@Autowired
    private ResourcePatternResolver resourcePatternResolver;

    public void deployProcesses() throws IOException {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Resource[] bpmnResources = resourcePatternResolver.getResources("classpath*:processes/*.bpmn");
        for (Resource resource : bpmnResources) {
            deploymentBuilder.addInputStream(resource.getFilename(), resource.getInputStream());
        }
        deploymentBuilder.deploy();
        System.out.println("Deploy complete");
    }
}