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
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class vehiclereg extends JFrame {

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
					vehiclereg frame = new vehiclereg();
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
	public vehiclereg() {
		conn=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 754);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Vehicle registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String query="select * from veh_registration";
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
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(56, 66, 323, 78);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))));
		scrollPane.setBounds(82, 233, 738, 357);
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(646, 620, 128, 50);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
				{
				String query="select * from veh_registration where reg_no=?";
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
		textField.setBounds(694, 100, 279, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(562, 117, 122, 31);
		contentPane.add(lblNewLabel);
	}

}
