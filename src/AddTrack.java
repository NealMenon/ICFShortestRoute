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

public class AddTrack {

	private JFrame frame;
	private JTextField startfield;
	private JTextField endfield;
	private JTextField distancefield;
	String sstation,estation;
	int distance;

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
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBackground(Color.GREEN);
		frame.setBounds(100, 100, 512, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrAddTrackPage = new JTextArea();
		txtrAddTrackPage.setBackground(Color.RED);
		txtrAddTrackPage.setEditable(false);
		txtrAddTrackPage.setText("Add Track Page");
		txtrAddTrackPage.setBounds(212, 12, 95, 15);
		frame.getContentPane().add(txtrAddTrackPage);
		
		JTextArea txtrStartStation = new JTextArea();
		txtrStartStation.setBackground(Color.ORANGE);
		txtrStartStation.setText("Start station");
		txtrStartStation.setBounds(70, 68, 95, 15);
		frame.getContentPane().add(txtrStartStation);
		
		startfield = new JTextField();
		startfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sstation=startfield.getText();
			}
		});
		startfield.setBounds(241, 66, 211, 19);
		frame.getContentPane().add(startfield);
		startfield.setColumns(10);
		
		JTextArea txtrEndStation = new JTextArea();
		txtrEndStation.setBackground(Color.ORANGE);
		txtrEndStation.setText("End station");
		txtrEndStation.setBounds(70, 125, 95, 15);
		frame.getContentPane().add(txtrEndStation);
		
		endfield = new JTextField();
		endfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estation=endfield.getText();
			}
		});
		endfield.setBounds(241, 123, 211, 19);
		frame.getContentPane().add(endfield);
		endfield.setColumns(10);
		
		JTextArea txtrDistance = new JTextArea();
		txtrDistance.setBackground(Color.ORANGE);
		txtrDistance.setText("Distance");
		txtrDistance.setBounds(70, 171, 95, 15);
		frame.getContentPane().add(txtrDistance);
		
		distancefield = new JTextField();
		distancefield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				distance=Integer.parseInt(distancefield.getText());
			}
		});
		distancefield.setBounds(241, 169, 211, 19);
		frame.getContentPane().add(distancefield);
		distancefield.setColumns(10);
		
		JButton btnAddTrack = new JButton("Add Track");
		btnAddTrack.addMouseListener(new MouseAdapter() {
			@Override
			//to add data to database and refresh page
			public void mouseClicked(MouseEvent e) {
				System.out.println(sstation+" "+estation+" "+distance);
			}
		});
		btnAddTrack.setBounds(93, 227, 114, 25);
		frame.getContentPane().add(btnAddTrack);
		
		JButton btnBackToMain = new JButton("Back to Main Page");
		btnBackToMain.addMouseListener(new MouseAdapter() {
			@Override
			//button to go back to main page of website
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnBackToMain.setBounds(290, 227, 162, 25);
		frame.getContentPane().add(btnBackToMain);
	}
}
