package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chart.Columnchart;
import ite.computer_management.controller.DashboardForManagerController;
import ite.computer_management.model.Account;
import main.Login;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;

public class DashboardForManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel productNavLbl;
	public JTabbedPane tabbedPane;
	public JLabel myInformationLbl;
	public JLabel logOutNavLbl;
	public JLabel exportCouponNavLbl;
	public JLabel importCouponNavLbl;
	public JLabel exportProductNavLbl;
	public JLabel importProductNavLbl;
	public JLabel statisticalNavLbl;
	public JLabel supplierNavLbl;
	public JPanel navPanel;
	public JLabel ChatNavLbl_1;
	private Account accountReturn;

	public DashboardForManager(Account accountReturn) {
		this.accountReturn = accountReturn;
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {
		DashboardForManagerController dashboardForManagerController = new DashboardForManagerController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, -20, 1250, 800);
		contentPane.add(tabbedPane);

		ProductView productView = new ProductView(this);
		tabbedPane.addTab("Product Management", productView);

		SupplierView supplierView = new SupplierView(this);
		tabbedPane.addTab("Supplier manegement", supplierView);

		ImportsProductView ImportsProductView = new ImportsProductView(accountReturn);
		ImportsProductView.creator_txt.setText(accountReturn.getFullName());
		tabbedPane.addTab("Imports Product", ImportsProductView);

		ImportCouponView importCouponView = new ImportCouponView();
		tabbedPane.addTab("Import coupon", importCouponView);

		ExportProductView ExportProductView = new ExportProductView(accountReturn);
		ExportProductView.creator_txt.setText(accountReturn.getFullName());
		tabbedPane.addTab("Export Product", ExportProductView);

		ExportCouponView exportCouponView = new ExportCouponView();
		tabbedPane.addTab("Export coupon", exportCouponView);
		
		Columnchart chart = new Columnchart(this);
		tabbedPane.addTab("statistical chart", chart);

		navPanel = new JPanel();
		navPanel.setForeground(new Color(0, 0, 0));
		navPanel.setLayout(null);
		navPanel.setBounds(0, 0, 250, 800);
		navPanel.setBackground(new Color(70, 163, 100));
		contentPane.add(navPanel);

		String xinchao = "Hello  " + accountReturn.getFullName() + " <3";
		JLabel greetingLbl = new JLabel(xinchao);
		greetingLbl.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 19));
