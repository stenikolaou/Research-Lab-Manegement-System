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
public class PublicationParticipants extends JFrame {

	private JPanel contentPane;
	private JTable pubParticipantsTable;
	private JTextField pubParticipantsTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublicationParticipants frame = new PublicationParticipants();
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
	public PublicationParticipants() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PublicationParticipants.class.getResource("/Group16-icon.png")));
		setTitle("Publication participants");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 90, 1000, 510);
		contentPane.add(scrollPane);
		
		pubParticipantsTable = new JTable();
		scrollPane.setViewportView(pubParticipantsTable);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(17, 11, 244, 68);
		contentPane.add(panel);
		
		JLabel lblPublicationTitle = new JLabel("Publication Title");
		lblPublicationTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPublicationTitle.setBounds(16, 7, 211, 20);
		panel.add(lblPublicationTitle);
		
		pubParticipantsTf = new JTextField();
		pubParticipantsTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubParticipantsTf.setColumns(10);
		pubParticipantsTf.setBounds(16, 34, 211, 30);
		panel.add(pubParticipantsTf);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(271, 29, 140, 50);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowPubParticipantsSP(?)}");
					cs.setString(1, pubParticipantsTf.getText());
					
					rs=cs.executeQuery();
					pubParticipantsTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(PublicationParticipants.class.getResource("/Search16-icon.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 11, 120, 30);
		panel_1.add(btnNewButton);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setIcon(new ImageIcon(PublicationParticipants.class.getResource("/Home16-icon.png")));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
