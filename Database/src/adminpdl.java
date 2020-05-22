import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class adminpdl extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField llr;
	private JTextField name;
	private JTextField dob;
	private JTextField from;
	private JTextField to;
	private JTextField type;
	private JTextField age;
	private JTextField dl;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpdl frame = new adminpdl();
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
	public adminpdl() {
		con=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1272, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show Permanent driving license apllicants");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="Select a.llr_no,a.name,a.type_of_vehicle,a.dob from pdl_apply a left join pdl_app p on p.llr_no=a.llr_no where p.llr_no is null";
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
		btnNewButton.setBounds(24, 10, 396, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 45, 1174, 202);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("LLR Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(48, 282, 221, 44);
		contentPane.add(lblNewLabel);
		
		llr = new JTextField();
		llr.setBounds(309, 282, 264, 44);
		contentPane.add(llr);
		llr.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(67, 349, 113, 40);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(309, 349, 264, 44);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date Of Birth");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(34, 423, 221, 44);
		contentPane.add(lblNewLabel_2);
		
		dob = new JTextField();
		dob.setBounds(309, 414, 264, 44);
		contentPane.add(dob);
		dob.setColumns(10);
		
		from = new JTextField();
		from.setBounds(309, 490, 264, 44);
		contentPane.add(from);
		from.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Licence Valid From");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(34, 500, 265, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Licence Valid To");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(39, 584, 260, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Type of Vehicle");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(603, 292, 207, 34);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(692, 359, 102, 34);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("DL Number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(630, 451, 180, 27);
		contentPane.add(lblNewLabel_7);
		
		to = new JTextField();
		to.setBounds(309, 570, 264, 44);
		contentPane.add(to);
		to.setColumns(10);
		
		type = new JTextField();
		type.setBounds(837, 281, 264, 55);
		contentPane.add(type);
		type.setColumns(10);
		
		age = new JTextField();
		age.setBounds(837, 369, 264, 44);
		contentPane.add(age);
		age.setColumns(10);
		
		dl = new JTextField();
		dl.setBounds(837, 451, 264, 55);
		contentPane.add(dl);
		dl.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="Insert into pdl_app(llr_no,name,DOB,Licence_valid_from, Licence_valid_to, type_of_vehicle,age,dl_no) values(?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, llr.getText());
					pst.setString(2, name.getText());
					pst.setString(3, dob.getText());
					pst.setString(4, from.getText());
					pst.setString(5, to.getText());
					pst.setString(6, type.getText());
					pst.setString(7, age.getText());
					pst.setString(8, dl.getText());						
				    pst.execute();
				JOptionPane.showMessageDialog(null, "Data saved");
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnNewButton_1.setBounds(460, 647, 102, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText(null);
				dob.setText(null);
				from.setText(null);
				to.setText(null);
				type.setText(null);
				age.setText(null);
				dl.setText(null);
			}
		});
		btnNewButton_2.setBounds(603, 647, 125, 44);
		contentPane.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(754, 642, 125, 49);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Show test details");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statustest test =new statustest();
				test.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_4.setBounds(581, 10, 298, 32);
		contentPane.add(btnNewButton_4);
	}

}
