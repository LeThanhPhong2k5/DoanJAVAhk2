
package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.AddProductController;
import ite.computer_management.controller.AddSupplierController;
import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.dao.SupplierDAO;
import ite.computer_management.model.Computer;
import ite.computer_management.model.Supplier;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
 
public class AddSupplierView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField SupplierNameTxt;
	private JTextField SupplierCodeTxt;
	private JTextField AddressTxt;
	private JTextField PhoneTxt;
	public JLabel refreshLbl;
	public JLabel addLbl;
	public JLabel cancelLbl;
	public SupplierView supplierView;
	public Dashboard dashboard;
	public JButton addBtn;
	public JButton cancelBtn;
	public JButton refreshBtn;
	private JLabel titleLbl;
	
	public AddSupplierView(SupplierView supplierView, Dashboard dashboard) {
		this.supplierView = supplierView;
		this.dashboard = dashboard;
		AddSupplierController addSupplierController = new AddSupplierController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SupplierNameLbl = new JLabel("Supplier Name");
		SupplierNameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		SupplierNameLbl.setForeground(new Color(219, 219, 219));
		SupplierNameLbl.setBackground(new Color(70, 163, 100));
		SupplierNameLbl.setOpaque(true);
		SupplierNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SupplierNameLbl.setBounds(123, 194, 217, 41);
		contentPane.add(SupplierNameLbl);
		
		JLabel SupplierCodeLbl = new JLabel("Supplier Code");
		SupplierCodeLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		SupplierCodeLbl.setForeground(new Color(219, 219, 219));
		SupplierCodeLbl.setOpaque(true);
		SupplierCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SupplierCodeLbl.setBackground(new Color(70, 163, 100));
		SupplierCodeLbl.setBounds(123, 133, 217, 41);
		contentPane.add(SupplierCodeLbl);
		
		JLabel AddressLbl = new JLabel("Address");
		AddressLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		AddressLbl.setForeground(new Color(219, 219, 219));
		AddressLbl.setOpaque(true);
		AddressLbl.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLbl.setBackground(new Color(70, 163, 100));
		AddressLbl.setBounds(123, 325, 217, 41);
		contentPane.add(AddressLbl);
		
		JLabel PhoneNumberLbl = new JLabel("Phone Number");
		PhoneNumberLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		PhoneNumberLbl.setForeground(new Color(219, 219, 219));
		PhoneNumberLbl.setOpaque(true);
		PhoneNumberLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberLbl.setBackground(new Color(70, 163, 100));
		PhoneNumberLbl.setBounds(123, 260, 217, 41);
		contentPane.add(PhoneNumberLbl);
		
		SupplierNameTxt = new JTextField();
		SupplierNameTxt.setBounds(340, 194, 326, 41);
		contentPane.add(SupplierNameTxt);
		SupplierNameTxt.setColumns(10);
		
		SupplierCodeTxt = new JTextField();
		SupplierCodeTxt.setColumns(10);
		SupplierCodeTxt.setBounds(340, 133, 326, 41);
		contentPane.add(SupplierCodeTxt);
		
		AddressTxt = new JTextField();
		AddressTxt.setColumns(10);
		AddressTxt.setBounds(340, 325, 326, 41);
		contentPane.add(AddressTxt);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(340, 260, 326, 41);
		contentPane.add(PhoneTxt);
		
		addBtn = new JButton("Add");
		 addBtn.setIcon(new ImageIcon(AddSupplierView.class.getResource("/ite/computer_management/img/add 30.png")));
		addBtn.setForeground(new Color(70, 163, 100));
		addBtn.setBackground(new Color(219,219,219));
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addBtn.setBounds(328, 434, 141, 41);
		contentPane.add(addBtn);
		addBtn.addMouseListener(addSupplierController);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setIcon(new ImageIcon(AddSupplierView.class.getResource("/ite/computer_management/img/icons8-cancel-30.png")));
		cancelBtn.setBackground(new Color(219,219,219));
		cancelBtn.setForeground(new Color(70, 163, 100));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelBtn.setBounds(120, 434, 141, 41);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setIcon(new ImageIcon(AddSupplierView.class.getResource("/ite/computer_management/img/icons8-refresh-30.png")));
		refreshBtn.setForeground(new Color(70, 163, 100));
		refreshBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		refreshBtn.setBackground(new Color(219,219,219));
		refreshBtn.setBounds(525, 434, 141, 41);
		contentPane.add(refreshBtn);
		
		titleLbl = new JLabel("ADD SUPPLIER");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 796, 114);
		titleLbl.setFont(new Font("Hack", Font.BOLD, 28));
		titleLbl.setForeground(new Color(219, 219, 219));
		titleLbl.setBackground(new Color(70, 163, 100));
		titleLbl.setOpaque(true);
		contentPane.add(titleLbl);
		cancelBtn.addMouseListener(addSupplierController);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void clickAddLbl() {
		String NameSupplier = SupplierNameTxt.getText();
		String CodeSupplier = SupplierCodeTxt.getText();
		String PhoneNumber = PhoneTxt.getText();
		String Address = AddressTxt.getText();
		
		Supplier Sup = new Supplier(CodeSupplier, NameSupplier, PhoneNumber, Address);
		

		int check = SupplierDAO.getInstance().insert(Sup);
		if(check == 1) {
			//front-end
			String[] rowData = {CodeSupplier, NameSupplier, PhoneNumber, Address};
			SupplierView.model.addRow(rowData);
		}
		
	}
	public void clickCancelLbl() {
		this.dispose();
	    dashboard.setVisible(true);
	}
	public void clickRefreshLbl() {
		SupplierNameTxt.setText(null);
		SupplierCodeTxt.setText(null);
		PhoneTxt.setText(null);
		AddressTxt.setText(null);
	}
}


