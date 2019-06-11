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
	private JTextField txtAddStationPage;
	private JTextField namefield;
	private JTextField codefield;
	private JTextField zonefield;
	private JTextArea txtrStationCode;
	private JTextArea txtrStationZone;
	String sname,scode,szone;

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
		frame.getContentPane().setBackground(Color.BLUE);
		
		txtAddStationPage = new JTextField();
		txtAddStationPage.setBackground(Color.RED);
		txtAddStationPage.setEditable(false);
		txtAddStationPage.setBounds(202, 12, 124, 19);
		txtAddStationPage.setText("Add Station Page");
		txtAddStationPage.setColumns(10);
		
		namefield = new JTextField();
		namefield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sname=namefield.getText();
			}
		});
		namefield.setBounds(234, 79, 269, 19);
		frame.getContentPane().add(namefield);
		namefield.setColumns(10);
		
		codefield = new JTextField();
		codefield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scode=codefield.getText();
			}
		});
		codefield.setBounds(234, 147, 269, 19);
		frame.getContentPane().add(codefield);
		codefield.setColumns(10);
		
		zonefield = new JTextField();
		zonefield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				szone=zonefield.getText();
			}
		});
		zonefield.setColumns(10);
		zonefield.setBounds(234, 215, 269, 19);
		frame.getContentPane().add(zonefield);
		
		JButton btnadd = new JButton("Add Station");
		btnadd.addMouseListener(new MouseAdapter() {
			@Override
			//for adding station and refreshing the page
			public void mouseClicked(MouseEvent e) {
				System.out.println(sname+" "+scode+" "+szone);
			}
		});
		btnadd.setBounds(101, 276, 138, 25);
		
		JButton btnhome = new JButton("Back to Home");
		btnhome.addMouseListener(new MouseAdapter() {
			@Override
			//for going back to main page
			public void mouseClicked(MouseEvent e) {
				//jex1 run=new jex1();
				//int a=25;
				//run.fun(a);
			}
		});
		btnhome.setBounds(284, 276, 148, 25);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(txtAddStationPage);
		frame.getContentPane().add(btnadd);
		frame.getContentPane().add(btnhome);
		
		JTextArea txtrStationName = new JTextArea();
		txtrStationName.setEditable(false);
		txtrStationName.setBackground(Color.ORANGE);
		txtrStationName.setText("Station Name");
		txtrStationName.setBounds(38, 81, 118, 15);
		frame.getContentPane().add(txtrStationName);
		
		txtrStationCode = new JTextArea();
		txtrStationCode.setEditable(false);
		txtrStationCode.setBackground(Color.ORANGE);
		txtrStationCode.setText("Station Code");
		txtrStationCode.setBounds(38, 149, 118, 15);
		frame.getContentPane().add(txtrStationCode);
		
		txtrStationZone = new JTextArea();
		txtrStationZone.setEditable(false);
		txtrStationZone.setBackground(Color.ORANGE);
		txtrStationZone.setText("Station Zone");
		txtrStationZone.setBounds(38, 217, 118, 15);
		frame.getContentPane().add(txtrStationZone);
		
		frame.setBackground(Color.GREEN);
		frame.setBounds(100, 100, 531, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
