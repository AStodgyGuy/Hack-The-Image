import java.lang.Exception.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.Object;
import java.net.InetAddress;

public class userInterface extends JFrame {
	
	private String URL;
	private JButton BUT_ChooseFile;
    private JButton BUT_Send;
    private JButton BUT_Switch;
    private JButton BUT_Webcam;
    private JTextField TF_ReceiverIP;
    private JTextField TF_UserIP;
    private JTextField TF_UserMessage;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;

	//UI code
	@SuppressWarnings("unchecked")
	public void initComponents() {

		JLabel jLabel1 = new JLabel();
		JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JTextField TF_UserIP = new JTextField();
        JTextField TF_ReceiverIP = new JTextField();
        JTextField TF_UserMessage = new JTextField();
        JButton BUT_ChooseFile = new JButton();
        
        JButton BUT_Webcam = new JButton();
        JButton BUT_Send = new JButton();
        JButton BUT_Switch = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        BUT_ChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT_ChooseFileActionPerformed(evt);
            }
        });
        
        pack();
    }
	
	//runs initcomponents
	public userInterface(){
		initComponents();
	}
	
	
	
	//chooses file
	public void BUT_ChooseFileActionPerformed(ActionEvent evt) {
		
		JFileChooser fc = new JFileChooser();
		JButton open = new JButton();

		fc.setCurrentDirectory(new java.io.File("home/"));
		fc.setDialogTitle("Choose file");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			//
		}
		
		URL = fc.getSelectedFile().getAbsolutePath();
	}

	public String GetURL() {
		return URL;
	}
	
		

	
	//creates new userInterface object and shows
    public static void main(String args[]) {
    	userInterface application = new userInterface();
        application.setVisible(true);
      }

}