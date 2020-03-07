package members;

import java.awt.Toolkit;
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

@SuppressWarnings("serial")
public class Faculty extends JFrame {

	private JPanel contentPane;
	public static JTable facultyTable;

	/**
	 * Create the frame.
	 */
	public Faculty() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Faculty.class.getResource("/Faculty16-icon.png")));
		setTitle("Faculty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 60, 1000, 540);
		contentPane.add(scrollPane);
		
		facultyTable = new JTable();
		scrollPane.setViewportView(facultyTable);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		homeBtn.setIcon(new ImageIcon(Faculty.class.getResource("/Home16-icon.png")));
		homeBtn.setBounds(472, 26, 89, 23);
		contentPane.add(homeBtn);
	}
}
