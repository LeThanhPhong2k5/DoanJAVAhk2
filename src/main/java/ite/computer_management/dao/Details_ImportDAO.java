package ite.computer_management.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Details_Form;

public class Details_ImportDAO implements DAOInterface<Details_Form>{

	 public static Details_ImportDAO getInstance() {
	        return new Details_ImportDAO();
	    }
	
	
	@Override
	public int insert(Details_Form t) {
	    int ketQua = 0;
	    try (Connection connect = ConnectDatabase.getInstance().getConnection();
	         PreparedStatement pst = connect.prepareStatement(
	             "INSERT INTO detail_imports_coupon (form_Code, computer_Code, quantity, unit_price) " + 
	             "VALUES (?, ?, ?, ?) " +
	             "ON DUPLICATE KEY UPDATE quantity = VALUES(quantity) + quantity, unit_price = VALUES(unit_price)")) {

	        pst.setString(1, t.getForm_Code());
	        pst.setString(2, t.getComputer_Code());
	        pst.setInt(3, t.getQuantity());
	        pst.setObject(4, t.getUnit_Price());

	        ketQua = pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketQua;
	}

	
	private boolean isFormCodeValid(Connection con, String formCode) {
	    boolean isValid = false;
	    try {
	        String sql = "SELECT form_Code FROM import_coupon WHERE form_Code = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, formCode);
	        ResultSet rs = pst.executeQuery();
	        isValid = rs.next(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return isValid;
	}


	@Override
	public int delete(Details_Form t) {
		 int ketQua = 0;
	        try {
	        	ConnectDatabase.getInstance();
	  			Connection con = ConnectDatabase.getConnection();
	            String sql = "DELETE FROM detail_imports_coupon WHERE form_Code=?";
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            ketQua = pst.executeUpdate();
	            con.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public int update(Details_Form t) {
		 int ketQua = 0;
	        try {
	        	ConnectDatabase.getInstance();
	  			Connection con = ConnectDatabase.getConnection();
	            String sql = "UPDATE detail_imports_coupon SET form_Code=?, computer_Code=?, quantity=?, unit_price = ?  WHERE form_Code=? AND computer_Code=?";
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setString(2, t.getComputer_Code());
	            pst.setInt(3, t.getQuantity());
	            pst.setObject(4, t.getUnit_Price());
	            pst.setString(5, t.getForm_Code());
	            pst.setString(6, t.getComputer_Code());
	            ketQua = pst.executeUpdate();
	            con.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public ArrayList<Details_Form> selectAll() {
		  ArrayList<Details_Form> ketQua = new ArrayList<Details_Form>();
	        try {
	        	ConnectDatabase.getInstance();
	  			Connection con = ConnectDatabase.getConnection();
	            String sql = "SELECT * FROM detail_imports_coupon";
	            PreparedStatement pst = con.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                String form_Code = rs.getString("form_Code");
	                String computer_Code = rs.getString("computer_Code");
	                int quantity = rs.getInt("quantity");
	                BigInteger unit_price = BigInteger.valueOf(rs.getLong("unit_price"));
	                Details_Form ctp = new Details_Form(form_Code, computer_Code, quantity, unit_price);
	                ketQua.add(ctp);
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}


	@Override
	public ArrayList<Details_Form> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Details_Form t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}
	public ArrayList<Details_Form> selectAll(String t) {
        ArrayList<Details_Form> ketQua = new ArrayList<Details_Form>();
        try {
            ConnectDatabase.getInstance();
			Connection con = ConnectDatabase.getConnection();
            String sql = "SELECT * FROM detail_imports_coupon WHERE form_Code=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String form_Code = rs.getString("form_Code");
                String computer_Code = rs.getString("computer_Code");
                int quantity = rs.getInt("quantity");
                BigInteger unit_price = BigInteger.valueOf( rs.getLong("unit_price"));
                Details_Form ctp = new Details_Form(form_Code, computer_Code, quantity, unit_price);
                ketQua.add(ctp);
            }
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }


	@Override
	public Details_Form selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
