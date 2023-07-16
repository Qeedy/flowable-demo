package com.flowabledemo.service;

import java.util.List;


public interface ApprovalService {
	
	public List<String> getAllApproval();
	
	public String getById();
	
	public void startProcess(String id);
	
	public void processApproval(String id, String approval);
	
	public void divisionApproved(String id);
	
	public void approvalRejected(String id);
	
	public void receiverApproved(String id);
	
}
