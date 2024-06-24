
package ite.computer_management.view;

import java.awt.EventQueue; 

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.sql.Timestamp;

import ite.computer_management.controller.Edit_ImportsCoupon_Controller;
import ite.computer_management.controller.Imports_productController;
import ite.computer_management.controller.WirtePDF_File;
import ite.computer_management.dao.Details_ImportDAO;
import ite.computer_management.dao.ImportCouponDAO;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.dao.computerDAO;
import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Account;
import ite.computer_management.model.Computer;
import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ImportsForm;
import ite.computer_management.model.Supplier;
import lombok.var;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Edit_ImportsCouponView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextField TF_Sreach;
	public JTextField TF_Form;
	public JTable table_Product;
	public JTable table_Imports;
	public JTextField TF_Quantity;
	private JLabel text_totalAmount;
	public JButton btn_DeleteProduct;
	private ImportCouponDAO ImportCouponDAO;
	private ImportDAO Imports_DAO;
	public JButton btn_accept;
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	public JComboBox Combo_Supplier;
	private String form_Code;
	private static final ArrayList<Supplier> arrNcc = SupplierDAO.getInstance().selectAll();
	private ArrayList<Details_Form> Details_Form;
	private ArrayList<Details_Form> Details_Form_old;
	public JButton btn_save;
	private ImportCouponView ICF;
	public JButton btn_back;
	 private String formCode;
	public ImportsForm importform;
	public JTextField creator_txt;

	
	public Edit_ImportsCouponView(ImportCouponView ICF, ArrayList<Details_Form> Details_Form, String form_code) {
		init();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		this.setLocationRelativeTo(null);
		this.form_Code = form_code;
		TF_Form.setText(form_Code);
		
		loadDataToTableProduct(ICF);	
		this.ICF = (ImportCouponView) ICF;
		this.importform = this.ICF.getPhieuNhapSelect();
		this.Details_Form = Details_ImportDAO.getInstance().selectAll(importform.getForm_Code());
		this.Details_Form_old = Details_ImportDAO.getInstance().selectAll(importform.getForm_Code());
	}
	public void init() {
		ImportCouponDAO = new ImportCouponDAO();
		Edit_ImportsCoupon_Controller edit_ImportsCoupon_Controller = new Edit_ImportsCoupon_Controller(this);
		Imports_DAO = new ImportDAO();
		getContentPane().setBackground(new Color(70, 163, 100));
		this.setSize(1250,595);
		getContentPane().setLayout(null);

		creator_txt = new JTextField();
		creator_txt.setColumns(10);
		creator_txt.setBounds(600, 112, 349, 28);
		creator_txt.setEditable(false);
		getContentPane().add(creator_txt);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(22, 10, 446, 78);
		getContentPane().add(verticalBox);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1.setBounds(504, 10, 722, 155);
		getContentPane().add(verticalBox_1);
		TF_Sreach = new JTextField();
		TF_Sreach.setBounds(37, 49, 282, 28);
		getContentPane().add(TF_Sreach);
		TF_Sreach.setColumns(10);
		
		btn_back = new JButton("Back");
		btn_back.setIcon(new ImageIcon(Edit_ImportsCouponView.class.getResource("/ite/computer_management/img/icons8-cancel-30.png")));
		btn_back.setForeground(Color.BLACK);
		btn_back.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_back.setBackground(Color.LIGHT_GRAY);
		btn_back.setBounds(862, 488, 160, 41);
		getContentPane().add(btn_back);
		btn_back.addMouseListener(edit_ImportsCoupon_Controller);
		
		JLabel lblNewLabel = new JLabel("Sreach:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 26, 90, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFrom = new JLabel("Form:");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(518, 26, 90, 13);
		getContentPane().add(lblFrom);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setForeground(Color.WHITE);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupplier.setBounds(518, 75, 90, 13);
		getContentPane().add(lblSupplier);
		
		JLabel lblCreator = new JLabel("Creator:");
		lblCreator.setForeground(Color.WHITE);
		lblCreator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreator.setBounds(518, 114, 90, 13);
		getContentPane().add(lblCreator);
		
		TF_Form = new JTextField();
		TF_Form.setColumns(10);
		TF_Form.setBounds(600, 26, 349, 28);
		TF_Form.setEditable(false);
		getContentPane().add(TF_Form);
		
		table_Product = new JTable();
		table_Product.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Code", "Name", "Quantity", "Price"
			}
		));
		table_Product.getColumnModel().getColumn(0).setPreferredWidth(54);
		table_Product.getColumnModel().getColumn(1).setPreferredWidth(42);
		table_Product.getColumnModel().getColumn(2).setPreferredWidth(168);
		table_Product.getColumnModel().getColumn(3).setPreferredWidth(53);
		table_Product.getColumnModel().getColumn(4).setPreferredWidth(43);

		table_Product.addMouseListener(new MouseAdapter() {
			public int r;

			@Override
			public void mouseClicked(MouseEvent e) {
				r= table_Product.getSelectedRow();
				if(r!=-1) {
					TF_Quantity.setText(table_Product.getValueAt(r, 3)+"");
			      
				}
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane(table_Product);
		scrollPane.setBounds(22, 107, 446, 385);
		getContentPane().add(scrollPane);
		
		table_Imports = new JTable();
		table_Imports.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Number", "Code ", "Name", "Quantity", "Price"
			}
		));
		table_Imports.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_Imports.getColumnModel().getColumn(1).setPreferredWidth(57);
		table_Imports.getColumnModel().getColumn(2).setPreferredWidth(185);
		table_Imports.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_Imports.getColumnModel().getColumn(4).setPreferredWidth(37);
		table_Imports.setBounds(553, 203, 1, 1);
		getContentPane().add(table_Imports);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_Imports);
		scrollPane_1.setBounds(512, 176, 700, 274);
		getContentPane().add(scrollPane_1);
		
		 Combo_Supplier = new JComboBox();
		Combo_Supplier.setBounds(600, 69, 349, 28);
		getContentPane().add(Combo_Supplier);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity.setBounds(22, 511, 90, 28);
		getContentPane().add(lblQuantity);
		
		TF_Quantity = new JTextField();
		TF_Quantity.setColumns(10);
		TF_Quantity.setBounds(102, 511, 125, 28);
		getContentPane().add(TF_Quantity);
		
		btn_accept = new JButton("Accept");
		btn_accept.setBackground(new Color(6, 191, 33));
		btn_accept.setForeground(new Color(255,255,255));
		btn_accept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_accept.setBounds(239, 509, 85, 28);
		getContentPane().add(btn_accept);
		btn_accept.addMouseListener(edit_ImportsCoupon_Controller);
		
		 btn_DeleteProduct = new JButton("Delete product");
		 btn_DeleteProduct.setIcon(new ImageIcon(ExportProductView.class.getResource("/ite/computer_management/img/icons8-cancel-30.png")));
			btn_DeleteProduct.setBackground(new Color(6, 191, 33));
			btn_DeleteProduct.setForeground(new Color(255,255,255));
			btn_DeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_DeleteProduct.setBounds(1024, 67, 188, 28);
		getContentPane().add(btn_DeleteProduct);
		btn_DeleteProduct.addMouseListener(edit_ImportsCoupon_Controller);
		
		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setForeground(Color.WHITE);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalAmount.setBounds(518, 460, 181, 28);
		getContentPane().add(lblTotalAmount);
		
		text_totalAmount = new JLabel("0Đ");
		text_totalAmount.setForeground(Color.RED);
		text_totalAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
		text_totalAmount.setBounds(682, 460, 341, 41);
		getContentPane().add(text_totalAmount);
		
		btn_save = new JButton("Save");
		btn_save.setIcon(new ImageIcon(Edit_ImportsCouponView.class.getResource("/ite/computer_management/img/icons8-update-30.png")));
		btn_save.setBackground(Color.LIGHT_GRAY);
		btn_save.setForeground(new Color(0, 0, 0));
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_save.setBounds(1032, 488, 160, 41);
		getContentPane().add(btn_save);
		btn_save.addMouseListener(edit_ImportsCoupon_Controller);
		
		Imports_DAO.display(table_Product);
		
		// lấy dữ liệu từ bảng supplier trong database để hiện thị trong Jcombobox
		ImportDAO importDAO = new ImportDAO();
		List<String> supplierNames = importDAO.getSupplierNames();
		for (String supplierName : supplierNames) {
		    Combo_Supplier.addItem(supplierName);
		}

	}
	public void addProductActionPerformed() {
	    Imports_productController imports_productController;
	    int row = table_Product.getSelectedRow();
	    if (row == -1) {
	        JOptionPane.showMessageDialog(this, "Please choose the row you need!");
	    } else {
	        try {
	            int quantity = Integer.parseInt(TF_Quantity.getText().trim());
	            if (quantity > 0) {
	            	BigInteger  price = BigInteger.valueOf(Long.valueOf((table_Product.getValueAt(row, 4).toString())));  
	                String productCode = table_Product.getValueAt(row, 1).toString();
	                String productName = table_Product.getValueAt(row, 2).toString();
	                // Thực hiện truy vấn để lấy thông tin còn lại từ cơ sở dữ liệu
	                String[] productInfo = Imports_DAO.getProductInfo(productCode);
	                if (productInfo != null) {
	                    int currentQuantity = Integer.parseInt(productInfo[1]); // Số lượng hiện có của sản phẩm
	                    if (quantity == currentQuantity) {
	                        DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel();
	                        // Kiểm tra xem sản phẩm đã tồn tại trong bảng nhập hàng hay chưa
	                        boolean productExists = false;
	                        for (int i = 0; i < tableModelImports.getRowCount(); i++) {
	                            if (productCode.equals(tableModelImports.getValueAt(i, 1))) {
	                                int existingQuantity = (int) tableModelImports.getValueAt(i, 3);
	                                tableModelImports.setValueAt(existingQuantity + quantity, i, 3);
	                                productExists = true;
	                                break;
	                            }
	                        }
	                        if (!productExists) {
	                            tableModelImports.addRow(new Object[] { productInfo[0], productCode, productName, quantity, price});
	                        }
	                        DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	                        tableModelProduct.removeRow(row);
	                        updateTotalAmount();

	                        // Cập nhật số lượng trong cơ sở dữ liệu
	                        int newQuantity = currentQuantity - quantity;
	                        Imports_DAO.updateProductQuantity(productCode, newQuantity);
	                    } else if (quantity < currentQuantity) {
	                        DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	                        // Cập nhật số lượng của sản phẩm trong bảng table_Product
	                        int quantityNow = currentQuantity - quantity;
	                        table_Product.setValueAt(quantityNow, row, 3);
	                        // Thêm sản phẩm vào bảng table_Imports với số lượng nhập
	                        DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel();
	                        boolean productExists = false;
	                        for (int i = 0; i < tableModelImports.getRowCount(); i++) {
	                            if (productCode.equals(tableModelImports.getValueAt(i, 1))) {
	                                int existingQuantity = (int) tableModelImports.getValueAt(i, 3);
	                                tableModelImports.setValueAt(existingQuantity + quantity, i, 3);
	                                productExists = true;
	                                break;
	                            }
	                        }
	                        int number =0;
	                        if (!productExists) {
	                            tableModelImports.addRow(new Object[] { number+1, productCode, productName, quantity, price});
	                        }                  
	                        updateTotalAmount();
	                        int newQuantity = currentQuantity - quantity;
	                        Imports_DAO.updateProductQuantity(productCode, newQuantity);
	                        form_Code = TF_Form.getText();
	                        if (Details_Form == null) {
	                            Details_Form = new ArrayList<>();
	                        }
	                        Details_Form.add(new ite.computer_management.model.Details_Form(form_Code, productCode, quantity, price));
	                    } else {
	                        JOptionPane.showMessageDialog(this, "Not enough quantity available for this product!");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(this, "No product information found in the database!");
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Please enter a quantity greater than 0");
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Please enter the quantity as an integer!");
	        }
	    } 
	}
	public void updateTotalAmount() {
	    DefaultTableModel modelImports = (DefaultTableModel) table_Imports.getModel();
	    BigDecimal totalAmount = BigDecimal.ZERO;
	    DecimalFormat formatter = new DecimalFormat("###,###,###");

	    for (int i = 0; i < modelImports.getRowCount(); i++) {
	        try {
	            // Lấy giá trị từ ô cột 4 (cột chứa giá)
	            String priceStr = modelImports.getValueAt(i, 4).toString().replace(",", "");
	            double price = Double.parseDouble(priceStr);
	            // Lấy giá trị từ ô cột 3 (cột chứa số lượng)
	            int quantity = Integer.parseInt(modelImports.getValueAt(i, 3).toString());
	            // Tính tổng tiền
	            BigDecimal totalPrice = BigDecimal.valueOf(price * quantity);
	            // Cộng tổng tiền vào tổng tổng tiền
	            totalAmount = totalAmount.add(totalPrice);
	        } catch (NumberFormatException e) {
	            // Xử lý ngoại lệ nếu không thể chuyển đổi chuỗi thành số
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "fail");
	        }
	    }

	    // Hiển thị tổng tiền đã tính được trên giao diện
	    text_totalAmount.setText(formatter.format(totalAmount) + "Đ");
	}
	    
	    public void delete_toTableImport() {
	        int row = table_Imports.getSelectedRow();
	        if (row == -1) {
	            JOptionPane.showMessageDialog(this, "Please choose the row you need!");
	        } else {
	            try {
	            	DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
	            	DefaultTableModel tableModelImports = (DefaultTableModel) table_Imports.getModel(); 	
	            	int quantity = Integer.parseInt(tableModelImports.getValueAt(row, 3).toString());
	                String productCode = table_Imports.getValueAt(row, 1).toString();
	                String productName = table_Imports.getValueAt(row, 2).toString();
	            	BigInteger  price = BigInteger.valueOf(Long.valueOf((table_Imports.getValueAt(row, 4).toString())));  
	                // Thực hiện truy vấn để lấy thông tin còn lại từ cơ sở dữ liệu
	                String[] productInfo = Imports_DAO.getProductInfo(productCode);
	                // Kiểm tra xem sản phẩm đã tồn tại trong bảng table_Product hay chưa
	                boolean productExists = false;
	                for (int i = 0; i < tableModelProduct.getRowCount(); i++) {
	                    if (productCode.equals(tableModelProduct.getValueAt(i, 1).toString())) {
	                        // Nếu sản phẩm đã tồn tại, cộng số lượng	
	                        int currentQuantity = Integer.parseInt(tableModelProduct.getValueAt(i, 3).toString());
	                        int quantity_now = currentQuantity + quantity;
	                        tableModelProduct.setValueAt(quantity_now, i, 3);
	                        productExists = true;
	                        break;
	                    }
	                }
	                // Nếu sản phẩm không tồn tại, thêm sản phẩm mới vào bảng table_Product
	                if (!productExists) {
	                    tableModelProduct.addRow(new Object[] { productInfo[0], productCode, productName, quantity, price});
	                }
	                // Xóa hàng đã chọn khỏi bảng table_Imports
	                tableModelImports.removeRow(row);
	                // Cập nhật lại tổng số tiền
	                updateTotalAmount();
	                // Cập nhật số lượng trong cơ sở dữ liệu
	                int newQuantity = Integer.parseInt(productInfo[1]) + quantity;
	                Imports_DAO.updateProductQuantity(productCode, newQuantity);
	                form_Code = TF_Form.getText();
	                Details_Form.remove(new Details_Form(form_Code, productCode, quantity, price));
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(this, "Please enter the quantity as an integer!");
	            }
	        }
	    }
	    public void btn_UpdateCoupon() {
	    	
	 
	    	if (Details_Form.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để nhập hàng !","Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        } else {
	            for (Details_Form ct : Details_Form_old) {
	                computerDAO.getInstance().updateSoLuong(ct.getComputer_Code(), computerDAO.getInstance().selectById(ct.getComputer_Code()).getQuantity() - ct.getQuantity());
	            }
	            for (Details_Form ct : Details_Form) {
	            	computerDAO.getInstance().updateSoLuong(ct.getComputer_Code(), computerDAO.getInstance().selectById(ct.getComputer_Code()).getQuantity() + ct.getQuantity());
	            }
	            long now = System.currentTimeMillis();
	            Timestamp sqlTimestamp = new Timestamp(now);
	            ImportsForm pn = new ImportsForm(arrNcc.get(Combo_Supplier.getSelectedIndex()).getSupplier_Code(),formCode, sqlTimestamp, creator_txt.getText(), Details_Form, total_Amount());
	            try {
	                ImportDAO.getInstance().update(pn);
	                Details_ImportDAO.getInstance().delete(Details_Form_old.get(Details_Form_old.size() - 1));
	                for (Details_Form i : Details_Form) {
	                    Details_ImportDAO.getInstance().insert(i);
	                }
	                JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
	                this.ICF.displayTable();
	                this.dispose();
	            } catch (Exception e) {
	            	e.printStackTrace();
	                JOptionPane.showMessageDialog(this, "Cập nhật thất bại !","Lỗi", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }
	    public BigInteger total_Amount() {
			BigInteger sum = BigInteger.valueOf(Long.valueOf("0"));
			for (Details_Form i : Details_Form) {
				BigInteger quantityBig = BigInteger.valueOf(Long.valueOf(i.getQuantity()));
				BigInteger resultEachLoop = i.getUnit_Price().multiply(quantityBig);
				sum.add(resultEachLoop);
			}
			return sum;
		}
	    public void loadDataToTableProduct(ImportCouponView ICF) {
	    	 try {
		            ArrayList<Details_Form> CTPhieu = Details_ImportDAO.getInstance().selectAll(ICF.getPhieuNhapSelect().getForm_Code().toString());
		            DefaultTableModel table_model = (DefaultTableModel) table_Imports.getModel();
		            table_model.setRowCount(0);
		            int stt=1;
		            for (int i = 0; i < CTPhieu.size(); i++) {  
		                table_model.addRow(new Object[]{
		                    stt++, 
		                    CTPhieu.get(i).getComputer_Code(),
		                    computerDAO.getInstance().selectById(CTPhieu.get(i).getComputer_Code()).getComputerName(),
		                    CTPhieu.get(i).getQuantity(),
		                    CTPhieu.get(i).getUnit_Price(),
		                });
		            }
		            this.Details_Form = CTPhieu; 
		            updateTotalAmount();
		        } catch (Exception e) {
		        	 System.out.println("Failed to load data: " + e.getMessage());
		 	        e.printStackTrace();
		        }
	    }
	    public void back() {
	    	this.dispose();
	    }
}