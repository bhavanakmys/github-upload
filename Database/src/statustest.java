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
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class statustest extends JFrame {

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
					statustest frame = new statustest();
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
	public statustest() {
		conn=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 761);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Test status details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String query="select * from dltest_details";
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
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButton.setBounds(102, 64, 320, 86);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(104, 238, 671, 353);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("BACk");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(647, 625, 110, 58);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
				{
				String query="select * from dltest_details where llr_no=?";
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
		textField.setBounds(715, 92, 260, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(582, 105, 110, 33);
		contentPane.add(lblNewLabel);
	}
}
