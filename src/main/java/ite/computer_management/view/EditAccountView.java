
package ite.computer_management.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;

import ite.computer_management.controller.EditAccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants; 
public class EditAccountView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField userNameTxt;
	public JTextField roleTxt;
	public JButton updateBtn;
	public JButton refreshBtn;
	public JButton cancelBtn;
	public AccountView accountView;
	private JLabel titleLbl;
	private JLabel gmail;
	public JTextField mailtxt;

	public EditAccountView(AccountView accountView, Dashboard dashboard) {
		this.accountView = accountView;
		init();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		this.setVisible(true);
	}
	public void init() {
		EditAccountController editAccountController = new EditAccountController(this);
		setBounds(100, 100, 638, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userNameLbl = new JLabel("User Name");
		userNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLbl.setBounds(77, 151, 119, 49);
		userNameLbl.setOpaque(true);
		userNameLbl.setBackground(new Color(70, 163, 100));
		userNameLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(userNameLbl);
		
		JLabel roleLbl = new JLabel("Role");
		roleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		roleLbl.setBounds(77, 246,119, 48);
		roleLbl.setOpaque(true);
		roleLbl.setBackground(new Color(70, 163, 100));
		roleLbl.setForeground(new Color(219, 219, 219));
		contentPane.add(roleLbl);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		userNameTxt.setEditable(false);
		userNameTxt.setBounds(197, 151, 349, 48);
		contentPane.add(userNameTxt);
		
		roleTxt = new JTextField();
		roleTxt.setColumns(10);
		roleTxt.setBounds(197, 246, 349, 48);
		contentPane.add(roleTxt);
		
		updateBtn = new JButton("UPDATE");
		updateBtn.setIcon(new ImageIcon(EditAccountView.class.getResource("/ite/computer_management/img/icons8-update-30.png")));
		updateBtn.setBounds(248, 421, 119, 43);
		updateBtn.setOpaque(true);
		updateBtn.setBackground(new Color(219, 219, 219));
		updateBtn.setForeground(new Color(70, 163, 100));
		updateBtn.addMouseListener(editAccountController);
		contentPane.add(updateBtn);
		
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setIcon(new ImageIcon(EditAccountView.class.getResource("/ite/computer_management/img/icons8-cancel-30.png")));
		cancelBtn.setBounds(77, 421, 132, 43);
		cancelBtn.setOpaque(true);
		cancelBtn.setBackground(new Color(219, 219, 219));
		cancelBtn.setForeground(new Color(70, 163, 100));
		cancelBtn.addMouseListener(editAccountController);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("REFRESH");
		refreshBtn.setIcon(new ImageIcon(EditAccountView.class.getResource("/ite/computer_management/img/icons8-refresh-30.png")));
		refreshBtn.setBounds(414, 421, 132, 43);
		refreshBtn.setOpaque(true);
		refreshBtn.setBackground(new Color(219, 219, 219));
		refreshBtn.setForeground(new Color(70, 163, 100));
		refreshBtn.addMouseListener(editAccountController);
		contentPane.add(refreshBtn);
		
		titleLbl = new JLabel("EDIT ACCOUNT");
		titleLbl.setBounds(0, 0, 646, 102);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Hack", Font.BOLD, 24));
		titleLbl.setForeground(new Color(219, 219, 219));
		titleLbl.setBackground(new Color(70, 163, 100));
		titleLbl.setOpaque(true);
		titleLbl.setBounds(0, 0, 622, 102);
		contentPane.add(titleLbl);
		
		gmail = new JLabel("Gmail");
		gmail.setOpaque(true);
		gmail.setHorizontalAlignment(SwingConstants.CENTER);
		gmail.setForeground(new Color(219, 219, 219));
		gmail.setBackground(new Color(70, 163, 100));
		gmail.setBounds(77, 332, 119, 48);
		contentPane.add(gmail);
		
		mailtxt = new JTextField();
		mailtxt.setColumns(10);
		mailtxt.setBounds(197, 332, 349, 48);
		contentPane.add(mailtxt);
	}

	public void clickUpdateBtn() {
		String userName = userNameTxt.getText();
		String role = roleTxt.getText();
		String gmail = mailtxt.getText();
		Account account = new Account(userName, role, gmail);
		
		int selectedRowIndex =  accountView.table.getSelectedRow();
		String userNameCondition = (String) accountView.model.getValueAt(selectedRowIndex, 1);

		int check = AccountDAO.getInstance().update(account, userNameCondition);
			accountView.model.setValueAt(userName, selectedRowIndex, 1);
			accountView.model.setValueAt(role, selectedRowIndex, 3);
			accountView.model.setValueAt(gmail, selectedRowIndex, 4);
		
	}

	public void clickCancelBtn() {
		this.dispose();
	}

	public void clickRefreshBtn() {
		userNameTxt.setText(null);
		roleTxt.setText(null);
		mailtxt.setText(null);
	}

}

