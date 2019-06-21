/*
  On this page the journey path is printed with a breakpoint being represented by the station code being printed twice.
  the total distance is also printed.
	*/
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
import javax.swing.JScrollPane;

public class JourneyPage {

	public  JFrame frame;
	public double distance;
	private JTextField distfield;
	String path="";
	private JTextArea routefield1;

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
	
	//sets the distance to be displayed in the text field "distfield"
	void setDist(double dist)
	{
		System.out.println("C"+"\t"+dist);
		distance=dist;
		distfield.setText(String.valueOf(distance));
	}

	//sets the route to be dispayed
	void setPath(String route)
	{
		routefield1.setText(route);
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
		frame.setBounds(100, 100, 479, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//links to Application page
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
		
		distfield = new JTextField();
		distfield.setEditable(false);
		distfield.setBounds(172, 181, 225, 19);
		frame.getContentPane().add(distfield);
		distfield.setColumns(10);
		//System.out.println("Distance"+"\t"+distance);
		
		JLabel lblTotalDistance = new JLabel("Total Distance");
		lblTotalDistance.setBounds(63, 181, 128, 17);
		frame.getContentPane().add(lblTotalDistance);
		
		JLabel lblRoute = new JLabel("Route");
		lblRoute.setBounds(63, 104, 82, 15);
		frame.getContentPane().add(lblRoute);
		
		//prints route
		JScrollPane routefield = new JScrollPane(routefield1);
		routefield.setBounds(173, 93, 237, 51);
		frame.getContentPane().add(routefield);
		
		routefield1 = new JTextArea();
		routefield1.setEditable(false);
		routefield.setViewportView(routefield1);
		routefield1.setColumns(10);
	}
}
