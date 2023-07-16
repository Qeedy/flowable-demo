package com.flowabledemo.service;

import com.flowabledemo.model.Invoice;

public interface InvoiceService {
	
	public void saveInvoice(String id);
	
	public void updateInvoice(Invoice invoice);
	
	public Invoice getInvoiceByInvoiceNumber(String invoiceNumber);
}
