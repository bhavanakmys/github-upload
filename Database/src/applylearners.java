import java.awt.BorderLayout;
import java .sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class applylearners extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applylearners frame = new applylearners();
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
	public applylearners() {
		conn=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 791);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Learner's Licence Application Form");
		lblNewLabel.setForeground(new Color(204, 51, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(262, 42, 487, 40);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(243, 220, 239, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(243, 300, 239, 40);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(243, 378, 239, 45);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(243, 449, 239, 40);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(243, 513, 239, 45);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(243, 582, 239, 40);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(138, 226, 76, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_3.setBounds(129, 300, 85, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Father's/Husband's Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(10, 389, 223, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Birth");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(62, 460, 152, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Blood Group");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_6.setBounds(81, 524, 133, 34);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Current Address");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_7.setBounds(28, 582, 205, 46);
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(714, 153, 249, 45);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(714, 220, 259, 45);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(714, 300, 259, 40);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(720, 378, 253, 45);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(720, 460, 253, 48);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Permanent Address");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_8.setBounds(538, 170, 166, 23);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("city");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(619, 226, 85, 34);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("State");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(619, 317, 85, 23);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Phone Number");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_11.setBounds(574, 391, 133, 32);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Mark of Identification");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_12.setBounds(516, 468, 188, 37);
		contentPane.add(lblNewLabel_12);
		
		textField_12 = new JTextField();
		textField_12.setBounds(720, 544, 264, 45);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Type_of vehicle");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_13.setBounds(538, 544, 166, 39);
		contentPane.add(lblNewLabel_13);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String query="insert into llr_apply(Date,Name,Fathers_or_husbands_Name,DOB,Blood_group,Current_address,Permanent_address,City,State,ph_no,Mark_of_identification,Type_of_vehicle)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, textField_1.getText());
			pst.setString(2, textField_2.getText());
			pst.setString(3, textField_3.getText());
			pst.setString(4, textField_4.getText());
			pst.setString(5, textField_5.getText());
			pst.setString(6, textField_6.getText());
			pst.setString(7, textField_7.getText());
			pst.setString(8, textField_8.getText());
			pst.setString(9, textField_9.getText());
			pst.setString(10, textField_10.getText());
			pst.setString(11, textField_11.getText());
			pst.setString(12, textField_12.getText());
			pst.execute();
			JOptionPane.showMessageDialog(null, "data saved");
			pst.close();
				}
				catch(Exception r)
				{
					JOptionPane.showMessageDialog(null, r);
				}
			
			
			
			
			
			
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(509, 672, 157, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(742, 672, 133, 41);
		contentPane.add(btnNewButton_1);
	}
}
