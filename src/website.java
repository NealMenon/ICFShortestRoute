/*
  Aim: To find the shortest path between any 2 stations along with any breakpoints.
  
  Tolerance: The maximum deviation from the shortest path.Default is set at 10%.
  
  Constraints: The distance inlcuding the user-defined breakpoints should not exceeed the tolerance.
	*/

/*
  Database: project1
  
  Tables: station(station details)
  		  track(track details)
  
  Station: sno int(3) //station serial nunber
  		   sname char(25) //station name
  		   scode char(7) //station code
  		   szone char(7) //station zone
  
  Track: src char(7) //source station
  		 dest char(7) //end station
  		 distance float(5,3) //distance between the src and dest
  
  Constraints: Foreign keys:
  					track(src)->station(scode)
  					track(dest)->station(scode)
  			   Primary keys:
  			   		station(sno)//auto_increment
  			   Unique keys:
  			   		station(sname,scode)
	*/
import java.io.*;
import java.lang.*;
import java.util.*;
import java.sql.*;

public class website
{
	String user="root";
	String pwd="Orion@1234";
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}
}

/*for application page and journey page.
	The constructor is for taking values from the application page while journey function is for calculating the shortest path between 2 stations with or without breakpoints. The default tolerance is set at 10%. the shortest path is always printed first and then the ones with breakpoints.If user given path exceeds the tolerance limit then "invalid path" is printed.The tolerance is compared against the shortest path without breakpoints. 
*/
class Application extends website
{
	String src,dest;
	int t;//tolerance
	String []bp=new String[5];
	Application(String src,String dest,int t,String[] bp)
	{
		this.src=src;
		this.dest=dest;
		this.t=t;
		this.bp=bp;
	}
	void journey()
	{
		if(t==0)
			t=10;
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Cannot find journey.Please check station details");
		}
	}
}

/*This class is linked to the AddStation page of frontend.The new station details are stored in the database project1 in table "station"*/
class AddS extends website
{
	String sname,scode,szone;
	AddS(String sname,String scode,String szone)
	{
		this.sname=sname;
		this.scode=scode;
		this.szone=szone;
	}
	void add()
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			String query1="INSERT INTO station VALUES ('"+sname+"','"+scode+"','"+szone+"')";
			q.executeUpdate(query1);
			System.out.println("Successfully added to database");
		}
		catch(Exception e)
		{
			System.out.println("Cannot add station.Please check station details.");
		}
	}
}

/*This class is linked to the AddTrack page of frontend.The new track details are stored in the database project1 in 	table "track"*/
class AddT extends website
{
	String src,dest;
	double distance;
	AddT(String src,String dest,double distance)
	{
		this.src=src;this.dest=dest;
		this.distance=distance;
	}
	void add()
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			String query1="INSERT INTO track VALUES ('"+src+"','"+dest+"','"+distance+"')";
		}
		catch(Exception e)
		{
			System.out.println("Cannot add track.Please check track details");
		}
	}
}

/*This class is linked to the ViewAllStations page of frontend.This class outputs all the stations present in table "station" in database project1*/
class ViewS extends website
{
	String[] view()
	{
		int n=0;
		String[] sd=new String[n];
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			String query1="SELECT * FROM station";
			String query2="SELECT COUNT(*) FROM station";
			ResultSet result1=q.executeQuery(query1);
			ResultSet result2=q.executeQuery(query2);
			while(result2.next())
				n=result2.getInt(1);
			sd=new String[n];//sd=station details
			int i=0;
			while(result1.next())
			{
				String sname=result1.getString("sname");
				String scode=result1.getString("scode");
				String szone=result1.getString("szone");
				sd[i]=sname;
				sd[i+1]=scode;
				sd[i+2]=szone;
				i+=3;
			}
		}
		catch(Exception e)
			{System.out.println("No stations available");}

		return sd;
	}
}

/*This class is linked to ViewAllTracks page of frontend.This class outputs all the tracks present in table "track" in the database project1*/
class ViewT extends website
{
	String[] view()
	{
		int n=0;
		String[] td=new String[n];
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			String query1="SELECT * FROM track";
			String query2="SELECT COUNT(*) FROM track";
			ResultSet result1=q.executeQuery(query1);
			ResultSet result2=q.executeQuery(query2);
			while(result2.next())
				n=result2.getInt(1);
			td=new String[n];//td->track details
			int i=0;
			while(result1.next())
			{
				String src=result1.getString("src");
				String dest=result2.getString("dest");
				String d=String.valueOf(result2.getDouble("distance"));
				td[i]=src;
				td[i+1]=dest;
				td[i+2]=d;
				i+=3;
			}
		}
		catch(Exception e)
		{
			System.out.println("No tracks available");
		}
		return td;
	}
}
