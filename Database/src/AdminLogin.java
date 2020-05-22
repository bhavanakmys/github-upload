import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 49));
		lblNewLabel.setBounds(428, 47, 217, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setBounds(75, 220, 207, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(new Color(255, 0, 255));
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(75, 331, 207, 50);
		contentPane.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(310, 220, 297, 40);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(310, 331, 297, 40);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddDetails add=new AddDetails();
				
				String Password=password.getText();
				String Username=username.getText();
								
				if(Password.contains("password") && Username.contains("root")){
						password.setText(null);
						username.setText(null);
					
						
						add.main(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					password.setText(null);
					username.setText(null);
				}

			}
		});
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		btnNewButton.setBounds(152, 455, 130, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText(null);
				password.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		btnNewButton_1.setBounds(341, 455, 109, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		btnNewButton_2.setBounds(521, 455, 103, 48);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(716, 171, 281, 258);
		contentPane.add(lblNewLabel_3);
	}
}
