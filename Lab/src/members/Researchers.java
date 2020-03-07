package members;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.HomeScreen;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Researchers extends JFrame {

	private JPanel contentPane;
	public static JTable researchersTable;

	/**
	 * Create the frame.
	 */
	public Researchers() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Researchers.class.getResource("/Researchers16-icon.png")));
		setTitle("Researchers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 60, 1000, 540);
		contentPane.add(scrollPane);
		
		researchersTable = new JTable();
		scrollPane.setViewportView(researchersTable);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(Researchers.class.getResource("/Home16-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(472, 26, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
