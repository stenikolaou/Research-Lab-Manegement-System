package members;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import user.HomeScreen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AllMembers extends JFrame {

	private JPanel contentPane;
	public static JTable allMembersTable;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public AllMembers() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AllMembers.class.getResource("/AllMembers16-icon.png")));
		setTitle("All Members");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 60, 1000, 540);
		contentPane.add(scrollPane);
		
		allMembersTable = new JTable();
		scrollPane.setViewportView(allMembersTable);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();

			}
		});
		homeBtn.setIcon(new ImageIcon(AllMembers.class.getResource("/Home16-icon.png")));
		homeBtn.setBounds(472, 26, 89, 23);
		contentPane.add(homeBtn);
	}

}
