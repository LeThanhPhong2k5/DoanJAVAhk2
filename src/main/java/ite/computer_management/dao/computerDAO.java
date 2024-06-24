package ite.computer_management.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Computer;

public class computerDAO implements DAOInterface<Computer> {

	
	 public static computerDAO getInstance() {
	        return new computerDAO();
	    }
		 
	@Override
	public int insert(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Computer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Computer selectById(String t) {
		Computer ketQua = null;
	        try {
	        	ConnectDatabase.getInstance();
	    		Connection connect = ConnectDatabase.getConnection();
	            String sql = "SELECT * FROM computer WHERE computer_Code = ?";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setString(1, t);

	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                String computer_Code = rs.getString("computer_Code");
	                String computer_Name = rs.getString("computer_Name");
	                int quantity = rs.getInt("quantity");
	                java.math.BigInteger price = BigInteger.valueOf( rs.getLong("price"));
	                String cpu_Name = rs.getString("cpu_Name");
	                String ram = rs.getString("ram");
	                String origin = rs.getString("origin");
	                String screen_Card = rs.getString("screen_Card");
	                String rom = rs.getString("rom");
	                ketQua = new Computer(computer_Code, computer_Name, quantity, price, cpu_Name, ram, origin, screen_Card, rom);
	            }
	           	connect.close();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public ArrayList<Computer> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Computer t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}





	public int updateQuantity(String computer_Code, int quantity) {
		 int ketQua = 0;
	        try {
	        	ConnectDatabase.getInstance();
	    		Connection connect = ConnectDatabase.getConnection();
	            String sql = "UPDATE computer SET quantity=? WHERE computer_Code=? ";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setInt(1, quantity);
	            pst.setString(2, computer_Code);
	            ketQua = pst.executeUpdate();
	            connect.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	public ArrayList<Computer> selectAllExist() {
		ArrayList<Computer> ketQua = new ArrayList<Computer>();
        try {
        	ConnectDatabase.getInstance();
    		Connection connect = ConnectDatabase.getConnection();
            String sql = "SELECT computer_Code, computer_Name, quantity, price, cpu_Name, ram, origin, screen_Card, rom FROM computer";
            PreparedStatement pst = connect.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String computer_Code = rs.getString("computer_Code");
                String computer_Name = rs.getString("computer_Name");
                int quantity = rs.getInt("quantity");
                BigInteger price = BigInteger.valueOf(rs.getLong("price"));
                String cpu_Name = rs.getString("cpu_Name");
                String ram = rs.getString("ram");
                String origin = rs.getString("origin");
                String screen_Card = rs.getString("screen_Card");
                String rom = rs.getString("rom");
                Computer mt = new Computer(computer_Code, computer_Name, quantity, price, cpu_Name, ram, origin, screen_Card, rom);
                ketQua.add(mt);
            }
            connect.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
	}

	public int updateSoLuong(String computer_Code, int quantity) {
		  int ketQua = 0;
	        try {
	        	ConnectDatabase.getInstance();
	    		Connection connect = ConnectDatabase.getConnection();
	            String sql = "UPDATE computer SET quantity=? WHERE computer_Code=? ";
	            PreparedStatement pst = connect.prepareStatement(sql);
	            pst.setInt(1, quantity);
	            pst.setString(2, computer_Code);
	            ketQua = pst.executeUpdate();
	            connect.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}
}