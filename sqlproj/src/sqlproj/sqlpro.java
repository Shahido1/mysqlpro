package sqlproj;

import java.sql.*;
import java.util.Scanner;
public class sqlpro {

	static void selects(){
	//case 1:
		try{ Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","student","shahid123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		
		while(rs.next())
		{
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
		}
		}
		catch(Exception e)
		{
		System.out.println(e.toString());}
	}
	
	static void delets() {
		
		try{ Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","student","shahid123");
		String s="delete from student where id=61";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1,3);
		ps.execute();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());}
	}
	
	static void inserts() {
		try{ Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","student","shahid123");
		Statement st=con.createStatement();
		st.executeUpdate("insert into student values(61,'john',963258,'BE')");
		con.close();
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());}
	
	}
	static void updates() {
		try{ Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","student","shahid123");
		Statement st=con.createStatement();
		st.executeUpdate("update student set qualification='BE' where id=62");
		con.close();
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());}
		
	}
	public static void main(String args []) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("<To perform operation press>: Insert:1 Delete:2 Select:3 Update:4");
		int a=sc.nextInt();
		sqlpro p=new sqlpro();
		switch(a) {
		case 1:
			p.inserts();
			break;
		case 2:
			p.delets();
			break;
		case 3:
			p.selects();
			break;
		case 4:
			p.updates();
			break;
			
		}
		
	}	

}
