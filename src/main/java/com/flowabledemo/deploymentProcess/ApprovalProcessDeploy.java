package com.flowabledemo.deploymentProcess;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApprovalProcessDeploy {
	
	@Autowired
    private RepositoryService repositoryService;

    public void deployProcessDefinition() {
        // Mendeploy definisi proses ke mesin proses Flowable
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/invoice-approval.bpmn20.xml")
                .deploy();

        // Menampilkan informasi deployment
        System.out.println("Deployment ID: " + deployment.getId());
        System.out.println("Deployment Name: " + deployment.getName());
    }
}