//		greetingLbl.setIcon(new ImageIcon(
//				"D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo.png"));
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(0, 0, 250, 158);
		greetingLbl.setOpaque(true);
		greetingLbl.setBackground(new Color(70, 163, 100));
		greetingLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(greetingLbl);

		productNavLbl = new JLabel("Product");
		productNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		productNavLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/icons8-product-30.png")));
		productNavLbl.setBounds(1, 157, 250, 45);
		productNavLbl.setBackground(new Color(220, 242, 227));
		productNavLbl.setForeground(new Color(0, 125, 40));
		productNavLbl.setOpaque(true);
		productNavLbl.addMouseListener(dashboardForManagerController);
		navPanel.add(productNavLbl);

		supplierNavLbl = new JLabel("Supplier");
		supplierNavLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/icons8-supplier-30.png")));
		supplierNavLbl.setOpaque(true);
		supplierNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		supplierNavLbl.setBounds(1, 201, 250, 45);
		supplierNavLbl.addMouseListener(dashboardForManagerController);
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(supplierNavLbl);

		statisticalNavLbl = new JLabel("Statistical");
		statisticalNavLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/icons8-analysis-30.png")));
		statisticalNavLbl.setOpaque(true);
		statisticalNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		statisticalNavLbl.setBounds(1, 625, 250, 45);
		statisticalNavLbl.addMouseListener(dashboardForManagerController);
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(statisticalNavLbl);

		importProductNavLbl = new JLabel("Import Product");
		importProductNavLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/importProduct-30.png")));
		importProductNavLbl.setOpaque(true);
		importProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importProductNavLbl.setBounds(1, 244, 250, 45);
		importProductNavLbl.addMouseListener(dashboardForManagerController);
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(importProductNavLbl);

		exportProductNavLbl = new JLabel("Export Product");
		exportProductNavLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/exportProductt-30.png")));
		exportProductNavLbl.setOpaque(true);
		exportProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportProductNavLbl.setBounds(1, 330, 250, 45);
		exportProductNavLbl.addMouseListener(dashboardForManagerController);
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(exportProductNavLbl);

		importCouponNavLbl = new JLabel("Import Coupon");
		importCouponNavLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/bill-30.png")));
		importCouponNavLbl.setOpaque(true);
		importCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importCouponNavLbl.setBounds(1, 287, 250, 45);
		importCouponNavLbl.addMouseListener(dashboardForManagerController);
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(importCouponNavLbl);

		exportCouponNavLbl = new JLabel("Export Coupon");
		exportCouponNavLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/bill-30.png")));
		exportCouponNavLbl.setOpaque(true);
		exportCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportCouponNavLbl.setBounds(1, 374, 250, 50);
		exportCouponNavLbl.addMouseListener(dashboardForManagerController);
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(exportCouponNavLbl);

		myInformationLbl = new JLabel("My Information");
		myInformationLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/myinfor-30.png")));
		myInformationLbl.setOpaque(true);
		myInformationLbl.setFont(new Font("Lato", Font.BOLD, 15));
		myInformationLbl.setBounds(0, 668, 250, 45);
		myInformationLbl.addMouseListener(dashboardForManagerController);
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(myInformationLbl);

		ChatNavLbl_1 = new JLabel("Chat");
		ChatNavLbl_1.setOpaque(true);
		ChatNavLbl_1.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/chat.png")));
		ChatNavLbl_1.setFont(new Font("Dialog", Font.BOLD, 15));
		ChatNavLbl_1.setBounds(1, 422, 250, 50);
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		navPanel.add(ChatNavLbl_1);
		ChatNavLbl_1.addMouseListener(dashboardForManagerController);
		
		logOutNavLbl = new JLabel("Log out");
		logOutNavLbl.setIcon(new ImageIcon(DashboardForManager.class.getResource("/ite/computer_management/img/exit30.png")));
		logOutNavLbl.setOpaque(true);
		logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		logOutNavLbl.setBounds(0, 712, 250, 50);
		logOutNavLbl.addMouseListener(dashboardForManagerController);
		logOutNavLbl.setBackground(new Color(70, 163, 100));
		logOutNavLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(logOutNavLbl);
	}

	public void clickSupplierNav() {
		this.tabbedPane.setSelectedIndex(1);
		supplierNavLbl.setBackground(new Color(220, 242, 227));
		supplierNavLbl.setForeground(new Color(59, 59, 59));

		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickProductNav() {
		this.tabbedPane.setSelectedIndex(0);
		productNavLbl.setBackground(new Color(220, 242, 227));
		productNavLbl.setForeground(new Color(0, 125, 40));

		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickImportProductNav() {
		importProductNavLbl.setBackground(new Color(220, 242, 227));
		importProductNavLbl.setForeground(new Color(0, 125, 40));
		this.tabbedPane.setSelectedIndex(2);

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickImportCouponNav() {
		this.tabbedPane.setSelectedIndex(3);
		importCouponNavLbl.setBackground(new Color(220, 242, 227));
		importCouponNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickExportProductNav() {
		this.tabbedPane.setSelectedIndex(4);
		exportProductNavLbl.setBackground(new Color(220, 242, 227));
		exportProductNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickExportCouponNav() {
		this.tabbedPane.setSelectedIndex(5);
		exportCouponNavLbl.setBackground(new Color(220, 242, 227));
		exportCouponNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));

	}

	public void clickStatisticalNav() {
		this.tabbedPane.setSelectedIndex(6);
		statisticalNavLbl.setBackground(new Color(220, 242, 227));
		statisticalNavLbl.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));

	}
	 private boolean isLoginViewVisible = false; 
	  private Login loginView = null; 
	public void clickChatNav() {
		ChatNavLbl_1.setBackground(new Color(220, 242, 227));
		ChatNavLbl_1.setForeground(new Color(0, 125, 40));

		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		
		if (loginView != null) {
	        loginView.dispose(); 
	    }
		loginView = new Login(accountReturn.getFullName());
	    loginView.setVisible(true);
	}

	public void clickMyInformationNav() {
		myInformationLbl.setBackground(new Color(220, 242, 227));
		myInformationLbl.setForeground(new Color(0, 125, 40));
		
		productNavLbl.setBackground(new Color(70, 163, 100));
		productNavLbl.setForeground(new Color(219, 219, 219));
		statisticalNavLbl.setBackground(new Color(70, 163, 100));
		statisticalNavLbl.setForeground(new Color(219, 219, 219));
		supplierNavLbl.setBackground(new Color(70, 163, 100));
		supplierNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));
		
		new MyInformationView(accountReturn);
	}

	public void clickLogoutNav() {
		LogInView view = new LogInView();
		dispose();
		view.setVisible(true);
	}
}