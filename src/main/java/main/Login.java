package main;

import function.FileChooser;
import function.Method;
import ite.computer_management.view.Dashboard;
import my_swing.Button;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;

import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DropMode;

public class Login extends JFrame {
    private  JLabel border;
    private Button cmdLogin;
    private  JLayeredPane jLayeredPane1;
    private  JPanel jPanel1;
    private  JLabel lbStatus;
    private  JLabel profile;
    private  JTextField txtIP;
    public  JTextField txtUser;
	private Button btnCancel;
	String username;
    public Login() {
        initComponents();
        open();
 
    }
    public Login(String username) {
        initComponents();
        open();
        this.username = username; 
    }
    private void open() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA_project\\computer-management-system\\src\\main\\java\\ite\\computer_management\\img\\Chat-room.png"));
     
        Method.setTextFieldSyle(txtIP, "IP Address");
        showStatus(ms);
        SwingUtilities.invokeLater(() -> { 
            txtUser.setText(username); 
        });
    }


   
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new JPanel();
        txtIP = new JTextField();
        txtUser = new JTextField();
     

        cmdLogin = new Button();
        jLayeredPane1 = new JLayeredPane();
        border = new JLabel();
        profile = new JLabel();
        lbStatus = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log in chat");
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));

        txtIP.setBackground(new Color(204, 204, 204));
        txtIP.setFont(new Font("Khmer SBBIC Serif", 1, 18)); 
        txtIP.setHorizontalAlignment(JTextField.CENTER);
        txtIP.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
        txtIP.setSelectionColor(new Color(131, 188, 227));
        txtIP.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                txtIPKeyTyped(evt);
            }
        });

        txtUser.setBackground(new Color(204, 204, 204));
        txtUser.setFont(new Font("Khmer SBBIC Serif", 1, 18)); 
        txtUser.setHorizontalAlignment( JTextField.CENTER);
        txtUser.setBorder( BorderFactory.createEmptyBorder(1, 10, 1, 10));
        txtUser.setSelectionColor(new Color(131, 188, 227));
        txtUser.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                txtIPKeyTyped(evt);
            }
        });

        cmdLogin.setBackground(new Color(101, 167, 232));
        cmdLogin.setForeground(new Color(255, 255, 255));
        cmdLogin.setText("Log in");
        cmdLogin.setColorClick(new Color(152, 196, 239));
        cmdLogin.setColorOver(new Color(31, 121, 208));
        cmdLogin.setFillBorder(20);
        cmdLogin.setFocusable(false);
        cmdLogin.setFont(new Font("sansserif", 1, 14)); // NOI18N
        cmdLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayout(new  OverlayLayout(jLayeredPane1));

        border.setHorizontalAlignment( SwingConstants.CENTER);
        border.setIcon(new  ImageIcon(getClass().getResource("/icon/border.png"))); // NOI18N
        border.setCursor(new Cursor(Cursor.HAND_CURSOR));
        border.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                borderMouseClicked(evt);
            }
        });
        jLayeredPane1.add(border);

        profile.setHorizontalAlignment( SwingConstants.CENTER);
        profile.setIcon(new  ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        jLayeredPane1.add(profile);

        lbStatus.setFont(new java.awt.Font("Khmer SBBIC Serif", 0, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(204, 0, 0));
        lbStatus.setHorizontalAlignment( SwingConstants.CENTER);
         
         btnCancel = new Button();
         btnCancel.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		Window window = SwingUtilities.getWindowAncestor(btnCancel); 

                if (window != null) {
                    window.dispose();
                }
         	}
         });
         btnCancel.setText("Cancel");
         btnCancel.setForeground(Color.WHITE);
         btnCancel.setFont(new Font("SansSerif", Font.BOLD, 14));
         btnCancel.setFocusable(false);
         btnCancel.setFillBorder(20);
         btnCancel.setColorOver(new Color(31, 121, 208));
         btnCancel.setColorClick(new Color(152, 196, 239));
         btnCancel.setBackground(Color.RED);

         GroupLayout jPanel1Layout = new  GroupLayout(jPanel1);
         jPanel1Layout.setHorizontalGroup(
         	jPanel1Layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(jPanel1Layout.createSequentialGroup()
         			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
         				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
         					.addContainerGap()
         					.addComponent(lbStatus, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
         				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
         					.addGap(76)
         					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
         						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
         						.addComponent(txtIP, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
         						.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
         							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
         							.addPreferredGap(ComponentPlacement.RELATED)
         							.addComponent(cmdLogin, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
         					.addGap(84))
         				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
         					.addGap(170)
         					.addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         					.addGap(0, 164, Short.MAX_VALUE)))
         			.addContainerGap())
         );
         jPanel1Layout.setVerticalGroup(
         	jPanel1Layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(jPanel1Layout.createSequentialGroup()
         			.addGap(24)
         			.addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
         			.addGap(18)
         			.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(txtIP, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.UNRELATED)
         			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
         				.addComponent(cmdLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
         				.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
         			.addGap(11)
         			.addComponent(lbStatus, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap())
         );
        jPanel1.setLayout(jPanel1Layout);

         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {
        try {
        
              
                    String IP = txtIP.getText().trim();
                    if (txtIP.getText().equals("") || !txtIP.getName().equals("have")) {
                        IP = "localhost";
                        System.err.println("have");
                    }
                    String userName = txtUser.getText().trim();
                    Method.connect(profile_pic, userName, IP);
                    this.dispose();
                    Main.main(null);
                

            
        } catch (UnknownHostException e) {
            showStatus("Unknown host : " + txtIP.getText());
        } catch (java.rmi.UnknownHostException e) {
            showStatus("Unknown host : " + txtIP.getText());
        } catch (ConnectException e) {
            showStatus("Server not found");
        } catch (java.rmi.ConnectException e) {
            showStatus("Server not found");
        } catch (Exception e) {
            showStatus("Network is unreachable : connect");
            System.out.println(e);
        }

    }//GEN-LAST:event_cmdLoginActionPerformed

    private void borderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borderMouseClicked
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
            JFileChooser ch = new JFileChooser();
            FileChooser preview = new FileChooser();
            ch.setAccessory(preview);
            ch.addPropertyChangeListener(preview);
            ch.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    String name = file.getName();
                    return file.isDirectory() || name.endsWith(".png") || name.endsWith(".PNG") || name.endsWith("jpg") || name.endsWith("JPG");
                }

                @Override
                public String getDescription() {
                    return "png,jpg";
                }
            });
            int opt = ch.showOpenDialog(this);
            if (opt == JFileChooser.APPROVE_OPTION) {
                ImageIcon image = new ImageIcon(ch.getSelectedFile().getAbsolutePath());
                Image img;
                if (image.getIconWidth() > image.getIconHeight()) {
                    img = image.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
                } else {
                    img = image.getImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
                }
                profile_pic = new ImageIcon(img);
                profile.setIcon(profile_pic);
            }
        }
    }

    private void txtUserKeyTyped(KeyEvent evt) {
        if (evt.getKeyChar() == 10) {
            txtIP.grabFocus();
        }
        if (txtUser.getText().trim().length() >= 15) {
            evt.consume();
        }
    }

    private void txtIPKeyTyped(KeyEvent evt) {
        if (evt.getKeyChar() == 10) {
            cmdLoginActionPerformed(null);
        }
    }

    private ImageIcon profile_pic;
    private Timer timer = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lbStatus.setText("");
            timer.stop();
        }
    });

    private void showStatus(String error) {
        if (timer.isRunning()) {
            lbStatus.setText("");
            timer.stop();
        }
        timer.start();
        lbStatus.setText(error);
    }

    private static String ms = "";

    public static void main(String args[]) {
        try {
            for ( UIManager.LookAndFeelInfo info :  UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                     UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

      EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (args.length == 1) {
                    ms = args[0];
                }
                new Login().setVisible(true);
            }
        });
    }
}
