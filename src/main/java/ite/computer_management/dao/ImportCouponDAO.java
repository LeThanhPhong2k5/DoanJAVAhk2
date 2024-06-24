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
import javax.swing.table.DefaultTableModel;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Form;
import ite.computer_management.model.ImportsForm;
import ite.computer_management.view.ImportCouponView;

public class ImportCouponDAO implements DAOInterface<ImportsForm>{
	private ImportCouponView importCouponView;
	
	
	public static ImportCouponDAO getInstance() {
		return new ImportCouponDAO();
	}
	public ImportCouponDAO() {
		
	};
	public ImportCouponDAO(ImportCouponView ICV) {
		importCouponView = ICV;
	}
	
	@Override
	public int insert(ImportsForm t) {
		   int ketQua = 0;
	        try {
	        	Connection connect = ConnectDatabase.getInstance().getConnection();
	            String sql = "INSERT INTO import_coupon (form_Code, time_Start, creator, supplier, total_Amount) VALUES (?,?,?,?,?)";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setTimestamp(2, t.getTime_Start());
	            pst.setString(3, t.getCreator());
	            pst.setString(4, t.getSupplier());
	            pst.setObject(5, t.getTotal_Amount());
	            ketQua = pst.executeUpdate();
	            connect.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public int delete(ImportsForm t) {
		   int ketQua = 0;
	        try {
	        	Connection connect = ConnectDatabase.getInstance().getConnection();
	            String sql = "DELETE FROM import_coupon WHERE form_Code=?";
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
	public int update(ImportsForm t) {
		 int ketQua = 0;
	        try {
	        	Connection connect = ConnectDatabase.getInstance().getConnection();
	            String sql = "UPDATE import_coupon SET form_Code=?, time_Start=?, creator=?, supplier=?, total_Amount = ? WHERE form_Code=?";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setTimestamp(2, t.getTime_Start());
	            pst.setString(3, t.getCreator());
	            pst.setString(4, t.getSupplier());
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
	public ArrayList<ImportsForm> selectAll() {
		  ArrayList<ImportsForm> ketQua = new ArrayList<ImportsForm>();
	        try {
	        	ConnectDatabase.getInstance();
				Connection connect = ConnectDatabase.getConnection();
	            String sql = "SELECT * FROM import_coupon ORDER BY time_Start DESC";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                String form_Code = rs.getString("form_Code");
	                Timestamp time_Start = rs.getTimestamp("time_Start");
	                String creator = rs.getString("creator");
	                String supplier_Code = rs.getString("supplier_Code");
	                BigInteger total_Amount = BigInteger.valueOf(rs.getLong("total_Amount"));
	                ImportsForm p = new ImportsForm(supplier_Code, form_Code, time_Start, creator, Details_ImportDAO.getInstance().selectAll(supplier_Code), total_Amount);
	                ketQua.add(p);
	            }
	            connect.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}


	@Override
	public ArrayList<ImportsForm> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ImportsForm t, String condition) {
		  int ketQua = 0;
	        try {
	        	Connection connect = ConnectDatabase.getInstance().getConnection();
	            String sql = "UPDATE import_coupon SET form_Code=?, time_start=?, creator=?, supplier_Code=?, total_Amount = ? WHERE form_Code=?";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setTimestamp(2, t.getTime_Start());
	            pst.setString(3, t.getCreator());
	            pst.setString(4, t.getSupplier());
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
	public ImportsForm selectById(String t) {
		ImportsForm ketQua = null;
        try {
        	Connection connect = ConnectDatabase.getInstance().getConnection();
            String sql = "SELECT * FROM import_coupon WHERE form_Code=?";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String form_Code = rs.getString("form_Code");
                Timestamp time_Start = rs.getTimestamp("time_Start");
                String creator = rs.getString("creator");
                String supplier_Code = rs.getString("supplier_Code");
                BigInteger total_Amount = BigInteger.valueOf(rs.getLong("total_Amount"));
                ketQua = new ImportsForm(supplier_Code, form_Code, time_Start, creator, Details_ImportDAO.getInstance().selectAll(form_Code), total_Amount);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
	}
	

}
