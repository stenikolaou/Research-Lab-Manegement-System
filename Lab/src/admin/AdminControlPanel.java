package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;
import user.HomeScreen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings({ "unused", "serial" })
public class AdminControlPanel extends JFrame {

	private JPanel contentPane;
	private JTable memberTable;
	private JTable pubTable;
	private JTable courseTable;
	private JTable annTable;
	private JTable projectTable;
	private JTextField memberIdTf;
	private JTextField memberNameTf;
	private JTextField memberSurnameTf;
	private JTextField memberWebpageTf;
	private JTextField memberEmailTf;
	private JTextField memberShortCVTf;
	private JTextField memberCategoryNameTf;
	private JTextField memberCategoryIdTf;
	private JTextField memberCategoryIdTf2;
	private JTable memberCategoryTable;
	private JTextField pubIdTf;
	private JTextField projectIdTf2;
	private JTextField pubTypeIdTf2;
	private JTextField pubTitleTf;
	private JTextField pubYearTf;
	private JTextField PubSubjectTf;
	private JTextField projectIdTf;
	private JTextField projectStatusIdTf2;
	private JTextField projectNameTf;
	private JTextField projectDescTf;
	private JTable pubTypeTable;
	private JTable projectStatusTable;
	private JTextField pubTypeIdTf;
	private JTextField pubTypeNameTf;
	private JTextField projectStatusIdTf;
	private JTextField projectStatusTypeTf;
	private JTextField courseIdTf;
	private JTextField courseLevelIdTf2;
	private JTextField courseTitleTf;
	private JTextField courseSemesterTf;
	private JTextField courseEctsTf;
	private JTextField annIdTf;
	private JTextField memberIdTf2;
	private JTextField annTitleTf;
	private JTextField annDateTf;
	private JTextField annBodyTf;
	private JTable courseLevelTable;
	private JTextField courseLevelIdTf;
	private JTextField courseLevelNameTf;
	private JTable pubParticipantsTable;
	private JTable projectMembersTable;
	private JTable courseParticipantsTable;
	private JTextField memberIdTf3;
	private JTextField pubIdTf2;
	private JTextField memberIdTf4;
	private JTextField projectIdTf3;
	private JTextField memberIdTf5;
	private JTextField courseIdTf2;
	
	
	
