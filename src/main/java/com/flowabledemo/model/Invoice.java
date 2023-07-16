package com.flowabledemo.model;

import org.hibernate.annotations.UuidGenerator;

import com.flowabledemo.model.enums.InvoiceStatus;
import com.flowabledemo.model.enums.ProcessStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Invoice {
	
	
	
	public Invoice(String invoiceNum) {
		this.invoiceNumber = invoiceNum;
		this.status = InvoiceStatus.DRAFT;
		this.processStatus = ProcessStatus.RECEIVER_APPROVAL;
	}

	@Id
    @UuidGenerator
    private String id;
	
	@Column
	private String invoiceNumber;
	
	@Column
	private InvoiceStatus status;
	
	@Column
	private ProcessStatus processStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	public ProcessStatus getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(ProcessStatus processStatus) {
		this.processStatus = processStatus;
	}
	
}
