package com.uow.cs.gpthirteen.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uow.cd.gpthirteen.util.DBConnection;
import com.uow.cs.gpthirteen.bean.BugTrackerBean;
import com.uow.cs.gpthirteen.bean.RegisterBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;
import com.uow.cs.gpthirteen.bean.ViewCommentBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;
import com.uow.cs.gpthirteen.bean.ViewUserBean;

public class ViewUserDAO {


	public ArrayList<ViewUserBean> ViewUser() throws IOException , SQLException{
		
		ArrayList<ViewUserBean> allusers = new ArrayList<ViewUserBean>();
	
		try{
			DBConnection.connectBD();
				
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("SELECT user.username,user.email,role.name,project_team.team_name,project.project_name from user Join role ON user.role_id=role.role_id JOIN project_team ON user.user_id = project_team.user_id JOIN project ON project.project_team_id = project_team.project_team_id");
			//queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		    ResultSet result = prep.executeQuery();
		     		
		    while(result.next())
		   {
		    	ViewUserBean alluser = new ViewUserBean();
		    	
		    	alluser.setUsername(result.getString("username"));
		    	alluser.setEmail(result.getString("email"));
		        alluser.setRole_Name(result.getString("name"));
		        alluser.setTeam_Name(result.getString("team_name"));
		        alluser.setProject_Name(result.getString("project_name"));
		    	
		    	
		    	allusers.add(alluser);	
	   	   }
		    result.close();
		   

		}
		
		 catch( SQLException e ){
	        e.printStackTrace();
	        System.out.println("@@@@Error In retrieving records from database@@@@");
	    }
		
		return allusers;
	
					
	}
		/*public void viewprojectdetail(ViewProjectBean projectbean){
		try{
			
			ViewProjectBean ProjectDesc = new ViewProjectBean();
			
			String projectname=projectbean.getName();
			
			DBConnection.connectBD();
			
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("Select project_id from project where name='"+projectname+"'");
			//queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		    ResultSet result = prep.executeQuery();
		    
		    if(result.next())
		    {
		    	
		  //  ProjectDesc.setProjectID(result.getInt("project_id"));
            System.out.println(result.getInt("project_id"));
		    }
			
			}catch( SQLException e ){
		        e.printStackTrace();
		        System.out.println("@@@@Record insertion error in Registration DAO@@@@");
		    }
		}
*/		
		
}
