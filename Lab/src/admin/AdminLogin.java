package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import admin.AdminControlPanel;

import user.HomeScreen;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTf;
	private JPasswordField passwordTf;

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin.class.getResource("/Login16-icon.png")));
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 290);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminLogin.class.getResource("/Login128-icon.png")));
		lblNewLabel.setBounds(10, 54, 128, 128);
		contentPane.add(lblNewLabel);
		
		usernameTf = new JTextField();
		usernameTf.setFont(new Font("Tahoma", Font.BOLD, 16));
		usernameTf.setBounds(208, 67, 242, 32);
		contentPane.add(usernameTf);
		usernameTf.setColumns(10);
		
		passwordTf = new JPasswordField();
		passwordTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String uname = usernameTf.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordTf.getText();
				
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					if (uname.equals("admin") && pass.equals("pass"))
					{
						AdminControlPanel adminControlPanel = new AdminControlPanel();
						adminControlPanel.setLocationRelativeTo(null);
						adminControlPanel.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong password/username!");
					}
					
				}
			}
		});
		passwordTf.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordTf.setBounds(208, 128, 242, 32);
		contentPane.add(passwordTf);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminLogin.class.getResource("/User24-icon.png")));
		lblNewLabel_1.setBounds(166, 67, 32, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminLogin.class.getResource("/Password24-icon.png")));
		label.setBounds(166, 128, 32, 32);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Admin");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(191, 19, 243, 37);
		contentPane.add(lblNewLabel_2);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setIcon(new ImageIcon(AdminLogin.class.getResource("/Ok24-icon.png")));
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
									
				String uname = usernameTf.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordTf.getText();
				
				if (uname.equals("admin") && pass.equals("pass"))
				{
					AdminControlPanel adminControlPanel = new AdminControlPanel();
					adminControlPanel.setVisible(true);
					adminControlPanel.setLocationRelativeTo(null);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong password/username!");
				}
			}
		});
		loginBtn.setBounds(208, 186, 116, 40);
		contentPane.add(loginBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setIcon(new ImageIcon(AdminLogin.class.getResource("/Cancel24-icon.png")));
		cancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen labHomeScreen = new HomeScreen();
				labHomeScreen.setVisible(true);
				labHomeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		cancelBtn.setBounds(334, 186, 116, 40);
		contentPane.add(cancelBtn);
	}
}
