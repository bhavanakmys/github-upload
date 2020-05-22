import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VehReg extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	Connection con=null;
	private JTextField regno;
	private JTextField regdate;
	private JTextField name;
	private JTextField addr;
	private JTextField type;
	private JTextField engineno;
	private JTextField model;
	private JTextField phoneno;
	public static void main(String[] args) {
		try {
			VehReg dialog = new VehReg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VehReg() {
		con=Connjava.dbConnector();
		setBounds(100, 100, 1041, 769);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 204, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD VEHICLE REGISTRATION DETAILS");
		lblNewLabel.setBounds(159, 0, 738, 71);
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 35));
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registration Number");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		lblNewLabel_1.setBounds(29, 96, 253, 49);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 29));
		lblNewLabel_2.setBounds(61, 247, 177, 35);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 29));
		lblNewLabel_3.setBounds(61, 309, 135, 45);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.BOLD, 26));
		lblNewLabel_4.setBounds(57, 383, 200, 45);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Engine Number");
		lblNewLabel_5.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_5.setBounds(70, 538, 212, 45);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Model Of Vehicle");
		lblNewLabel_6.setFont(new Font("Sitka Subheading", Font.BOLD, 26));
		lblNewLabel_6.setBounds(62, 619, 220, 51);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Registration Date");
		lblNewLabel_7.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		lblNewLabel_7.setBounds(29, 155, 209, 51);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Type");
		lblNewLabel_8.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		lblNewLabel_8.setBounds(70, 470, 89, 45);
		contentPanel.add(lblNewLabel_8);
		
		regno = new JTextField();
		regno.setBounds(333, 81, 313, 41);
		contentPanel.add(regno);
		regno.setColumns(10);
		
		regdate = new JTextField();
		regdate.setBounds(333, 151, 313, 41);
		contentPanel.add(regdate);
		regdate.setColumns(10);
		
		name = new JTextField();
		name.setBounds(333, 220, 313, 51);
		contentPanel.add(name);
		name.setColumns(10);
		
		addr = new JTextField();
		addr.setBounds(333, 309, 313, 45);
		contentPanel.add(addr);
		addr.setColumns(10);
		
		type = new JTextField();
		type.setBounds(333, 463, 313, 45);
		contentPanel.add(type);
		type.setColumns(10);
		
		engineno = new JTextField();
		engineno.setBounds(333, 538, 313, 45);
		contentPanel.add(engineno);
		engineno.setColumns(10);
		
		model = new JTextField();
		model.setBounds(333, 619, 313, 51);
		contentPanel.add(model);
		model.setColumns(10);
		
		phoneno = new JTextField();
		phoneno.setBounds(333, 383, 313, 45);
		contentPanel.add(phoneno);
		phoneno.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 680, 1027, 52);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			JButton btnNewButton = new JButton("Reset");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					regno.setText(null);
					regdate.setText(null);
					name.setText(null);
					addr.setText(null);
					phoneno.setText(null);
					type.setText(null);
					engineno.setText(null);
					model.setText(null);
				}
			});
			buttonPane.add(btnNewButton);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try
						{
							String sql="Insert into veh_registration( reg_no,reg_date,name,address,phone_no,type,engine_no,model_veh) values(?,?,?,?,?,?,?,?)";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setString(1, regno.getText());
							pst.setString(2, regdate.getText());
							pst.setString(3, name.getText());
							pst.setString(4, addr.getText());
							pst.setString(5, phoneno.getText());
							pst.setString(6, type.getText());
							pst.setString(7, engineno.getText());					
							pst.setString(8, model.getText());
							
							
							pst.execute();
							JOptionPane.showMessageDialog(null, "Data saved");
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
					}
						
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehiclereg veh=new vehiclereg();
				veh.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnNewButton_1.setBounds(754, 619, 135, 51);
		contentPanel.add(btnNewButton_1);
	}
}
