import java.awt.EventQueue;

import java.awt.Image;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class licenecapp {

	private JFrame frame;
	private JTextField txtLearnersLicence;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					licenecapp window = new licenecapp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection=null;
private JLabel lblNewLabel;
	/**
	 * Create the application.
	 */
	public licenecapp() {
		initialize();
		//connection=Connjava.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 139, 139));
		frame.setBounds(100, 100, 1281, 785);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtLearnersLicence = new JTextField();
		txtLearnersLicence.setForeground(Color.GREEN);
		txtLearnersLicence.setHorizontalAlignment(SwingConstants.CENTER);
		txtLearnersLicence.setFont(new Font("Tahoma", Font.PLAIN, 32));
		txtLearnersLicence.setText("RTO Management System");
		txtLearnersLicence.setBounds(400, 55, 461, 72);
		frame.getContentPane().add(txtLearnersLicence);
		txtLearnersLicence.setColumns(10);
		
		JButton btnNewButton = new JButton("Learner's Licence");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					//frame.dispose();
					Display dis=new Display();
					dis.setVisible(true);
					//dis.toFront();
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(26, 223, 286, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Permanent Licence");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				permanentDL pdl=new permanentDL();
				pdl.setVisible(true);
				pdl.toFront();
			}
		});
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(26, 362, 311, 54);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/cars.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(519, 201, 269, 261);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Renewal of licence");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				RenewalDetails rdl=new RenewalDetails();
				rdl.setVisible(true);
				rdl.toFront();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(26, 472, 311, 60);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Payment details");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				Paymentd pay=new Paymentd();
				pay.setVisible(true);
				pay.toFront();
			}
		});
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_3.setBounds(458, 608, 286, 54);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Test Details");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				statustest tst=new statustest();
				tst.setVisible(true);
				tst.toFront();
			}
		});
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_4.setBounds(854, 475, 269, 54);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("traffic Offence");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				trafficoffence toff=new trafficoffence();
				toff.setVisible(true);
				toff.toFront();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_5.setBackground(Color.DARK_GRAY);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(854, 359, 286, 60);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("vehicle Registration");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				vehiclereg vreg=new vehiclereg();
				vreg.setVisible(true);
				vreg.toFront();
			}
		});
		btnNewButton_6.setBackground(Color.DARK_GRAY);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_6.setBounds(833, 226, 358, 54);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("BACK");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
			}
		});
		btnNewButton_7.setBackground(Color.DARK_GRAY);
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_7.setBounds(884, 672, 125, 54);
		frame.getContentPane().add(btnNewButton_7);
		
		
}
}
