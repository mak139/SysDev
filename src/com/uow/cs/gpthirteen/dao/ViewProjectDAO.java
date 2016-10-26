package com.uow.cs.gpthirteen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uow.cd.gpthirteen.util.DBConnection;
import com.uow.cs.gpthirteen.bean.BugTrackerBean;
import com.uow.cs.gpthirteen.bean.RegisterBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;

public class ViewProjectDAO {


	public ArrayList<ViewProjectBean> ViewProject() throws SQLException{
		
		ArrayList<ViewProjectBean> allProjects = new ArrayList<ViewProjectBean>();
	
		try{
			DBConnection.connectBD();
				
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("Select project_id,project_team_id,project_name,url,description,start_date,end_date from project");
			//queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		    ResultSet result = prep.executeQuery();
		     		
		    while(result.next())
		   {
		    	ViewProjectBean allProject = new ViewProjectBean();
		    	
		    	allProject.setProject_desc(result.getString("description"));
		    	allProject.setProjectID(result.getInt("project_id"));
		    	allProject.setName(result.getString("project_name"));
		    	allProject.setStart_date(result.getString("start_date"));
		    	allProject.setEnd_date(result.getString("end_date"));
		    	allProjects.add(allProject);	
	   	   }
		    result.close();
		   

		}
		
		 catch( SQLException e ){
	        e.printStackTrace();
	        System.out.println("@@@@Error In retrieving records from database@@@@");
	    }
		
		return allProjects;
	
					
	}
		public void viewprojectdetail(ViewProjectBean projectbean){
		try{
			
			ViewProjectBean ProjectDesc = new ViewProjectBean();
			
			String projectname=projectbean.getName();
			
			DBConnection.connectBD();
			
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer();
			StringBuffer query = new StringBuffer();
			queryBuf.append("Select project_id from project where project_name='"+projectname+"'");
			//queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		    ResultSet result = prep.executeQuery();
		    int num = 0;
		    
		    if(result.next())
		    {
		    	
		    //ProjectDesc.setProjectID(result.getInt("project_id"));
            System.out.println(result.getInt("project_id"));
            num = result.getInt("project_id");
		    }
		    
		    query.append("Select  * from project where project_id='"+num+"'");
		    prep=DBConnection.conn.prepareStatement(query.toString());
		    
		    ResultSet rs = prep.executeQuery();
		    
		    while(rs.next()){
		    	ViewProjectBean  viewBean = new ViewProjectBean();
		    	
		    	
		    }
			
			}catch( SQLException e ){
		        e.printStackTrace();
		        System.out.println("@@@@Record insertion error in Registration DAO@@@@");
		    }
		
		
		}
}
