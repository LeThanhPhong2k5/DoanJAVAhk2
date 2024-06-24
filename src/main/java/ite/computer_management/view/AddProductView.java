
package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.AddProductController;
import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Computer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField computerNameTxt;
	private JTextField computerCodeTxt;
	private JTextField cpuTxt;
	private JTextField ramTxt;
	private JTextField screenCardTxt;
	private JTextField screenSizeTxt;
	private JTextField priceTxt;
	private JTextField quantityTxt;
	private JLabel machineTypeLbl;
	private JTextField machineTypeTxt;
	private JLabel batteryCapacityLbl;
	private JTextField batteryCapacityTxt;
	private JLabel originLbl;
	private JTextField originTxt;
	private JTextField sourceCapacityTxt;
	private JTextField romTxt;
	public JLabel addLbl1;
	public ProductView productView;
	public Dashboard dashboard;
	public JButton addBtn;
	public JButton cancelBtn;
	public JButton refreshBtn;
	public JLabel add;
	
	public AddProductView(ProductView productView, Dashboard dashboard) {
		this.dashboard = dashboard;
		this.productView = productView;
		init();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setVisible(true);
	}
	public void init() {
		AddProductController addProductController = new AddProductController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(213, 232, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 add = new JLabel("ADD PRODUCT");
		add.setHorizontalAlignment(SwingConstants.CENTER);
		add.setBounds(0, 0, 1090, 122);
		add.setFont(new Font("Hack", Font.BOLD, 28));
		add.setForeground(new Color(219, 219, 219));
		add.setBackground(new Color(70, 163, 100));
		add.setOpaque(true);
		contentPane.add(add);
		add.addMouseListener(addProductController);
		
		JLabel computerNameLbl = new JLabel("Computer Name");
		computerNameLbl.setFont(new Font("Inter", Font.BOLD, 12));
		computerNameLbl.setOpaque(true);
		computerNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerNameLbl.setBounds(46, 220, 190, 41);
		computerNameLbl.setForeground(new Color(219, 219, 219));
		computerNameLbl.setBackground(new Color(70, 163, 100));
		contentPane.add(computerNameLbl);
		
		JLabel computerCodeLbl = new JLabel("Computer Code");
		computerCodeLbl.setFont(new Font("Inter", Font.BOLD, 12));
		computerCodeLbl.setOpaque(true);
		computerCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerCodeLbl.setBackground(new Color(70, 163, 100));
		computerCodeLbl.setForeground(new Color(219, 219, 219));
		computerCodeLbl.setBounds(46, 161, 190, 41);
		contentPane.add(computerCodeLbl);
		
		JLabel cpuLbl = new JLabel("CPU");
		cpuLbl.setFont(new Font("Inter", Font.BOLD, 12));
		cpuLbl.setOpaque(true);
		cpuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cpuLbl.setBounds(561, 273, 190, 41);
		cpuLbl.setBackground(new Color(70, 163, 100));
		cpuLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(cpuLbl);
		
		JLabel ramLbl = new JLabel("RAM");
		ramLbl.setFont(new Font("Inter", Font.BOLD, 12));
		ramLbl.setOpaque(true);
		ramLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ramLbl.setForeground(new Color(219, 219, 219));
		ramLbl.setBackground(new Color(70, 163, 100));
		ramLbl.setBounds(46, 378, 190, 41);
		contentPane.add(ramLbl);
		
		JLabel screenCardLbl = new JLabel("Screen Card");
		screenCardLbl.setFont(new Font("Inter", Font.BOLD, 12));
		screenCardLbl.setOpaque(true);
		screenCardLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenCardLbl.setBackground(new Color(70, 163, 100));
		screenCardLbl.setForeground(new Color(219, 219, 219));
		screenCardLbl.setBounds(561, 378, 190, 41);
		contentPane.add(screenCardLbl);
		
		JLabel screenSizeLbl = new JLabel("Screen Size");
		screenSizeLbl.setFont(new Font("Inter", Font.BOLD, 12));
		screenSizeLbl.setOpaque(true);
		screenSizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenSizeLbl.setForeground(new Color(219, 219, 219));
		screenSizeLbl.setBackground(new Color(70, 163, 100));
		screenSizeLbl.setBounds(46, 492, 190, 41);
		contentPane.add(screenSizeLbl);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setFont(new Font("Inter", Font.BOLD, 12));
		priceLbl.setOpaque(true);
		priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		priceLbl.setForeground(new Color(219, 219, 219));
		priceLbl.setBackground(new Color(70, 163, 100));
		priceLbl.setBounds(46, 273, 190, 41);
		contentPane.add(priceLbl);
		
		JLabel sourceCapacityLbl = new JLabel("Souce Capacity");
		sourceCapacityLbl.setFont(new Font("Inter", Font.BOLD, 12));
		sourceCapacityLbl.setOpaque(true);
		sourceCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sourceCapacityLbl.setForeground(new Color(219, 219, 219));
		sourceCapacityLbl.setBackground(new Color(70, 163, 100));
		sourceCapacityLbl.setBounds(561, 431, 190, 41);
		contentPane.add(sourceCapacityLbl);
		
		JLabel romLbl = new JLabel("Rom");
		romLbl.setFont(new Font("Inter", Font.BOLD, 12));
		romLbl.setOpaque(true);
		romLbl.setHorizontalAlignment(SwingConstants.CENTER);
		romLbl.setForeground(new Color(219, 219, 219));
		romLbl.setBackground(new Color(70, 163, 100));
		romLbl.setBounds(46, 326, 190, 41);
		contentPane.add(romLbl);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setFont(new Font("Inter", Font.BOLD, 12));
		quantityLbl.setOpaque(true);
		quantityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLbl.setBackground(new Color(70, 163, 100));
		quantityLbl.setForeground(new Color(219, 219, 219));
		quantityLbl.setBounds(563, 220, 188, 41);
		contentPane.add(quantityLbl);
		

		originLbl = new JLabel("Origin");
		originLbl.setFont(new Font("Inter", Font.BOLD, 12));
		originLbl.setOpaque(true);
		originLbl.setHorizontalAlignment(SwingConstants.CENTER);
		originLbl.setForeground(new Color(219, 219, 219));
		originLbl.setBackground(new Color(70, 163, 100));
		originLbl.setBounds(561, 326, 190, 41);
		contentPane.add(originLbl);
		
		machineTypeLbl = new JLabel("Machine Type");
		machineTypeLbl.setFont(new Font("Inter", Font.BOLD, 12));
		machineTypeLbl.setOpaque(true);
		machineTypeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		machineTypeLbl.setBackground(new Color(70, 163, 100));
		machineTypeLbl.setForeground(new Color(219, 219, 219));
		machineTypeLbl.setBounds(46, 431, 190, 41);
		contentPane.add(machineTypeLbl);
		
		batteryCapacityLbl = new JLabel("Battery Capacity");
		batteryCapacityLbl.setFont(new Font("Inter", Font.BOLD, 12));
		batteryCapacityLbl.setOpaque(true);
		batteryCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		batteryCapacityLbl.setBackground(new Color(70, 163, 100));
		batteryCapacityLbl.setForeground(new Color(219, 219, 219));
		batteryCapacityLbl.setBounds(561, 492, 190, 41);
		contentPane.add(batteryCapacityLbl);
		
		
		computerNameTxt = new JTextField();
		computerNameTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		computerNameTxt.setBounds(236, 220, 309, 41);
		contentPane.add(computerNameTxt);
		computerNameTxt.setColumns(10);
		
		computerCodeTxt = new JTextField();
		computerCodeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		computerCodeTxt.setColumns(10);
		computerCodeTxt.setBounds(236, 161, 823, 41);
		contentPane.add(computerCodeTxt);
		
		cpuTxt = new JTextField();
		cpuTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		cpuTxt.setColumns(10);
		cpuTxt.setBounds(750, 273, 309, 41);
		contentPane.add(cpuTxt);
		
		ramTxt = new JTextField();
		ramTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		ramTxt.setColumns(10);
		ramTxt.setBounds(236, 378, 307, 41);
		contentPane.add(ramTxt);
		
		screenCardTxt = new JTextField();
		screenCardTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		screenCardTxt.setColumns(10);
		screenCardTxt.setBounds(750, 378, 309, 41);
		contentPane.add(screenCardTxt);
		
		screenSizeTxt = new JTextField();
		screenSizeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		screenSizeTxt.setColumns(10);
		screenSizeTxt.setBounds(236, 492, 307, 41);
		contentPane.add(screenSizeTxt);
		
		priceTxt = new JTextField();
		priceTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		priceTxt.setColumns(10);
		priceTxt.setBounds(236, 273, 309, 41);
		contentPane.add(priceTxt);
		
		quantityTxt = new JTextField();
		quantityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(750, 220, 309, 41);
		contentPane.add(quantityTxt);
		
		machineTypeTxt = new JTextField();
		machineTypeTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		machineTypeTxt.setColumns(10);
		machineTypeTxt.setBounds(236, 431, 307, 41);
		contentPane.add(machineTypeTxt);
		
		batteryCapacityTxt = new JTextField();
		batteryCapacityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		batteryCapacityTxt.setColumns(10);
		batteryCapacityTxt.setBounds(750, 492, 309, 41);
		contentPane.add(batteryCapacityTxt);
		
		originTxt = new JTextField();
		originTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		originTxt.setColumns(10);
		originTxt.setBounds(750, 326, 309, 41);
		contentPane.add(originTxt);
		
		sourceCapacityTxt = new JTextField();
		sourceCapacityTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		sourceCapacityTxt.setColumns(10);
		sourceCapacityTxt.setBounds(750, 431, 309, 41);
		contentPane.add(sourceCapacityTxt);
		
		romTxt = new JTextField();
		romTxt.setFont(new Font("Roboto", Font.PLAIN, 13));
		romTxt.setColumns(10);
		romTxt.setBounds(236, 326, 307, 41);
		contentPane.add(romTxt);
		
		 addBtn = new JButton("Add Product");
		 addBtn.setIcon(new ImageIcon(AddProductView.class.getResource("/ite/computer_management/img/add 30.png")));
		addBtn.setBackground(new Color(219,219,219));
		addBtn.setForeground(new Color(70, 163, 100));
		addBtn.setFont(new Font("Dialog", Font.BOLD, 15));
		addBtn.setBounds(456, 594, 190, 41);
		contentPane.add(addBtn);
		addBtn.addMouseListener(addProductController);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setIcon(new ImageIcon(AddProductView.class.getResource("/ite/computer_management/img/icons8-cancel-30.png")));
		cancelBtn.setForeground(new Color(70, 163, 100));
		cancelBtn.setBackground(new Color(219,219,219));
		cancelBtn.setFont(new Font("Dialog", Font.BOLD, 15));
		cancelBtn.setBounds(120, 594, 190, 41);
		contentPane.add(cancelBtn);
		cancelBtn.addMouseListener(addProductController);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setIcon(new ImageIcon(AddProductView.class.getResource("/ite/computer_management/img/icons8-refresh-30.png")));
		refreshBtn.setForeground(new Color(70, 163, 100));
		refreshBtn.setFont(new Font("Dialog", Font.BOLD, 15));
		refreshBtn.setBackground(new Color(219,219,219));
		refreshBtn.setBounds(790, 594, 190, 41);
		contentPane.add(refreshBtn);
		refreshBtn.addMouseListener(addProductController);
	}
	
	public void clickAddLbl() {
		String preparedScreenCard = screenCardTxt.getText();
		String preparedComputerName = computerNameTxt.getText();
		String preparedComputerCode = computerCodeTxt.getText();
		String preparedSourceCapacity = sourceCapacityTxt.getText();
		String preparedCpuName = cpuTxt.getText();
		String preparedRam = ramTxt.getText();
		String preparedMachineType = machineTypeTxt.getText();
		BigInteger preparedPrice = BigInteger.valueOf(Long.valueOf(priceTxt.getText()));
		int preparedQuantity = Integer.parseInt(quantityTxt.getText());
		String preparedRom = romTxt.getText();
		String preparedOrigin = originTxt.getText();
		Double preparedScreenSize = Double.parseDouble(screenSizeTxt.getText());
		String preparedBatteryCapacity = batteryCapacityTxt.getText();
		Computer preparedComputer = new Computer(preparedComputerCode, preparedComputerName, preparedQuantity, preparedCpuName, preparedRam, preparedScreenCard,
					preparedPrice, preparedSourceCapacity, preparedMachineType, preparedRom, preparedScreenSize,preparedBatteryCapacity, preparedOrigin);
		 
  System.out.println(preparedPrice);
		int check = ProductDAO.getInstance().insert(preparedComputer);
		if(check == 1) {
			//front-end
			String[] rowData = {preparedComputerName, preparedComputerCode, String.valueOf(preparedQuantity), preparedCpuName, preparedRam, preparedScreenCard,String.valueOf(preparedPrice),
														 preparedSourceCapacity, preparedMachineType, preparedRom,String.valueOf(preparedScreenSize),	preparedBatteryCapacity, preparedOrigin};
			productView.model.addRow(rowData);
		}
		
	}
	public void clickCancelLbl() {
		this.dispose();
		dashboard.setVisible(true);
		
	}
	public void clickRefreshLbl() {
		computerNameTxt.setText(null);
		computerCodeTxt.setText(null);
		quantityTxt.setText(null);
		cpuTxt.setText(null);
		ramTxt.setText(null);
		screenCardTxt.setText(null);
		priceTxt.setText(null);
		sourceCapacityTxt.setText(null);
		machineTypeTxt.setText(null);
		romTxt.setText(null);
		screenSizeTxt.setText(null);
		batteryCapacityTxt.setText(null);
		originTxt.setText(null);
	}
}