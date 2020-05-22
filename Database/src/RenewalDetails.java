import java.awt.BorderLayout;
import java.sql.*;


import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RenewalDetails extends JFrame {

	private JPanel contentPane;
Connection conn=null;
private JTable table;
private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenewalDetails frame = new RenewalDetails();
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
	public RenewalDetails() {
		conn=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Renewal list");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String query="select * from renewal_dl";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs= pst.executeQuery();
				//rs.next();
				//String name=rs.getString(1) + " : " +rs.getString(2);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception q)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(64, 56, 208, 64);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		scrollPane.setBounds(64, 167, 864, 364);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setForeground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(743, 587, 133, 55);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
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
				
			}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(696, 75, 279, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(576, 86, 110, 31);
		contentPane.add(lblNewLabel);
	}

}
