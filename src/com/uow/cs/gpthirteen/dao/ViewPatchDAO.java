package com.uow.cs.gpthirteen.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uow.cd.gpthirteen.util.DBConnection;
import com.uow.cs.gpthirteen.bean.BugTrackerBean;
import com.uow.cs.gpthirteen.bean.LoginBean;
import com.uow.cs.gpthirteen.bean.RegisterBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;
import com.uow.cs.gpthirteen.bean.ViewCommentBean;
import com.uow.cs.gpthirteen.bean.ViewPatchBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;
import com.uow.cs.gpthirteen.bean.ViewUserBean;

public class ViewPatchDAO {


	public ArrayList<ViewPatchBean> ViewPatchDetail(ViewPatchBean viewpatchbean) throws IOException , SQLException{
		
		ArrayList<ViewPatchBean> allbugs = new ArrayList<ViewPatchBean>();
		//LoginBean loginBean = new LoginBean();
		
		
		int userid=viewpatchbean.getUser_ID();
		
		try{
			DBConnection.connectBD();
			
				
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("SELECT * from patch where user_id='"+userid+"'");
			//queryBuf.append("value ('"+username+"','"+password+"','"+email+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
		
			
		    ResultSet result = prep.executeQuery();
		     		
		    while(result.next())
		   {
		    	ViewPatchBean allbug = new ViewPatchBean();
		    	
		    	allbug.setPatch_ID(result.getInt("patch_id"));
		    	
		    	
		        allbug.setBug_ID(result.getString("bug_id"));
		        allbug.setReview_Status(result.getString("review_status"));
		      
		    	
		    	
		    	allbugs.add(allbug);	
	   	   }
		   // System.out.println(viewpatchbean.getUser_ID());
		    result.close();
		   

		}
		
		 catch( SQLException e ){
	        e.printStackTrace();
	        System.out.println("@@@@Error In retrieving records from database@@@@");
	    }
		
		return allbugs;
	
					
	}
		public void addpatchdata(ViewPatchBean viewpatchbean){
		try{
			
						
			String filename=viewpatchbean.getFile();
			String bugid=viewpatchbean.getBug_ID();
			String version=viewpatchbean.getPatch_Version();
			String status= "Open";
			
			int res;
			int userid=viewpatchbean.getUser_ID();
			
			DBConnection.connectBD();
			
			PreparedStatement prep ;

			StringBuffer queryBuf = new StringBuffer(); 
			String query="Insert into bugtracker.patch (patch_version,bug_id,user_id,file,review_status) values (?,?,?,?,?)";
			//queryBuf.append("value ('"+version+"','1','1','"+filename+"','"+status+"')");
			prep= DBConnection.conn.prepareStatement(query);
			
			
			prep.setString(1,version);
			prep.setString(2,bugid);
			prep.setInt(3,userid);
			prep.setString(4,filename);
			prep.setString(5,status);
			
			res=prep.executeUpdate() ; 
     		
			   if(res>0)
			   {
				 	System.out.println("Data is successfully inserted!");
				 	System.out.println(filename);
				 	System.out.println("Inner"+bugid);
			   }
			
			}catch( SQLException e ){
		        e.printStackTrace();
		        System.out.println("@@@@Record insertion error in ViewPatchDAO@@@@");
		    }
		}
		
		
			
	
		
}
