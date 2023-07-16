package com.flowabledemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flowabledemo.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	
	public Invoice findByInvoiceNumber(String invoiceNumber);

}
