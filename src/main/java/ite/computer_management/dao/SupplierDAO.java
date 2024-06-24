package ite.computer_management.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Supplier;
import ite.computer_management.view.SupplierView;

public class SupplierDAO implements DAOInterface<Supplier> {
    private SupplierView SupplierView;

    public SupplierDAO() {}

    public SupplierDAO(SupplierView SV) {
        this.SupplierView = SV;
    }

    public static SupplierDAO getInstance() {
        return new SupplierDAO();
    }

    @Override
    public int insert(Supplier t) {
    	int check = 0;
		ConnectDatabase.getInstance();
		Connection connect = ConnectDatabase.getConnection();
		try {
			String sql = "INSERT INTO supplier" + " VALUE"		
					+ "(?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getSupplier_Code());    // setString--> first Parameter is 1
			ps.setString(2, t.getSupplier_Name());
			ps.setString(3, t.getPhone_Number());
			ps.setString(4, t.getAddress());
	
			check = ps.executeUpdate();	
			connect.close();
			System.out.println(sql);
			JOptionPane.showMessageDialog(null, "Insert successfully ><");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			JOptionPane.showMessageDialog(null, "Supplier code already exist");
		}
		return check;
    }

    @Override
    public int delete(Supplier t) {
    	int check = 0;
		ConnectDatabase.getInstance();
		Connection connect = ConnectDatabase.getConnection();
		String sql = "DELETE FROM supplier WHERE supplier_Code=?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getSupplier_Code());
			check = ps.executeUpdate();
			connect.close();
			JOptionPane.showMessageDialog(null, "Delete successfully ");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " +e);
		}
		
		return check;
    }

	public int updateWithCondition(Supplier t, String condition) {
		int check = 0;
		ConnectDatabase.getInstance();
		Connection connect = ConnectDatabase.getConnection();
		String sql = "UPDATE supplier SET supplier_Name=?, phone_Number=?, address=? WHERE supplier_Code=?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, t.getSupplier_Name());
			ps.setString(2, t.getPhone_Number());
			ps.setString(3, t.getAddress());
			ps.setString(4, condition);
			check = ps.executeUpdate();
			System.out.println("so dong thay doi :" + check);
			connect.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Edit unsuccessfully");
		}
		return check;
	}


    @Override
    public ArrayList<Supplier> selectAll() {
        ArrayList<Supplier> ketQua = new ArrayList<>();
        ConnectDatabase.getInstance();
		try (Connection connect = ConnectDatabase.getConnection()) {
            String sql = "SELECT * FROM supplier";
            try (PreparedStatement pst = connect.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String supplier_Code = rs.getString("supplier_Code");
                    String supplier_Name = rs.getString("supplier_Name");
                    String phone_Number = rs.getString("phone_Number");
                    String address = rs.getString("address");
                    Supplier sup = new Supplier(supplier_Code, supplier_Name, phone_Number, address);
                    ketQua.add(sup);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return ketQua;
    }
    public void display(JTable table) {
		 try {
		        ConnectDatabase.getInstance();
				Connection connection = ConnectDatabase.getConnection();

		        String sql = "SELECT * FROM supplier";
		        try (PreparedStatement p = connection.prepareStatement(sql)) {
		            try (ResultSet re = p.executeQuery()) {
		                DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		                model_table.setRowCount(0);	
		                while (re.next()) {
		                    Object[] row = new Object[]{
		                 		
		                            re.getString("supplier_Code"),
		                            re.getString("supplier_Name"),                     
		                            re.getString("phone_Number"),
		                            re.getString("address"),   
		                    };
		                    model_table.addRow(row);
		                }
		            }
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } 	
	}
    public Supplier selectById(String t) {
        Supplier ketQua = null;
        ConnectDatabase.getInstance();
		try (Connection connect = ConnectDatabase.getConnection()) {
            String sql = "SELECT * FROM supplier WHERE supplier_Code=?";
            try (PreparedStatement pst = connect.prepareStatement(sql)) {
                pst.setString(1, t);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String supplier_Code = rs.getString("supplier_Code");
                        String supplier_Name = rs.getString("supplier_Name");
                        String phone_Number = rs.getString("phone_Number");
                        String address = rs.getString("address");
                        ketQua = new Supplier(supplier_Code, supplier_Name, phone_Number, address);
                    }
                }
            }
            connect.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return ketQua;
    }

    @Override
    public ArrayList<Supplier> selectByCondition(String condition) {
        return null;
    }

    @Override
    public int update(Supplier t, String condition) {
        return 0;
    }

	@Override
	public int update(Supplier t) {
		return 0;
	}
}
