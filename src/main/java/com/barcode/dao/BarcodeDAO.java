package com.barcode.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.barcode.entity.Barcode;

public interface BarcodeDAO {
	
	public void saveBarcode(Barcode barcode);
	
	public List<Barcode> getbarcode();
	
	public List<Barcode> getTwoBetweenDate(String start_date_, String end_date_);

	public List<Barcode> getDateValue();
	
	public Barcode findByIdBarcode(int theId);

	public void deleteBarcode(int theId);
}
