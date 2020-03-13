package com.barcode.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.barcode.dao.BarcodeDAO;
import com.barcode.entity.Barcode;

@Service
public class BarcodeServiceImpl implements BarcodeService{
	
	private BarcodeDAO barcodeDAO;
	
	public BarcodeServiceImpl(BarcodeDAO theBarcodeDAO) {
		barcodeDAO = theBarcodeDAO;
	}

	@Override
	public void saveBarcode(Barcode barcode) {
		barcodeDAO.saveBarcode(barcode);
	}

	@Override
	public List<Barcode> getbarcode() {
		return barcodeDAO.getbarcode();
	}

	@Override
	public List<Barcode> getTwoBetweenDate(String start_date_, String end_date_) {
		return barcodeDAO.getTwoBetweenDate(start_date_, end_date_);
	}

	@Override
	public List<Barcode> getDateValue() {
		return barcodeDAO.getDateValue();
	}

	@Override
	public Barcode findByIdBarcode(int theId) {
		return barcodeDAO.findByIdBarcode(theId);
	}

	
	@Override
	public void deleteBarcode(int theId) {
		barcodeDAO.deleteBarcode(theId);
	}

	
}
