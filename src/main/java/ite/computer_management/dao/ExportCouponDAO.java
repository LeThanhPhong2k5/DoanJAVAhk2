package ite.computer_management.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.ExportForm;
import ite.computer_management.model.Form;
import ite.computer_management.model.ImportsForm;
import ite.computer_management.view.ExportCouponView;
import ite.computer_management.view.ImportCouponView;

public class ExportCouponDAO implements DAOInterface<ExportForm>{
	public static ExportCouponDAO getInstance() {
		return new ExportCouponDAO();
	}
	public ExportCouponDAO() {
		
	};
	public ExportCouponDAO(ExportCouponView exportCouponView) {
	}
	
	@Override
	public int insert(ExportForm t) {
		   int ketQua = 0;
	        try {
	        	Connection connect = ConnectDatabase.getInstance().getConnection();
	            String sql = "INSERT INTO exports_coupon (form_Code, time_Start, creator, total_Amount) VALUES (?,?,?,?)";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setTimestamp(2, t.getTime_Start());
	            pst.setString(3, t.getCreator());
	            pst.setObject(4, t.getTotal_Amount());
	            ketQua = pst.executeUpdate();
	            connect.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public int delete(ExportForm t) {
		   int ketQua = 0;
	        try {
	        	Connection connect = ConnectDatabase.getInstance().getConnection();
	            String sql = "DELETE FROM exports_coupon WHERE form_Code=?";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            ketQua = pst.executeUpdate();
	            connect.close();
	            JOptionPane.showMessageDialog(null, "Delete successfully ");
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public int update(ExportForm t) {
		 int ketQua = 0;
	        try {
	        	Connection connect = ConnectDatabase.getInstance().getConnection();
	            String sql = "UPDATE exports_coupon SET form_Code=?, time_Start=?, creator=?, total_Amount = ? WHERE form_Code=?";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setTimestamp(2, t.getTime_Start());
	            pst.setString(3, t.getCreator());
	            pst.setObject(4, t.getTotal_Amount());
	            pst.setString(5, t.getForm_Code());
	            ketQua = pst.executeUpdate();
	            connect.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public ArrayList<ExportForm> selectAll() {
		  ArrayList<ExportForm> ketQua = new ArrayList<ExportForm>();
	        try {
	        	ConnectDatabase.getInstance();
				Connection connect = ConnectDatabase.getConnection();
	            String sql = "SELECT * FROM exports_coupon ORDER BY time_Start DESC";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                String form_Code = rs.getString("form_Code");
	                Timestamp time_Start = rs.getTimestamp("time_Start");
	                String creator = rs.getString("creator");
	                BigInteger  total_Amount = BigInteger.valueOf(rs.getLong("total_Amount"));
	                ExportForm p = new ExportForm( form_Code, time_Start, creator, Details_ExportDAO.getInstance().selectAll(form_Code), total_Amount);
	                ketQua.add(p);
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}


	@Override
	public ArrayList<ExportForm> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ExportForm t, String condition) {
		  int ketQua = 0;
	        try {
	        	Connection connect = ConnectDatabase.getInstance().getConnection();
	            String sql = "UPDATE exports_coupon SET form_Code=?, time_start=?, creator=?, total_Amount = ? WHERE form_Code=?";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setTimestamp(2, t.getTime_Start());
	            pst.setString(3, t.getCreator());
	            pst.setObject(5, t.getTotal_Amount());
	            pst.setString(6, t.getForm_Code());
	            ketQua = pst.executeUpdate();
	            connect.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}
	@Override
	public ExportForm selectById(String t) {
		ExportForm ketQua = null;
        try {
        	Connection connect = ConnectDatabase.getInstance().getConnection();
            String sql = "SELECT * FROM exports_coupon WHERE form_Code=?";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String form_Code = rs.getString("form_Code");
                Timestamp time_Start = rs.getTimestamp("time_Start");
                String creator = rs.getString("creator");
                BigInteger total_Amount = BigInteger.valueOf(rs.getLong("total_Amount"));
                ketQua = new ExportForm( form_Code, time_Start, creator, Details_ExportDAO.getInstance().selectAll(form_Code), total_Amount);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
	}
}
