package ite.computer_management.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import ite.computer_management.model.Account;

public class Sub1MyInformation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField fullNameTxt;
	private JTextField userNameTxt;
	private Account account;

	/**
	 * Create the panel.
	 */
	public Sub1MyInformation(Account account) {
		this.account = account;
		this.setSize(684,290);
		setLayout(null);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setBounds(104, 69, 80, 39);
		fullNameLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		add(fullNameLbl);
		
		fullNameTxt = new JTextField(account.getFullName());
		fullNameTxt.setBounds(208, 69, 375, 39);
		fullNameTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		fullNameTxt.setColumns(10);
		fullNameTxt.setEditable(false);
		add(fullNameTxt);
		
		JLabel userNameLbl = new JLabel("Role");
		userNameLbl.setBounds(104, 138, 94, 39);
		userNameLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		add(userNameLbl);
		
		userNameTxt = new JTextField(account.getRole());
		userNameTxt.setBounds(208, 138, 375, 39);
		userNameTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		userNameTxt.setColumns(10);
		userNameTxt.setEditable(false);
		add(userNameTxt);
		
		this.setVisible(true);
	}

}
