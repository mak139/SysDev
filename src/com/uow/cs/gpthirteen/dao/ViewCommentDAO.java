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

public class ViewCommentDAO {


	public ArrayList<ViewCommentBean> ViewComment() throws IOException , SQLException{
		
		ArrayList<ViewCommentBean> allcomments = new ArrayList<ViewCommentBean>();
	
		try{
			DBConnection.connectBD();
				
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
//			queryBuf.append("Select comment.comment_id,comment.user_id,comment.comment_text,comment.date,commentgroup.bug_id from comment join commentgroup on comment.comment_id=commentgroup.comment_id");
			//queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			
			queryBuf.append("select bug_id, description from bug");
			
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		    ResultSet result = prep.executeQuery();
		     		
		    while(result.next())
		   {
		    	ViewCommentBean allcomment = new ViewCommentBean();
		    	
		    	allcomment.setBug_ID(result.getString("bug_id"));
		    	allcomment.setDescription(result.getString("description"));
//		    	allcomment.setComment_Text(result.getString("comment_text"));
//		    	allcomment.setDate(result.getString("date"));
//		    	allcomment.setBug_ID(result.getInt("bug_id"));
		    	allcomments.add(allcomment);	
	   	   }
		    result.close();
		   

		}
		
		 catch( SQLException e ){
	        e.printStackTrace();
	        System.out.println("@@@@Error In retrieving records from database@@@@");
	    }
		
		return allcomments;
	
					
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
