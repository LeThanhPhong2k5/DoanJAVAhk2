package ite.computer_management.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.DashboardForExportStaffController;
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

public class DashboardForExportStaff extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	public JLabel productNavLbl;
	public JTabbedPane tabbedPane;
	public JLabel accountNavLbl;
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

	public DashboardForExportStaff(Account accountReturn) {
		this.accountReturn = accountReturn;
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void init() {
		DashboardForExportStaffController dashboardForExportStaffController = new DashboardForExportStaffController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, -20, 1250, 800);
		contentPane.add(tabbedPane);

		ExportProductView ExportProductView = new ExportProductView(accountReturn);
		ExportProductView.creator_txt.setText(accountReturn.getFullName());
		
		ExportProductView.table_Product.setLocation(23, 142);
		tabbedPane.addTab("Export Product", ExportProductView);

		ExportCouponView exportCouponView = new ExportCouponView();
		tabbedPane.addTab("Export coupon", exportCouponView);

		navPanel = new JPanel();
		navPanel.setLayout(null);
		navPanel.setBounds(0, 0, 250, 800);
		navPanel.setBackground(new Color(70, 163, 100));
		navPanel.setForeground(new Color(0, 0, 0));
		contentPane.add(navPanel);

		String xinchao = "Hello  " + accountReturn.getFullName() +" <3";
		JLabel greetingLbl = new JLabel(xinchao);
		greetingLbl.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 17));
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(0, 0, 250, 158);
		greetingLbl.setOpaque(true);
		greetingLbl.setBackground(new Color(70, 163, 100));
		greetingLbl.setForeground(new Color(219, 219, 219));
		navPanel.add(greetingLbl);

		exportProductNavLbl = new JLabel("Export Product");
		exportProductNavLbl.setIcon(new ImageIcon(DashboardForExportStaff.class.getResource("/ite/computer_management/img/exportProductt-30.png")));
		exportProductNavLbl.setOpaque(true);
		exportProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportProductNavLbl.setBounds(1, 168, 250, 45);
		exportProductNavLbl.addMouseListener(dashboardForExportStaffController);
		exportProductNavLbl.setBackground(new Color(220, 242, 227));
		exportProductNavLbl.setForeground(new Color(0, 125, 40));
		navPanel.add(exportProductNavLbl);
				      
		exportCouponNavLbl = new JLabel("Export Coupon");
		exportCouponNavLbl.setIcon(new ImageIcon(DashboardForExportStaff.class.getResource("/ite/computer_management/img/bill-30.png")));
		exportCouponNavLbl.setOpaque(true);
		exportCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportCouponNavLbl.setBounds(1, 213, 250, 50);
		exportCouponNavLbl.addMouseListener(dashboardForExportStaffController);
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219,219,219));
		navPanel.add(exportCouponNavLbl);

		myInformationLbl = new JLabel("My Information");
		myInformationLbl.setIcon(new ImageIcon(DashboardForExportStaff.class.getResource("/ite/computer_management/img/myinfor-30.png")));
		myInformationLbl.setOpaque(true);
		myInformationLbl.setFont(new Font("Lato", Font.BOLD, 15));
		myInformationLbl.setBounds(0, 668, 250, 45);
		myInformationLbl.addMouseListener(dashboardForExportStaffController);
		myInformationLbl.setBackground(new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219,219,219));
		navPanel.add(myInformationLbl);

		logOutNavLbl = new JLabel("Log out");
		logOutNavLbl.setIcon(new ImageIcon(DashboardForExportStaff.class.getResource("/ite/computer_management/img/exit30.png")));
		logOutNavLbl.setOpaque(true);
		logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		logOutNavLbl.setBounds(0, 712, 250, 50);
		logOutNavLbl.addMouseListener(dashboardForExportStaffController);
		logOutNavLbl.setBackground(new Color(70, 163, 100));
		logOutNavLbl.setForeground(new Color(219,219,219));
		navPanel.add(logOutNavLbl);
		
		ChatNavLbl_1 = new JLabel("Chat");
		ChatNavLbl_1.setIcon(new ImageIcon(DashboardForExportStaff.class.getResource("/ite/computer_management/img/chat.png")));
		ChatNavLbl_1.setOpaque(true);
		ChatNavLbl_1.setFont(new Font("Dialog", Font.BOLD, 15));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219,219,219));
		ChatNavLbl_1.setBounds(1, 257, 250, 56);
		navPanel.add(ChatNavLbl_1);
		ChatNavLbl_1.addMouseListener(dashboardForExportStaffController);
	}

	public void clickExportProductNav() {
		this.tabbedPane.setSelectedIndex(0);
		exportProductNavLbl.setBackground(new Color(220, 242, 227));
		exportProductNavLbl.setForeground(new Color(0, 125, 40));
		
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));	
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));	
	}

	 private boolean isLoginViewVisible = false; 
	  private Login loginView = null; 
	public void clickExportCouponNav() {
		this.tabbedPane.setSelectedIndex(1);
		exportCouponNavLbl.setBackground(new Color(220, 242, 227));
		exportCouponNavLbl.setForeground(new Color(0, 125, 40));
		
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));		
	}
	public void clickChatNav() {
		ChatNavLbl_1.setBackground(new Color(220, 242, 227));
		ChatNavLbl_1.setForeground( new Color(0, 125, 40) );
		
		myInformationLbl.setBackground( new Color(70, 163, 100));
		myInformationLbl.setForeground(new Color(219, 219, 219));
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));	

		if (loginView != null) {
	        loginView.dispose(); 
	    }
		loginView = new Login(accountReturn.getFullName());
	    loginView.setVisible(true);
	}
	public void clickMyInformationNav() {
		myInformationLbl.setBackground( new Color(220, 242, 227));
		myInformationLbl.setForeground(new Color(0, 125, 40));
		
		ChatNavLbl_1.setBackground(new Color(70, 163, 100));
		ChatNavLbl_1.setForeground(new Color(219, 219, 219));	
		exportProductNavLbl.setBackground(new Color(70, 163, 100));
		exportProductNavLbl.setForeground(new Color(219, 219, 219));
		exportCouponNavLbl.setBackground(new Color(70, 163, 100));
		exportCouponNavLbl.setForeground(new Color(219, 219, 219));	
		
		new MyInformationView(accountReturn);
	}

	public void clickLogoutNav() {
		LogInView view = new LogInView();
		dispose();
		view.setVisible(true);
	}
}