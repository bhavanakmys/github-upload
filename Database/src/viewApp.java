import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.lang.invoke.VarHandle.AccessMode;

public class viewApp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

private JTextField textField_1;
private JTextField textField_2;
Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewApp frame = new viewApp();
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
	public viewApp() {
		conn=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 753);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Application Type");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(41, 36, 309, 53);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Learner's Licence application", "Permanent Driving Licence application", "Renewal of Licence application"}));
		comboBox.addItem("Learner's Licence application");
		comboBox.addItem("Permanent Driving Licence application");
		comboBox.addItem("Renewal of Licence application");
		comboBox.setSelectedItem(null);
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(153, 204, 204));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 29));
		comboBox.setBounds(360, 36, 484, 53);
		contentPane.add(comboBox);
		
		table = new JTable();
		table.setBounds(64, 420, 897, 203);
		contentPane.add(table);
		
		textField = new JTextField();
		textField.setBounds(538, 324, 265, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Learners Licence Number/Dl Number");
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(23, 313, 517, 63);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_2.setBounds(10, 179, 142, 43);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 179, 250, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setForeground(new Color(0, 0, 139));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(10, 253, 178, 37);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 260, 227, 40);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value=(String)comboBox.getSelectedItem();
				switch(value)
				{
				   case "Permanent Driving Licence application":
				  {
					try
					{
					String query="select * from pdl_apply where llr_no=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					//pst.setString(2, textField_2.getText());
					ResultSet rs= pst.executeQuery();
					//rs.next();
					//String name=rs.getString(1) + " : " +rs.getString(2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				//	pst.close();
					}
					catch(Exception q)
					{
						JOptionPane.showMessageDialog(null,e);
					}
					break;
				   }
				   case "Learner's Licence application":
				{
					try
					{
					String query="select * from llr_apply where name=? and DOB=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField_2.getText());
					ResultSet rs= pst.executeQuery();
					//JOptionPane.showMessageDialog(null,"done");
					//rs.next();
					//String name=rs.getString(1) + " : " +rs.getString(2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
					//pst.close();
					}
					catch(Exception q)
					{
						JOptionPane.showMessageDialog(null,e);
					}
				    break;
				}
				   case "Renewal of Licence application":
				{
					try
					{
					String query="select * from renewal_dl where dl_no=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs= pst.executeQuery();
					//rs.next();
					//String name=rs.getString(1) + " : " +rs.getString(2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception q)
					{
						JOptionPane.showMessageDialog(null,e);
					}
					break;
				}
				
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnNewButton.setBounds(872, 344, 104, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 139));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(818, 653, 113, 53);
		contentPane.add(btnNewButton_1);
	}
}
