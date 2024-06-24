
package ite.computer_management.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Computer;
import ite.computer_management.model.ExportForm;
import ite.computer_management.model.ImportsForm;
import ite.computer_management.view.ExportProductView;
import ite.computer_management.view.ImportsProductView;

public class ExportsDAO implements DAOInterface<ExportForm> {
	 public ExportsDAO(ExportProductView exportProductView) {
	   }

	   public static ExportsDAO getInstance() {
	      return new ExportsDAO();
	   }
	    
	   public ExportsDAO() {};
	public void display(JTable table) {
		 try {
		        ConnectDatabase.getInstance();
				Connection connection = ConnectDatabase.getConnection();

		        String sql = "SELECT computer_Code, computer_Name, quantity, price FROM computer";
		        try (PreparedStatement p = connection.prepareStatement(sql)) {
		            try (ResultSet re = p.executeQuery()) {
		                DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		                model_table.setRowCount(0);	
		                int stt =1;
		                while (re.next()) {
		                    Object[] row = new Object[]{
		                    		stt++,
		                            re.getString("computer_Code"),
		                            re.getString("computer_Name"),                     
		                            re.getString("quantity"),
		                            re.getString("price"),                   
		                    };
		                    model_table.addRow(row);
		                }
		            }
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } 	
	}
	 public List<String> getFullName() {
	        List<String> getfullname = new ArrayList<>();
	        try {
	        	ConnectDatabase.getInstance();
	            Connection connection = ConnectDatabase.getConnection();
	            String sql = "SELECT fullName FROM account";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        String name = resultSet.getString("fullName");
	                        getfullname.add(name);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return getfullname;
	    }
	 public String[] getProductInfo(String productCode) {
		    String[] productInfo = new String[3]; 
		    try {
		        ConnectDatabase.getInstance();
		        Connection connection = ConnectDatabase.getConnection();
		        String sql = "SELECT computer_Name, quantity, price FROM computer WHERE computer_Code = ?";
		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		            statement.setString(1, productCode);
		            try (ResultSet resultSet = statement.executeQuery()) {
		                if (resultSet.next()) {
		                    productInfo[0] = resultSet.getString("computer_Name");
		                    productInfo[1] = String.valueOf(resultSet.getInt("quantity"));
		                    productInfo[2] = String.valueOf(resultSet.getLong("price"));
		                    System.out.println("click accept from Export Product : Quantify " + productInfo[1] + ",Price  " + productInfo[2]);
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return productInfo;
		}
	 
	 public int updateProductQuantity(String productCode, int newQuantity) {
		    int rowsAffected = 0;
		    try {
		    	ConnectDatabase.getInstance();
		        Connection connec = ConnectDatabase.getConnection();
		        String sql = "UPDATE computer SET quantity = ? WHERE computer_Code = ?";
		        try (PreparedStatement statement = connec.prepareStatement(sql)) {
		            statement.setInt(1, newQuantity);
		            statement.setString(2, productCode);
		            rowsAffected = statement.executeUpdate();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return rowsAffected;
		}

	@Override
	public int insert(ExportForm t) {
		 int ketQua = 0;
	        try {
	        	ConnectDatabase.getInstance();
		        Connection connec = ConnectDatabase.getConnection();
	            String sql = "INSERT INTO exports_coupon (form_Code, time_Start, creator, total_Amount) VALUES (?,?,?,?)";
	            PreparedStatement pst = connec.prepareStatement(sql);
	            pst.setString(1, t.getForm_Code());
	            pst.setTimestamp(2, t.getTime_Start());
	            pst.setString(3, t.getCreator());
	            pst.setObject(4, t.getTotal_Amount());
	            ketQua = pst.executeUpdate();
	            connec.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public int delete(ExportForm t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ExportForm t) {
		int ketQua = 0;
        try {
        	ConnectDatabase.getInstance();
	        Connection connec = ConnectDatabase.getConnection();
            String sql = "UPDATE exports_coupon SET form_Code=?, time_Start=?, creator=?, total_Amount = ? WHERE form_Code=?";
            PreparedStatement pst = connec.prepareStatement(sql);
            pst.setString(1, t.getForm_Code());
            pst.setTimestamp(2, t.getTime_Start());
            pst.setString(3, t.getCreator());
            pst.setObject(4, t.getTotal_Amount());
            pst.setString(5, t.getForm_Code());
            ketQua = pst.executeUpdate();
            connec.close();
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
		        Connection connec = ConnectDatabase.getConnection();
	            String sql = "SELECT * FROM exports_coupon ORDER BY time_Start DESC";
	            PreparedStatement pst = connec.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                String form_Code = rs.getString("form_Code");
	                Timestamp time_Start = rs.getTimestamp("time_Start");
	                String creator = rs.getString("creator");
	                BigInteger total_Amount =  BigInteger.valueOf(rs.getLong("total_Amount"));
	                ExportForm p = new ExportForm(form_Code, time_Start, creator, Details_ExportDAO.getInstance().selectAll(form_Code), total_Amount);
	                ketQua.add(p);
	            }
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
        	ConnectDatabase.getInstance();
	        Connection connec = ConnectDatabase.getConnection();
            String sql = "SELECT * FROM exports_coupon WHERE form_Code=?";
            PreparedStatement pst = connec.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String form_Code = rs.getString("form_Code");
                Timestamp time_Start = rs.getTimestamp("time_Start");
                String creator = rs.getString("creator");
                BigInteger  total_Amount = BigInteger.valueOf(rs.getLong("total_Amount"));
                ketQua = new ExportForm(form_Code, time_Start, creator, Details_ExportDAO.getInstance().selectAll(form_Code), total_Amount);
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
		// TODO Auto-generated method stub
		return 0;
	}

}
