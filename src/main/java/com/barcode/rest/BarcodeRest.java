package com.barcode.rest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.entity.Barcode;
import com.barcode.service.BarcodeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BarcodeRest {

	private BarcodeService barcodeService;
	
	@Autowired
	public BarcodeRest(BarcodeService theBarcodeService) {
		barcodeService = theBarcodeService;
	}
	
	@PostMapping(value = "/insertbarcode", produces = MediaType.APPLICATION_JSON_VALUE)
	public Barcode saveBarcode(@RequestBody Barcode barcode) {
		barcode.setId(0);
		barcode.setCreated_at(new Date());
		barcodeService.saveBarcode(barcode);
		return barcode;
	}
	@GetMapping(value = "/getbarcode")
	public List<Barcode> getBarcodeList(){
		return barcodeService.getbarcode();
	}
	
	@GetMapping(value = "/gettwodatebetween/{start_date_}/{end_date_}")
	public List<Barcode> getTwoBetweenList(@PathVariable(value = "start_date_") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fromDate,
					@PathVariable(value = "end_date_") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String toDate){
		return barcodeService.getTwoBetweenDate(fromDate, toDate);
	}
	
	@GetMapping(value = "/getValueDate")
	public List<Barcode> getDateValue(){
		return barcodeService.getDateValue();
	}
	
	@GetMapping(value = "/getById/{barcodeId}")
	public Barcode getById(@PathVariable int barcodeId) {
		Barcode theBarcode = barcodeService.findByIdBarcode(barcodeId);
		
		return theBarcode;
	}
	
	@DeleteMapping(value = "/deletebarcode/{barcodeId}")
	public String deleteBarcodeRestService(@PathVariable int barcodeId) {
		Barcode theBarcode = barcodeService.findByIdBarcode(barcodeId);
		barcodeService.deleteBarcode(barcodeId);
		return "" + barcodeId;
	}
}
