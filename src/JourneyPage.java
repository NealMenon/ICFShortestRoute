import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JourneyPage {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JourneyPage window = new JourneyPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JourneyPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ApplicationPage applicationPageObj = new ApplicationPage();
				frame.dispose();
				ApplicationPage.frame.setVisible(true);
			}
		});
		btnBack.setBounds(172, 215, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JLabel lblTheJourneyIs = new JLabel("The journey is as follows");
		lblTheJourneyIs.setBounds(153, 27, 202, 16);
		frame.getContentPane().add(lblTheJourneyIs);
	}
}
