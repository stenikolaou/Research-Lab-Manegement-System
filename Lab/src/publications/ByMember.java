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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import user.HomeScreen;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ByMember extends JFrame {

	private JPanel contentPane;
	public static JTable pubByMemberTable;
	private JScrollPane scrollPane;
	private JTextField pubByMemberTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ByMember frame = new ByMember();
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
	public ByMember() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ByMember.class.getResource("/Person16-icon.png")));
		setTitle("Publications by member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 90, 1000, 510);
		contentPane.add(scrollPane);
		
		pubByMemberTable = new JTable();
		scrollPane.setViewportView(pubByMemberTable);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setBounds(472, 56, 89, 23);
		homeBtn.setIcon(new ImageIcon(ByMember.class.getResource("/Home16-icon.png")));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		contentPane.add(homeBtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(17, 11, 220, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Surname");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(16, 7, 120, 25);
		panel.add(lblNewLabel);
		
		pubByMemberTf = new JTextField();
		pubByMemberTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubByMemberTf.setBounds(16, 34, 187, 30);
		panel.add(pubByMemberTf);
		pubByMemberTf.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(247, 29, 140, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL PubByMemberSP(?)}");
					cs.setString(1, pubByMemberTf.getText());
					
					rs=cs.executeQuery();
					pubByMemberTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			
			}
		});
		btnNewButton.setBounds(10, 11, 120, 30);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setIcon(new ImageIcon(ByMember.class.getResource("/Search16-icon.png")));
	}
}
