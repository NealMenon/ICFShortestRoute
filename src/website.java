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
	int nbp;// nbp->number of breakpoints
	String route="";
	int flag=0;
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}
}

/*For application page and journey page.
	The constructor is for taking values from the application page while journey function is for calculating the shortest path between 2 stations with or without breakpoints. The default tolerance is set at 10%. the shortest path is always printed first and then the ones with breakpoints.If user given path exceeds the tolerance limit then "invalid path" is printed.The tolerance is compared against the shortest path without breakpoints. 
*/
class Application extends website
{
	String[] path=new String[nbp+2];
	String a="";//for storing route via printPath()
	Application(int nbp,String[] path)
	{
		this.nbp=nbp;
		this.path=path;
	}

	ViewS run=new ViewS();
	int v=run.countStation();
	double[][] graph=new double[v][v];
	int min=0;
	void matrix()
	{
		for(double[] row:graph)
			Arrays.fill(row,0.0);
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			Statement q1=con.createStatement();
			Statement q2=con.createStatement();
			Statement q3=con.createStatement();
			String query1="SELECT * FROM track";
			String query2="SELECT MIN(sno) AS min FROM station";
			ResultSet result1=q.executeQuery(query1);
			ResultSet result2=q1.executeQuery(query2);
			if(result2.next())
				min=result2.getInt(1);
			while(result1.next())
			{
				String a=result1.getString("src");
				String b=result1.getString("dest");
				String query3="SELECT * FROM station WHERE scode='"+a+"'";
				String query4="SELECT * FROM station WHERE scode='"+b+"'";
				ResultSet result3=q2.executeQuery(query3);
				ResultSet result4=q3.executeQuery(query4);
				if(result3.next() && result4.next())
				{
					int i=result3.getInt("sno");
					int j=result4.getInt("sno");
					double d=result1.getDouble("distance");
					if(i>v)
						i=i-min;
					if(j>v)
						j=j-min;
					graph[i][j]=d;
					graph[j][i]=d;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	double journey(String src,String dest)
	{
		matrix();
		double[] sd=new double[v];
		boolean[] added=new boolean[v];
		Arrays.fill(added,false);
		Arrays.fill(sd,Double.MAX_VALUE);
		int root=0,leaf=0;
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q1=con.createStatement();
			Statement q2=con.createStatement();
			String query1="SELECT * FROM station WHERE scode='"+src+"'";
			String query2="SELECT * FROM station WHERE scode='"+dest+"'";
			ResultSet result1=q1.executeQuery(query1);
			ResultSet result2=q2.executeQuery(query2);
			if(result1.next() && result2.next())
			{
				root=result1.getInt("sno");
				leaf=result2.getInt("sno");
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		root-=min;leaf-=min;
		sd[root]=0.0;
		int[] parents=new int[v];
		parents[root]=-1;
		for(int i=1;i<v;i++)
		{
			int nv=-1;
			double dist=Double.MAX_VALUE;
			for(int vi=0;vi<v;vi++)
			{
				if(!added[vi] && sd[vi]<dist)
				{
					nv=vi;
					dist=sd[vi];
				}
			}
			added[nv]=true;
			for(int vi=0;vi<v;vi++)
			{
				double edgedist=graph[nv][vi];
				if(edgedist >0 && ((dist+edgedist)<sd[vi]))
				{
					parents[vi]=nv;
					sd[vi]=dist+edgedist;
				}
			}
		}
		route=printSolution(root,leaf,sd,parents);
		System.out.println();
		return sd[leaf];
	}
	String printSolution(int root,int leaf,double[] distance,int[] parents)
	{
		String b="";
		if(leaf!=root)
		{
			System.out.print(root+"->");
			System.out.print(leaf+"\t\t");
			System.out.print(distance[leaf]+"\t");
			if(flag>0)
				b=printPath(leaf,parents);
			flag++;
		}
		return b;
	}
	String printPath(int cv,int[] parents)
	{

		if(cv==-1)
		{
			return "";
		}
		printPath(parents[cv],parents);
		if(flag%4==0)
			a+="\n";
		a+=" "+printName(cv);
		//System.out.println(a+" "+printName(cv));
		return a;
	}
	String printRoute()
	{
		return route;
	}
	String printName(int cv)
	{
		String b="";
		try
		{
			int a=cv+min;
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			String query1="SELECT * FROM station WHERE sno='"+a+"'";
			ResultSet result1=q.executeQuery(query1);
			if(result1.next())
				b+=" "+result1.getString("scode");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
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
			String query1="INSERT INTO station(sname,scode,szone) VALUES ('"+sname+"','"+scode+"','"+szone+"')";
			q.executeUpdate(query1);
			System.out.println("Successfully added to database");
		}
		catch(Exception e)
		{
			System.out.println(e);
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
			q.executeUpdate(query1);
			System.out.println("Successfully added to database");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

/*This class is linked to the ViewAllStations page of frontend.This class outputs all the stations present in table "station" in database project1*/
class ViewS extends website
{
	int n=0;
	int countStation()
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			String query1="SELECT COUNT(*) FROM station";
			ResultSet result1=q.executeQuery(query1);
			if(result1.next())
				n=result1.getInt(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		int a=n;
		return a;
	}
	String[][] view()
		{
			String[][] sd=new String[n][3];
			try
			{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
				Statement q=con.createStatement();
				String query1="SELECT * FROM station";
				ResultSet result1=q.executeQuery(query1);
				int i=0; //j = 0;
				while(result1.next())
				{
					String sname=result1.getString("sname");
					String scode = result1.getString("scode");	
					String szone=result1.getString("szone");
					sd[i][0]=sname;
					sd[i][1]=scode;
					sd[i][2]=szone;
					i++;
				}
			}
			catch(Exception e)
				{
					System.out.println("No stations available");
				}
			return sd;
		}
}

/*This class is linked to ViewAllTracks page of frontend.This class outputs all the tracks present in table "track" in the database project1*/
class ViewT extends website
{
	int n=0;
	int countTrack()
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			String query1="SELECT COUNT(*) FROM track";
			ResultSet result1=q.executeQuery(query1);
			if(result1.next())
				n=result1.getInt(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		int a=n;
		return a;
	}

	String [][] view()
	{
		String [][] td = new String[n][3];
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false",user,pwd);
			Statement q=con.createStatement();
			String query1="SELECT * FROM track";
			ResultSet result1=q.executeQuery(query1);
			int i=0;
			while(result1.next())
			{
				String src=result1.getString("src");
				String dest=result1.getString("dest");
				String d=String.valueOf(result1.getDouble("distance"));
				
				td[i][0]=src;
				td[i][1]=dest;
				td[i][2]=d;
				
				i++;
			}
		}
		catch(Exception e)
		{
			System.out.println("No stations available");
		}
		return td;
	}
}
