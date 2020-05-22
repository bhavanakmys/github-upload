import java.awt.BorderLayout;
import java.sql.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Dltestdetails extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	Connection con=null;
	private JTextField llr_nofield;
	private JTextField datefield;
	private JTextField statusfield;
	public static void main(String[] args) {
		try {
			Dltestdetails dialog = new Dltestdetails();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dltestdetails() {
		con=Connjava.dbConnector();
		setBounds(100, 100, 1032, 756);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(46, 139, 87));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("LLR_NO");
			lblNewLabel.setBounds(75, 207, 148, 37);
			lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setForeground(new Color(0, 0, 204));
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("DATE");
			lblNewLabel_1.setBounds(75, 296, 110, 42);
			lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel_1.setForeground(new Color(0, 0, 204));
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("STATUS");
			lblNewLabel_2.setBounds(82, 395, 123, 49);
			lblNewLabel_2.setForeground(new Color(0, 0, 204));
			lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
			contentPanel.add(lblNewLabel_2);
		}
		{
			llr_nofield = new JTextField();
			llr_nofield.setBounds(278, 207, 319, 59);
			contentPanel.add(llr_nofield);
			llr_nofield.setColumns(10);
		}
		{
			datefield = new JTextField();
			datefield.setBounds(278, 296, 319, 49);
			contentPanel.add(datefield);
			datefield.setColumns(10);
		}
		{
			statusfield = new JTextField();
			statusfield.setBounds(278, 395, 319, 49);
			contentPanel.add(statusfield);
			statusfield.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("ADD DL TEST DETAILS");
			lblNewLabel_3.setForeground(new Color(255, 250, 250));
			lblNewLabel_3.setBounds(294, 29, 425, 75);
			lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 39));
			lblNewLabel_3.setBackground(new Color(46, 139, 87));
			contentPanel.add(lblNewLabel_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 650, 1008, 59);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
				okButton.setForeground(Color.BLUE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String sql="Insert into dltest_details( llr_no,date,status) values(?,?,?)";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setString(1, llr_nofield.getText());
							pst.setString(2, datefield.getText());
							pst.setString(3, statusfield.getText());
							
							pst.execute();
							JOptionPane.showMessageDialog(null, "Data saved");
						}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, e1);

						}
					}
				});
				{
					JButton btnNewButton = new JButton("Reset");
					btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							llr_nofield.setText(null);
							datefield.setText(null);
							statusfield.setText(null);						
							
						}
					});
					btnNewButton.setForeground(Color.BLUE);
					buttonPane.add(btnNewButton);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
				cancelButton.setForeground(Color.BLUE);
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
			JButton btnNewButton_1 = new JButton(" Display payment details");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Paymentd pay=new Paymentd();
					pay.setVisible(true);
				}
			});
			btnNewButton_1.setForeground(Color.BLUE);
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
			btnNewButton_1.setBounds(652, 509, 356, 49);
			contentPanel.add(btnNewButton_1);
		}
	}

}
