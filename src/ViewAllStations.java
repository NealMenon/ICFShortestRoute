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
	
	public static JFrame f;
	public  ViewAllStations() {
		{
			ViewS vw=new ViewS();
			//System.out.println(vw.countStation());
			int n =vw.countStation();
			String[][] cmon = new String [n][3];
			cmon = vw.view();     
		    f=new JFrame();    
		    String data[][];
		   // for(int i = 0; i<n;i++)   
		    String column[]={"name","code","zone"};         
		    f.getContentPane().setLayout(null);
		    JTable jt=new JTable(cmon,column);    
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
		    		f.dispose();
					ApplicationPage.frame.setVisible(true);
		    	}
		    });
		    btnNewButton.setBounds(212, 325, 117, 29);
		    f.getContentPane().add(btnNewButton);
		    f.setSize(625,400);    
		    f.setVisible(true);    
		}     
    }
}
