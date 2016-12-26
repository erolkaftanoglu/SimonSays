/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaming;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author erol
 */
public class JGameFrame extends javax.swing.JFrame implements ActionListener {

    ArrayList<String> game;
    int turn = 1;
    int gameindex = 0;
    boolean newColor = false;

    /**
     * Creates new form JGameFrame
     */
    public JGameFrame() {
        initComponents();
        red.addActionListener(this);
        blue.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);
        game = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            game.add(getRandomString(r.nextInt(4)));
        }
        turnCount.setText("Turn: " + turn);

        ArrayList<JButton> buttons = new ArrayList<>();
        game.stream().forEach((string) -> {
            System.out.println("Game:" + string);
            jLabel2.setText(jLabel2.getText() + string + " ");
            buttons.add(getButton(string));
        });
        new Thread(new JButtonTimer(buttons)).start();

    }

    private String getRandomString(int i) {
        String x = "";
        switch (i) {
            case 0:
                x = "red";
                break;
            case 1:
                x = "yellow";
                break;
            case 2:
                x = "blue";
                break;
            case 3:
                x = "green";
                break;
        }
        return x;
    }

    private JButton getButton(String a) {
        JButton x = null;
        switch (a) {
            case "red":
                x = red;
                break;
            case "yellow":
                x = yellow;
                break;
            case "blue":
                x = blue;
                break;
            case "green":
                x = green;
                break;
        }
        return x;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        red = new javax.swing.JButton();
        blue = new javax.swing.JButton();
        yellow = new javax.swing.JButton();
        green = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        turnCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        red.setBackground(new java.awt.Color(255, 0, 0));
        red.setForeground(new java.awt.Color(255, 255, 255));
        red.setText("red");

        blue.setBackground(new java.awt.Color(0, 0, 255));
        blue.setForeground(new java.awt.Color(255, 255, 255));
        blue.setText("blue");

        yellow.setBackground(new java.awt.Color(204, 204, 0));
        yellow.setForeground(new java.awt.Color(255, 255, 255));
        yellow.setText("yellow");

        green.setBackground(new java.awt.Color(0, 204, 0));
        green.setForeground(new java.awt.Color(255, 255, 255));
        green.setText("green");

        jLabel1.setText("jLabel1");

        jLabel2.setText("İpucu: ");

        jButton1.setText("İpucu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        turnCount.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(turnCount))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(yellow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(green, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(blue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 105, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(turnCount))
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(green, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(yellow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList<JButton> buttons = new ArrayList<>();
        game.stream().forEach((string) -> {
            buttons.add(getButton(string));
        });
        new Thread(new JButtonTimer(buttons)).start();


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JGameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blue;
    private javax.swing.JButton green;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton red;
    private javax.swing.JLabel turnCount;
    private javax.swing.JButton yellow;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        turnCount.setText("Turn: " + turn);
        String s = e.getActionCommand();
        if (newColor) {
            s = e.getActionCommand();
            game.add(s);
            newColor = false;
            jLabel1.setText("");

        } else if (gameindex == game.size() - 1) {
            changeStatus();
            JOptionPane.showMessageDialog(this, "Choose new color");
            newColor = true;
            turn++;
            gameindex = 0;
            turnCount.setText("Turn: " + turn);
            System.out.println("game: " + game.toString());
            jLabel1.setText("Lütfen bir renk seçin");
        } else if (s == null ? game.get(gameindex) == null : s.equals(game.get(gameindex))) {
            gameindex++;
            System.out.println(game.toString());
            jLabel1.setText("");
        } else {
            int n = JOptionPane.showConfirmDialog(
                    this,
                    "Yeniden oynamak ister mi siniz ?",
                    "oyun",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                this.setVisible(false);
                new JGameFrame().setVisible(true);
            } else {
                System.exit(0);
            }
        }

    }

    private void changeStatus() {
        red.setEnabled(false);
                green.setEnabled(false);
        yellow.setEnabled(false);
        blue.setEnabled(false);

        ArrayList<JButton> status = new ArrayList<>();
        status.add(red);
        status.add(blue);
        status.add(yellow);
        status.add(green);
        new Thread(new JButtonTimer(status)).start();
    }

}
