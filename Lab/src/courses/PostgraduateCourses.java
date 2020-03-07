package courses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import user.HomeScreen;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class PostgraduateCourses extends JFrame {

	private JPanel contentPane;
	public static JTable postCourseTable;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public PostgraduateCourses() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PostgraduateCourses.class.getResource("/PostCourse16-icon.png")));
		setTitle("Postgraduate Courses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 60, 1000, 540);
		contentPane.add(scrollPane);
		
		postCourseTable = new JTable();
		scrollPane.setViewportView(postCourseTable);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setIcon(new ImageIcon(PostgraduateCourses.class.getResource("/Home16-icon.png")));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		homeBtn.setBounds(460, 26, 89, 23);
		contentPane.add(homeBtn);
	}
}
