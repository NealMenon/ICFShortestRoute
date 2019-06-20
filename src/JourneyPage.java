import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JourneyPage {

	public  JFrame frame;
	public double distance;
	private JTextField distfield;

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
	void setDist(double dist)
	{
		distance=dist;
		System.out.println("C"+"\t"+distance);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 479, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationPage applicationPageObj = new ApplicationPage();
				frame.dispose();
				applicationPageObj.frame.setVisible(true);
			}
		});
		btnBack.setBounds(172, 215, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JLabel lblTheJourneyIs = new JLabel("The journey is as follows");
		lblTheJourneyIs.setBounds(153, 27, 202, 16);
		frame.getContentPane().add(lblTheJourneyIs);
		
		distfield = new JTextField();
		distfield.setEditable(false);
		distfield.setBounds(246, 181, 151, 19);
		frame.getContentPane().add(distfield);
		distfield.setColumns(10);
		distfield.setText(String.valueOf(distance));
		System.out.println("Distance"+"\t"+distance);
		
		JLabel lblTotalDistance = new JLabel("Total Distance");
		lblTotalDistance.setBounds(63, 181, 128, 17);
		frame.getContentPane().add(lblTotalDistance);
	}
}
