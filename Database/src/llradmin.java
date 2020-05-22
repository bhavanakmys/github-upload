import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class llradmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField llr;
	private JTextField date;
	private JTextField name;
	private JTextField father;
	private JTextField dob;
	private JTextField bg;
	private JTextField cur;
	private JTextField peraddr;
	private JTextField city;
	private JTextField State;
	private JTextField phno;
	private JTextField mark;
	private JTextField from;
	private JTextField to;
	private JTextField type;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					llradmin frame = new llradmin();
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
	public llradmin() {
		con=Connjava.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 776);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show LLR Applicants");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String sql="Select a.name,a.dob,a.date,a.blood_group,a.fathers_or_husbands_name,a.current_address,a.permanent_address,a.city,a.state,a.mark_of_identification,a.type_of_vehicle from llr_apply a left join llr_app l on l.name=a.name where l.name is null";
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
		btnNewButton.setBounds(10, 11, 335, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 1164, 170);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("LLR Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(10, 229, 169, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(29, 293, 131, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(20, 343, 140, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Fathers_or_HusbandsName");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(0, 409, 244, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date Of Birth");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(10, 468, 169, 32);
		contentPane.add(lblNewLabel_4);
		
		llr = new JTextField();
		llr.setBounds(277, 229, 289, 38);
		contentPane.add(llr);
		llr.setColumns(10);
		
		date = new JTextField();
		date.setBounds(277, 277, 289, 44);
		contentPane.add(date);
		date.setColumns(10);
		
		name = new JTextField();
		name.setBounds(277, 352, 289, 38);
		contentPane.add(name);
		name.setColumns(10);
		
		father = new JTextField();
		father.setBounds(277, 414, 289, 38);
		contentPane.add(father);
		father.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(277, 473, 289, 35);
		contentPane.add(dob);
		dob.setColumns(10);
		
		bg = new JTextField();
		bg.setBounds(277, 533, 289, 38);
		contentPane.add(bg);
		bg.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(" Blood group");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_5.setBounds(10, 525, 169, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Current_Adrress");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_6.setBounds(10, 583, 169, 35);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Permanent Adrress");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_7.setBounds(0, 643, 220, 44);
		contentPane.add(lblNewLabel_7);
		
		cur = new JTextField();
		cur.setBounds(277, 588, 289, 35);
		contentPane.add(cur);
		cur.setColumns(10);
		
		peraddr = new JTextField();
		peraddr.setBounds(277, 643, 289, 38);
		contentPane.add(peraddr);
		peraddr.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("City");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(617, 225, 143, 46);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("State");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_9.setBounds(610, 287, 113, 35);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Phone Number ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_10.setBounds(603, 349, 188, 29);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Mark Of Identification");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_11.setBounds(592, 410, 269, 35);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(" Licence_valid_from");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_12.setBounds(572, 470, 281, 34);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(" Licence valid to");
		lblNewLabel_13.setBounds(466, 572, 46, -48);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(" Type_of_vehicle");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_14.setBounds(592, 590, 213, 35);
		contentPane.add(lblNewLabel_14);
		
		city = new JTextField();
		city.setBounds(844, 220, 269, 38);
		contentPane.add(city);
		city.setColumns(10);
		
		State = new JTextField();
		State.setBounds(844, 276, 269, 38);
		contentPane.add(State);
		State.setColumns(10);
		
		phno = new JTextField();
		phno.setBounds(844, 343, 269, 38);
		contentPane.add(phno);
		phno.setColumns(10);
		
		mark = new JTextField();
		mark.setBounds(852, 409, 261, 38);
		contentPane.add(mark);
		mark.setColumns(10);
		
		from = new JTextField();
		from.setBounds(852, 477, 261, 38);
		contentPane.add(from);
		from.setColumns(10);
		
		to = new JTextField();
		to.setBounds(852, 534, 261, 38);
		contentPane.add(to);
		to.setColumns(10);
		
		type = new JTextField();
		type.setBounds(863, 596, 261, 38);
		contentPane.add(type);
		type.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="Insert into llr_app(llr_no,date,name, Fathers_or_Husbands_Name, DOB,Bloodgroup, Current_Adrress,Permanent_Adrress,city,state,ph_no,mark_of_identification, Licence_valid_from, Licence_valid_till, type_of_vehicle) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, llr.getText());
					pst.setString(2, date.getText());
					pst.setString(3, name.getText());
					pst.setString(4, father.getText());
					pst.setString(5, dob.getText());
					pst.setString(6, bg.getText());
					pst.setString(7, cur.getText());
					pst.setString(8, peraddr.getText());
					pst.setString(9, city.getText());
					pst.setString(10, State.getText());
					pst.setString(11, phno.getText());
					pst.setString(12, mark.getText());
					pst.setString(13, from.getText());
					pst.setString(14, to.getText());
					pst.setString(15, type.getText());
					
				
				pst.execute();
				JOptionPane.showMessageDialog(null, "Data saved");
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnNewButton_1.setBounds(500, 692, 89, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(747, 692, 135, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llr.setText(null);
				date.setText(null);
				name.setText(null);
				father.setText(null);
				dob.setText(null);
				bg.setText(null);
				cur.setText(null);
				peraddr.setText(null);
				city.setText(null);
				State.setText(null);
				phno.setText(null);
				mark.setText(null);
				to.setText(null);
				type.setText(null);
				
			}
		});
		btnNewButton_3.setBounds(624, 692, 113, 37);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_15 = new JLabel("Licence valid till");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_15.setBounds(582, 537, 244, 26);
		contentPane.add(lblNewLabel_15);
	}
}
