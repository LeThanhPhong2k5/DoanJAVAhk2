
package ite.computer_management.view;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.Box;

import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.sql.Timestamp;

import ite.computer_management.controller.Imports_productController;
import ite.computer_management.controller.WirtePDF_File;
import ite.computer_management.dao.Details_ImportDAO;
import ite.computer_management.dao.ImportDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.dao.computerDAO;
import ite.computer_management.model.Account;
import ite.computer_management.model.Details_Form;
import ite.computer_management.model.ImportsForm;
import ite.computer_management.model.Supplier;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ImportsProductView extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField TF_Sreach;
	public JTextField TF_Form;
	public JTable table_Product;
	public JTable table_Imports;
	public JTextField TF_Quantity;
	private JLabel text_totalAmount;
	public JButton btn_DeleteProduct;
	private ImportDAO Imports_DAO;
	public JButton btn_accept;

	DecimalFormat formatter = new DecimalFormat("###,###,###");
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
	private JComboBox Combo_Supplier;
	private String form_Code;
	private static final ArrayList<Supplier> arrNcc = SupplierDAO.getInstance().selectAll();
	private ArrayList<Details_Form> Details_Form;
	public JButton btn_ImportsProduct;
	public JButton btn_Refresh;
	public JTextField creator_txt;
	Account accountReturn;
	
	public DecimalFormat getFormatter() {
		return formatter;
	}

	public SimpleDateFormat getFormatDate() {
		return formatDate;
	}
	

	public ImportsProductView(Account accountReturn) {
		init();
		this.accountReturn = accountReturn;
		
		
		this.setVisible(true);
		Details_Form = new ArrayList<Details_Form>();
		form_Code = createId(Imports_DAO.getInstance().selectAll());
		TF_Form.setText(form_Code);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(22, 10, 446, 78);
		add(verticalBox);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1.setBounds(503, 0, 722, 146);
		add(verticalBox_1);
		
		creator_txt = new JTextField();
		creator_txt.setColumns(10);
		creator_txt.setBounds(600, 112, 349, 28);
		add(creator_txt);
	}

	public void init() {
		Imports_DAO = new ImportDAO(this);
		Imports_productController Imports_productController = new Imports_productController(this);

		this.setSize(1250, 800);
		setLayout(null);

		TF_Sreach = new JTextField();
		TF_Sreach.setBounds(37, 49, 282, 28);
		add(TF_Sreach);
		TF_Sreach.setColumns(10);
		TF_Sreach.addKeyListener(Imports_productController);

		btn_Refresh = new JButton("");
		btn_Refresh.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\reload 30.png"));
		btn_Refresh.setBounds(348, 46, 85, 28);
		btn_Refresh.setForeground(Color.WHITE);
		btn_Refresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Refresh.setBackground(new Color(0, 0, 51));
		add(btn_Refresh);
		btn_Refresh.addMouseListener(Imports_productController);

		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setBounds(37, 26, 90, 13);
		lblNewLabel.setForeground(new Color(6, 191, 33));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel);

		JLabel lblFrom = new JLabel("Form:");
		lblFrom.setBounds(518, 26, 90, 28);
		lblFrom.setForeground(new Color(6, 191, 33));
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblFrom);

		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setBounds(518, 75, 90, 13);
		lblSupplier.setForeground(new Color(6, 191, 33));
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblSupplier);

		JLabel lblCreator = new JLabel("Creator:");
		lblCreator.setBounds(518, 114, 90, 13);
		lblCreator.setForeground(new Color(6, 191, 33));
		lblCreator.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblCreator);

		TF_Form = new JTextField();
		TF_Form.setBounds(600, 26, 349, 28);
		TF_Form.setColumns(10);
		TF_Form.setEditable(false);
		add(TF_Form);

		table_Product = new JTable();
		table_Product.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Number", "Code", "Name", "Quantity", "Price" }));
		table_Product.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_Product.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_Product.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_Product.getColumnModel().getColumn(3).setPreferredWidth(150);
		table_Product.getColumnModel().getColumn(4).setPreferredWidth(150);
		
		table_Product.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_Product.setFillsViewportHeight(true);
		table_Product.setFont(new Font("JetBrains MonoMono", Font.BOLD, 16));
		table_Product.setBackground(new Color(255, 255, 255));
		table_Product.getTableHeader().setFont(new Font("JetBrains Mono", Font.BOLD, 17));
		table_Product.getTableHeader().setBackground(new Color(70, 163, 100));
		table_Product.getTableHeader().setForeground(new Color(255, 255, 255));
		table_Product.getTableHeader().setReorderingAllowed(false);
		table_Product.getTableHeader().setResizingAllowed(false);
		table_Product.setRowHeight(30);
		table_Product.setGridColor(new Color(64, 82, 69));
		table_Product.setShowHorizontalLines(true);
		table_Product.setBackground(new Color(197, 227, 206));
		table_Product.setForeground(new Color(47, 97, 62));

		table_Product.addMouseListener(new MouseAdapter() {
			public int r;

			@Override
			public void mouseClicked(MouseEvent e) {
				r = table_Product.getSelectedRow();
				if (r != -1) {
					TF_Quantity.setText(table_Product.getValueAt(r, 3) + "");

				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table_Product);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(22, 107, 452, 571);
		add(scrollPane);
		

		table_Imports = new JTable();
		table_Imports.setBounds(1, 25, 698, 0);
		table_Imports.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Number", "Code ", "Name", "Quantity", "Price" }));
		table_Imports.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_Imports.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_Imports.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_Imports.getColumnModel().getColumn(3).setPreferredWidth(150);
		table_Imports.getColumnModel().getColumn(4).setPreferredWidth(150);

		table_Imports.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_Imports.setFillsViewportHeight(true);
		table_Imports.setFont(new Font("JetBrains MonoMono", Font.BOLD, 16));
		table_Imports.setBackground(new Color(255, 255, 255));
		table_Imports.getTableHeader().setFont(new Font("JetBrains Mono", Font.BOLD, 17));
		table_Imports.getTableHeader().setBackground(new Color(70, 163, 100));
		table_Imports.getTableHeader().setForeground(new Color(255, 255, 255));
		table_Imports.getTableHeader().setReorderingAllowed(false);
		table_Imports.getTableHeader().setResizingAllowed(false);
		table_Imports.setRowHeight(30);
		table_Imports.setGridColor(new Color(64, 82, 69));
		table_Imports.setShowHorizontalLines(true);
		table_Imports.setBackground(new Color(197, 227, 206));
		table_Imports.setForeground(new Color(47, 97, 62));

		add(table_Imports);

		JScrollPane scrollPane_1 = new JScrollPane(table_Imports);
		scrollPane_1.setBounds(503, 176, 722, 478);
		add(scrollPane_1);

		Combo_Supplier = new JComboBox();
		Combo_Supplier.setBounds(600, 69, 349, 28);
		add(Combo_Supplier);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(22, 705, 90, 23);
		lblQuantity.setForeground(new Color(6, 191, 33));
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblQuantity);

		TF_Quantity = new JTextField();
		TF_Quantity.setBounds(111, 705, 125, 28);
		TF_Quantity.setColumns(10);
		add(TF_Quantity);

		btn_accept = new JButton("Accept");
		btn_accept.setBounds(246, 705, 85, 28);
		btn_accept.setBackground(new Color(6, 191, 33));
		btn_accept.setForeground(new Color(255, 255, 255));
		btn_accept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btn_accept);
		btn_accept.addMouseListener(Imports_productController);

		btn_DeleteProduct = new JButton("Delete product");
		btn_DeleteProduct.setBounds(1006, 67, 188, 28);
		 btn_DeleteProduct.setIcon(new ImageIcon(ExportProductView.class.getResource("/ite/computer_management/img/icons8-cancel-30.png")));
		btn_DeleteProduct.setBackground(new Color(6, 191, 33));
		btn_DeleteProduct.setForeground(new Color(255, 255, 255));
		btn_DeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btn_DeleteProduct);
		btn_DeleteProduct.addMouseListener(Imports_productController);

		JLabel lblTotalAmount = new JLabel("Total amount:");
		lblTotalAmount.setBounds(503, 670, 181, 28);
		lblTotalAmount.setForeground(new Color(6, 191, 33));
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		add(lblTotalAmount);

		text_totalAmount = new JLabel("0Đ");
		text_totalAmount.setBounds(671, 663, 341, 41);
		text_totalAmount.setForeground(Color.RED);
		text_totalAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(text_totalAmount);

		btn_ImportsProduct = new JButton("Imports product");
		btn_ImportsProduct.setIcon(new ImageIcon(ExportProductView.class.getResource("/ite/computer_management/img/icons8-pdf-30.png")));
		btn_ImportsProduct.setBounds(1030, 682, 182, 41);
		btn_ImportsProduct.setBackground(new Color(6, 191, 33));
		btn_ImportsProduct.setForeground(new Color(255, 255, 255));
		btn_ImportsProduct.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(btn_ImportsProduct);
		btn_ImportsProduct.addMouseListener(Imports_productController);

		Imports_DAO.display(table_Product);

		// lấy dữ liệu từ bảng supplier trong database để hiện thị trong Jcombobox
		ImportDAO importDAO = new ImportDAO();
		List<String> supplierNames = importDAO.getSupplierNames();
		for (String supplierName : supplierNames) {
			Combo_Supplier.addItem(supplierName);
		}


	}

	public void addProductActionPerformed() {
		int row = table_Product.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Please choose the row you need!");
		} else {
			try {
				int quantity = Integer.parseInt(TF_Quantity.getText().trim());
				if (quantity > 0) {
					BigInteger price = BigInteger.valueOf(Long.parseLong(table_Product.getValueAt(row, 4).toString())); 
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
								tableModelImports.addRow(
										new Object[] { productInfo[0], productCode, productName, quantity, price });
							}
							// Xóa hàng đã chọn khỏi bảng table_Product
							DefaultTableModel tableModelProduct = (DefaultTableModel) table_Product.getModel();
							tableModelProduct.removeRow(row);
							// Cập nhật lại tổng số tiền
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
							int number = 0;
							if (!productExists) {
								tableModelImports
										.addRow(new Object[] { number + 1, productCode, productName, quantity, price });
							}
							// Cập nhật lại tổng số tiền
							updateTotalAmount();

							// Cập nhật số lượng trong cơ sở dữ liệu
							int newQuantity = currentQuantity - quantity;
							Imports_DAO.updateProductQuantity(productCode, newQuantity);
							form_Code = TF_Form.getText();
							Details_Form.add(new ite.computer_management.model.Details_Form(form_Code, productCode,
									quantity, price));
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

	public String createId(ArrayList<ImportsForm> arr) {
		int id = arr.size() + 1;
		String check = "";
		for (ImportsForm form : arr) {
			if (form.getForm_Code().equals("IF" + id)) {
				check = form.getForm_Code();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getForm_Code().equals("IF" + id)) {
					check = arr.get(i).getForm_Code();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}
		return "IF" + id;
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
				BigInteger price = BigInteger.valueOf(Long.valueOf((table_Imports.getValueAt(row, 4).toString())));
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
					tableModelProduct
							.addRow(new Object[] { productInfo[0], productCode, productName, quantity, price });
				}
				// Xóa hàng đã chọn khỏi bảng table_Imports
				tableModelImports.removeRow(row);
				// Cập nhật lại tổng số tiền
				updateTotalAmount();
				// Cập nhật số lượng trong cơ sở dữ liệu
				int newQuantity = Integer.parseInt(productInfo[1]) + quantity;
				Imports_DAO.updateProductQuantity(productCode, newQuantity);
				form_Code = TF_Form.getText();
				Details_Form.remove(
						new ite.computer_management.model.Details_Form(form_Code, productCode, quantity, price));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Please enter the quantity as an integer!");
			}
		}
	}

	public void btn_ImportProduct() {
		DefaultTableModel model_table = (DefaultTableModel) table_Imports.getModel();
		if (model_table == null) {
			JOptionPane.showMessageDialog(this, "There are no products in the table");
		} else {
			int check = JOptionPane.showConfirmDialog(this, "are you sure??", "yes", JOptionPane.YES_NO_OPTION);
			if (check == JOptionPane.YES_NO_OPTION) {
				long now = System.currentTimeMillis();
				Timestamp sqlTimeTamp = new Timestamp(now);
				String Creator = creator_txt.getText();
				ImportsForm IM = new ImportsForm(arrNcc.get(Combo_Supplier.getSelectedIndex()).getSupplier_Code(),
						form_Code, sqlTimeTamp, Creator, Details_Form, TotalAmount());
				try {
					ImportDAO.getInstance().insert(IM);
					computerDAO CPTD = computerDAO.getInstance();
					for (Details_Form i : Details_Form) {
						Details_ImportDAO.getInstance().insert(i);
						CPTD.updateQuantity(i.getComputer_Code(),
								CPTD.selectById(i.getComputer_Code()).getQuantity() + i.getQuantity());
					}
					JOptionPane.showMessageDialog(this, "Imports product success");
					int res = JOptionPane.showConfirmDialog(this, "do you want export file pdf?", "",
							JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {
						WirtePDF_File writepdf = new WirtePDF_File();
						writepdf.writeImportCoupon(form_Code);
					}
					DefaultTableModel r = (DefaultTableModel) table_Imports.getModel();
					r.setRowCount(0);
					text_totalAmount.setText("0");
					this.form_Code = createId(ImportDAO.getInstance().selectAll());
					TF_Form.setText(this.form_Code);
				
			
					
				} catch (Exception e) {

				}
			}
		}
	}

	private BigInteger TotalAmount() {
		DefaultTableModel modelImports = (DefaultTableModel) table_Imports.getModel();
		BigInteger totalAmount = BigInteger.valueOf(Long.valueOf("0"));
		for (int i = 0; i < modelImports.getRowCount(); i++) {
			BigInteger price = BigInteger.valueOf(Integer.valueOf((modelImports.getValueAt(i, 4).toString())));
			BigInteger quantity = BigInteger.valueOf(Integer.parseInt(modelImports.getValueAt(i, 3).toString()));
			BigInteger  resultEachLoop = price.multiply(quantity);
			totalAmount = totalAmount.add(resultEachLoop);
		}
		 return totalAmount;
	}	

	private void updateTotalAmount() {
		DefaultTableModel modelImports = (DefaultTableModel) table_Imports.getModel();
		BigInteger totalAmount = BigInteger.valueOf(Long.valueOf("0"));
		for (int i = 0; i < modelImports.getRowCount(); i++) {
			BigInteger price = BigInteger.valueOf(Integer.valueOf((modelImports.getValueAt(i, 4).toString())));
			BigInteger quantity = BigInteger.valueOf(Integer.parseInt(modelImports.getValueAt(i, 3).toString()));
			BigInteger  resultEachLoop = price.multiply(quantity);
			totalAmount = totalAmount.add(resultEachLoop);
		}
		text_totalAmount.setText(String.valueOf(totalAmount) + "Đ");
	}

	public void displayTable() {
		ImportDAO view = new ImportDAO();
		view.display(table_Product);
	}

	public void clicksearch() {
		DefaultTableModel model = (DefaultTableModel) table_Product.getModel();

		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table_Product.setRowSorter(sorter);

		String searchText = TF_Sreach.getText();
		RowFilter<DefaultTableModel, Integer> rowFilter = new RowFilter<DefaultTableModel, Integer>() {
			public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
				String code = entry.getStringValue(1).toLowerCase();
				return code.contains(searchText.toLowerCase());
			}
		};
		sorter.setRowFilter(rowFilter);
	}
}