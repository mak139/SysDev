package com.uow.cs.gpthirteen.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uow.cd.gpthirteen.util.DBConnection;
import com.uow.cs.gpthirteen.bean.AddCommentBean;
import com.uow.cs.gpthirteen.bean.BugTrackerBean;
import com.uow.cs.gpthirteen.bean.LoginBean;
import com.uow.cs.gpthirteen.bean.RegisterBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;
import com.uow.cs.gpthirteen.bean.ViewCommentBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;

public class AddCommentDAO {


	ViewCommentBean  viewCommentBean = new ViewCommentBean();
	/*public ArrayList<ViewBugDetailBean> ViewBugDetail() throws IOException , SQLException{
		
		ArrayList<ViewBugDetailBean> allbugs = new ArrayList<ViewBugDetailBean>();
	
		try{
			DBConnection.connectBD();
				
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("Select bug_id,user_id,project_id,component_id,reported_date,code,description,summary from bug");
			//queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		    ResultSet result = prep.executeQuery();
		     		
		    while(result.next())
		   {
		    	ViewBugDetailBean allbug = new ViewBugDetailBean();
		    	
		    	allbug.setBug_ID(result.getInt("bug_id"));
		    	allbug.setUser_ID(result.getInt("user_id"));
		    	allbug.setProjectID(result.getInt("project_id"));
		    	allbug.setComponent_ID(result.getInt("component_id"));
		    	allbug.setReported_Date(result.getString("reported_date"));
		    	allbug.setCode(result.getString("code"));
		    	allbug.setDescription(result.getString("description"));
		    	allbug.setSummary(result.getString("summary"));
		    	allbugs.add(allbug);	
	   	   }
		    result.close();
		   

		}
		
		 catch( SQLException e ){
	        e.printStackTrace();
	        System.out.println("@@@@Error In retrieving records from database@@@@");
	    }
		
		return allbugs;
	
					
	}*/
		public boolean addcomment(AddCommentBean addcommentbean){
			
			boolean result=false;
			
			try{
			
						
			LoginBean loginBean = new LoginBean();
			
			
			String comments=addcommentbean.getComment_Text();
			
			int userid=loginBean.getUser_ID();
			
			DBConnection.connectBD();
			
			PreparedStatement prep, pr ;

			StringBuffer queryBuf = new StringBuffer(); 
			StringBuffer buf = new StringBuffer();
			queryBuf.append("Insert into bugtracker.comment(user_id,comment_text) ");
			queryBuf.append("value ('"+userid+"','"+comments+"')");	
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			int status=prep.executeUpdate();
			
			buf.append("select comment_id from comment where comment_text ='"+comments+"'");
			pr = DBConnection.conn.prepareStatement(buf.toString());
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()){
				
				viewCommentBean.setComment_ID(rs.getInt("comment_id"));
				System.out.println("Com ID------"+rs.getInt("comment_id"));
				break;
			}
		    if(status>0)
		    {
		    	result=true;
		    		    	
		    }
			}catch( SQLException e ){
		        e.printStackTrace();
		        
		        System.out.println("@@@@Record insertion error in addcomment DAO@@@@");
		    }
		return result;
		}
		
		public boolean addcommentgroup(AddCommentBean addcommentbean){
			
			boolean result=false;
			
			try{
			
						
			LoginBean loginBean = new LoginBean();
			
			int bugid=addcommentbean.getBug_ID();
					
			int userid=loginBean.getUser_ID();
			
			DBConnection.connectBD();
			
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("Insert into bugtracker.commentgroup(comment_id,bug_id) ");
			queryBuf.append("value ('"+viewCommentBean.getComment_ID()+"','"+bugid+"')");	
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			prep.executeUpdate();
	    	
			
		    int status=prep.executeUpdate();
		    
		    if(status>0)
		    {
		    	result=true;
		    	    	
		    }
			}catch( SQLException e ){
		        e.printStackTrace();
		        
		        System.out.println("@@@@Record insertion error in commentgroup  DAO@@@@");
		    }
		return result;
		}
}
