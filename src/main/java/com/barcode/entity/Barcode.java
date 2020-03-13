package com.barcode.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "barcode")
public class Barcode {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "cargotrackingcode")
	private String cargoTrackingCode;
	
	@Column(name = "selectdepartman")
	private String selectDepartman;

	@Column(name = "created_at")
	private Date created_at;

	@Column(name="start_date_")
	private String start_date_;
	
	@Column(name = "end_date_")
	private String end_date_;
	

	public Barcode() {
		super();
	}

	public Barcode(String cargoTrackingCode, String selectDepartman, Date created_at, String start_date_,
			String end_date_) {
		super();
		this.cargoTrackingCode = cargoTrackingCode;
		this.selectDepartman = selectDepartman;
		this.created_at = created_at;
		this.start_date_ = start_date_;
		this.end_date_ = end_date_;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getCargoTrackingCode() {
		return cargoTrackingCode;
	}

	public void setCargoTrackingCode(String cargoTrackingCode) {
		this.cargoTrackingCode = cargoTrackingCode;
	}
	
	public String getSelectDepartman() {
		return selectDepartman;
	}

	public void setSelectDepartman(String selectDepartman) {
		this.selectDepartman = selectDepartman;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


	public String getStart_date_() {
		return start_date_;
	}


	public void setStart_date_(String start_date_) {
		this.start_date_ = start_date_;
	}


	public String getEnd_date_() {
		return end_date_;
	}


	public void setEnd_date_(String end_date_) {
		this.end_date_ = end_date_;
	}


	@Override
	public String toString() {
		return "Barcode [id=" + id + ", cargoTrackingCode=" + cargoTrackingCode + ", created_at=" + created_at
				+ ", start_date_=" + start_date_ + ", end_date_=" + end_date_ + "]";
	}
	
}
