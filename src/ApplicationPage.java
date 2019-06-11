import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class ApplicationPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblDestinationStationCode;
	private JTextField txtBreak;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		frame.setBounds(100, 100, 722, 494);
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
		
		txtBreak = new JTextField();
		txtBreak.setText("Break 1");
		txtBreak.setBounds(105, 166, 130, 26);
		frame.getContentPane().add(txtBreak);
		txtBreak.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("Break 2");
		textField_2.setColumns(10);
		textField_2.setBounds(105, 204, 130, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("Break 3");
		textField_3.setColumns(10);
		textField_3.setBounds(105, 246, 130, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Break 4");
		textField_4.setColumns(10);
		textField_4.setBounds(247, 166, 130, 26);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("Break 5");
		textField_5.setColumns(10);
		textField_5.setBounds(247, 204, 130, 26);
		frame.getContentPane().add(textField_5);
		
		
	}
}
