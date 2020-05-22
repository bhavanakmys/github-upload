import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminsubwindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminsubwindow frame = new Adminsubwindow();
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
	public Adminsubwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 754);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin window");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 50));
		lblNewLabel.setBounds(295, 42, 341, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADD Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDetails add=new AddDetails();
				add.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton.setBounds(564, 185, 236, 71);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Veiw Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				licenecapp lin=new licenecapp();
				lin.main(null);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 139, 139));
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton_1.setBounds(564, 316, 236, 71);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(245, 255, 250));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setBounds(798, 649, 154, 44);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(181, 185, 251, 268);
		contentPane.add(lblNewLabel_1);
	}
}
