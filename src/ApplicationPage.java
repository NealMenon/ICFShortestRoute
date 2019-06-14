import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationPage {

	public static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblDestinationStationCode;
	private JTextField textField_2;
	private JLabel lblTolerance;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationPage window = new ApplicationPage();
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
	public ApplicationPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(105, 55, 185, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(302, 55, 185, 26);
		frame.getContentPane().add(textField_1);
		
		JLabel lblSourceStationCode = new JLabel("Source Station Code");
		lblSourceStationCode.setBounds(105, 34, 126, 16);
		frame.getContentPane().add(lblSourceStationCode);
		
		lblDestinationStationCode = new JLabel("Destination Station Code");
		lblDestinationStationCode.setBounds(302, 34, 168, 16);
		frame.getContentPane().add(lblDestinationStationCode);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(270, 110, 52, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNumberOfBreak = new JLabel("Number of Break points");
		lblNumberOfBreak.setBounds(105, 114, 164, 16);
		frame.getContentPane().add(lblNumberOfBreak);
		
		textField_2 = new JTextField();
		textField_2.setBounds(357, 109, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblTolerance = new JLabel("Tolerance");
		lblTolerance.setBounds(357, 93, 84, 16);
		frame.getContentPane().add(lblTolerance);
		
		JButton btnFindJourneyLength = new JButton("Find Journey Length");
		btnFindJourneyLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JourneyPage journeyObj = new JourneyPage();
				frame.setVisible(false);
				journeyObj.frame.setVisible(true);
			}
		});
		btnFindJourneyLength.setBounds(371, 314, 151, 70);
		frame.getContentPane().add(btnFindJourneyLength);
		
		JButton btnAddNewStation = new JButton("Add new Station");
		btnAddNewStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStation addStationObj = new AddStation();
				frame.setVisible(false);
				addStationObj.frame.setVisible(true);
			}
		});
		btnAddNewStation.setBounds(44, 314, 151, 29);
		frame.getContentPane().add(btnAddNewStation);
		
		JButton btnAddNewTrack = new JButton("Add new Track");
		btnAddNewTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTrack addTrackObj = new AddTrack();
				frame.setVisible(false);
				addTrackObj.frame.setVisible(true);
			}
		});
		btnAddNewTrack.setBounds(44, 355, 151, 29);
		frame.getContentPane().add(btnAddNewTrack);
		
		JButton btnViewAllStation = new JButton("View all Stations");
		btnViewAllStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllStations viewAllStationsObj = new ViewAllStations();
				frame.setVisible(false);
				viewAllStationsObj.frame.setVisible(true);
			}
		});
		btnViewAllStation.setBounds(207, 314, 151, 29);
		frame.getContentPane().add(btnViewAllStation);
		
		JButton btnViewAllTracks = new JButton("View all Tracks");
		btnViewAllTracks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllTracks viewAllTracksObj = new ViewAllTracks();
				frame.setVisible(false);
				viewAllTracksObj.frame.setVisible(true);
			}
		});
		btnViewAllTracks.setBounds(207, 355, 151, 29);
		frame.getContentPane().add(btnViewAllTracks);
		
		textField_3 = new JTextField();
		textField_3.setBounds(105, 167, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBreakStationCodes = new JLabel("Break Station Codes");
		lblBreakStationCodes.setBounds(105, 149, 142, 16);
		frame.getContentPane().add(lblBreakStationCodes);
		
		textField_4 = new JTextField();
		textField_4.setBounds(105, 199, 130, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(105, 237, 130, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(279, 167, 130, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(279, 199, 130, 26);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label = new JLabel("1:");
		label.setBounds(90, 172, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2:");
		label_1.setBounds(90, 205, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3:");
		label_2.setBounds(90, 242, 61, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4:");
		label_3.setBounds(261, 172, 61, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("5:");
		label_4.setBounds(261, 204, 61, 16);
		frame.getContentPane().add(label_4);
		
		
	}
}
