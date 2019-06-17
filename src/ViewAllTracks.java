import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAllTracks {

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllTracks window = new ViewAllTracks();
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
	public ViewAllTracks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ViewT vwT = new ViewT();
		int n =vwT.countTrack();
		
		String[][] vtrack = new String [n][3];
		vtrack = vwT.view();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String data[][];
	    data= vtrack;
	    
	    String column[]={"Source","Destination", "Distance"};         

		JTable jt=new JTable(data,column);    
		jt.setBounds(30,40,200,300);          
		JScrollPane sp=new JScrollPane(jt);    
		    
		frame.add(sp);          	    
		frame.setSize(300,400);    		    
		frame.setVisible(true);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ApplicationPage applicationPageObj = new ApplicationPage();
				frame.dispose();
				ApplicationPage.frame.setVisible(true);
			}
		});
		btnBack.setBounds(171, 209, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JLabel lblAllTracksIn = new JLabel("All tracks in the network are as follows");
		lblAllTracksIn.setBounds(104, 24, 271, 16);
		frame.getContentPane().add(lblAllTracksIn);
	}

}
