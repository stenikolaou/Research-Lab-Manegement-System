package user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import admin.AdminLogin;
import announcements.ByDateAsc;
import announcements.ByDateDesc;
import courses.ByFaculty;
import courses.PostgraduateCourses;
import courses.UndergraduateCourses;
import members.AllMembers;
import members.Faculty;
import members.PastMembers;
import members.PhdCandidates;
import members.Postgraduates;
import members.Researchers;
import members.Undergraduates;
import net.proteanit.sql.DbUtils;
import projects.Current;
import projects.Past;
import projects.ProjectParticipants;
import publications.AllPubs;
import publications.ByMember;
import publications.ByProject;
import publications.Convention;
import publications.Magazine;
import publications.PublicationParticipants;

@SuppressWarnings("serial")
public class HomeScreen extends JFrame {

	private JPanel contentPane;
	private JMenuItem projectParticipantsMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen labHomeScreen = new HomeScreen();
					labHomeScreen.setVisible(true);
					labHomeScreen.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeScreen.class.getResource("/Home16-icon.png")));
		setTitle("HomeScreen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 562);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(10, 0, 0, 0));
		setJMenuBar(menuBar);
		
		JMenu membersMenu = new JMenu("Members");
		menuBar.add(membersMenu);
		
		JMenuItem facultyMenuItem = new JMenuItem("Faculty");
		facultyMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Faculty16-icon.png")));
		facultyMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Faculty faculty = new Faculty();
				faculty.setVisible(true);
				faculty.setLocationRelativeTo(null);
				dispose();

				Connection con;
				CallableStatement cs;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowFacultySP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);

					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);

					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					Faculty.facultyTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		membersMenu.add(facultyMenuItem);
		
		JMenuItem researchersMenuItem = new JMenuItem("Researchers");
		researchersMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Researchers16-icon.png")));
		researchersMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Researchers researchers = new Researchers();
				researchers.setVisible(true);
				researchers.setLocationRelativeTo(null);
				dispose();
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowResearchersSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);
		
					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);
		
					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					Researchers.researchersTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		membersMenu.add(researchersMenuItem);
		
		JMenuItem phdMenuItem = new JMenuItem("PhD Candidates");
		phdMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Phd16-icon.png")));
		phdMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PhdCandidates phd = new PhdCandidates();
				phd.setVisible(true);
				phd.setLocationRelativeTo(null);
				dispose();
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowPhdSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);
		
					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);
		
					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					PhdCandidates.phdTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		membersMenu.add(phdMenuItem);
		
		JMenuItem postgraduatesMenuItem = new JMenuItem("Postgraduates");
		postgraduatesMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Postgraduate16-icon.png")));
		postgraduatesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Postgraduates postgraduates = new Postgraduates();
				postgraduates.setVisible(true);
				postgraduates.setLocationRelativeTo(null);
				dispose();
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowPostgraduatesSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);
		
					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);
		
					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					Postgraduates.postgraduatesTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		membersMenu.add(postgraduatesMenuItem);
		
		JMenuItem undergraduatesMenuItem = new JMenuItem("Undergraduates");
		undergraduatesMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Undergraduate16-icon.png")));
		undergraduatesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Undergraduates undergraduates = new Undergraduates();
				undergraduates.setVisible(true);
				undergraduates.setLocationRelativeTo(null);
				dispose();
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowUndergraduatesSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);
		
					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);
		
					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					Undergraduates.undergraduatesTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		membersMenu.add(undergraduatesMenuItem);
		
		JMenuItem pastMembersNewMenuItem = new JMenuItem("Past Members");
		pastMembersNewMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Past16-icon.png")));
		pastMembersNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PastMembers pastMembers = new PastMembers();
				pastMembers.setVisible(true);
				pastMembers.setLocationRelativeTo(null);
				dispose();
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowPastMembersSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);
		
					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);
		
					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					PastMembers.pastMembersTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		JMenuItem allMembersMenuItem = new JMenuItem("All Members");
		allMembersMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/AllMembers16-icon.png")));
		allMembersMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AllMembers allMembers = new AllMembers();
				allMembers.setVisible(true);
				allMembers.setLocationRelativeTo(null);
				dispose();
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowAllMembersSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);
		
					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);
		
					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					AllMembers.allMembersTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		membersMenu.add(allMembersMenuItem);
		membersMenu.add(pastMembersNewMenuItem);
		
		JMenu pubsMenu = new JMenu("Publications");
		menuBar.add(pubsMenu);
		
		JMenuItem conventionMenuItem = new JMenuItem("Convention");
		conventionMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Convention16-icon.png")));
		conventionMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Convention convention = new Convention();
				convention.setVisible(true);
				convention.setLocationRelativeTo(null);
				dispose();
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowConvPubSP}");
		JMenu mnNewMenu_1 = new JMenu("Publications");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
		mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					Convention.conventionTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		pubsMenu.add(conventionMenuItem);
		
		JMenuItem magazineMenuItem = new JMenuItem("Magazine");
		magazineMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Magazine16-icon.png")));
		magazineMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Magazine magazine = new Magazine();
				magazine.setVisible(true);
				magazine.setLocationRelativeTo(null);
				dispose();
				
				Connection con;
				CallableStatement cs;
				ResultSet rs;
							
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowMagPubSP}");
		JMenu mnNewMenu_1 = new JMenu("Publications");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
		mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					Magazine.magazineTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		pubsMenu.add(magazineMenuItem);
		
		JMenuItem allPubsMenuItem = new JMenuItem("All");
		allPubsMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/AllPubs16-icon.png")));
		allPubsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AllPubs allPubs = new AllPubs();
				allPubs.setVisible(true);
				allPubs.setLocationRelativeTo(null);
				dispose();

				Connection con;
				CallableStatement cs;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowAllPubSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);

					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);

					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					AllPubs.allPubsTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		pubsMenu.add(allPubsMenuItem);
		
		JMenuItem pubByMemberMenuItem = new JMenuItem("By Member");
		pubByMemberMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Person16-icon.png")));
		pubByMemberMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ByMember byMember = new ByMember();
				byMember.setVisible(true);
				byMember.setLocationRelativeTo(null);
				dispose();
			}
		});
		pubsMenu.add(pubByMemberMenuItem);
		
		JMenuItem pubByProjectMenuItem = new JMenuItem("By Project");
		pubByProjectMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Project16-icon.png")));
		pubByProjectMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ByProject byProject = new ByProject();
				byProject.setVisible(true);
				byProject.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		pubsMenu.add(pubByProjectMenuItem);
		
		JMenuItem publicationParticipantsMenuItem = new JMenuItem("Publication Participants");
		publicationParticipantsMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Group16-icon.png")));
		publicationParticipantsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PublicationParticipants publicationParticipants = new PublicationParticipants();
				publicationParticipants.setVisible(true);
				publicationParticipants.setLocationRelativeTo(null);
				dispose();
			}
		});
		pubsMenu.add(publicationParticipantsMenuItem);
		
		JMenu projectsMenu = new JMenu("Projects");
		menuBar.add(projectsMenu);
		
		JMenuItem currentProjectsMenuItem = new JMenuItem("Current");
		currentProjectsMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/CurrentProject16-icon.png")));
		currentProjectsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Current current = new Current();
				current.setVisible(true);
				current.setLocationRelativeTo(null);
				dispose();

				Connection con;
				CallableStatement cs;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowCurrentProjectsSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);

					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);

					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					Current.currentProjectsTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		projectsMenu.add(currentProjectsMenuItem);
		
		JMenuItem pastProjectsMenuItem = new JMenuItem("Past");
		pastProjectsMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/PastProject16-icon.png")));
		pastProjectsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Past past = new Past();
				past.setVisible(true);
				past.setLocationRelativeTo(null);
				dispose();

				Connection con;
				CallableStatement cs;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowPastProjectsSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);

					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);

					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					Past.pastProjectsTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		projectsMenu.add(pastProjectsMenuItem);
		
		projectParticipantsMenuItem = new JMenuItem("Project Participants");
		projectParticipantsMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Group16-icon.png")));
		projectParticipantsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProjectParticipants projectParticipants = new ProjectParticipants();
				projectParticipants.setVisible(true);
				projectParticipants.setLocationRelativeTo(null);
				dispose();
			}
		});
		projectsMenu.add(projectParticipantsMenuItem);
		
		JMenu coursesMenu = new JMenu("Courses");
		menuBar.add(coursesMenu);
		
		JMenuItem undergraduateCoursesMenuItem = new JMenuItem("Undergraduate Courses");
		undergraduateCoursesMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/UnderCourse16-icon.png")));
		undergraduateCoursesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UndergraduateCourses undergraduateCourses = new UndergraduateCourses();
				undergraduateCourses.setVisible(true);
				undergraduateCourses.setLocationRelativeTo(null);
				dispose();

				Connection con;
				CallableStatement cs;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowUndergraduateCoursesSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);

					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);

					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					UndergraduateCourses.underCourseTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		coursesMenu.add(undergraduateCoursesMenuItem);
		
		JMenuItem postgraduateCoursesMenuItem = new JMenuItem("Postgraduate Courses");
		postgraduateCoursesMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/PostCourse16-icon.png")));
		postgraduateCoursesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PostgraduateCourses postgraduateCourses = new PostgraduateCourses();
				postgraduateCourses.setVisible(true);
				postgraduateCourses.setLocationRelativeTo(null);
				dispose();

				Connection con;
				CallableStatement cs;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowPostgraduateCoursesSP}");
					JMenu mnNewMenu_1 = new JMenu("Publications");
					menuBar.add(mnNewMenu_1);

					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Convention");
					mnNewMenu_1.add(mntmNewMenuItem_6);

					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Magazine");
					mnNewMenu_1.add(mntmNewMenuItem_7);
					rs=cs.executeQuery();
					PostgraduateCourses.postCourseTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		coursesMenu.add(postgraduateCoursesMenuItem);
		
		JMenuItem coursesByFacultyMenuItem = new JMenuItem("By Faculty");
		coursesByFacultyMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/Faculty16-icon.png")));
		coursesByFacultyMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ByFaculty byFaculty = new ByFaculty();
				byFaculty.setVisible(true);
				byFaculty.setLocationRelativeTo(null);
				dispose();
			}
		});
		coursesMenu.add(coursesByFacultyMenuItem);
		
		JMenu annsMenu = new JMenu("Announcements");
		
		menuBar.add(annsMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("By Date");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ByDateDesc byDateDesc = new ByDateDesc();
				byDateDesc.setVisible(true);
				byDateDesc.setLocationRelativeTo(null);
			
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		annsMenu.add(mntmNewMenuItem_1);
			dispose();

				Connection con;
				CallableStatement cs;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowAnnByDateDescSP}");
		
					rs=cs.executeQuery();
					ByDateDesc.byDateDescTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(HomeScreen.class.getResource("/ArrowDown16-icon.png")));
		annsMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("By Date");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				ByDateAsc byDateAsc = new ByDateAsc();
				byDateAsc.setVisible(true);
				byDateAsc.setLocationRelativeTo(null);

				JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
				annsMenu.add(mntmNewMenuItem_1);
				dispose();

				Connection con;
				CallableStatement cs;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb","root","");
					cs = con.prepareCall("{ CALL ShowAnnByDateAscSP}");

					rs=cs.executeQuery();
					ByDateAsc.byDateAscTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(HomeScreen.class.getResource("/ArrowUp16-icon.png")));
		annsMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setToolTipText("");
		setContentPane(contentPane);
		
		JButton adminBtn = new JButton("Admin");
		adminBtn.setBounds(589, 474, 79, 25);
		adminBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLogin labAdminLogin = new AdminLogin();
				labAdminLogin.setVisible(true);
				labAdminLogin.setLocationRelativeTo(null);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(adminBtn);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.ORANGE);
		headerPanel.setBounds(28, 11, 640, 64);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Research Lab");
		lblNewLabel.setBounds(188, 0, 256, 64);
		headerPanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(HomeScreen.class.getResource("/Database64-icon.png")));
		lblNewLabel_1.setBounds(114, 0, 64, 64);
		headerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(HomeScreen.class.getResource("/Database64-icon.png")));
		lblNewLabel_1_1.setBounds(454, 0, 64, 64);
		headerPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(HomeScreen.class.getResource("/HomePage.png")));
		lblNewLabel_2.setBounds(28, 85, 640, 360);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Copyright");
		lblNewLabel_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2_1.setBounds(28, 466, 64, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("2020, Nikolaou Stefanos");
		lblNewLabel_3.setIcon(new ImageIcon(HomeScreen.class.getResource("/Copyright16-icon.png")));
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblNewLabel_3.setBounds(94, 466, 180, 25);
		contentPane.add(lblNewLabel_3);
		
	}
}
