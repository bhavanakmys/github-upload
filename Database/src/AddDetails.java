import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDetails frame = new AddDetails();
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
	public AddDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD DETAILS FOR");
		lblNewLabel.setBackground(new Color(102, 153, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 43));
		lblNewLabel.setBounds(281, 10, 513, 102);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("DL TEST DETAILS");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dltestdetails dl=new Dltestdetails();
				dl.main(null);
			}
		});
		btnNewButton.setBounds(660, 147, 290, 60);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PAYMENT DETAILS");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Paymentdetails pay=new Paymentdetails();
			pay.main(null);
			}
		});
		btnNewButton_1.setBounds(660, 271, 315, 60);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VEHICLE REGISTRATION");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehReg veh=new VehReg();
				veh.main(null);
			}
		});
		btnNewButton_2.setBounds(660, 422, 333, 60);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("TRAFFIC OFFENCE");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrafficOffenceadd tra=new TrafficOffenceadd();
				tra.main(null);
			}
		});
		btnNewButton_3.setBounds(343, 577, 326, 60);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("BACK");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(797, 577, 117, 49);
		contentPane.add(btnNewButton_4);
		
		JButton LL = new JButton("LLR APPLICATION");
		LL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llradmin llr=new llradmin();
				llr.main(null);
			}
		});
		LL.setBounds(24, 147, 285, 60);
		contentPane.add(LL);
		
		JButton btnNewButton_6 = new JButton("PDL APPLICATION");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminpdl pdl=new adminpdl();
				pdl.main(null);
			}
		});
		btnNewButton_6.setBounds(24, 271, 285, 60);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("RENEWAL DL");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renewadmin rendl=new renewadmin();
				rendl.main(null);
			}
		});
		btnNewButton_7.setBounds(24, 422, 285, 60);
		contentPane.add(btnNewButton_7);
	}
}
