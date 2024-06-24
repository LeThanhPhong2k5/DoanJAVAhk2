package my_swing;

import function.Method;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;



public class Get_Emoji_New extends  JPanel {

    private JLabel border;
    private JLayeredPane jLayeredPane1;
    private JLabel lb;
    private JLabel lbName;
    private JLabel profile;
    
    public Get_Emoji_New() {
        initComponents();
    }

    public void setPhoto(int ID, String emoji) {
        if (Method.getFriends().get(ID).getImage() != null) {
            profile.setIcon(Method.getFriends().get(ID).getImage());
        }
        lbName.setText(Method.getFriends().get(ID).getfName());
        lb.setIcon(new ImageIcon(getClass().getResource("/emoji/" + emoji)));
    }

    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jLayeredPane1 = new JLayeredPane();
        border = new JLabel();
        profile = new JLabel();
        lb = new JLabel();
        lbName = new JLabel();

        setBackground(new Color(255, 255, 255));
        setMaximumSize(new  Dimension(600, 104));
        setPreferredSize(new  Dimension(600, 104));

        jLayeredPane1.setLayout(new  OverlayLayout(jLayeredPane1));

        border.setHorizontalAlignment( SwingConstants.CENTER);
        border.setIcon(new  ImageIcon(getClass().getResource("/icon/border_small.png"))); 
        jLayeredPane1.add(border);

        profile.setHorizontalAlignment( SwingConstants.CENTER);
        profile.setIcon(new  ImageIcon(getClass().getResource("/icon/profile_small.png"))); 
        jLayeredPane1.add(profile);

        lb.setHorizontalAlignment( SwingConstants.CENTER);
        lb.setIcon(new  ImageIcon(getClass().getResource("/emoji/emoji_green (1).png"))); 

        lbName.setFont(new  Font("Khmer SBBIC Serif", 1, 12)); 
        lbName.setForeground(new  Color(29, 118, 206));
        lbName.setText("Name");

         GroupLayout layout = new  GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1,  GroupLayout.PREFERRED_SIZE, 60,  GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(lbName,  GroupLayout.PREFERRED_SIZE, 236,  GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(172, 172, 172)))
                .addGap(280, 280, 280))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName,  GroupLayout.PREFERRED_SIZE, 22,  GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLayeredPane1,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }

}
