import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class renewadmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField dl;
	private JTextField name;
	private JTextField age;
	private JTextField date;
	private JTextField veh;
	private JTextField exp;
	private JTextField addr;
	private JTextField aadhar;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					renewadmin frame = new renewadmin();
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
	public renewadmin() {
		con=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1328, 777);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show Renew DL Applicants");
		btnNewButton.setForeground(new Color(0, 0, 205));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="Select * from renewal_dl";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs= pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception q)
					{
						JOptionPane.showMessageDialog(null,e);
					}
			}
		});
		btnNewButton.setBounds(183, 0, 374, 36);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 39, 1254, 267);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("DL Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(41, 345, 152, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(99, 421, 78, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(111, 492, 110, 47);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date Of Issue");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(22, 582, 210, 39);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Vehicle Type");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(662, 324, 183, 42);
		contentPane.add(lblNewLabel_4);
		
		dl = new JTextField();
		dl.setBounds(242, 327, 283, 53);
		contentPane.add(dl);
		dl.setColumns(10);
		
		name = new JTextField();
		name.setBounds(242, 413, 283, 47);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(242, 492, 283, 47);
		contentPane.add(age);
		age.setColumns(10);
		
		date = new JTextField();
		date.setBounds(242, 582, 283, 39);
		contentPane.add(date);
		date.setColumns(10);
		
		veh = new JTextField();
		veh.setBounds(901, 316, 262, 47);
		contentPane.add(veh);
		veh.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Date Of Expiry");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(678, 425, 196, 31);
		contentPane.add(lblNewLabel_5);
		
		exp = new JTextField();
		exp.setBounds(901, 405, 262, 55);
		contentPane.add(exp);
		exp.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(712, 489, 143, 52);
		contentPane.add(lblNewLabel_6);
		
		addr = new JTextField();
		addr.setBounds(901, 487, 262, 52);
		contentPane.add(addr);
		addr.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Aadhar Number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(662, 586, 212, 31);
		contentPane.add(lblNewLabel_7);
		
		aadhar = new JTextField();
		aadhar.setBounds(913, 574, 262, 47);
		contentPane.add(aadhar);
		aadhar.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="Insert into renewal_dl(dl_no,name,age,date_of_issue,vehicle_type, date_of_expiry,adrress,aadhar_no) values(?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, dl.getText());
					pst.setString(2, name.getText());
					pst.setString(3, age.getText());
					pst.setString(4, date.getText());
					pst.setString(5, veh.getText());
					pst.setString(6, exp.getText());
					pst.setString(7, addr.getText());
					pst.setString(8, aadhar.getText());						
				    pst.execute();
				JOptionPane.showMessageDialog(null, "Data saved");
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
				
				
			}
		});
		btnNewButton_1.setBounds(492, 670, 89, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setForeground(new Color(0, 0, 205));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dl.setText(null);
				name.setText(null);
				age.setText(null);
				date.setText(null);
				veh.setText(null);
				exp.setText(null);			
				addr.setText(null);
				aadhar.setText(null);
			}
		});
		btnNewButton_2.setBounds(629, 670, 110, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(785, 670, 110, 41);
		contentPane.add(btnNewButton_3);
	}
}
