package ite.computer_management.view;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ite.computer_management.controller.SupplierController;

import ite.computer_management.dao.SupplierDAO;

import ite.computer_management.model.Supplier;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupplierView extends JPanel {
	public static DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public JTextField searchTxt;
	public Dashboard dashboard;
	public DashboardForManager dashboardForManager;
	public JButton btnExcel;
	public JButton btnadd;
	public JButton btnUpdate;
	public JButton btndelete;

	/**
	 * @wbp.parser.constructor
	 */
	public SupplierView(Dashboard dashboard) {
		this.dashboard = dashboard;
		init();
		this.setVisible(true);
	}

	public SupplierView(DashboardForManager dashboardForManager) {
		this.dashboardForManager = dashboardForManager;
		init();
		this.setVisible(true);
	}

	public void init() {
		SupplierController SupplierController = new SupplierController(this);
		this.setSize(1250, 800);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(36, 243, 1004, 466);
		scrollPane.setBounds(36, 243, 1163, 466);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Supplier code", "Supplier Name", "Phone number", "Address" }));
		model = (DefaultTableModel) table.getModel();

		
		table.setFillsViewportHeight(true);
		table.setFont(new Font("JetBrains MonoMono", Font.BOLD, 16));
		table.setBackground(new Color(255, 255, 255));
		table.setRowHeight(30);
		table.setGridColor(new Color(64, 82, 69));
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(197, 227, 206));
		table.setForeground(new Color(47, 97, 62));
		table.getTableHeader().setFont(new Font("JetBrains Mono", Font.BOLD, 17));
		table.getTableHeader().setBackground(new Color(70, 163, 100));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		
		SupplierDAO supplierDAO = new SupplierDAO(this);
		supplierDAO.display(table);
		scrollPane.setViewportView(table);
		searchTxt = new JTextField();
		searchTxt.addKeyListener(SupplierController);
		searchTxt.setBounds(792, 72, 385, 40);
		add(searchTxt);
		searchTxt.setColumns(10);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(772, 38, 427, 102);
		add(verticalBox);

		JLabel searchLbl = new JLabel("Search:");
		verticalBox.add(searchLbl);
		searchLbl.setForeground(new Color(6, 191, 33));
		searchLbl.setFont(new Font("Dialog", Font.BOLD, 17));

		btnadd = new JButton("Add");
		btnadd.setForeground(new Color(6, 191, 33));
		btnadd.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\add 25.png"));
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnadd.setBackground(new Color(171, 214, 177));
		btnadd.setBounds(36, 50, 190, 40);
		add(btnadd);
		btnadd.addMouseListener(SupplierController);

		btndelete = new JButton("Delete");
		btndelete.setForeground(new Color(6, 191, 33));
		btndelete.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btndelete.setBackground(new Color(171, 214, 177));
		btndelete.setBounds(36, 112, 190, 40);
		add(btndelete);
		btndelete.addMouseListener(SupplierController);

		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(6, 191, 33));
		btnUpdate.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\edit 30.png"));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(171, 214, 177));
		btnUpdate.setBounds(36, 167, 190, 40);
		add(btnUpdate);
		btnUpdate.addMouseListener(SupplierController);

		btnExcel = new JButton("Export excel");
		btnExcel.setForeground(new Color(6, 191, 33));
		btnExcel.setIcon(new ImageIcon(
				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExcel.setBackground(new Color(171, 214, 177));
		btnExcel.setBounds(1018, 167, 181, 40);
		add(btnExcel);
		btnExcel.addMouseListener(SupplierController);
	}

	public void clickAddLbl() {
		new AddSupplierView(this, dashboard);
	}

	public void clickDeleteLbl() {
		int check = table.getSelectedRowCount();
		int selectedRow = table.getSelectedRow();

		if (check < 1) {
			JOptionPane.showMessageDialog(null, "Please select row to delete.");
		} else {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?"); // yes:0, no:1
			if (confirm == 0) {
				String supplier_code = model.getValueAt(selectedRow, 0).toString();
				String supplier_name = model.getValueAt(selectedRow, 1).toString();

				Supplier Delete = new Supplier();
				Delete.setSupplier_Code(supplier_code);
				int result = SupplierDAO.getInstance().delete(Delete);
				System.out.println(result);
				if (result == 1) {
					model.removeRow(selectedRow);
				}
			}

		}
	}

	public void clickSearchBtn() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);

		String search = searchTxt.getText();

		RowFilter<DefaultTableModel, Integer> row = new RowFilter<DefaultTableModel, Integer>() {

			@Override
			public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
				String code = entry.getStringValue(0).toLowerCase();

				return code.contains(search.toLowerCase());
			}

		};
		sorter.setRowFilter(row);
	}

	public void clickExportExcel() {
		try {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.showSaveDialog(this);
			File saveFile = jFileChooser.getSelectedFile();

			if (saveFile != null) {
				saveFile = new File(saveFile.toString() + ".xlsx");
				Workbook wb = new XSSFWorkbook();
				Sheet sheet = wb.createSheet("product");

				Row rowCol = sheet.createRow(0);
				for (int i = 0; i < table.getColumnCount(); i++) {
					Cell cell = rowCol.createCell(i);
					cell.setCellValue(table.getColumnName(i));
				}
				for (int j = 0; j < table.getRowCount(); j++) {
					Row row = sheet.createRow(j);
					for (int k = 0; k < table.getColumnCount(); k++) {
						Cell cell = row.createCell(k);
						if (table.getValueAt(j, k) != null) {
							cell.setCellValue(table.getValueAt(j, k).toString());
						}
					}
				}
				FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
				wb.write(out);
				wb.close();
				out.close();
			}
			JOptionPane.showMessageDialog(null, "Export successfully ><");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void clickEditBtn() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if (check < 1) {
			JOptionPane.showMessageDialog(null, "Please select row to edit >< ");
		} else {
			EditSupplierView editSupplierView = new EditSupplierView(this, dashboard);
			editSupplierView.SupplierNameTxt.setText(String.valueOf(model.getValueAt(selectedRowIndex, 1)));
			editSupplierView.PhoneTxt.setText(String.valueOf(model.getValueAt(selectedRowIndex, 2)));
			editSupplierView.AddressTxt.setText(String.valueOf(model.getValueAt(selectedRowIndex, 3)));
		}

	}

}