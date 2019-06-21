/*
	This page represents the main page of the application.On this page the user enters source,destinatio,number of breakpoints,breakpoint stations if any and the tolerance which when not specified is taken as 10%. All the other frontend pages are accessed from here with links back to this page.
	*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;

public class ApplicationPage {

	public static JFrame frame;
	private JTextField sourcefield;
	private JTextField destfield;
	private JLabel lblDestinationStationCode;
	private JTextField tolerance;
	private JLabel lblTolerance;
	private JTextField breakpoint1;
	private JTextField breakpoint2;
	private JTextField breakpoint3;
	private JTextField breakpoint4;
	private JTextField breakpoint5;
	String src,dest,route="";//src->source;dest->destination;route->path taken by train
	int t;//t->tolerance

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
		
		sourcefield = new JTextField();
		sourcefield.setBounds(99, 40, 185, 26);
		frame.getContentPane().add(sourcefield);
		sourcefield.setColumns(10);
		
		destfield = new JTextField();
		destfield.setColumns(10);
		destfield.setBounds(319, 40, 185, 26);
		frame.getContentPane().add(destfield);
		
		JLabel lblSourceStationCode = new JLabel("Source Station Code");
		lblSourceStationCode.setBounds(105, 12, 164, 16);
		frame.getContentPane().add(lblSourceStationCode);
		
		lblDestinationStationCode = new JLabel("Destination Station Code");
		lblDestinationStationCode.setBounds(319, 12, 185, 16);
		frame.getContentPane().add(lblDestinationStationCode);
		
		JLabel lblNumberOfBreak = new JLabel("Number of Break points");
		lblNumberOfBreak.setBounds(90, 130, 164, 16);
		frame.getContentPane().add(lblNumberOfBreak);
		
		tolerance = new JTextField();
		tolerance.setBounds(228, 78, 130, 26);
		frame.getContentPane().add(tolerance);
		tolerance.setColumns(10);
		
		lblTolerance = new JLabel("Tolerance");
		lblTolerance.setBounds(147, 81, 84, 16);
		frame.getContentPane().add(lblTolerance);
		
		//links to Add Station page
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
		
		//links to Add Track page
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
		
		//links to View All Stations page
		JButton btnViewAllStation = new JButton("View all Stations");
		btnViewAllStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllStations viewAllStationsObj = new ViewAllStations();
				frame.setVisible(false);
				viewAllStationsObj.f.setVisible(true);
			}
		});
		btnViewAllStation.setBounds(207, 314, 151, 29);
		frame.getContentPane().add(btnViewAllStation);
		

		//links to View All Tracks page
		JButton btnViewAllTracks = new JButton("View all Tracks");
		btnViewAllTracks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllTracks viewAllTracksObj = new ViewAllTracks();
				frame.setVisible(false);
				viewAllTracksObj.f.setVisible(true);
			}
		});
		btnViewAllTracks.setBounds(207, 355, 151, 29);
		frame.getContentPane().add(btnViewAllTracks);
		
		
		SpinnerModel sm = new SpinnerNumberModel(0, 0, 5, 1); //default value,lower bound,upper bound,increment by
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(260, 126, 41, 26);
		frame.getContentPane().add(spinner);
//		int numBreakPoints = (Integer) spinner.getValue();
		
		
		breakpoint1 = new JTextField();
		breakpoint1.setEditable(false);
		breakpoint1.setBounds(105, 186, 130, 26);
		frame.getContentPane().add(breakpoint1);
		breakpoint1.setColumns(10);
		
		JLabel lblBreakStationCodes = new JLabel("Break Station Codes: ");
		lblBreakStationCodes.setBounds(107, 158, 142, 16);
		frame.getContentPane().add(lblBreakStationCodes);
		
		breakpoint2 = new JTextField();
		breakpoint2.setEditable(false);
		breakpoint2.setBounds(105, 224, 130, 26);
		frame.getContentPane().add(breakpoint2);
		breakpoint2.setColumns(10);
		
		breakpoint3 = new JTextField();
		breakpoint3.setEditable(false);
		breakpoint3.setBounds(105, 262, 130, 26);
		frame.getContentPane().add(breakpoint3);
		breakpoint3.setColumns(10);
		
		breakpoint4 = new JTextField();
		breakpoint4.setEditable(false);
		breakpoint4.setBounds(289, 186, 130, 26);
		frame.getContentPane().add(breakpoint4);
		breakpoint4.setColumns(10);
		
		breakpoint5 = new JTextField();
		breakpoint5.setEditable(false);
		breakpoint5.setBounds(289, 224, 130, 26);
		frame.getContentPane().add(breakpoint5);
		breakpoint5.setColumns(10);
		
		JLabel label = new JLabel("1:");
		label.setBounds(90, 186, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2:");
		label_1.setBounds(90, 224, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3:");
		label_2.setBounds(90, 262, 61, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4:");
		label_3.setBounds(271, 186, 61, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("5:");
		label_4.setBounds(271, 224, 61, 16);
		frame.getContentPane().add(label_4);
		
		//to set breakpoints
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    spinner.commitEdit();
				} catch ( java.text.ParseException ex ) { System.out.println("Something went wrng heere\n"); }
				int numBreakPoints = (Integer) spinner.getValue();
				switch(numBreakPoints) {
				case 0:
					breakpoint1.setEditable(false);
					breakpoint1.setText("");
				case 1: 
					breakpoint2.setEditable(false);
					breakpoint2.setText("");
				case 2:
					breakpoint3.setEditable(false);
					breakpoint3.setText("");
				case 3:
					breakpoint4.setEditable(false);
					breakpoint4.setText("");
				case 4: 
					breakpoint5.setEditable(false);
					breakpoint5.setText("");
					break;
				}
				switch(numBreakPoints) {
				case 5:
					breakpoint5.setEditable(true);
				case 4:
					breakpoint4.setEditable(true);
				case 3:
					breakpoint3.setEditable(true);
				case 2:
					breakpoint2.setEditable(true);
				case 1:
					breakpoint1.setEditable(true);
				}
			}
		});
		btnAdd.setBounds(313, 125, 90, 26);
		frame.getContentPane().add(btnAdd);

		//links to Journey Page which gives details for the path
		JButton btnFindJourneyLength = new JButton("Find Journey Length");//Journey Page
		btnFindJourneyLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    spinner.commitEdit();
				} catch ( java.text.ParseException ex ) { System.out.println("Something went wrng heere\n"); }
				int nbp = (Integer) spinner.getValue();
				String[] path=new String[nbp+2];
				switch(nbp) {
				case 0:
					breakpoint1.setEditable(false);
					breakpoint1.setText("");
				case 1: 
					breakpoint2.setEditable(false);
					breakpoint2.setText("");
				case 2:
					breakpoint3.setEditable(false);
					breakpoint3.setText("");
				case 3:
					breakpoint4.setEditable(false);
					breakpoint4.setText("");
				case 4: 
					breakpoint5.setEditable(false);
					breakpoint5.setText("");
					break;
				}
				switch(nbp) {
				case 5:
					breakpoint5.setEditable(true);
					path[5]=breakpoint5.getText();
				case 4:
					breakpoint4.setEditable(true);
					path[4]=breakpoint4.getText();
				case 3:
					breakpoint3.setEditable(true);
					path[3]=breakpoint3.getText();
				case 2:
					breakpoint2.setEditable(true);
					path[2]=breakpoint2.getText();
				case 1:
					breakpoint1.setEditable(true);
					path[1]=breakpoint1.getText();
				}
				if(tolerance.getText().compareTo("")==0)
					t=10;
				else
					t=Integer.parseInt(tolerance.getText());
				dest=destfield.getText();
				src=sourcefield.getText();
				path[0]=src;path[nbp+1]=dest;
				Application app=new Application(nbp,path);
				JourneyPage journeyObj = new JourneyPage();
				double sd=app.journey(path[0],path[nbp+1]);//shortest path between source and destination without breakpoints
				double dist=0;
				for(int i=0;i<nbp+1;i++)
				{
					dist+=app.journey(path[i],path[i+1]);//distance with breakpoints
				}
				double exceed=sd*(100+t)/100;
				if(dist>exceed)//check if within tolerance limit
					JOptionPane.showMessageDialog(null,"Route exceeded tolerance limit. Please choose different breakpoints","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
				else
				{
					frame.setVisible(false);
					journeyObj.frame.setVisible(true);
					journeyObj.setDist(dist);//sending total distance of route with breakpoints
					journeyObj.setPath(app.printRoute());//sending path details
				}
			}
		});
		btnFindJourneyLength.setBounds(371, 314, 151, 70);
		frame.getContentPane().add(btnFindJourneyLength);

		
		
	}
}



