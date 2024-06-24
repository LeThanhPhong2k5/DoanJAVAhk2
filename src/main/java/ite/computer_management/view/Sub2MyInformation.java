package ite.computer_management.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;
import ite.computer_management.model.PasswordHashingService;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Sub2MyInformation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField currentPasswordTxt;
	private JTextField newPasswordTxt;
	private JTextField reEnterPasswordTxt;
	private Account account;

	/**
	 * Create the panel.
	 */
	public Sub2MyInformation(Account account){
		this.account = account;
		this.setSize(684,290);
		setLayout(null);
		
		JLabel currentPasswordLbl = new JLabel("Current password");
		currentPasswordLbl.setBounds(92, 27, 171, 35);
		currentPasswordLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		add(currentPasswordLbl);
		
		currentPasswordTxt = new JTextField();
		currentPasswordTxt.setBounds(326, 25, 302, 40);
		currentPasswordTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		currentPasswordTxt.setColumns(10);
		add(currentPasswordTxt);
		
		JLabel newPasswordLbl = new JLabel("New Password");
		newPasswordLbl.setBounds(92, 92, 171, 35);
		newPasswordLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		add(newPasswordLbl);
		
		JLabel reEnterPasswordLbl = new JLabel("Re-enter password");
		reEnterPasswordLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		reEnterPasswordLbl.setBounds(92, 149, 186, 35);
		add(reEnterPasswordLbl);
		
		newPasswordTxt = new JTextField();
		newPasswordTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		newPasswordTxt.setColumns(10);
		newPasswordTxt.setBounds(326, 92, 302, 40);
		add(newPasswordTxt); 
		
		reEnterPasswordTxt = new JTextField();
		reEnterPasswordTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		reEnterPasswordTxt.setColumns(10);
		reEnterPasswordTxt.setBounds(326, 149, 302, 40);
		add(reEnterPasswordTxt);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newPassword = newPasswordTxt.getText();
				String currentPassword = currentPasswordTxt.getText();
				String reEnterPassword = reEnterPasswordTxt.getText();
				String userName = account.getUserName();
				
				   if (!isValidPassword(newPassword)) {
				        JOptionPane.showMessageDialog(null, "Invalid password. Please make sure the password contains:\\n\" +\r\n"
				        		+ "  \"- At least 8 characters and maximum 20 characters\\n\" +\r\n"
				        		+ "  \"- At least one capital letter\\n\" +\r\n"
				        		+ "  \"- At least one special character");
				        return; 
				    }
				   Account accountReturn = AccountDAO.getInstance().select1AccountByUsername(userName);
				   String storedPassword = accountReturn.getPassword();
				   try {
					   
		
					if(newPassword.equalsIgnoreCase(reEnterPassword)) {
						 if (PasswordHashingService.validatePassword(currentPassword, storedPassword)) {
							 String hashedPassword = PasswordHashingService.generatePasswordHash(newPassword);		
							 AccountDAO.getInstance().updatePassword(hashedPassword, userName);
							 JOptionPane.showMessageDialog(null, "Update password successfully");
							 newPasswordTxt.setText(null);
							 currentPasswordTxt.setText(null);
							 reEnterPasswordTxt.setText(null);
						 } 
					}else {
					JOptionPane.showMessageDialog(submitBtn, "The re-entered password does not match the new password :(");
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		submitBtn.setFont(new Font("Roboto", Font.BOLD, 16));
		submitBtn.setBounds(253, 211, 153, 47);
		submitBtn.setOpaque(true);
		submitBtn.setBackground(new Color(70, 163, 100));
		submitBtn.setForeground(new Color(255,255,255));
		add(submitBtn);	
		this.setVisible(true);
		
	}
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
}
