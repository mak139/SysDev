package com.uow.cs.gpthirteen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uow.cd.gpthirteen.util.DBConnection;
import com.uow.cs.gpthirteen.bean.BugTrackerBean;
import com.uow.cs.gpthirteen.bean.RegisterBean;

public class RegisterDAO {


	public boolean registerUser(RegisterBean registerbean){
		
		boolean result = false;
		try{
			
			
			String username= registerbean.getUsername();
			String password= registerbean.getPassword();
			String email= registerbean.getEmail();
			
			DBConnection.connectBD();
				
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("Insert into bugtracker.user(username, password, email) ");
			queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		  int status=prep.executeUpdate() ; 
		     		
		   if(status>0)
		   {
			result=true;
	    	System.out.println("Data is successfully inserted!");
		   }
		   

		}
		
		 catch( SQLException e ){
	        e.printStackTrace();
	        System.out.println("@@@@Record insertion error in Registration DAO@@@@");
	    }
		return result;
					
	}
}
