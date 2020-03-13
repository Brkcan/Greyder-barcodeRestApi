package com.barcode.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.barcode.entity.Barcode;

@Repository
public class BarcodeDAOImpl implements BarcodeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public BarcodeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public void saveBarcode(Barcode barcode) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(barcode);
	}

	@Override
	public List<Barcode> getbarcode() {
		Connection conn = null;
		List<Barcode> barcodelist= new ArrayList<Barcode>();
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.46:1433;databaseName=GreyderPortalDB;user=sa;password=A234567b;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("SELECT * FROM [GreyderPortalDB].[dbo].[barcode] WHERE CAST(created_at AS date)=CAST(GETDATE() AS DATE) ORDER BY created_at DESC");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Barcode barcode = new Barcode();
				barcode.setId(rs.getInt("id"));
				barcode.setCargoTrackingCode(rs.getString("cargoTrackingCode"));
				barcode.setCreated_at(rs.getDate("created_at"));
				barcode.setSelectDepartman(rs.getString("selectDepartman"));
				barcodelist.add(barcode);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return barcodelist;
	}

	@Override
	public List<Barcode> getTwoBetweenDate(String start_date_, String end_date_) {
		Connection conn = null;
		Barcode barcode = new Barcode();
		List<Barcode> barcodelist= new ArrayList<Barcode>();
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.46:1433;databaseName=GreyderPortalDB;user=sa;password=A234567b;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("SELECT * FROM [GreyderPortalDB].[dbo].[barcode] WHERE  created_at BETWEEN '"+start_date_+ "' AND '"+end_date_+"'");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				barcode.setCargoTrackingCode(rs.getString("cargoTrackingCode"));
				barcode.setCreated_at(rs.getDate("created_at"));
				barcodelist.add(barcode);
				System.out.println(barcodelist);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return barcodelist;
	}

	@Override
	public List<Barcode> getDateValue() {
		Connection conn = null;
		Barcode barcode = new Barcode();
		List<Barcode> barcodelist= new ArrayList<Barcode>();
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.46:1433;databaseName=GreyderPortalDB;user=sa;password=A234567b;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("SELECT GETDATE() AS created_at");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				 barcode.setCreated_at(rs.getDate("created_at"));
				barcodelist.add(barcode);
				System.out.println(barcodelist);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return barcodelist;
	}
	
	@Override
	public Barcode findByIdBarcode(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Barcode theBarcode = session.get(Barcode.class, theId);
		
		return theBarcode;
	}

	@Override
	public void deleteBarcode(int theId) {
		Connection conn = null;
		Barcode barcode = new Barcode();
		List<Barcode> barcodelist= new ArrayList<Barcode>();
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.46:1433;databaseName=GreyderPortalDB;user=sa;password=A234567b;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("DELETE FROM [GreyderPortalDB].[dbo].[barcode] WHERE id='"+theId+"'");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				 barcode.setCreated_at(rs.getDate("created_at"));
				barcodelist.add(barcode);
				System.out.println(barcodelist);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
	
	
}
