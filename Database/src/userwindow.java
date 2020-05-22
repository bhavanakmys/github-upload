import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userwindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserWindowPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userwindow frame = new userwindow();
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
	public userwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 733);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserWindowPanel = new JTextField();
		txtUserWindowPanel.setForeground(Color.WHITE);
		txtUserWindowPanel.setBackground(new Color(102, 205, 170));
		txtUserWindowPanel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		txtUserWindowPanel.setText("User window panel");
		txtUserWindowPanel.setBounds(250, 44, 395, 72);
		contentPane.add(txtUserWindowPanel);
		txtUserWindowPanel.setColumns(10);
		
		JButton btnNewButton = new JButton("APPLICATION");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnNewButton.setBounds(66, 203, 381, 61);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VEIW DETAILS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				licenecapp lapp=new licenecapp();
				lapp.main(null);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(616, 203, 240, 61);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Learner's Licence", "Permanent Driving Licence", "Renewal of Licence"}));
		comboBox.addItem("Learner's Licence");
		comboBox.addItem("Permanent Driving Licence");
		comboBox.addItem("Renewal of Licence");
		comboBox.setSelectedItem(null);
		comboBox.setBackground(new Color(153, 204, 204));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBox.setToolTipText("\r\n");
		comboBox.setBounds(66, 267, 381, 61);
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("APPLY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value=(String)comboBox.getSelectedItem();
				switch(value)
				{
				   case "Learner's Licence":
				{
					applylearners appl=new applylearners();
					appl.setVisible(true);
					break;
				}
				   case "Permanent Driving Licence":
				{
				   applypdl appdl=new applypdl();
				    appdl.setVisible(true);
				    break;
				}
				   case "Renewal of Licence":
				{
					applyrdl apprl=new applyrdl();
					apprl.setVisible(true);
					break;
				}
				
				}
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(102, 153, 102));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setBounds(144, 376, 171, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VIEW MY APPLICATION");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewApp view=new viewApp();
				view.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_3.setBounds(616, 320, 364, 61);
		contentPane.add(btnNewButton_3);
	}
}
