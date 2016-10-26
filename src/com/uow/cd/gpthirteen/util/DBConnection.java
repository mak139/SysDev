package com.uow.cd.gpthirteen.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection {
	public static Connection conn;
	public static void connectBD(){
		try
		{
//			String url = "jdbc:mysql://localhost:3306/SysDev";
			String url = "jdbc:mysql://localhost:3306/bugtracker";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "");
		}
		catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
		catch (SQLException ex)           {System.err.println(ex.getMessage());}
		if(conn!=null){
			System.out.println("Connection Successfull!!!");
			System.out.println(conn);
		}else{
			System.out.println("Not connected!!!");
		}
	}
	public static void close() throws SQLException{
		conn.close();
	}
}
