package publications;

import java.awt.EventQueue;
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
public class Magazine extends JFrame {

	private JPanel contentPane;
	public static JTable magazineTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Magazine frame = new Magazine();
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
	public Magazine() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Magazine.class.getResource("/Magazine16-icon.png")));
		setTitle("Magazine Publications");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 60, 1000, 540);
		contentPane.add(scrollPane);
		
		magazineTable = new JTable();
		scrollPane.setViewportView(magazineTable);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
				dispose();
			}
		});
		homeBtn.setIcon(new ImageIcon(Magazine.class.getResource("/Home16-icon.png")));
		homeBtn.setBounds(472, 26, 89, 23);
		contentPane.add(homeBtn);
	}

}
