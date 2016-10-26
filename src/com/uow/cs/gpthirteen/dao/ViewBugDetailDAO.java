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
import com.uow.cs.gpthirteen.bean.ViewProjectBean;

public class ViewBugDetailDAO {


	public ArrayList<ViewBugDetailBean> ViewBugDetail(ViewBugDetailBean bugdetailbean) throws IOException , SQLException{
		
		ArrayList<ViewBugDetailBean> allbugs = new ArrayList<ViewBugDetailBean>();
	
		try{
			String bugid=bugdetailbean.getBug_ID();
			
			DBConnection.connectBD();
				
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer();
			queryBuf.append("select bug.bug_id, comment.comment_text from comment join commentgroup on commentgroup.comment_id=comment.comment_id join bug on bug.bug_id=commentgroup.bug_id where bug.bug_id='"+bugid+"'");
//			queryBuf.append("where bug_id ="+bugid);
			//queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			
			System.out.println(queryBuf.toString());
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		    ResultSet result = prep.executeQuery();
		     		
		    while(result.next())
		   {
		    	ViewBugDetailBean allbug = new ViewBugDetailBean();
		    	
		    	allbug.setBug_ID(result.getString("bug_id"));
		    	allbug.setComment(result.getString("comment_text"));
//		    	allbug.setProjectID(result.getInt("project_id"));
//		    	allbug.setComponent_ID(result.getInt("component_id"));
//		    	allbug.setReported_Date(result.getString("reported_date"));
//		    	allbug.setCode(result.getString("code"));
//		    	allbug.setDescription(result.getString("description"));
//		    	allbug.setSummary(result.getString("summary"));
		    	allbugs.add(allbug);
		    	
		    	
	   	   }
		    result.close();
		   

		}
		
		 catch( SQLException e ){
	        e.printStackTrace();
	        System.out.println("@@@@Error In retrieving records from database@@@@");
	    }
		
		return allbugs;
	
					
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
