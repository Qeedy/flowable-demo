package com.flowabledemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowabledemo.model.Invoice;
import com.flowabledemo.repository.InvoiceRepository;
import com.flowabledemo.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	@Override
	public void saveInvoice(String invoiceNumber) {
		// TODO Auto-generated method stub
		invoiceRepository.save(new Invoice(invoiceNumber));
	}
	
	@Override
	public void updateInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	@Override
	public Invoice getInvoiceByInvoiceNumber(String invoiceNumber) {
		// TODO Auto-generated method stub
		return invoiceRepository.findByInvoiceNumber(invoiceNumber);
	}

}
