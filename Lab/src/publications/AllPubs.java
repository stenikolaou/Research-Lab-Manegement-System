package publications;

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
public class AllPubs extends JFrame {

	private JPanel contentPane;
	public static JTable allPubsTable;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public AllPubs() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AllPubs.class.getResource("/AllPubs16-icon.png")));
		setTitle("All publications");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 60, 1000, 540);
		contentPane.add(scrollPane);
		
		allPubsTable = new JTable();
		scrollPane.setViewportView(allPubsTable);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		homeBtn.setIcon(new ImageIcon(AllPubs.class.getResource("/Home16-icon.png")));
		homeBtn.setBounds(472, 26, 89, 23);
		contentPane.add(homeBtn);
	}

}
