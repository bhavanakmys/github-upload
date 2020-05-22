import java.awt.BorderLayout;
import java.sql.*;


import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class permanentDL extends JFrame {

	private JPanel contentPane;
Connection cont=null;
private JTable table;
private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					permanentDL frame = new permanentDL();
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
	public permanentDL() {
		cont=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 744);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("DL Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String query="select * from pdl_app";
				PreparedStatement pst=cont.prepareStatement(query);
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
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(54, 45, 198, 63);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 199, 955, 402);
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
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(784, 645, 109, 45);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
				{
				String query="select * from pdl_app where llr_no=?";
				PreparedStatement pst=cont.prepareStatement(query);
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
		textField.setBounds(716, 61, 293, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(578, 79, 118, 32);
		contentPane.add(lblNewLabel);
	}
}
