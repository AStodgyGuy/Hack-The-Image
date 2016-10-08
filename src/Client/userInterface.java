import java.lang.Object;
import java.lang.Exception.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.io.*;

public class userInterface extends JFrame {
 
	
	
	//UI code
	@SuppressWarnings("unchecked")
	public void initComponents() {

        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JTextField TF_UserIP = new javax.swing.JTextField();
        JTextField TF_ReceiverIP = new javax.swing.JTextField();
        JTextField TF_UserMessage = new javax.swing.JTextField();
        JButton BUT_ChooseFile = new javax.swing.JButton();
        JButton BUT_Webcam = new javax.swing.JButton();
        JButton BUT_Send = new javax.swing.JButton();
        JButton BUT_Switch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Your IP:");

        jLabel2.setText("Receiver IP: ");

        jLabel3.setText("Write a message:");

        jLabel4.setText("Attach Image:");
        
        try {
        	TF_UserIP.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e) {
        	System.out.print("lmao");
        }
        
        TF_ReceiverIP.setText("Receiver IP Goes Here");

        TF_UserMessage.setText("Message goes here");

        BUT_ChooseFile.setText("Choose File...");

        BUT_Webcam.setText("jButton2");

        BUT_Send.setText("Encrpyt and Send Image");

        BUT_Switch.setText("Inbox");       
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(BUT_Send,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF_UserIP)
                            .addComponent(TF_ReceiverIP)
                            .addComponent(TF_UserMessage)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BUT_ChooseFile, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BUT_Webcam, GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(BUT_Switch, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TF_UserIP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_ReceiverIP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_UserMessage, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUT_ChooseFile, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUT_Webcam, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BUT_Send, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BUT_Switch)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TF_UserIP.setEditable(false);
        
        pack();
    }
	
	//runs initcomponents
	public userInterface(){
		initComponents();
	}
	
	//chooses file
	BUT_ChooseFile.addActionListener(new ActionListener() {	
		public void actionPerformed (ActionEvent e) {
			BufferedImage img = null;
			try {
			    img = ImageIO.read(new File("strawberry.jpg"));
			} catch (IOException event) {
				System.out.println("Not a valid file")
			}
		}
	});
	
		

	
	//creates new userInterface object and shows
    public static void main(String args[]) {
    	userInterface application = new userInterface();
        application.setVisible(true);
      }

}