package my_swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import function.Method;

public class Send_Sound extends javax.swing.JPanel {
	
	private JLabel lbTime;
	private JProgressBar play;
    private byte[] sound;
    private boolean over = false;

    public Send_Sound() {
        initComponents();
    }

    public void set(byte[] sound, String time) {
        this.sound = sound;
        lbTime.setText(time.split("!")[0]);
        play.setMaximum(Integer.valueOf(time.split("!")[1]));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        play = new JProgressBar();
        lbTime = new JLabel();

        setBackground(new Color(255, 255, 255));
        setMaximumSize(new Dimension(600, 45));

        play.setCursor(new Cursor(Cursor.HAND_CURSOR));
        play.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                playStateChanged(evt);
            }
        });
        play.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                playMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                playMouseExited(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                playMouseReleased(evt);
            }
        });

        lbTime.setFont(new Font("sansserif", 0, 13)); // NOI18N
        lbTime.setHorizontalAlignment(SwingConstants.TRAILING);
        lbTime.setText("0:00");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTime, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(play, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(play, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private boolean p = false;
    private void playStateChanged(ChangeEvent evt) {
        if (play.getValue() >= play.getMaximum()) {
            p = false;
        }
    }

    private void playMouseEntered(MouseEvent evt) {
        over = true;
    }

    private void playMouseExited(MouseEvent evt) {
        over = false;
    }

    private void playMouseReleased(MouseEvent evt) {
        if (over) {
            if (!p) {
                play.setValue(0);
                Method.getRecoder().playAudio(sound, play);
                p = true;
            } else {
                Method.getRecoder().stopPlay();
                p = false;
            }
        }
    }
 
   
}
