package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chart.MailCode;
import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.PasswordHashingService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ChangepassView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField gmailtext;
    private JPasswordField mk_text;
    private JTextField textcode;
    public String codeGenerateFromServer;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangepassView frame = new ChangepassView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ChangepassView() {
        setTitle("Computer mangement");
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\lgo - Copy - Copy.png"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 935, 568);
        contentPane = 	new JPanel();
        contentPane.setBackground(new Color(144, 238, 144));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel gmail = new JLabel("Gmail:");
        gmail.setBounds(89, 136, 115, 29);
        gmail.setForeground(SystemColor.window);
        gmail.setFont(new Font("Arial", Font.BOLD, 17));
        contentPane.add(gmail);
        
        gmailtext = new JTextField();
        gmailtext.setBounds(89, 164, 232, 29);
        contentPane.add(gmailtext);
        gmailtext.setColumns(10);
        
        JLabel mk = new JLabel("New Password:");
        mk.setBounds(89, 256, 147, 29);
        mk.setForeground(SystemColor.window);
        mk.setFont(new Font("Arial", Font.BOLD, 17));
        contentPane.add(mk);
        
        mk_text = new JPasswordField();
        mk_text.setBounds(89, 284, 232, 27);
        contentPane.add(mk_text);
        
        JButton Nut_Dangki = new JButton("LOG IN");
        Nut_Dangki.setBounds(89, 333, 88, 29);
        Nut_Dangki.setBackground(Color.WHITE);
        Nut_Dangki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               LogInView view = new LogInView();
               dispose();
               view.setVisible(true);
            }
        });
        
        Nut_Dangki.setFont(new Font("Arial", Font.BOLD, 14));
        contentPane.add(Nut_Dangki);
        
        JButton Nut_Dangnhap = new JButton("CHANGE PASS");
        Nut_Dangnhap.setBounds(180, 334, 141, 29);
        Nut_Dangnhap.setBackground(Color.WHITE);
        Nut_Dangnhap.addActionListener(new ActionListener() {
            ResultSet rs;
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
            	 String code_enter = textcode.getText().trim();
                 String code_sent = MailCode.laymaTeenCode();
 
                 if (code_enter.equals(code_sent)) {
                     try {
                         String newPassword = new String(mk_text.getPassword());
                         String gmail = gmailtext.getText(); 
                         String hashedPassword = PasswordHashingService.generatePasswordHash(newPassword);
                         if (changePasswordInDatabase(gmail, hashedPassword)) {
                             JOptionPane.showMessageDialog(null, "Password changed successfully!");
                         } else {
                             JOptionPane.showMessageDialog(null, "fail");
                         }
                     } catch (SQLException e1) {
                         e1.printStackTrace();
                         JOptionPane.showMessageDialog(null, "Error when querying the database: " + e1.getMessage());
                     } catch (NoSuchAlgorithmException e1) {
                    	 System.out.println("mã hóa thất bại");
						e1.printStackTrace();
					} catch (InvalidKeySpecException e1) {
						
						e1.printStackTrace();
					}
                 } else {
                     // Mã xác nhận không khớp
                     JOptionPane.showMessageDialog(null, "Incorrect code. Please try again!");
                 }
            }
        }
        );
        Nut_Dangnhap.setFont(new Font("Arial", Font.BOLD, 13));
        contentPane.add(Nut_Dangnhap);
        
        JButton Nut_thoat = new JButton("Cancel");
        Nut_thoat.setBounds(242, 378, 79, 29);
        Nut_thoat.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 152951.png"));
        Nut_thoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  System.exit(0);
            }
        });
        Nut_thoat.setBackground(Color.WHITE);
        Nut_thoat.setFont(new Font("Arial", Font.BOLD, 12));
        contentPane.add(Nut_thoat);
        
        JButton Nut_DoiMk = new JButton("get code");
        Nut_DoiMk.setBounds(92, 378, 147, 29);
        Nut_DoiMk.setBackground(Color.WHITE);
        Nut_DoiMk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					Connection c = ConnectDatabase.getConnection();
					ResultSet rs;
					if (gmailtext.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "please enter gmail");
					}
					String sql = "select * from account where gmail=?";
					PreparedStatement ps = c.prepareStatement(sql);
					
					ps.setString(1, gmailtext.getText());
					rs = ps.executeQuery();
					
					if(rs.next()) {
					  MailCode.guiTeenCodequa_gmail(gmailtext.getText());
						JOptionPane.showMessageDialog(null, "sent successfully" + gmailtext.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Gmail doesn't exist");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
              
            }
        });
        Nut_DoiMk.setFont(new Font("Arial", Font.BOLD, 12));
        contentPane.add(Nut_DoiMk);
        
        JToggleButton Nut_hienMK = new JToggleButton("");
        Nut_hienMK.setBounds(268, 258, 53, 22);
        Nut_hienMK.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\anhhhhhhhhh\\Screenshot 2023-12-23 194914.png"));
        Nut_hienMK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 if (Nut_hienMK.isSelected()) {
                        mk_text.setEchoChar('\0');
                    } else {
                        mk_text.setEchoChar('*');
                    }
                
            }
        });
        Nut_hienMK.setFont(new Font("Arial", Font.BOLD, 18));
        Nut_hienMK.setBackground(Color.LIGHT_GRAY);
        Nut_hienMK.setForeground(Color.BLACK);
        contentPane.add(Nut_hienMK);
        
        textcode = new JTextField();
        textcode.setBounds(89, 223, 232, 29);
        textcode.setColumns(10);
        contentPane.add(textcode);
        
        JLabel lblGmail = new JLabel("Code:");
        lblGmail.setBounds(89, 193, 115, 29);
        lblGmail.setForeground(SystemColor.window);
        lblGmail.setFont(new Font("Arial", Font.BOLD, 17));
        contentPane.add(lblGmail);
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBounds(0, -11, 459, 529);
        verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        contentPane.add(verticalBox);
        
        JLabel dangnhap_1 = new JLabel("");
        dangnhap_1.setBounds(454, 44, 455, 458);
        contentPane.add(dangnhap_1);
        dangnhap_1.setIcon(new ImageIcon(ChangepassView.class.getResource("/ite/computer_management/img/logo2 - Copy.png")));
        dangnhap_1.setFont(new Font("Arial", Font.BOLD, 27));
        
        JLabel lblLogIn = new JLabel("CHANGE PASS");
        lblLogIn.setBounds(91, 40, 240, 60);
        contentPane.add(lblLogIn);
        lblLogIn.setForeground(new Color(0, 0, 0));
        lblLogIn.setFont(new Font("Freestyle Script", Font.BOLD, 50));
        
        JLabel dangnhap_1_1 = new JLabel("");
        dangnhap_1_1.setBounds(-92, -47, 1032, 592);
        dangnhap_1_1.setIcon(new ImageIcon(ChangepassView.class.getResource("/ite/computer_management/img/anh.jpg")));
        dangnhap_1_1.setFont(new Font("Arial", Font.BOLD, 27));
        contentPane.add(dangnhap_1_1);
    }  
    private boolean changePasswordInDatabase(String gmail, String newPassword) throws SQLException {
        try (Connection conn = ConnectDatabase.getConnection()) {
            String sql = "UPDATE account SET password = ? WHERE gmail = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, gmail);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
}