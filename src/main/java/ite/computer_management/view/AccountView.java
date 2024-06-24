
package ite.computer_management.view;

import javax.swing.JPanel; 

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ite.computer_management.controller.AccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Account;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountView extends JPanel {

	private static final long serialVersionUID = 1L;
	public DefaultTableModel model;
	public JLabel addLbl;
	public JLabel deleteLbl;
	public JLabel editLbl;
	public JLabel exportExcelLbl;
	public AccountDAO accountDAO;
	public JTextField searchAreaTxt;
	private JLabel label;
	public static JTable table;
	public JTextField searchTxt;
	public Dashboard dashboard;
	public JButton btnExcel;
	public JButton btnadd;
	public JButton btnUpdate;
	public JButton btndelete;
	/**
	 * Create the panel.
	 */
	public AccountView(Dashboard dashboard) {
		this.dashboard = dashboard;
		init();
		this.setVisible(true);	
	}
	
	public void init(){
		AccountController accountController = new AccountController(this);
		accountDAO = new AccountDAO(this);
		this.setSize(1250,800);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(23, 243, 1176, 466);
		scrollPane.setBounds(36, 243, 1163, 466);
		add(scrollPane);
		//create table and fetch data from database
		table = new JTable();
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
		AccountDAO AccountDAO = new AccountDAO(this);
		AccountDAO.selectAll();
		scrollPane.setViewportView(table);
		
		searchTxt = new JTextField();
		searchTxt.addKeyListener(accountController);
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
		btnadd.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\add 25.png"));
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnadd.setBackground(new Color(171, 214, 177));
		btnadd.setBounds(36, 38, 190, 40);
		add(btnadd);
		btnadd.addMouseListener(accountController);
		
		btndelete = new JButton("Delete");
		btndelete.setForeground(new Color(6, 191, 33));
		btndelete.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btndelete.setBackground(new Color(171, 214, 177));
		btndelete.setBounds(36, 100, 190, 40);
		add(btndelete);
		btndelete.addMouseListener(accountController);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(6, 191, 33));
		btnUpdate.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\edit 30.png"));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(171, 214, 177));
		btnUpdate.setBounds(36, 168, 190, 40);
		add(btnUpdate);
		btnUpdate.addMouseListener(accountController);
		
		btnExcel = new JButton("Export excel");
		btnExcel.setForeground(new Color(6, 191, 33));
		btnExcel.setIcon(new ImageIcon("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\excel 30.png"));
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExcel.setBackground(new Color(171, 214, 177));
		btnExcel.setBounds(1018, 168, 181, 40);
		add(btnExcel);
		btnExcel.addMouseListener(accountController);
	}
	public void clickAddLbl() {
		new AddAccountView(this, dashboard);
	}
	public void clickDeleteLbl() {
		int frontEndCheck = table.getSelectedRowCount();
		
		if(frontEndCheck <1) { 
			JOptionPane.showMessageDialog(null, "Please select row to delete.");
		}else {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if(confirm ==0) {
				int selectedRowIndex = table.getSelectedRow();
				String fullName = (String) model.getValueAt(selectedRowIndex, 0);
				String userName = (String)model.getValueAt(selectedRowIndex, 1);
				Account account = new Account();
				account.setUserName(userName);
				int check = accountDAO.delete(account);
				if(check ==1) {
					model.removeRow(selectedRowIndex);
				}
			}
		}
	}

	public void displayTable() {
	    model.setRowCount(0);
	    accountDAO.selectAll();
	}

	public void clickEditLbl() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if(check <1) {
			JOptionPane.showMessageDialog(null, "Please select row to edit.");
		}else {
			String userName = (String) model.getValueAt(selectedRowIndex, 1);
			String role = (String) model.getValueAt(selectedRowIndex, 3);
			String gmail = (String) model.getValueAt(selectedRowIndex, 4);
			EditAccountView editAccountView = new EditAccountView(this, dashboard);

			editAccountView.userNameTxt.setText(userName);
			editAccountView.roleTxt.setText(role);
			editAccountView.mailtxt.setText(gmail);
		}
		
	}
	public void clickExportExcel() {
		 try {
		        JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));
		        int option = fileChooser.showSaveDialog(this);

		        if (option == JFileChooser.APPROVE_OPTION) {
		            File saveFile = fileChooser.getSelectedFile();
		            if (!saveFile.toString().endsWith(".xlsx")) {  
		                saveFile = new File(saveFile.toString() + ".xlsx");
		            }
		            Workbook workbook = new XSSFWorkbook();
		            Sheet sheet = workbook.createSheet("Account");    
		            Row headerRow = sheet.createRow(0);
		            for (int i = 0; i < table.getColumnCount(); i++) {
		                Cell cell = headerRow.createCell(i);
		                cell.setCellValue(table.getColumnName(i));
		            }
		            for (int j = 0; j < table.getRowCount(); j++) {
		                Row row = sheet.createRow(j + 1);
		                for (int k = 0; k < table.getColumnCount(); k++) {
		                    Cell cell = row.createCell(k);
		                    Object value = table.getValueAt(j, k);
		                    if (value != null) {
		                        if (value instanceof Number) {
		                            cell.setCellValue(((Number) value).doubleValue()); 
		                        } else {
		                            cell.setCellValue(value.toString()); 
		                        }
		                    }
		                }
		            }
		            try (FileOutputStream out = new FileOutputStream(saveFile)) {
		                workbook.write(out);
		            }
		            JOptionPane.showMessageDialog(this, "successfull", "Notification", JOptionPane.INFORMATION_MESSAGE);
		            if (Desktop.isDesktopSupported()) {
		                Desktop.getDesktop().open(saveFile);
		            }
		        }
		    } catch (FileNotFoundException e) {
		        JOptionPane.showMessageDialog(this, "not found" + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		    } catch (IOException e) {
		        JOptionPane.showMessageDialog(this, "fail" + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		    }
	}
	public void enterSearch() {
		DefaultTableModel demo = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(demo);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(searchAreaTxt.getText()));
	}
}