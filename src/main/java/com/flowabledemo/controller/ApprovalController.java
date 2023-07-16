package com.flowabledemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flowabledemo.service.ApprovalService;

@RestController
public class ApprovalController {
	
	@Autowired
	private ApprovalService approvalService;
	
	@PostMapping("/api/start-process-approval")
	public ResponseEntity<Void> startProcess(@RequestParam("businessId") String id) {
		approvalService.startProcess(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/api/approve/{id}")
	public ResponseEntity<Void> approveProcess(@PathVariable("id") String id, @RequestParam("status") String status) {
		try {
			approvalService.processApproval(id, status);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_GATEWAY);
		}
	}
	

}
