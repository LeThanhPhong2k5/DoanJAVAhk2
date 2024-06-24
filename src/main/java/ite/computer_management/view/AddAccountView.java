
package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import ite.computer_management.controller.AddAccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;
import ite.computer_management.model.PasswordHashingService;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class AddAccountView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullNameTxt;
	private JTextField userNameTxt;
	private JTextField roleTxt;
	public JButton addBtn;
	public JButton cancelBtn;
	public JButton refreshBtn;
	public AccountView accountView;
	public Dashboard dashboard;
	private JPasswordField passwordTxt;
	private JTextField text_gmail;

	public AddAccountView(AccountView accountView, Dashboard dashboard) {
		this.accountView = accountView;
		this.dashboard = dashboard;
		init();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void init() { 
		AddAccountController addAccountController = new AddAccountController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addBtn = new JButton("Add account");
		 addBtn.setIcon(new ImageIcon(AddProductView.class.getResource("/ite/computer_management/img/add 30.png")));
		 addBtn.setBackground(new Color(219,219,219));
		addBtn.setForeground(new Color(70, 163, 100));
		addBtn.setFont(new Font("Dialog", Font.BOLD, 12));
		addBtn.setBounds(224, 432, 154, 37);
		addBtn.addMouseListener(addAccountController);
		contentPane.add(addBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setIcon(new ImageIcon(AddProductView.class.getResource("/ite/computer_management/img/icons8-cancel-30.png")));
		cancelBtn.setForeground(new Color(70, 163, 100));
		cancelBtn.setBackground(new Color(219,219,219));
		cancelBtn.setFont(new Font("Dialog", Font.BOLD, 12));
		cancelBtn.setBounds(464, 432, 121, 37);
		cancelBtn.addMouseListener(addAccountController);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setIcon(new ImageIcon(AddProductView.class.getResource("/ite/computer_management/img/icons8-refresh-30.png")));
		refreshBtn.setForeground(new Color(70, 163, 100));
		refreshBtn.setFont(new Font("Dialog", Font.BOLD, 12));
		refreshBtn.setBackground(new Color(219,219,219));
		refreshBtn.setBounds(21, 432, 121, 37);
		refreshBtn.addMouseListener(addAccountController);
		contentPane.add(refreshBtn);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setFont(new Font("Inter", Font.BOLD, 13));
		fullNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		fullNameLbl.setBounds(105, 141, 138, 35);
		fullNameLbl.setBackground(new Color(70, 163, 100));
		fullNameLbl.setForeground(new Color(219, 219, 219));
		fullNameLbl.setOpaque(true);
		contentPane.add(fullNameLbl);
		
		JLabel userNameLbl = new JLabel("User Name");
		userNameLbl.setFont(new Font("Inter", Font.BOLD, 13));
		userNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLbl.setBounds(105, 194, 138, 35);
		userNameLbl.setBackground(new Color(70, 163, 100));
		userNameLbl.setForeground(new Color(219, 219, 219));
		userNameLbl.setOpaque(true);
		contentPane.add(userNameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setFont(new Font("Inter", Font.BOLD, 13));
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setBounds(105, 251, 138, 35);
		passwordLbl.setBackground(new Color(70, 163, 100));
		passwordLbl.setForeground(new Color(219, 219, 219));
		passwordLbl.setOpaque(true);
		contentPane.add(passwordLbl);
		
		JLabel Gmail = new JLabel("Gmail");
		Gmail.setFont(new Font("Inter", Font.BOLD, 13));
		Gmail.setHorizontalAlignment(SwingConstants.CENTER);
		Gmail.setBounds(105, 366, 138, 35);
		Gmail.setBackground(new Color(70, 163, 100));
		Gmail.setForeground(new Color(219, 219, 219));
		Gmail.setOpaque(true);
		contentPane.add(Gmail);
		
		fullNameTxt = new JTextField();
		fullNameTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		fullNameTxt.setBounds(242, 141, 258, 35);
		contentPane.add(fullNameTxt);
		fullNameTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(242, 194, 258, 35);
		contentPane.add(userNameTxt);
		
		roleTxt = new JTextField();
		roleTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		roleTxt.setColumns(10);
		roleTxt.setBounds(242, 306, 258, 35);
		contentPane.add(roleTxt);
		
		JLabel titleLbl = new JLabel("ADD ACCOUNT");
		titleLbl.setFont(new Font("Hack", Font.PLAIN, 28));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 621, 109);
		titleLbl.setBackground(new Color(70, 163, 100));
		titleLbl.setForeground(new Color(219, 219, 219));
		titleLbl.setOpaque(true);
		contentPane.add(titleLbl);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(241, 251, 259, 35);
		contentPane.add(passwordTxt);
		
		JLabel roleLbl_1 = new JLabel("Role");
		roleLbl_1.setOpaque(true);
		roleLbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		roleLbl_1.setForeground(new Color(219, 219, 219));
		roleLbl_1.setFont(new Font("Dialog", Font.BOLD, 13));
		roleLbl_1.setBackground(new Color(70, 163, 100));
		roleLbl_1.setBounds(105, 307, 138, 35);
		contentPane.add(roleLbl_1);
		
		text_gmail = new JTextField();
		text_gmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		text_gmail.setColumns(10);
		text_gmail.setBounds(242, 366, 258, 35);
		contentPane.add(text_gmail);
	}
	public void clickAddBtn() {
	    String fullName = fullNameTxt.getText();
	    String userName = userNameTxt.getText();
	    char[] passwordChars = passwordTxt.getPassword();
	    String password = new String(passwordChars);
	    String role = roleTxt.getText();
	    String gmail = text_gmail.getText();
	    // check role
	    List<String> allowedRoles = Arrays.asList("admin", "importstaff", "exportstaff", "manager");
	    if (!allowedRoles.contains(role)) {
	        JOptionPane.showMessageDialog(this, "Invalid role. Please choose one of the following: admin, importstaff, exportstaff, manager");
	        return;
	    }
	    // check acount
	    if (AccountDAO.getInstance().selectById(userName) != null) {
	        JOptionPane.showMessageDialog(this, "Username already exists!");
	        return;
	    }
	    // check mail
	    if (AccountDAO.getInstance().selectBygmail(gmail) != null) {
	        JOptionPane.showMessageDialog(this, "gmail already exists!");
	        return;
	    }
	    if (!isValidGmail(gmail)) {
	        JOptionPane.showMessageDialog(this, "Invalid Gmail format.");
	        return;
	    }
	 // Kiểm tra tính hợp lệ của mật khẩu
	    if (!isValidPassword(password)) {
	        JOptionPane.showMessageDialog(this, "Invalid password. Please make sure the password contains:\\n\" +\r\n"
	        		+ "  \"- At least 8 characters and maximum 20 characters\\n\" +\r\n"
	        		+ "  \"- At least one capital letter\\n\" +\r\n"
	        		+ "  \"- At least one special character");
	        return; 
	    }
	    try {
	    	// mã hóa mk
	        String hashedPassword = PasswordHashingService.generatePasswordHash(password);
	        Account account = new Account(fullName, userName, hashedPassword, role, gmail);
	        int check = AccountDAO.getInstance().insert(account);

	        if (check != 1) {
	            JOptionPane.showMessageDialog(this, "Failed to add account.");
	        }
	    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error hashing password.");
	    }
	}
	// check định dạng gmail
	private boolean isValidGmail(String gmail) {
	    String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(gmail);
	    return matcher.matches();
	}
	// ktra mật khẩu
	private boolean isValidPassword(String password) {
	    if (password.length() < 8 || password.length() > 20) {
	        return false;
	    }
	    boolean hasUpperCase = false;
	    boolean hasSpecialChar = false;
	    for (char c : password.toCharArray()) {
	        if (Character.isUpperCase(c)) {
	            hasUpperCase = true;
	        } else if (!Character.isLetterOrDigit(c)) {
	            hasSpecialChar = true;
	        }
	    }
	    return hasUpperCase && hasSpecialChar;
	}

	public void clickCancelBtn() {
		this.dispose();
		dashboard.setVisible(true);
	}
	public void clickRefreshBtn() {
		fullNameTxt.setText(null);
		userNameTxt.setText(null);
		passwordTxt.setText(null);
		roleTxt.setText(null);
		text_gmail.setText(null);
	}
}