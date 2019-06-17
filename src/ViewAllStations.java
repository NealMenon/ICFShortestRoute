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

	public  ViewAllStations() {
	//public static void main(String[] args)
    {
		ViewS vw = new ViewS();
<<<<<<< HEAD
		int n =vw.countStation();
		
		String[][] vstat = new String [n][3];
		vstat = vw.view();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		for(int i=0;i<n;i++)
		{
			System.out.println(vstat[i][0]+" "+vstat[i][1]+" "+vstat[i][2]);
		}    

		String column[]={"name","code", "zone"};         

		JTable jt=new JTable(vstat,column);    
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

=======
		System.out.println(vw.countStation());
		int n =vw.checkn();
		String[][] cmon = new String [n][3];
		cmon = vw.view();
		for(int i = 0; i<n; i++ ) {
			
			System.out.println(cmon[i][1]);
		 }   
			    JFrame f;  
			    
		
			    f=new JFrame();    
			    String data[][];
			   // for(int i = 0; i<n;i++)
			    	data= cmon;    
			    String column[]={"name","code","zone"};         
			    f.getContentPane().setLayout(null);
			    JTable jt=new JTable(data,column);    
			    jt.setBounds(30,40,200,300);          
			    JScrollPane sp=new JScrollPane(jt);
			    sp.setBounds(81, 51, 376, 247);
			    f.getContentPane().add(sp);
			    
			    JLabel lblAllStationsAre = new JLabel("All Stations are as follows");
			    lblAllStationsAre.setBounds(175, 23, 225, 16);
			    f.getContentPane().add(lblAllStationsAre);
			    
			    JButton btnNewButton = new JButton("Back");
			    btnNewButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    	}
			    });
			    btnNewButton.setBounds(212, 325, 117, 29);
			    f.getContentPane().add(btnNewButton);
			    f.setSize(625,400);    
			    f.setVisible(true);    
			}     
    }
>>>>>>> b6e1b67c03614d9cb3e524840ada995e04e271de
}
