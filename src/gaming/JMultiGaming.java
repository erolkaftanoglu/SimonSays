/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaming;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author erol
 */
public class JMultiGaming extends javax.swing.JFrame implements ActionListener {

    private static int PORT = 8901;
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    /**
     * Creates new form JMultiGaming
     */
    public JMultiGaming() throws Exception {
        initComponents();
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        yellow.addActionListener(this);
        System.out.println("start client");
        connectToServer();

    }

    public void connectToServer() throws IOException, Exception {

        // Get the server address from a dialog box.
        socket = new Socket("localhost", PORT);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    play();
                } catch (Exception ex) {
                }
            }
        }).start();
        if (!wantsToPlayAgain()) {
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        turnCount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        yellow = new javax.swing.JButton();
        green = new javax.swing.JButton();
        red = new javax.swing.JButton();
        blue = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        turnCount.setText("jLabel3");

        jLabel2.setText("İpucu: ");

        jLabel1.setText("jLabel1");

        yellow.setBackground(new java.awt.Color(204, 204, 0));
        yellow.setForeground(new java.awt.Color(255, 255, 255));
        yellow.setText("yellow");

        green.setBackground(new java.awt.Color(0, 204, 0));
        green.setForeground(new java.awt.Color(255, 255, 255));
        green.setText("green");

        red.setBackground(new java.awt.Color(255, 0, 0));
        red.setForeground(new java.awt.Color(255, 255, 255));
        red.setText("red");

        blue.setBackground(new java.awt.Color(0, 0, 255));
        blue.setForeground(new java.awt.Color(255, 255, 255));
        blue.setText("blue");

        jButton1.setText("İpucu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                                .addGap(0, 171, Short.MAX_VALUE)))
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
                .addGap(18, 18, Short.MAX_VALUE)
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
        ArrayList<String> game = Game.colors;
        game.stream().forEach((string) -> {
            buttons.add(getButton(string));
        });
        new Thread(new JButtonTimer(buttons)).start();

    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(JMultiGaming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMultiGaming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMultiGaming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMultiGaming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JMultiGaming().setVisible(true);
                } catch (Exception ex) {
                }
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
    
    boolean newColor = false;
    int turn = 1;
    int gameindex = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        ArrayList<String> game = Game.colors;
        if (newColor) {
            newColor = false;
            jLabel1.setText("");
            out.println("MOVE " + e.getActionCommand());
        } else if (gameindex == game.size() - 1) {
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
            //lost
            System.out.println("kaybettin");
            out.println("VICTORY");
            jLabel1.setText("Kaybettin");
        }
        
    }

    public void play() throws Exception {
        String response;
        try {
            response = in.readLine();
            if (response.startsWith("WELCOME")) {
                char mark = response.charAt(8);
                jLabel2.setText("Simon - Player " + mark);
            }
            while (true) {
                response = in.readLine();
                if (response.startsWith("VALID_MOVE")) {
                    jLabel1.setText("Doğru hamle, lütfen bekleyiniz.");

                } else if (response.startsWith("OPPONENT_MOVED")) {
                    jLabel1.setText("Karşı taraf oynadı, sıra sende");
                    ArrayList<JButton> buttons = new ArrayList<>();
                    ArrayList<String> game = Game.colors;
                    game.stream().forEach((string) -> {
                        buttons.add(getButton(string));
                    });
                    new Thread(new JButtonTimer(buttons)).start();

                } else if (response.startsWith("VICTORY")) {
                    jLabel1.setText("You win");
                    break;
                } else if (response.startsWith("DEFEAT")) {
                    jLabel1.setText("You lose");
                    break;
                } else if (response.startsWith("TIE")) {
                    jLabel1.setText("You tied");
                    break;
                } else if (response.startsWith("MESSAGE")) {
                    jLabel1.setText(response.substring(8));
                }
            }
            out.println("QUIT");
        } finally {
            socket.close();
        }
    }

    private boolean wantsToPlayAgain() {
        int response = JOptionPane.showConfirmDialog(this,
                "Want to play again?",
                "Simon Says",
                JOptionPane.YES_NO_OPTION);
        this.dispose();
        return response == JOptionPane.YES_OPTION;
    }
}
