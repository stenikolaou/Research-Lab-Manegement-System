package publications;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import user.HomeScreen;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ByProject extends JFrame {

	private JPanel contentPane;
	private JTable pubByProjectTable;
	private JTextField pubByProjectTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ByProject frame = new ByProject();
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
	public ByProject() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ByProject.class.getResource("/Project16-icon.png")));
		setTitle("Publications by project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 90, 1000, 510);
		contentPane.add(scrollPane);
		
		pubByProjectTable = new JTable();
		scrollPane.setViewportView(pubByProjectTable);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(17, 11, 295, 68);
		contentPane.add(panel);
		
		JLabel lblProjectTitle = new JLabel("Project title");
		lblProjectTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProjectTitle.setBounds(12, 7, 120, 25);
		panel.add(lblProjectTitle);
		
		pubByProjectTf = new JTextField();
		pubByProjectTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubByProjectTf.setColumns(10);
		pubByProjectTf.setBounds(12, 34, 271, 30);
		panel.add(pubByProjectTf);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(null);
		panel_1.setBounds(322, 29, 140, 50);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL PubByProjectSP(?)}");
					cs.setString(1, pubByProjectTf.getText());
					
					rs=cs.executeQuery();
					pubByProjectTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(ByProject.class.getResource("/Search16-icon.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 11, 120, 30);
		panel_1.add(btnNewButton);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setIcon(new ImageIcon(ByProject.class.getResource("/Home16-icon.png")));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		homeBtn.setBounds(472, 56, 89, 23);
		contentPane.add(homeBtn);
	}

}
