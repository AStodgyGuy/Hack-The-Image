import java.io.*;
import java.lang.Exception.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;
import java.net.InetAddress;

public class Receiver extends JFrame {

    private JButton BUT_Decrypt;
    private JButton BUT_Outbox;
    private JLabel imageLabel;
    private JLabel jLabel2;
    private JTextField TF_DecryptedMessage;
    
    public Receiver() {
       receiverComponents();
    }

    @SuppressWarnings("unchecked") 
    private void receiverComponents() {

        
        jLabel2 = new JLabel();
        BUT_Decrypt = new JButton();
        TF_DecryptedMessage = new JTextField();
        BUT_Outbox = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //insert picture into label
        //ImageIcon image = new ImageIcon(bufferedimage)
        //imageLabel = new JLabel(bufferedimage);
        
        

        jLabel2.setText("Decrypted message:");

        BUT_Decrypt.setText("Decrypt message");

        TF_DecryptedMessage.setText("Decrypted message is displayed here");
        //insert decryption algorithm here

        BUT_Outbox.setText("Outbox");
        //link userInterface.java

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_DecryptedMessage)))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 74, Short.MAX_VALUE)
                .addComponent(BUT_Decrypt, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(BUT_Outbox, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_DecryptedMessage)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BUT_Decrypt, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BUT_Outbox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
    	Receiver application = new Receiver();
    	application.setVisible(true);
    	
    }

    

    // End of variables declaration//GEN-END:variables
}
