package members;

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
public class Postgraduates extends JFrame {

	private JPanel postgraduatesContentPane;
	public static JTable postgraduatesTable;

	/**
	 * Create the frame.
	 */
	public Postgraduates() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Postgraduates.class.getResource("/Postgraduate16-icon.png")));
		setTitle("Postgraduates");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		postgraduatesContentPane = new JPanel();
		postgraduatesContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(postgraduatesContentPane);
		postgraduatesContentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 60, 1000, 540);
		postgraduatesContentPane.add(scrollPane);
		
		postgraduatesTable = new JTable();
		scrollPane.setViewportView(postgraduatesTable);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		homeBtn.setIcon(new ImageIcon(Postgraduates.class.getResource("/Home16-icon.png")));
		homeBtn.setBounds(472, 26, 89, 23);
		postgraduatesContentPane.add(homeBtn);
	}

}
