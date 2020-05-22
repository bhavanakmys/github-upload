import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class applyrdl extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applyrdl frame = new applyrdl();
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
	public applyrdl() {
		conn=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1037, 757);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Renewal Driving Licence Application");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(274, 49, 510, 54);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(309, 191, 260, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(309, 264, 260, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(309, 348, 260, 43);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(309, 428, 260, 49);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(309, 516, 260, 43);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Driving Licence Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(41, 192, 226, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(133, 275, 118, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(145, 359, 92, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date_of_issue");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(130, 445, 166, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vehicle_Type");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(130, 515, 171, 32);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(309, 607, 260, 43);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Date_of_expiry");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_6.setBounds(130, 604, 166, 32);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(753, 191, 260, 70);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(629, 209, 103, 32);
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(753, 348, 249, 43);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Aadhar Number");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(593, 359, 150, 28);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String query="insert into renewal_dl(dl_no,Name,age,Date_of_issue,vechile_type,Date_of_expiry,Adrress,aadhar_no) values(?,?,?,?,?,?,?,?)";
				PreparedStatement pst=conn.prepareStatement(query);
				pst.setString(1, textField.getText());
				pst.setString(2, textField_1.getText());
				pst.setString(3, textField_2.getText());
				pst.setString(4, textField_3.getText());
				pst.setString(5, textField_4.getText());
				pst.setString(6, textField_5.getText());
				pst.setString(7, textField_6.getText());
				pst.setString(8, textField_7.getText());
				pst.execute();
				JOptionPane.showMessageDialog(null,"Data saved");
				pst.close();
				}
				catch(Exception r)
				{
					JOptionPane.showMessageDialog(null,r);
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(780, 461, 125, 43);
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
		btnNewButton_1.setBounds(788, 557, 117, 54);
		contentPane.add(btnNewButton_1);
	}

}
