package ite.computer_management.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ite.computer_management.controller.DashboardForImportStaffController;
import ite.computer_management.model.Account;
import main.Login;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window;

public class DashboardForImportStaff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JLabel myInformationLbl;
	public JLabel logOutNavLbl;
	public JLabel importCouponNavLbl;
	public JLabel importProductNavLbl;
	public JLabel Imports_ProductNavLbl;
	public JLabel Export_ProductNavLbl;
	public JPanel navPanel;
	public JLabel chatNavLbl_1;
	private Account accountReturn;

	public DashboardForImportStaff(Account accountReturn) {
		this.accountReturn = accountReturn;
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {
		DashboardForImportStaffController dashboardController = new DashboardForImportStaffController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, -20, 1250, 800);
		contentPane.add(tabbedPane);

		ImportsProductView ImportsProductView = new ImportsProductView(accountReturn);
		ImportsProductView.creator_txt.setText(accountReturn.getFullName());
		tabbedPane.addTab("Imports Product", ImportsProductView);
		ImportCouponView importCouponView = new ImportCouponView();
		tabbedPane.addTab("Import coupon", importCouponView);

		navPanel = new JPanel();
		navPanel.setForeground(new Color(0, 0, 0));
		navPanel.setLayout(null);
		navPanel.setBounds(0, 0, 250, 800);
		navPanel.setBackground(new Color(70, 163, 100));
		contentPane.add(navPanel);

		String xinchao = "Hello  " + accountReturn.getFullName() +" <3";
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

		importProductNavLbl = new JLabel("Import Product");
		importProductNavLbl.setIcon(new ImageIcon(DashboardForImportStaff.class.getResource("/ite/computer_management/img/importProduct-30.png")));
		importProductNavLbl.setOpaque(true);
		importProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importProductNavLbl.setBackground(new Color(220, 242, 227));
		importProductNavLbl.setBounds(1, 181, 250, 45);
		importProductNavLbl.addMouseListener(dashboardController);
		importProductNavLbl.setForeground(new Color(0, 125, 40));
		navPanel.add(importProductNavLbl);

		importCouponNavLbl = new JLabel("Import Coupon");
		importCouponNavLbl.setIcon(new ImageIcon(DashboardForImportStaff.class.getResource("/ite/computer_management/img/bill-30.png")));
		importCouponNavLbl.setOpaque(true);
		importCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setBounds(1, 223, 250, 45);
		importCouponNavLbl.addMouseListener(dashboardController);
		importCouponNavLbl.setForeground(new Color(219,219,219));
		navPanel.add(importCouponNavLbl);

		myInformationLbl = new JLabel("My Information");
		myInformationLbl.setIcon(new ImageIcon(DashboardForImportStaff.class.getResource("/ite/computer_management/img/myinfor-30.png")));
		myInformationLbl.setOpaque(true);
		myInformationLbl.setFont(new Font("Lato", Font.BOLD, 15));
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setBounds(0, 668, 250, 45);
		myInformationLbl.addMouseListener(dashboardController);
		myInformationLbl.setForeground(new Color(219,219,219));
		navPanel.add(myInformationLbl);
		
		chatNavLbl_1 = new JLabel("Chat");
		chatNavLbl_1.setIcon(new ImageIcon(DashboardForImportStaff.class.getResource("/ite/computer_management/img/chat.png")));
		chatNavLbl_1.setOpaque(true);
		chatNavLbl_1.setFont(new Font("Dialog", Font.BOLD, 15));
		chatNavLbl_1.setBackground(new Color(70, 163, 100));
		chatNavLbl_1.setForeground(new Color(219,219,219));
		chatNavLbl_1.setBounds(1, 266, 250, 45);
		navPanel.add(chatNavLbl_1);
		chatNavLbl_1.addMouseListener(dashboardController);
		
		logOutNavLbl = new JLabel("Log out");
		logOutNavLbl.setIcon(new ImageIcon(DashboardForImportStaff.class.getResource("/ite/computer_management/img/exit30.png")));
		logOutNavLbl.setOpaque(true);
		logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		logOutNavLbl.setBackground(new Color(70, 163, 100));
		logOutNavLbl.setBounds(0, 712, 250, 50);
		logOutNavLbl.addMouseListener(dashboardController);
		logOutNavLbl.setForeground(new Color(219,219,219));
		navPanel.add(logOutNavLbl);
	}

	public void clickImportProductNav() {
		importProductNavLbl.setBackground(new Color(220, 242, 227));
		importProductNavLbl.setForeground(new Color(0, 125, 40));
		this.tabbedPane.setSelectedIndex(0);
		
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		chatNavLbl_1.setBackground(new Color(70, 163, 100));
		chatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}

	public void clickImportCouponNav() {
		this.tabbedPane.setSelectedIndex(1);
		importCouponNavLbl.setBackground(new Color(220, 242, 227));
		importCouponNavLbl.setForeground(new Color(0, 125, 40));
		
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		chatNavLbl_1.setBackground(new Color(70, 163, 100));
		chatNavLbl_1.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
	}
	 private boolean isLoginViewVisible = false; 
	  private Login loginView = null; 
	public void clickChatNav() {
		chatNavLbl_1.setBackground(new Color(220, 242, 227));
		chatNavLbl_1.setForeground(new Color(0, 125, 40));
		
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		
		if (loginView != null) {
	        loginView.dispose(); 
	    }
		loginView = new Login(accountReturn.getFullName());
	    loginView.setVisible(true);
	}
	public void clickMyInformationNav() {
		myInformationLbl.setBackground( new Color(220, 242, 227));
		myInformationLbl.setForeground(new Color(0, 125, 40));
		
		importCouponNavLbl.setBackground(new Color(70, 163, 100));
		importCouponNavLbl.setForeground(new Color(219, 219, 219));
		importProductNavLbl.setBackground(new Color(70, 163, 100));
		importProductNavLbl.setForeground(new Color(219, 219, 219));
		chatNavLbl_1.setBackground(new Color(70, 163, 100));
		chatNavLbl_1.setForeground(new Color(219, 219, 219));
		
		new MyInformationView(accountReturn);
	}

	public void clickLogoutNav() {
		LogInView view = new LogInView();
		dispose();
		view.setVisible(true);
	}
}
