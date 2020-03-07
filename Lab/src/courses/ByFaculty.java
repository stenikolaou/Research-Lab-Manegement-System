package courses;

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
public class ByFaculty extends JFrame {

	private JPanel contentPane;
	private JTextField coursesByFacultyTf;
	private JTable coursesByFacultyTable;

	/**
	 * Create the frame.
	 */
	public ByFaculty() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ByFaculty.class.getResource("/Faculty16-icon.png")));
		setTitle("Courses By Faculty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(17, 11, 220, 68);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Surname");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(16, 7, 120, 20);
		panel.add(lblNewLabel);
		
		coursesByFacultyTf = new JTextField();
		coursesByFacultyTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		coursesByFacultyTf.setColumns(10);
		coursesByFacultyTf.setBounds(16, 34, 187, 30);
		panel.add(coursesByFacultyTf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 90, 1000, 510);
		contentPane.add(scrollPane);
		
		coursesByFacultyTable = new JTable();
		scrollPane.setViewportView(coursesByFacultyTable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(247, 29, 140, 50);
		contentPane.add(panel_1);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CoursesByFacultySP(?)}");
					cs.setString(1, coursesByFacultyTf.getText());
					
					rs=cs.executeQuery();
					coursesByFacultyTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		searchBtn.setIcon(new ImageIcon(ByFaculty.class.getResource("/Search16-icon.png")));
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchBtn.setBounds(10, 11, 120, 30);
		panel_1.add(searchBtn);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		homeBtn.setIcon(new ImageIcon(ByFaculty.class.getResource("/Home16-icon.png")));
		homeBtn.setBounds(472, 56, 89, 23);
		contentPane.add(homeBtn);
	}
}
