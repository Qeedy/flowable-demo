package com.flowabledemo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowabledemo.model.Invoice;
import com.flowabledemo.model.enums.InvoiceStatus;
import com.flowabledemo.model.enums.ProcessStatus;
import com.flowabledemo.service.ApprovalService;
import com.flowabledemo.service.InvoiceService;

@Service
public class ApprovalServiceImpl implements ApprovalService {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private InvoiceService invoiceService;

	@Override
	public List<String> getAllApproval() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startProcess(String id) {
		// TODO Auto-generated method stub
		invoiceService.saveInvoice(id);
		runtimeService.startProcessInstanceByKey("invoiceApproval", id);
	}

	@Override
	public void processApproval(String id, String approval) {
		// TODO Auto-generated method stub
		Map<String, Object> variables = new HashMap<>();
		variables.put("approval", approval);
		Task task = taskService.createTaskQuery()
					.processInstanceBusinessKey(id).singleResult();
		taskService.complete(task.getId(), variables);
	}

	@Override
	public void divisionApproved(String id) {
		processUpdateInvoice(id, InvoiceStatus.APPROVED, ProcessStatus.DONE);
	}


	@Override
	public void approvalRejected(String id) {
		processUpdateInvoice(id, InvoiceStatus.REJECTED, ProcessStatus.DONE);
	}

	@Override
	public void receiverApproved(String id) {
		processUpdateInvoice(id, InvoiceStatus.APPROVED, ProcessStatus.DIVISION_APPROVAL);
	}

	private void processUpdateInvoice(String id, 
			InvoiceStatus invoiceStatus, ProcessStatus processStatus) {
		Invoice invoice = invoiceService.getInvoiceByInvoiceNumber(id);
		invoice.setStatus(invoiceStatus);
		invoice.setProcessStatus(processStatus);
		invoiceService.updateInvoice(invoice);
	}
}
