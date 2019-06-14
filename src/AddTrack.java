import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AddTrack {

	public static JFrame frame;
	private JTextField startfield;
	private JTextField endfield;
	private JTextField distancefield;
	String sstation,estation;//start station,end station
	int distance;//track distance between them

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTrack window = new AddTrack();
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
	public AddTrack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.getContentPane().setBackground(Color.BLUE);
		frame.setBackground(Color.GREEN);
		frame.setBounds(100, 100, 512, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrAddTrackPage = new JTextArea();
		//txtrAddTrackPage.setBackground(Color.RED);
		txtrAddTrackPage.setEditable(false);
		txtrAddTrackPage.setText("Add Track Page");
		txtrAddTrackPage.setBounds(212, 12, 95, 15);
		frame.getContentPane().add(txtrAddTrackPage);
		
		startfield = new JTextField();
		startfield.setBounds(241, 66, 211, 19);
		frame.getContentPane().add(startfield);
		startfield.setColumns(10);
		
		endfield = new JTextField();
		endfield.setBounds(241, 123, 211, 19);
		frame.getContentPane().add(endfield);
		endfield.setColumns(10);
		
		distancefield = new JTextField();
		distancefield.setBounds(241, 169, 211, 19);
		frame.getContentPane().add(distancefield);
		distancefield.setColumns(10);
		
		JButton btnAddTrack = new JButton("Add Track");
		btnAddTrack.addActionListener(new ActionListener() {
			@Override
			//to add data to database and refresh page
			public void actionPerformed(ActionEvent arg0) {
				sstation=startfield.getText();estation=endfield.getText();
				distance=Integer.parseInt(distancefield.getText());
				System.out.println(sstation+" "+estation+" "+distance);
			}
		});
		btnAddTrack.setBounds(93, 227, 114, 25);
		frame.getContentPane().add(btnAddTrack);
		
		JButton btnBackToMain = new JButton("Back to Main Page");
		btnBackToMain.addActionListener(new ActionListener() {
			@Override
			//button to go back to main page of website
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("Back");
//			}
			public void actionPerformed(ActionEvent e) {
//				applicationPageObj = new ApplicationPage();
				frame.dispose();
				ApplicationPage.frame.setVisible(true);
			}
		});
		btnBackToMain.setBounds(290, 227, 162, 25);
		frame.getContentPane().add(btnBackToMain);
		
		JLabel lblStartStation = new JLabel("Start Station");
		lblStartStation.setBounds(76, 68, 89, 15);
		frame.getContentPane().add(lblStartStation);
		
		JLabel lblEndStation = new JLabel("End Station");
		lblEndStation.setBounds(76, 125, 99, 15);
		frame.getContentPane().add(lblEndStation);
		
		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setBounds(76, 171, 89, 15);
		frame.getContentPane().add(lblDistance);
	}
}
