import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;*/
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ViewAllStations {

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllStations window = new ViewAllStations();
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
	public ViewAllStations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		ViewS vw = new ViewS();
		int n =vw.countStation();
		
		String[][] vstat = new String [n][3];
		vstat = vw.view();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String data[][];
		    data= vstat;    

		String column[]={"name","code", "zone"};         

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
				//frame.setVisible(false);
				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				frame.dispose();
				ApplicationPage.frame.setVisible(true);
			}
		});
		
		
		btnBack.setBounds(160, 205, 117, 29);
		frame.getContentPane().add(btnBack);
		
		
		
		JLabel lblAllTheStations = new JLabel("All The Stations in the Network are as follows");
		lblAllTheStations.setBounds(81, 24, 306, 16);
		frame.getContentPane().add(lblAllTheStations);
	}

}
