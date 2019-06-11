import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStation {

	private JFrame frame;
	private JTextField namefield;
	private JTextField codefield;
	private JTextField zonefield;
	String sname,scode,szone;
	private JLabel lblStationName;
	private JLabel lblStationCode;
	private JLabel lblStationZone;
	private JLabel lblAddStationPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStation window = new AddStation();
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
	public AddStation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		namefield = new JTextField();
		namefield.setBounds(234, 79, 269, 19);
		frame.getContentPane().add(namefield);
		namefield.setColumns(10);
		
		codefield = new JTextField();
		codefield.setBounds(234, 147, 269, 19);
		frame.getContentPane().add(codefield);
		codefield.setColumns(10);
		
		zonefield = new JTextField();
		zonefield.setColumns(10);
		zonefield.setBounds(234, 215, 269, 19);
		frame.getContentPane().add(zonefield);
		
		JButton btnadd = new JButton("Add Station");
		btnadd.addActionListener(new ActionListener() {
			@Override
			//for adding station and refreshing the page
			public void actionPerformed(ActionEvent arg0) {
				sname=namefield.getText();scode=codefield.getText();szone=zonefield.getText();
				System.out.println(sname+" "+scode+" "+szone);
			}
		});
		btnadd.setBounds(101, 276, 138, 25);
		
		JButton btnhome = new JButton("Back to Home");
		btnhome.addActionListener(new ActionListener() {
			@Override
			//for going back to main page
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Back");
			}
		});
		btnhome.setBounds(284, 276, 148, 25);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnadd);
		frame.getContentPane().add(btnhome);
		
		lblStationName = new JLabel("Station Name");
		lblStationName.setBounds(100, 82, 108, 15);
		frame.getContentPane().add(lblStationName);
		
		lblStationCode = new JLabel("Station code");
		lblStationCode.setBounds(100, 150, 108, 15);
		frame.getContentPane().add(lblStationCode);
		
		lblStationZone = new JLabel("Station Zone");
		lblStationZone.setBounds(101, 218, 108, 15);
		frame.getContentPane().add(lblStationZone);
		
		lblAddStationPage = new JLabel("Add Station Page");
		lblAddStationPage.setBounds(198, 19, 114, 16);
		frame.getContentPane().add(lblAddStationPage);
		
		//frame.setBackground(Color.GREEN);
		frame.setBounds(100, 100, 565, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
