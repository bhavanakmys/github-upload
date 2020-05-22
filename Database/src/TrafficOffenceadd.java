import java.awt.BorderLayout;
import java.sql.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TrafficOffenceadd extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	Connection con=null;
	private JTextField vehno;
	private JTextField remarks;
	private JTextField engno;
	public static void main(String[] args) {
		try {
			TrafficOffenceadd dialog = new TrafficOffenceadd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TrafficOffenceadd() {
		con=Connjava.dbConnector();
		setBounds(100, 100, 1036, 755);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(64, 224, 208));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			vehno = new JTextField();
			vehno.setBounds(322, 112, 355, 70);
			contentPanel.add(vehno);
			vehno.setColumns(10);
		}
		{
			remarks = new JTextField();
			remarks.setBounds(322, 229, 355, 109);
			contentPanel.add(remarks);
			remarks.setColumns(10);
		}
		{
			engno = new JTextField();
			engno.setBounds(322, 375, 355, 60);
			contentPanel.add(engno);
			engno.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("TRAFFIC OFFENCES");
			lblNewLabel.setForeground(new Color(128, 0, 128));
			lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 34));
			lblNewLabel.setBounds(275, 24, 390, 60);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Vehicle Number");
			lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 33));
			lblNewLabel_1.setBounds(23, 128, 257, 54);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Remarks");
			lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 32));
			lblNewLabel_2.setBounds(64, 261, 174, 77);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Engine Number");
			lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 31));
			lblNewLabel_3.setBounds(35, 375, 227, 60);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 654, 1022, 54);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton btnNewButton = new JButton("Reset");
				btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vehno.setText(null);
						remarks.setText(null);
						engno.setText(null);
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String sql="Insert into traffic_offence(vehicle_no ,remarks,engine_no) values(?,?,?)";
											PreparedStatement pst = con.prepareStatement(sql);
											pst.setString(1, vehno.getText());
											pst.setString(2, remarks.getText());
											pst.setString(3, engno.getText());
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
				cancelButton.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JButton btnNewButton_1 = new JButton("Display vehicle registration");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vehiclereg veh=new vehiclereg();
					veh.setVisible(true);
				}
			});
			btnNewButton_1.setBackground(new Color(255, 250, 250));
			btnNewButton_1.setForeground(new Color(148, 0, 211));
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton_1.setBounds(657, 490, 355, 54);
			contentPanel.add(btnNewButton_1);
		}
	}

}