	/**
	 * Create the frame.
	 */
	public AdminControlPanel() {
				
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminControlPanel.class.getResource("/Panel16-icon.png")));
		setTitle("Admin Control Panel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1450, 820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.setBounds(10, 75, 1414, 662);
		contentPane.add(tabbedPane);
		
		JPanel memberPanel = new JPanel();
		memberPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Members", null, memberPanel, null);
		memberPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 15, 1149, 541);
		memberPanel.add(scrollPane);
		
		memberTable = new JTable();
		memberTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		memberTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)memberTable.getModel();
				int rowIndex = memberTable.getSelectedRow();
				
				memberIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				memberCategoryIdTf2.setText(model.getValueAt(rowIndex, 1).toString());
				memberNameTf.setText(model.getValueAt(rowIndex, 2).toString());
				memberSurnameTf.setText(model.getValueAt(rowIndex, 3).toString());
				memberWebpageTf.setText(model.getValueAt(rowIndex, 4).toString());
				memberEmailTf.setText(model.getValueAt(rowIndex, 5).toString());
				memberShortCVTf.setText(model.getValueAt(rowIndex, 6).toString());
			}
		});
		memberTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(memberTable);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1.setBounds(250, 567, 1149, 50);
		memberPanel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JButton addMemberBtn = new JButton("Add");
		addMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreateMemberSP(?,?,?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(memberCategoryIdTf2.getText()));	
					cs.setString(2, memberNameTf.getText());
					cs.setString(3, memberSurnameTf.getText());
					cs.setString(4, memberWebpageTf.getText());
					cs.setString(5, memberEmailTf.getText());
					cs.setString(6, memberShortCVTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Member successfully inserted to DB");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		addMemberBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addMemberBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addMemberBtn.setBounds(85, 5, 180, 40);
		panel_2_1.add(addMemberBtn);
		
		JButton deleteMemberBtn = new JButton("Delete");
		deleteMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this member?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeleteMemberSP(?)}");
					
					cs.setInt(1, Integer.parseInt(memberIdTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted member");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
			}
		});
		deleteMemberBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deleteMemberBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteMemberBtn.setBounds(350, 5, 180, 40);
		panel_2_1.add(deleteMemberBtn);
		
		JButton viewMemberBtn = new JButton("View");
		viewMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadMembersSP()}");
					rs=cs.executeQuery();
					memberTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		viewMemberBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewMemberBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewMemberBtn.setBounds(615, 5, 180, 40);
		panel_2_1.add(viewMemberBtn);
		
		JButton updateMemberBtn = new JButton("Update");
		updateMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL UpdateMemberSP(?,?,?,?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(memberIdTf.getText()));
					cs.setInt(2, Integer.parseInt(memberCategoryIdTf2.getText()));	
					cs.setString(3, memberNameTf.getText());
					cs.setString(4, memberSurnameTf.getText());
					cs.setString(5, memberWebpageTf.getText());
					cs.setString(6, memberEmailTf.getText());
					cs.setString(7, memberShortCVTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Member successfully updated");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		updateMemberBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
		updateMemberBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateMemberBtn.setBounds(880, 5, 180, 40);
		panel_2_1.add(updateMemberBtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 15, 230, 541);
		memberPanel.add(panel);
		panel.setLayout(null);
		
		memberIdTf = new JTextField();
		memberIdTf.setBounds(15, 41, 200, 35);
		panel.add(memberIdTf);
		memberIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberIdTf.setColumns(10);
		
		JLabel lblMemberCategoryId = new JLabel("Member Category Id");
		lblMemberCategoryId.setBounds(15, 84, 180, 25);
		panel.add(lblMemberCategoryId);
		lblMemberCategoryId.setForeground(SystemColor.controlDkShadow);
		lblMemberCategoryId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		memberCategoryIdTf2 = new JTextField();
		memberCategoryIdTf2.setBounds(15, 117, 200, 35);
		panel.add(memberCategoryIdTf2);
		memberCategoryIdTf2.setToolTipText("1 - Faculty, 2 - Researcher, 3 - PhD Candidate, 4 - Postgraduate , 5 - Undergraduate ");
		memberCategoryIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberCategoryIdTf2.setColumns(10);
		
		JLabel lblMemberName = new JLabel("Member Name");
		lblMemberName.setBounds(15, 160, 126, 25);
		panel.add(lblMemberName);
		lblMemberName.setForeground(SystemColor.controlDkShadow);
		lblMemberName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		memberNameTf = new JTextField();
		memberNameTf.setBounds(15, 193, 200, 35);
		panel.add(memberNameTf);
		memberNameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberNameTf.setColumns(10);
		
		JLabel lblMemberSurname = new JLabel("Member Surname");
		lblMemberSurname.setBounds(15, 236, 148, 25);
		panel.add(lblMemberSurname);
		lblMemberSurname.setForeground(SystemColor.controlDkShadow);
		lblMemberSurname.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		memberSurnameTf = new JTextField();
		memberSurnameTf.setBounds(15, 269, 200, 35);
		panel.add(memberSurnameTf);
		memberSurnameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberSurnameTf.setColumns(10);
		
		JLabel lblMemberWebpage = new JLabel("Member Webpage");
		lblMemberWebpage.setBounds(15, 312, 148, 25);
		panel.add(lblMemberWebpage);
		lblMemberWebpage.setForeground(SystemColor.controlDkShadow);
		lblMemberWebpage.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		memberWebpageTf = new JTextField();
		memberWebpageTf.setBounds(15, 345, 200, 35);
		panel.add(memberWebpageTf);
		memberWebpageTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberWebpageTf.setColumns(10);
		
		JLabel lblMemberSurname_1_1 = new JLabel("Member Email");
		lblMemberSurname_1_1.setBounds(15, 388, 148, 25);
		panel.add(lblMemberSurname_1_1);
		lblMemberSurname_1_1.setForeground(SystemColor.controlDkShadow);
		lblMemberSurname_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		memberEmailTf = new JTextField();
		memberEmailTf.setBounds(15, 421, 200, 35);
		panel.add(memberEmailTf);
		memberEmailTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberEmailTf.setColumns(10);
		
		JLabel lblMemberSurname_1_2 = new JLabel("Member Short CV");
		lblMemberSurname_1_2.setBounds(15, 464, 148, 25);
		panel.add(lblMemberSurname_1_2);
		lblMemberSurname_1_2.setForeground(SystemColor.controlDkShadow);
		lblMemberSurname_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		memberShortCVTf = new JTextField();
		memberShortCVTf.setBounds(15, 497, 200, 35);
		panel.add(memberShortCVTf);
		memberShortCVTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberShortCVTf.setColumns(10);
		
		JLabel lblMemberId = new JLabel("Member Id");
		lblMemberId.setBounds(15, 8, 103, 25);
		panel.add(lblMemberId);
		lblMemberId.setForeground(new Color(105, 105, 105));
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearMemberBtn = new JButton("Clear");
		clearMemberBtn.setBounds(35, 567, 180, 40);
		memberPanel.add(clearMemberBtn);
		clearMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberIdTf.setText(null);
				memberCategoryIdTf2.setText(null);
				memberNameTf.setText(null);
				memberSurnameTf.setText(null);
				memberWebpageTf.setText(null);
				memberEmailTf.setText(null);
				memberShortCVTf.setText(null);
			}
		});
		clearMemberBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearMemberBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel pubPanel = new JPanel();
		pubPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Publications", null, pubPanel, null);
		pubPanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 15, 1149, 541);
		pubPanel.add(scrollPane_1);
		
		pubTable = new JTable();
		pubTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)pubTable.getModel();
				int rowIndex = pubTable.getSelectedRow();
				
				pubIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				projectIdTf2.setText(model.getValueAt(rowIndex, 1).toString());
				pubTypeIdTf2.setText(model.getValueAt(rowIndex, 2).toString());
				pubTitleTf.setText(model.getValueAt(rowIndex, 3).toString());
				pubYearTf.setText(model.getValueAt(rowIndex, 4).toString());
				PubSubjectTf.setText(model.getValueAt(rowIndex, 5).toString());
			}
		});
		pubTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(pubTable);
		
		JPanel panel_2_1_5 = new JPanel();
		panel_2_1_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_5.setLayout(null);
		panel_2_1_5.setBounds(250, 567, 1149, 50);
		pubPanel.add(panel_2_1_5);
		
		JButton addPubBtn = new JButton("Add");
		addPubBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addPubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreatePubSP(?,?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(projectIdTf2.getText()));	
					cs.setInt(2, Integer.parseInt(pubTypeIdTf2.getText()));	
					cs.setString(3, pubTitleTf.getText());
					cs.setInt(4, Integer.parseInt(pubYearTf.getText()));	
					cs.setString(5, PubSubjectTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Publication successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		addPubBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addPubBtn.setBounds(85, 5, 180, 40);
		panel_2_1_5.add(addPubBtn);
		
		JButton deletePubBtn = new JButton("Delete");
		deletePubBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deletePubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this publication?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeletePubSP(?)}");
					
					cs.setInt(1, Integer.parseInt(pubIdTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted publication");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
			}
		});
		deletePubBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deletePubBtn.setBounds(350, 5, 180, 40);
		panel_2_1_5.add(deletePubBtn);
		
		JButton viewPubsBtn = new JButton("View");
		viewPubsBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewPubsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadPubsSP()}");
					rs=cs.executeQuery();
					pubTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewPubsBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewPubsBtn.setBounds(615, 5, 180, 40);
		panel_2_1_5.add(viewPubsBtn);
		
		JButton updatePubBtn = new JButton("Update");
		updatePubBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
		updatePubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL UpdatePubSP(?,?,?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(pubIdTf.getText()));
					cs.setInt(2, Integer.parseInt(projectIdTf2.getText()));	
					cs.setString(3, pubTypeIdTf2.getText());
					cs.setString(4, pubTitleTf.getText());
					cs.setInt(5, Integer.parseInt(pubYearTf.getText()));	
					cs.setString(6, PubSubjectTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Publication successfully updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		updatePubBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePubBtn.setBounds(880, 5, 180, 40);
		panel_2_1_5.add(updatePubBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 15, 230, 541);
		pubPanel.add(panel_1);
		panel_1.setLayout(null);
		
		pubIdTf = new JTextField();
		pubIdTf.setBounds(15, 51, 200, 35);
		panel_1.add(pubIdTf);
		pubIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubIdTf.setColumns(10);
		
		projectIdTf2 = new JTextField();
		projectIdTf2.setBounds(15, 137, 200, 35);
		panel_1.add(projectIdTf2);
		projectIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projectIdTf2.setColumns(10);
		
		pubTypeIdTf2 = new JTextField();
		pubTypeIdTf2.setBounds(15, 223, 200, 35);
		panel_1.add(pubTypeIdTf2);
		pubTypeIdTf2.setToolTipText("1 - Convention, 2 - Magazine");
		pubTypeIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubTypeIdTf2.setColumns(10);
		
		pubTitleTf = new JTextField();
		pubTitleTf.setBounds(15, 309, 200, 35);
		panel_1.add(pubTitleTf);
		pubTitleTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubTitleTf.setColumns(10);
		
		pubYearTf = new JTextField();
		pubYearTf.setBounds(15, 395, 200, 35);
		panel_1.add(pubYearTf);
		pubYearTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubYearTf.setColumns(10);
		
		PubSubjectTf = new JTextField();
		PubSubjectTf.setBounds(15, 481, 200, 35);
		panel_1.add(PubSubjectTf);
		PubSubjectTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PubSubjectTf.setColumns(10);
		
		JLabel lblPubId = new JLabel("Publication Id");
		lblPubId.setBounds(15, 13, 205, 25);
		panel_1.add(lblPubId);
		lblPubId.setForeground(SystemColor.controlDkShadow);
		lblPubId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblProjectId2 = new JLabel("Project Id");
		lblProjectId2.setBounds(15, 99, 205, 25);
		panel_1.add(lblProjectId2);
		lblProjectId2.setForeground(SystemColor.controlDkShadow);
		lblProjectId2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblPubTypeId2 = new JLabel("Publication Type Id");
		lblPubTypeId2.setBounds(15, 185, 205, 25);
		panel_1.add(lblPubTypeId2);
		lblPubTypeId2.setForeground(SystemColor.controlDkShadow);
		lblPubTypeId2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblPubTitle = new JLabel("Publication Title");
		lblPubTitle.setBounds(15, 271, 205, 25);
		panel_1.add(lblPubTitle);
		lblPubTitle.setForeground(SystemColor.controlDkShadow);
		lblPubTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblPubYear = new JLabel("Publication Year");
		lblPubYear.setBounds(15, 357, 205, 25);
		panel_1.add(lblPubYear);
		lblPubYear.setForeground(SystemColor.controlDkShadow);
		lblPubYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblPubSubject = new JLabel("Publication Subject");
		lblPubSubject.setBounds(15, 443, 205, 25);
		panel_1.add(lblPubSubject);
		lblPubSubject.setForeground(SystemColor.controlDkShadow);
		lblPubSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearPubBtn = new JButton("Clear");
		clearPubBtn.setBounds(35, 567, 180, 40);
		pubPanel.add(clearPubBtn);
		clearPubBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearPubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pubIdTf.setText(null);
				projectIdTf2.setText(null);
				pubTypeIdTf2.setText(null);
				pubTitleTf.setText(null);
				pubYearTf.setText(null);
				PubSubjectTf.setText(null);
			}
		});
		clearPubBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel projectPanel = new JPanel();
		projectPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Projects", null, projectPanel, null);
		projectPanel.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(250, 15, 1149, 541);
		projectPanel.add(scrollPane_3);
		
		projectTable = new JTable();
		projectTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)projectTable.getModel();
				int rowIndex = projectTable.getSelectedRow();
				
				projectIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				projectStatusIdTf2.setText(model.getValueAt(rowIndex, 1).toString());
				projectNameTf.setText(model.getValueAt(rowIndex, 2).toString());
				projectDescTf.setText(model.getValueAt(rowIndex, 3).toString());
			}
		});
		projectTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_3.setViewportView(projectTable);
		
		JPanel panel_2_1_5_1 = new JPanel();
		panel_2_1_5_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_5_1.setLayout(null);
		panel_2_1_5_1.setBounds(250, 567, 1149, 50);
		projectPanel.add(panel_2_1_5_1);
		
		JButton addProjectBtn = new JButton("Add");
		addProjectBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addProjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreateProjectSP(?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(projectStatusIdTf2.getText()));	
					cs.setString(2, projectNameTf.getText());
					cs.setString(3, projectDescTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Project successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		addProjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addProjectBtn.setBounds(85, 5, 180, 40);
		panel_2_1_5_1.add(addProjectBtn);
		
		JButton deleteProjectBtn = new JButton("Delete");
		deleteProjectBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deleteProjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this project?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeleteProjectSP(?)}");
					
					cs.setInt(1, Integer.parseInt(projectIdTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted project");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
			}
		});
		deleteProjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteProjectBtn.setBounds(350, 5, 180, 40);
		panel_2_1_5_1.add(deleteProjectBtn);
		
		JButton viewProjectBtn = new JButton("View");
		viewProjectBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewProjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadProjectsSP()}");
					rs=cs.executeQuery();
					projectTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewProjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewProjectBtn.setBounds(615, 5, 180, 40);
		panel_2_1_5_1.add(viewProjectBtn);
		
		JButton updateProjectBtn = new JButton("Update");
		updateProjectBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
		updateProjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL UpdateProjectSP(?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(projectIdTf.getText()));
					cs.setInt(2, Integer.parseInt(projectStatusIdTf2.getText()));	
					cs.setString(3, projectNameTf.getText());
					cs.setString(4, projectDescTf.getText());

					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Project successfully updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		updateProjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateProjectBtn.setBounds(880, 5, 180, 40);
		panel_2_1_5_1.add(updateProjectBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 15, 230, 300);
		projectPanel.add(panel_2);
		panel_2.setLayout(null);
		
		projectIdTf = new JTextField();
		projectIdTf.setBounds(15, 37, 200, 35);
		panel_2.add(projectIdTf);
		projectIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projectIdTf.setColumns(10);
		
		projectStatusIdTf2 = new JTextField();
		projectStatusIdTf2.setBounds(15, 109, 200, 35);
		panel_2.add(projectStatusIdTf2);
		projectStatusIdTf2.setToolTipText("1 - Current, 2 - Past");
		projectStatusIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projectStatusIdTf2.setColumns(10);
		
		projectNameTf = new JTextField();
		projectNameTf.setBounds(15, 181, 200, 35);
		panel_2.add(projectNameTf);
		projectNameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projectNameTf.setColumns(10);
		
		projectDescTf = new JTextField();
		projectDescTf.setBounds(15, 253, 200, 35);
		panel_2.add(projectDescTf);
		projectDescTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projectDescTf.setColumns(10);
		
		JLabel lblProjectId = new JLabel("Project Id");
		lblProjectId.setBounds(15, 6, 103, 25);
		panel_2.add(lblProjectId);
		lblProjectId.setForeground(SystemColor.controlDkShadow);
		lblProjectId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblProjectStatusId = new JLabel("Project Status Id");
		lblProjectStatusId.setBounds(15, 78, 180, 25);
		panel_2.add(lblProjectStatusId);
		lblProjectStatusId.setForeground(SystemColor.controlDkShadow);
		lblProjectStatusId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setBounds(15, 150, 200, 25);
		panel_2.add(lblProjectName);
		lblProjectName.setForeground(SystemColor.controlDkShadow);
		lblProjectName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblProjectDescription = new JLabel("Project Description");
		lblProjectDescription.setBounds(15, 222, 180, 25);
		panel_2.add(lblProjectDescription);
		lblProjectDescription.setForeground(SystemColor.controlDkShadow);
		lblProjectDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearProjectBtn = new JButton("Clear");
		clearProjectBtn.setBounds(35, 326, 180, 40);
		projectPanel.add(clearProjectBtn);
		clearProjectBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearProjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				projectIdTf.setText(null);
				projectStatusIdTf2.setText(null);
				projectNameTf.setText(null);
				projectDescTf.setText(null);
			}
		});
		clearProjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel coursePanel = new JPanel();
		coursePanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Courses", null, coursePanel, null);
		coursePanel.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(250, 15, 1149, 541);
		coursePanel.add(scrollPane_4);
		
		courseTable = new JTable();
		courseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel)courseTable.getModel();
				int rowIndex = courseTable.getSelectedRow();
				
				courseIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				courseLevelIdTf2.setText(model.getValueAt(rowIndex, 1).toString());
				courseTitleTf.setText(model.getValueAt(rowIndex, 2).toString());
				courseSemesterTf.setText(model.getValueAt(rowIndex, 3).toString());
				courseEctsTf.setText(model.getValueAt(rowIndex, 4).toString());
			}
		});
		courseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_4.setViewportView(courseTable);
		
		JPanel panel_2_1_5_2 = new JPanel();
		panel_2_1_5_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_5_2.setLayout(null);
		panel_2_1_5_2.setBounds(250, 567, 1149, 50);
		coursePanel.add(panel_2_1_5_2);
		
		JButton addCourseBtn = new JButton("Add");
		addCourseBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreateCourseSP(?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(courseLevelIdTf2.getText()));	
					cs.setString(2, courseTitleTf.getText());
					cs.setInt(3, Integer.parseInt(courseSemesterTf.getText()));	
					cs.setInt(4, Integer.parseInt(courseEctsTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Course successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		addCourseBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addCourseBtn.setBounds(85, 5, 180, 40);
		panel_2_1_5_2.add(addCourseBtn);
		
		JButton deleteCourseBtn = new JButton("Delete");
		deleteCourseBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deleteCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this course?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeleteCourseSP(?)}");
					
					cs.setInt(1, Integer.parseInt(courseIdTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted course");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
			}
		});
		deleteCourseBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteCourseBtn.setBounds(350, 5, 180, 40);
		panel_2_1_5_2.add(deleteCourseBtn);
		
		JButton viewCourseBtn = new JButton("View");
		viewCourseBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadCoursesSP()}");
					rs=cs.executeQuery();
					courseTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewCourseBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewCourseBtn.setBounds(615, 5, 180, 40);
		panel_2_1_5_2.add(viewCourseBtn);
		
		JButton updateCourseBtn = new JButton("Update");
		updateCourseBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
		updateCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL UpdateCourseSP(?,?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(courseIdTf.getText()));
					cs.setInt(2, Integer.parseInt(courseLevelIdTf2.getText()));	
					cs.setString(3, courseTitleTf.getText());
					cs.setInt(4, Integer.parseInt(courseSemesterTf.getText()));	
					cs.setInt(5, Integer.parseInt(courseEctsTf.getText()));	

					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Course successfully updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		updateCourseBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateCourseBtn.setBounds(880, 5, 180, 40);
		panel_2_1_5_2.add(updateCourseBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 15, 230, 400);
		coursePanel.add(panel_3);
		panel_3.setLayout(null);
		
		courseIdTf = new JTextField();
		courseIdTf.setBounds(15, 43, 200, 35);
		panel_3.add(courseIdTf);
		courseIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseIdTf.setColumns(10);
		
		courseLevelIdTf2 = new JTextField();
		courseLevelIdTf2.setBounds(15, 121, 200, 35);
		panel_3.add(courseLevelIdTf2);
		courseLevelIdTf2.setToolTipText("1 - Undergraduate, 2 - Postgraduate");
		courseLevelIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseLevelIdTf2.setColumns(10);
		
		courseTitleTf = new JTextField();
		courseTitleTf.setBounds(15, 199, 200, 35);
		panel_3.add(courseTitleTf);
		courseTitleTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseTitleTf.setColumns(10);
		
		courseSemesterTf = new JTextField();
		courseSemesterTf.setBounds(15, 277, 200, 35);
		panel_3.add(courseSemesterTf);
		courseSemesterTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseSemesterTf.setColumns(10);
		
		courseEctsTf = new JTextField();
		courseEctsTf.setBounds(15, 355, 200, 35);
		panel_3.add(courseEctsTf);
		courseEctsTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseEctsTf.setColumns(10);
		
		JLabel lblCourseId = new JLabel("Course Id");
		lblCourseId.setBounds(15, 9, 200, 25);
		panel_3.add(lblCourseId);
		lblCourseId.setForeground(SystemColor.controlDkShadow);
		lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblCourseLevelId = new JLabel("Course Level Id");
		lblCourseLevelId.setBounds(15, 87, 200, 25);
		panel_3.add(lblCourseLevelId);
		lblCourseLevelId.setForeground(SystemColor.controlDkShadow);
		lblCourseLevelId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblCourseTitle = new JLabel("Course Title");
		lblCourseTitle.setBounds(15, 165, 200, 25);
		panel_3.add(lblCourseTitle);
		lblCourseTitle.setForeground(SystemColor.controlDkShadow);
		lblCourseTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblCourseSemester = new JLabel("Course Semester");
		lblCourseSemester.setBounds(15, 243, 200, 25);
		panel_3.add(lblCourseSemester);
		lblCourseSemester.setForeground(SystemColor.controlDkShadow);
		lblCourseSemester.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblCourseECTS = new JLabel("Course ECTS");
		lblCourseECTS.setBounds(15, 321, 200, 25);
		panel_3.add(lblCourseECTS);
		lblCourseECTS.setForeground(SystemColor.controlDkShadow);
		lblCourseECTS.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearCourseBtn = new JButton("Clear");
		clearCourseBtn.setBounds(35, 426, 180, 40);
		coursePanel.add(clearCourseBtn);
		clearCourseBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				courseIdTf.setText(null);
				courseLevelIdTf2.setText(null);
				courseTitleTf.setText(null);
				courseSemesterTf.setText(null);
				courseEctsTf.setText(null);
			}
		});
		clearCourseBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel annPanel = new JPanel();
		annPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Announcements", null, annPanel, null);
		annPanel.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(250, 15, 1149, 541);
		annPanel.add(scrollPane_5);
		
		annTable = new JTable();
		annTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)annTable.getModel();
				int rowIndex = annTable.getSelectedRow();
				
				annIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				memberIdTf2.setText(model.getValueAt(rowIndex, 1).toString());
				annTitleTf.setText(model.getValueAt(rowIndex, 2).toString());
				annDateTf.setText(model.getValueAt(rowIndex, 3).toString());
				annBodyTf.setText(model.getValueAt(rowIndex, 4).toString());
			}
		});
		annTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_5.setViewportView(annTable);
		
		JPanel panel_2_1_5_2_1 = new JPanel();
		panel_2_1_5_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_5_2_1.setLayout(null);
		panel_2_1_5_2_1.setBounds(250, 567, 1149, 50);
		annPanel.add(panel_2_1_5_2_1);
		
		JButton addAnnBtn = new JButton("Add");
		addAnnBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addAnnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreateAnnSP(?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(memberIdTf2.getText()));	
					cs.setString(2, annTitleTf.getText());
					cs.setString(3, annDateTf.getText());
					cs.setString(4, annBodyTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Announcement successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		addAnnBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addAnnBtn.setBounds(85, 5, 180, 40);
		panel_2_1_5_2_1.add(addAnnBtn);
		
		JButton deleteAnnBtn = new JButton("Delete");
		deleteAnnBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deleteAnnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this announcement?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeleteAnnSP(?)}");
					
					cs.setInt(1, Integer.parseInt(annIdTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted announcement");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
			}
		});
		deleteAnnBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteAnnBtn.setBounds(350, 5, 180, 40);
		panel_2_1_5_2_1.add(deleteAnnBtn);
		
		JButton viewAnnBtn = new JButton("View");
		viewAnnBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewAnnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadAnnsSP()}");
					rs=cs.executeQuery();
					annTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewAnnBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewAnnBtn.setBounds(615, 5, 180, 40);
		panel_2_1_5_2_1.add(viewAnnBtn);
		
		JButton updateAnnBtn = new JButton("Update");
		updateAnnBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
		updateAnnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL UpdateAnnSP(?,?,?,?,?)}");
					
					cs.setInt(1, Integer.parseInt(annIdTf.getText()));
					cs.setInt(2, Integer.parseInt(memberIdTf2.getText()));	
					cs.setString(3, annTitleTf.getText());
					cs.setString(4, annDateTf.getText());
					cs.setString(5, annBodyTf.getText());

					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Announcement successfully updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		updateAnnBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateAnnBtn.setBounds(880, 5, 180, 40);
		panel_2_1_5_2_1.add(updateAnnBtn);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(10, 15, 230, 400);
		annPanel.add(panel_4);
		panel_4.setLayout(null);
		
		annIdTf = new JTextField();
		annIdTf.setBounds(15, 43, 200, 35);
		panel_4.add(annIdTf);
		annIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		annIdTf.setColumns(10);
		
		memberIdTf2 = new JTextField();
		memberIdTf2.setBounds(15, 121, 200, 35);
		panel_4.add(memberIdTf2);
		memberIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberIdTf2.setColumns(10);
		
		annTitleTf = new JTextField();
		annTitleTf.setBounds(15, 199, 200, 35);
		panel_4.add(annTitleTf);
		annTitleTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		annTitleTf.setColumns(10);
		
		annDateTf = new JTextField();
		annDateTf.setToolTipText("yyyy-mm-dd");
		annDateTf.setBounds(15, 277, 200, 35);
		panel_4.add(annDateTf);
		annDateTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		annDateTf.setColumns(10);
		
		annBodyTf = new JTextField();
		annBodyTf.setBounds(15, 355, 200, 35);
		panel_4.add(annBodyTf);
		annBodyTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		annBodyTf.setColumns(10);
		
		JLabel lblAnnouncementId = new JLabel("Announcement Id");
		lblAnnouncementId.setBounds(16, 11, 199, 25);
		panel_4.add(lblAnnouncementId);
		lblAnnouncementId.setForeground(SystemColor.controlDkShadow);
		lblAnnouncementId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblMemberId_3 = new JLabel("Member Id");
		lblMemberId_3.setBounds(15, 89, 199, 25);
		panel_4.add(lblMemberId_3);
		lblMemberId_3.setForeground(SystemColor.controlDkShadow);
		lblMemberId_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblAnnouncementTitle = new JLabel("Announcement Title");
		lblAnnouncementTitle.setBounds(16, 167, 199, 25);
		panel_4.add(lblAnnouncementTitle);
		lblAnnouncementTitle.setForeground(SystemColor.controlDkShadow);
		lblAnnouncementTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblAnnouncementDate = new JLabel("Announcement Date");
		lblAnnouncementDate.setBounds(16, 245, 199, 25);
		panel_4.add(lblAnnouncementDate);
		lblAnnouncementDate.setForeground(SystemColor.controlDkShadow);
		lblAnnouncementDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblAnnouncementBody = new JLabel("Announcement Body");
		lblAnnouncementBody.setBounds(16, 323, 199, 25);
		panel_4.add(lblAnnouncementBody);
		lblAnnouncementBody.setForeground(SystemColor.controlDkShadow);
		lblAnnouncementBody.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearAnnBtn = new JButton("Clear");
		clearAnnBtn.setBounds(35, 424, 180, 40);
		annPanel.add(clearAnnBtn);
		clearAnnBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearAnnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				annIdTf.setText(null);
				memberIdTf2.setText(null);
				annTitleTf.setText(null);
				annDateTf.setText(null);
				annBodyTf.setText(null);
			}
		});
		clearAnnBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
				JPanel memberCategoryPanel = new JPanel();
				memberCategoryPanel.setBackground(new Color(255, 222, 173));
				tabbedPane.addTab("Member Category", null, memberCategoryPanel, null);
				memberCategoryPanel.setLayout(null);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(250, 15, 1149, 541);
				memberCategoryPanel.add(scrollPane_2);
				
				memberCategoryTable = new JTable();
				memberCategoryTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						DefaultTableModel model = (DefaultTableModel)memberCategoryTable.getModel();
						int rowIndex = memberCategoryTable.getSelectedRow();
						
						memberCategoryIdTf.setText(model.getValueAt(rowIndex, 0).toString());
						memberCategoryNameTf.setText(model.getValueAt(rowIndex, 1).toString());
						
					}
				});
				memberCategoryTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
					}
				));
				scrollPane_2.setViewportView(memberCategoryTable);
				
				JPanel panel_2_1_1 = new JPanel();
				panel_2_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_2_1_1.setLayout(null);
				panel_2_1_1.setBounds(250, 567, 1149, 50);
				memberCategoryPanel.add(panel_2_1_1);
				
				JButton addMemberCategoryBtn = new JButton("Add");
				addMemberCategoryBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
				addMemberCategoryBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Connection con;
						CallableStatement cs;
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
							cs = con.prepareCall("{ CALL CreateMemberCategorySP(?)}");
							
							cs.setString(1, memberCategoryNameTf.getText());
							
							cs.executeUpdate();
							JOptionPane.showMessageDialog(null, "Member category successfully inserted to DB");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				addMemberCategoryBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
				addMemberCategoryBtn.setBounds(85, 5, 180, 40);
				panel_2_1_1.add(addMemberCategoryBtn);
				
				JButton deleteMemberCategoryBtn = new JButton("Delete");
				deleteMemberCategoryBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
				deleteMemberCategoryBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Connection con;
						CallableStatement cs;
						
						int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this member category?", "Delete", JOptionPane.YES_NO_OPTION);
						if(p==0) {				
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
							cs = con.prepareCall("{ CALL DeleteMemberCategorySP(?)}");
							
							cs.setInt(1, Integer.parseInt(memberCategoryIdTf.getText()));	
							
							cs.executeUpdate();
							JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted member category");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					}
				});
				deleteMemberCategoryBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
				deleteMemberCategoryBtn.setBounds(350, 5, 180, 40);
				panel_2_1_1.add(deleteMemberCategoryBtn);
				
				JButton viewMemberCategoryBtn = new JButton("View");
				viewMemberCategoryBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
				viewMemberCategoryBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Connection con;
						CallableStatement cs;
						ResultSet rs;
									
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
							cs = con.prepareCall("{ CALL ReadMemberCategorySP()}");
							rs=cs.executeQuery();
							memberCategoryTable.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
					}
				});
				viewMemberCategoryBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
				viewMemberCategoryBtn.setBounds(615, 5, 180, 40);
				panel_2_1_1.add(viewMemberCategoryBtn);
				
				JButton updateMemberCategoryBtn = new JButton("Update");
				updateMemberCategoryBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
				updateMemberCategoryBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Connection con;
						CallableStatement cs;
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
							cs = con.prepareCall("{ CALL UpdateMemberCategorySP(?,?)}");
							
							cs.setInt(1, Integer.parseInt(memberCategoryIdTf.getText()));
							cs.setString(2, memberCategoryNameTf.getText());
							
							cs.executeUpdate();
							JOptionPane.showMessageDialog(null, "Member category successfully updated");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				updateMemberCategoryBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
				updateMemberCategoryBtn.setBounds(880, 5, 180, 40);
				panel_2_1_1.add(updateMemberCategoryBtn);
				
				JPanel panel_5 = new JPanel();
				panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_5.setBounds(10, 15, 230, 150);
				memberCategoryPanel.add(panel_5);
				panel_5.setLayout(null);
				
				memberCategoryIdTf = new JTextField();
				memberCategoryIdTf.setBounds(15, 37, 200, 35);
				panel_5.add(memberCategoryIdTf);
				memberCategoryIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
				memberCategoryIdTf.setColumns(10);
				
				memberCategoryNameTf = new JTextField();
				memberCategoryNameTf.setBounds(15, 109, 200, 35);
				panel_5.add(memberCategoryNameTf);
				memberCategoryNameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
				memberCategoryNameTf.setColumns(10);
				
				JLabel lblMemberCategoryId_1 = new JLabel("Member Category Id");
				lblMemberCategoryId_1.setBounds(15, 6, 180, 25);
				panel_5.add(lblMemberCategoryId_1);
				lblMemberCategoryId_1.setForeground(SystemColor.controlDkShadow);
				lblMemberCategoryId_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				JLabel lblMemberCategoryName = new JLabel("Member Category Name");
				lblMemberCategoryName.setBounds(15, 78, 205, 25);
				panel_5.add(lblMemberCategoryName);
				lblMemberCategoryName.setForeground(SystemColor.controlDkShadow);
				lblMemberCategoryName.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				JButton clearMemberCategoryBtn = new JButton("Clear");
				clearMemberCategoryBtn.setBounds(35, 176, 180, 40);
				memberCategoryPanel.add(clearMemberCategoryBtn);
				clearMemberCategoryBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
				clearMemberCategoryBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						memberCategoryIdTf.setText(null);
						memberCategoryNameTf.setText(null);
					}
				});
				clearMemberCategoryBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel pubTypePanel = new JPanel();
		pubTypePanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Pub Type", null, pubTypePanel, null);
		pubTypePanel.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(250, 15, 1149, 541);
		pubTypePanel.add(scrollPane_6);
		
		pubTypeTable = new JTable();
		pubTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)pubTypeTable.getModel();
				int rowIndex = pubTypeTable.getSelectedRow();
				
				pubTypeIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				pubTypeNameTf.setText(model.getValueAt(rowIndex, 1).toString());
				
			}
		});
		pubTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_6.setViewportView(pubTypeTable);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBounds(250, 567, 1149, 50);
		pubTypePanel.add(panel_2_1_1_1);
		
		JButton addPubTypeBtn = new JButton("Add");
		addPubTypeBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addPubTypeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreatePubTypeSP(?)}");
					
					cs.setString(1, pubTypeNameTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Publication type successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addPubTypeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addPubTypeBtn.setBounds(85, 5, 180, 40);
		panel_2_1_1_1.add(addPubTypeBtn);
		
		JButton deletePubTypeBtn = new JButton("Delete");
		deletePubTypeBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deletePubTypeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this publication type?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeletePubTypeSP(?)}");
					
					cs.setInt(1, Integer.parseInt(pubTypeIdTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted publication type");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
			}
		});
		deletePubTypeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deletePubTypeBtn.setBounds(350, 5, 180, 40);
		panel_2_1_1_1.add(deletePubTypeBtn);
		
		JButton viewPubTypeBtn = new JButton("View");
		viewPubTypeBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewPubTypeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadPubTypeSP()}");
					rs=cs.executeQuery();
					pubTypeTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewPubTypeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewPubTypeBtn.setBounds(615, 5, 180, 40);
		panel_2_1_1_1.add(viewPubTypeBtn);
		
		JButton updatePubTypeBtn = new JButton("Update");
		updatePubTypeBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
		updatePubTypeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL UpdatePubTypeSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(pubTypeIdTf.getText()));
					cs.setString(2, pubTypeNameTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Publication type successfully updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		updatePubTypeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updatePubTypeBtn.setBounds(880, 5, 180, 40);
		panel_2_1_1_1.add(updatePubTypeBtn);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(10, 15, 230, 150);
		pubTypePanel.add(panel_6);
		panel_6.setLayout(null);
		
		pubTypeIdTf = new JTextField();
		pubTypeIdTf.setBounds(15, 37, 200, 35);
		panel_6.add(pubTypeIdTf);
		pubTypeIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubTypeIdTf.setColumns(10);
		
		pubTypeNameTf = new JTextField();
		pubTypeNameTf.setBounds(15, 109, 200, 35);
		panel_6.add(pubTypeNameTf);
		pubTypeNameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubTypeNameTf.setColumns(10);
		
		JLabel lblPubTypeId = new JLabel("Publication Type Id");
		lblPubTypeId.setBounds(15, 6, 180, 25);
		panel_6.add(lblPubTypeId);
		lblPubTypeId.setForeground(SystemColor.controlDkShadow);
		lblPubTypeId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblPubTypeName = new JLabel("Publication Type Name");
		lblPubTypeName.setBounds(15, 78, 205, 25);
		panel_6.add(lblPubTypeName);
		lblPubTypeName.setForeground(SystemColor.controlDkShadow);
		lblPubTypeName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearPubTypeBtn = new JButton("Clear");
		clearPubTypeBtn.setBounds(35, 176, 180, 40);
		pubTypePanel.add(clearPubTypeBtn);
		clearPubTypeBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearPubTypeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pubTypeIdTf.setText(null);
				pubTypeNameTf.setText(null);
			}
		});
		clearPubTypeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel projectStatusPanel = new JPanel();
		projectStatusPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Project Status", null, projectStatusPanel, null);
		projectStatusPanel.setLayout(null);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(250, 15, 1149, 541);
		projectStatusPanel.add(scrollPane_7);
		
		projectStatusTable = new JTable();
		projectStatusTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)projectStatusTable.getModel();
				int rowIndex = projectStatusTable.getSelectedRow();
				
				projectStatusIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				projectStatusTypeTf.setText(model.getValueAt(rowIndex, 1).toString());
			
			}
		});
		projectStatusTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_7.setViewportView(projectStatusTable);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBounds(250, 567, 1149, 50);
		projectStatusPanel.add(panel_2_1_1_1_1);
		
		JButton addProjectStatusBtn = new JButton("Add");
		addProjectStatusBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addProjectStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreateProjectStatusSP(?)}");
					
					cs.setString(1, projectStatusTypeTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Project status successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addProjectStatusBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addProjectStatusBtn.setBounds(85, 5, 180, 40);
		panel_2_1_1_1_1.add(addProjectStatusBtn);
		
		JButton deleteProjectStatusBtn = new JButton("Delete");
		deleteProjectStatusBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deleteProjectStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this project status?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeleteProjectStatusSP(?)}");
					
					cs.setInt(1, Integer.parseInt(projectStatusIdTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted project status");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
			}
		});
		deleteProjectStatusBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteProjectStatusBtn.setBounds(350, 5, 180, 40);
		panel_2_1_1_1_1.add(deleteProjectStatusBtn);
		
		JButton viewProjectStatusBtn = new JButton("View");
		viewProjectStatusBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewProjectStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadProjectStatusSP()}");
					rs=cs.executeQuery();
					projectStatusTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewProjectStatusBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewProjectStatusBtn.setBounds(615, 5, 180, 40);
		panel_2_1_1_1_1.add(viewProjectStatusBtn);
		
		JButton updateProjectStatusBtn = new JButton("Update");
		updateProjectStatusBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
		updateProjectStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL UpdateProjectStatusSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(projectStatusIdTf.getText()));
					cs.setString(2, projectStatusTypeTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Project status successfully updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		updateProjectStatusBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateProjectStatusBtn.setBounds(880, 5, 180, 40);
		panel_2_1_1_1_1.add(updateProjectStatusBtn);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(10, 15, 230, 150);
		projectStatusPanel.add(panel_7);
		panel_7.setLayout(null);
		
		projectStatusIdTf = new JTextField();
		projectStatusIdTf.setBounds(15, 37, 200, 35);
		panel_7.add(projectStatusIdTf);
		projectStatusIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projectStatusIdTf.setColumns(10);
		
		projectStatusTypeTf = new JTextField();
		projectStatusTypeTf.setBounds(15, 109, 200, 35);
		panel_7.add(projectStatusTypeTf);
		projectStatusTypeTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projectStatusTypeTf.setColumns(10);
		
		JLabel lblProjectStatusId_1 = new JLabel("Project Status Id");
		lblProjectStatusId_1.setBounds(15, 6, 180, 25);
		panel_7.add(lblProjectStatusId_1);
		lblProjectStatusId_1.setForeground(SystemColor.controlDkShadow);
		lblProjectStatusId_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblProjectStatusType = new JLabel("Project Status Type");
		lblProjectStatusType.setBounds(15, 78, 205, 25);
		panel_7.add(lblProjectStatusType);
		lblProjectStatusType.setForeground(SystemColor.controlDkShadow);
		lblProjectStatusType.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearProjectStatusBtn = new JButton("Clear");
		clearProjectStatusBtn.setBounds(35, 176, 180, 40);
		projectStatusPanel.add(clearProjectStatusBtn);
		clearProjectStatusBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearProjectStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				projectStatusIdTf.setText(null);
				projectStatusTypeTf.setText(null);
			}
		});
		clearProjectStatusBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel courseLevelPanel = new JPanel();
		courseLevelPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Course Level", null, courseLevelPanel, null);
		courseLevelPanel.setLayout(null);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(250, 15, 1149, 541);
		courseLevelPanel.add(scrollPane_8);
		
		courseLevelTable = new JTable();
		courseLevelTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)courseLevelTable.getModel();
				int rowIndex = courseLevelTable.getSelectedRow();
				
				courseLevelIdTf.setText(model.getValueAt(rowIndex, 0).toString());
				courseLevelNameTf.setText(model.getValueAt(rowIndex, 1).toString());
			}
		});
		courseLevelTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_8.setViewportView(courseLevelTable);
		
		JPanel panel_2_1_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1.setBounds(250, 567, 1149, 50);
		courseLevelPanel.add(panel_2_1_1_1_1_1);
		
		JButton addCourseLevelBtn = new JButton("Add");
		addCourseLevelBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addCourseLevelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreateCourseLevelSP(?)}");
					
					cs.setString(1, courseLevelNameTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Course level successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addCourseLevelBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addCourseLevelBtn.setBounds(85, 5, 180, 40);
		panel_2_1_1_1_1_1.add(addCourseLevelBtn);
		
		JButton deleteCourseLevelBtn = new JButton("Delete");
		deleteCourseLevelBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deleteCourseLevelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this course level?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeleteCourseLevelSP(?)}");
					
					cs.setInt(1, Integer.parseInt(courseLevelIdTf.getText()));	
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted course level");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
			}
		});
		deleteCourseLevelBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteCourseLevelBtn.setBounds(350, 5, 180, 40);
		panel_2_1_1_1_1_1.add(deleteCourseLevelBtn);
		
		JButton viewCourseLevelBtn = new JButton("View");
		viewCourseLevelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadCourseLevelSP()}");
					rs=cs.executeQuery();
					courseLevelTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewCourseLevelBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewCourseLevelBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewCourseLevelBtn.setBounds(615, 5, 180, 40);
		panel_2_1_1_1_1_1.add(viewCourseLevelBtn);
		
		JButton updateCourseLevelBtn = new JButton("Update");
		updateCourseLevelBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Update16-icon.png")));
		updateCourseLevelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL UpdateCourseLevelSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(courseLevelIdTf.getText()));
					cs.setString(2, courseLevelNameTf.getText());
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Course level successfully updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		updateCourseLevelBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateCourseLevelBtn.setBounds(880, 5, 180, 40);
		panel_2_1_1_1_1_1.add(updateCourseLevelBtn);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBounds(10, 15, 230, 150);
		courseLevelPanel.add(panel_8);
		panel_8.setLayout(null);
		
		courseLevelIdTf = new JTextField();
		courseLevelIdTf.setBounds(15, 37, 200, 35);
		panel_8.add(courseLevelIdTf);
		courseLevelIdTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseLevelIdTf.setColumns(10);
		
		courseLevelNameTf = new JTextField();
		courseLevelNameTf.setBounds(15, 109, 200, 35);
		panel_8.add(courseLevelNameTf);
		courseLevelNameTf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseLevelNameTf.setColumns(10);
		
		JLabel lblCourseLevelId2 = new JLabel("Course Level Id");
		lblCourseLevelId2.setBounds(15, 6, 180, 25);
		panel_8.add(lblCourseLevelId2);
		lblCourseLevelId2.setForeground(SystemColor.controlDkShadow);
		lblCourseLevelId2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblCourseLevelName = new JLabel("Course Level Name");
		lblCourseLevelName.setBounds(15, 78, 205, 25);
		panel_8.add(lblCourseLevelName);
		lblCourseLevelName.setForeground(SystemColor.controlDkShadow);
		lblCourseLevelName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearCourseLevelBtn = new JButton("Clear");
		clearCourseLevelBtn.setBounds(35, 176, 180, 40);
		courseLevelPanel.add(clearCourseLevelBtn);
		clearCourseLevelBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearCourseLevelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				courseLevelIdTf.setText(null);
				courseLevelNameTf.setText(null);
			}
		});
		clearCourseLevelBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel pubParticipantsPanel = new JPanel();
		pubParticipantsPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Pub Participants", null, pubParticipantsPanel, null);
		pubParticipantsPanel.setLayout(null);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(250, 15, 1149, 541);
		pubParticipantsPanel.add(scrollPane_9);
		
		pubParticipantsTable = new JTable();
		pubParticipantsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel)pubParticipantsTable.getModel();
				int rowIndex = pubParticipantsTable.getSelectedRow();
				
				pubIdTf2.setText(model.getValueAt(rowIndex, 0).toString());
				memberIdTf3.setText(model.getValueAt(rowIndex, 1).toString());
			}
		});
		pubParticipantsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_9.setViewportView(pubParticipantsTable);
		
		JPanel panel_2_1_1_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1_1.setBounds(250, 567, 1149, 50);
		pubParticipantsPanel.add(panel_2_1_1_1_1_1_1);
		
		JButton addPubParticipantBtn = new JButton("Add");
		addPubParticipantBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addPubParticipantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreatePubParticipantSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(pubIdTf2.getText()));
					cs.setInt(2, Integer.parseInt(memberIdTf3.getText()));
										
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Publication participant successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addPubParticipantBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addPubParticipantBtn.setBounds(152, 5, 180, 40);
		panel_2_1_1_1_1_1_1.add(addPubParticipantBtn);
		
		JButton deletePubParticipantBtn = new JButton("Delete");
		deletePubParticipantBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deletePubParticipantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this publication participant?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeletePubParticipantSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(pubIdTf2.getText()));
					cs.setInt(2, Integer.parseInt(memberIdTf3.getText()));

					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted publication participant");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
			}
		});
		deletePubParticipantBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deletePubParticipantBtn.setBounds(484, 5, 180, 40);
		panel_2_1_1_1_1_1_1.add(deletePubParticipantBtn);
		
		JButton viewPubParticipantBtn = new JButton("View");
		viewPubParticipantBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewPubParticipantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadPubParticipantsSP()}");
					rs=cs.executeQuery();
					pubParticipantsTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewPubParticipantBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewPubParticipantBtn.setBounds(816, 5, 180, 40);
		panel_2_1_1_1_1_1_1.add(viewPubParticipantBtn);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9.setBounds(10, 15, 230, 150);
		pubParticipantsPanel.add(panel_9);
		panel_9.setLayout(null);
		
		pubIdTf2 = new JTextField();
		pubIdTf2.setBounds(15, 37, 200, 35);
		panel_9.add(pubIdTf2);
		pubIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pubIdTf2.setColumns(10);
		
		memberIdTf3 = new JTextField();
		memberIdTf3.setBounds(15, 109, 200, 35);
		panel_9.add(memberIdTf3);
		memberIdTf3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberIdTf3.setColumns(10);
		
		JLabel lblPublicationId = new JLabel("Publication Id");
		lblPublicationId.setBounds(15, 6, 205, 25);
		panel_9.add(lblPublicationId);
		lblPublicationId.setForeground(SystemColor.controlDkShadow);
		lblPublicationId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblMemberId_1 = new JLabel("Member Id");
		lblMemberId_1.setBounds(15, 78, 180, 25);
		panel_9.add(lblMemberId_1);
		lblMemberId_1.setForeground(SystemColor.controlDkShadow);
		lblMemberId_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearPubParticipantBtn = new JButton("Clear");
		clearPubParticipantBtn.setBounds(35, 176, 180, 40);
		pubParticipantsPanel.add(clearPubParticipantBtn);
		clearPubParticipantBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearPubParticipantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				memberIdTf3.setText(null);
				pubIdTf2.setText(null);
			}
		});
		clearPubParticipantBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel projectMembersPanel = new JPanel();
		projectMembersPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Project Members", null, projectMembersPanel, null);
		projectMembersPanel.setLayout(null);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(250, 15, 1149, 541);
		projectMembersPanel.add(scrollPane_10);
		
		projectMembersTable = new JTable();
		projectMembersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)projectMembersTable.getModel();
				int rowIndex = projectMembersTable.getSelectedRow();
				
				projectIdTf3.setText(model.getValueAt(rowIndex, 0).toString());
				memberIdTf4.setText(model.getValueAt(rowIndex, 1).toString());
			}
		});
		projectMembersTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_10.setViewportView(projectMembersTable);
		
		JPanel panel_2_1_1_1_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_1_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1_1_1.setBounds(250, 567, 1149, 50);
		projectMembersPanel.add(panel_2_1_1_1_1_1_1_1);
		
		JButton addProjectMemberBtn = new JButton("Add");
		addProjectMemberBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addProjectMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreateProjectMemberSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(projectIdTf3.getText()));
					cs.setInt(2, Integer.parseInt(memberIdTf4.getText()));
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Project member successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addProjectMemberBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addProjectMemberBtn.setBounds(152, 5, 180, 40);
		panel_2_1_1_1_1_1_1_1.add(addProjectMemberBtn);
		
		JButton deleteProjectMemberBtn = new JButton("Delete");
		deleteProjectMemberBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deleteProjectMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this project member?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeleteProjectMemberSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(projectIdTf3.getText()));
					cs.setInt(2, Integer.parseInt(memberIdTf4.getText()));
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted project member");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
			}
		});
		deleteProjectMemberBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteProjectMemberBtn.setBounds(484, 5, 180, 40);
		panel_2_1_1_1_1_1_1_1.add(deleteProjectMemberBtn);
		
		JButton viewProjectMembersBtn = new JButton("View");
		viewProjectMembersBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewProjectMembersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadProjectMembersSP()}");
					rs=cs.executeQuery();
					projectMembersTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewProjectMembersBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewProjectMembersBtn.setBounds(816, 5, 180, 40);
		panel_2_1_1_1_1_1_1_1.add(viewProjectMembersBtn);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9_1.setBounds(10, 15, 230, 150);
		projectMembersPanel.add(panel_9_1);
		panel_9_1.setLayout(null);
		
		projectIdTf3 = new JTextField();
		projectIdTf3.setBounds(15, 37, 200, 35);
		panel_9_1.add(projectIdTf3);
		projectIdTf3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		projectIdTf3.setColumns(10);
		
		memberIdTf4 = new JTextField();
		memberIdTf4.setBounds(15, 109, 200, 35);
		panel_9_1.add(memberIdTf4);
		memberIdTf4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberIdTf4.setColumns(10);
		
		JLabel lblProjectId_1 = new JLabel("Project Id");
		lblProjectId_1.setBounds(15, 6, 205, 25);
		panel_9_1.add(lblProjectId_1);
		lblProjectId_1.setForeground(SystemColor.controlDkShadow);
		lblProjectId_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblMemberId_1_1 = new JLabel("Member Id");
		lblMemberId_1_1.setBounds(15, 78, 180, 25);
		panel_9_1.add(lblMemberId_1_1);
		lblMemberId_1_1.setForeground(SystemColor.controlDkShadow);
		lblMemberId_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearProjectMemberBtn = new JButton("Clear");
		clearProjectMemberBtn.setBounds(35, 176, 180, 40);
		projectMembersPanel.add(clearProjectMemberBtn);
		clearProjectMemberBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearProjectMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				memberIdTf4.setText(null);
				projectIdTf3.setText(null);
			}
		});
		clearProjectMemberBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel courseParticipantsPanel = new JPanel();
		courseParticipantsPanel.setBackground(new Color(255, 222, 173));
		tabbedPane.addTab("Course Participants", null, courseParticipantsPanel, null);
		courseParticipantsPanel.setLayout(null);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(250, 15, 1149, 541);
		courseParticipantsPanel.add(scrollPane_11);
		
		courseParticipantsTable = new JTable();
		courseParticipantsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)courseParticipantsTable.getModel();
				int rowIndex = courseParticipantsTable.getSelectedRow();
				
				courseIdTf2.setText(model.getValueAt(rowIndex, 0).toString());
				memberIdTf5.setText(model.getValueAt(rowIndex, 1).toString());
			}
		});
		courseParticipantsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_11.setViewportView(courseParticipantsTable);
		
		JPanel panel_2_1_1_1_1_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_1_1_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1_1_1_1.setBounds(250, 567, 1149, 50);
		courseParticipantsPanel.add(panel_2_1_1_1_1_1_1_1_1);
		
		JButton addCourseParticipantBtn = new JButton("Add");
		addCourseParticipantBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Add16-icon.png")));
		addCourseParticipantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL CreateCourseParticipantSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(courseIdTf2.getText()));
					cs.setInt(2, Integer.parseInt(memberIdTf5.getText()));
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(null, "Course participant successfully inserted to DB");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addCourseParticipantBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addCourseParticipantBtn.setBounds(152, 5, 180, 40);
		panel_2_1_1_1_1_1_1_1_1.add(addCourseParticipantBtn);
		
		JButton deleteCourseParticipantBtn = new JButton("Delete");
		deleteCourseParticipantBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Delete16-icon.png")));
		deleteCourseParticipantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				
				int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this course participant?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL DeleteCourseParticipantSP(?,?)}");
					
					cs.setInt(1, Integer.parseInt(memberIdTf5.getText()));
					cs.setInt(2, Integer.parseInt(courseIdTf2.getText()));
					
					cs.executeUpdate();
					JOptionPane.showMessageDialog(getContentPane(), "Successfully deleted course participant");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
			}
		});
		deleteCourseParticipantBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteCourseParticipantBtn.setBounds(484, 5, 180, 40);
		panel_2_1_1_1_1_1_1_1_1.add(deleteCourseParticipantBtn);
		
		JButton viewCourseParticipantBtn = new JButton("View");
		viewCourseParticipantBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/View16-icon.png")));
		viewCourseParticipantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ReadCourseParticipantsSP()}");
					rs=cs.executeQuery();
					courseParticipantsTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		viewCourseParticipantBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewCourseParticipantBtn.setBounds(816, 5, 180, 40);
		panel_2_1_1_1_1_1_1_1_1.add(viewCourseParticipantBtn);
		
		JPanel panel_9_2 = new JPanel();
		panel_9_2.setLayout(null);
		panel_9_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9_2.setBounds(10, 15, 230, 150);
		courseParticipantsPanel.add(panel_9_2);
		
		courseIdTf2 = new JTextField();
		courseIdTf2.setBounds(15, 37, 200, 35);
		panel_9_2.add(courseIdTf2);
		courseIdTf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseIdTf2.setColumns(10);
		
		memberIdTf5 = new JTextField();
		memberIdTf5.setBounds(15, 109, 200, 35);
		panel_9_2.add(memberIdTf5);
		memberIdTf5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memberIdTf5.setColumns(10);
		
		JLabel lblCourseId_1_1 = new JLabel("Course Id");
		lblCourseId_1_1.setBounds(15, 6, 205, 25);
		panel_9_2.add(lblCourseId_1_1);
		lblCourseId_1_1.setForeground(SystemColor.controlDkShadow);
		lblCourseId_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblMemberId_1_1_1 = new JLabel("Member Id");
		lblMemberId_1_1_1.setBounds(15, 78, 180, 25);
		panel_9_2.add(lblMemberId_1_1_1);
		lblMemberId_1_1_1.setForeground(SystemColor.controlDkShadow);
		lblMemberId_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton clearCourseParticipantBtn = new JButton("Clear");
		clearCourseParticipantBtn.setBounds(35, 176, 180, 40);
		courseParticipantsPanel.add(clearCourseParticipantBtn);
		clearCourseParticipantBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Clear16-icon.png")));
		clearCourseParticipantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				memberIdTf5.setText(null);
				courseIdTf2.setText(null);
			}
		});
		clearCourseParticipantBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeScreen labHomeScreen = new HomeScreen();
				labHomeScreen.setVisible(true);
				labHomeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		logoutBtn.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Cancel16-icon.png")));
		logoutBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		logoutBtn.setBounds(1314, 24, 110, 40);
		contentPane.add(logoutBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Lab64-icon.png")));
		lblNewLabel.setBounds(256, 11, 64, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Editor64-icon.png")));
		lblNewLabel_1.setBounds(330, 11, 64, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Graph64-icon.png")));
		lblNewLabel_1_1.setBounds(404, 11, 64, 64);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("2020, Nikolaou Stefanos");
		lblNewLabel_3.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Copyright16-icon.png")));
		lblNewLabel_3.setForeground(new Color(47, 79, 79));
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblNewLabel_3.setBounds(76, 745, 191, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright");
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(10, 745, 64, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Research Lab DataBase Management System");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(483, 27, 468, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Lab64-icon.png")));
		lblNewLabel_4.setBounds(956, 11, 64, 64);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Editor64-icon.png")));
		lblNewLabel_1_2.setBounds(1030, 11, 64, 64);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/Graph64-icon.png")));
		lblNewLabel_1_1_1.setBounds(1104, 11, 64, 64);
		contentPane.add(lblNewLabel_1_1_1);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
