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
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Paymentd extends JFrame {

	private JPanel contentPane;
	private JTable table;
Connection conn=null;
private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paymentd frame = new Paymentd();
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
	public Paymentd() {
		conn=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setForeground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("display Payment Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String query="select * from payment_details";
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
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(44, 54, 372, 67);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		scrollPane.setBounds(63, 205, 876, 363);
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
		btnNewButton_1.setBounds(679, 619, 110, 57);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
				{
				String query="select * from payment_details where llr_no=?";
				PreparedStatement pst=conn.prepareStatement(query);
			    pst.setString(1,textField.getText());
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
		textField.setBounds(716, 67, 275, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(564, 76, 127, 37);
		contentPane.add(lblNewLabel);
	}

}
