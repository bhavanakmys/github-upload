import java.awt.BorderLayout;
import java.sql.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Paymentdetails extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField challan;
	private JTextField name;
	private JTextField llr_no;
	private JTextField date;
	private JTextField amt;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	public static void main(String[] args) {
		try {
			Paymentdetails dialog = new Paymentdetails();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Paymentdetails() {
		con=Connjava.dbConnector();
		setBounds(100, 100, 1067, 766);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 255, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ADD PAYMENT DETAILS ");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 40));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(261, 40, 482, 63);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Challan Number");
			lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel_1.setBounds(33, 180, 237, 55);
			contentPanel.add(lblNewLabel_1);
		}
		{
			challan = new JTextField();
			challan.setBounds(323, 180, 277, 55);
			contentPanel.add(challan);
			challan.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Name");
			lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel_2.setBounds(53, 280, 120, 43);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Amount");
			lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel_3.setBounds(55, 347, 147, 48);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Date");
			lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel_4.setBounds(55, 426, 118, 35);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("LLR number");
			lblNewLabel_5.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel_5.setBounds(55, 496, 215, 43);
			contentPanel.add(lblNewLabel_5);
		}
		{
			name = new JTextField();
			name.setBounds(323, 265, 277, 43);
			contentPanel.add(name);
			name.setColumns(10);
		}
		{
			llr_no = new JTextField();
			llr_no.setBounds(323, 496, 277, 43);
			contentPanel.add(llr_no);
			llr_no.setColumns(10);
		}
		{
			date = new JTextField();
			date.setBounds(323, 426, 277, 43);
			contentPanel.add(date);
			date.setColumns(10);
		}
		{
			amt = new JTextField();
			amt.setBounds(323, 347, 277, 48);
			contentPanel.add(amt);
			amt.setColumns(10);
		}
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paymentd pay=new Paymentd();
				pay.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(682, 560, 166, 63);
		contentPanel.add(btnNewButton_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 667, 1053, 52);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton btnNewButton = new JButton("Reset");
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						challan.setText(null);
						name.setText(null);
						amt.setText(null);
						date.setText(null);
						llr_no.setText(null);
						
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							String sql="Insert into payment_details( challan_no,name,amount,date,llr_no) values(?,?,?,?,?)";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setString(1, challan.getText());
							pst.setString(2, name.getText());
							pst.setString(3, amt.getText());
							pst.setString(4, date.getText());
							pst.setString(5, llr_no.getText());
							
							
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
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
