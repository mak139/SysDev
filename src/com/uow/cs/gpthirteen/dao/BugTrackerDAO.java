package com.uow.cs.gpthirteen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.uow.cd.gpthirteen.util.DBConnection;
import com.uow.cs.gpthirteen.bean.BugTrackerBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;

public class BugTrackerDAO {

	public void insertBugDetails(BugTrackerBean bugbean){
		try{
			String descriptor = bugbean.getDescriptor();
			String snippet = bugbean.getSnippet();
			DBConnection.connectBD();
			PreparedStatement prep;
			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("Insert into bugtracker.bug_table(Descriptor, Snippet) ");
			queryBuf.append("value ('"+descriptor+"','"+snippet+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			prep.executeUpdate();
			DBConnection.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<ViewBugDetailBean> viewBugs(){
		
		ArrayList<ViewBugDetailBean> list = new ArrayList<ViewBugDetailBean>();
		
		try{
			
			DBConnection.connectBD();
			PreparedStatement prep ;
			StringBuffer queryBuf = new StringBuffer(); 
			
			queryBuf.append("select * from bug where status = 'open'");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			System.out.println("Query----"+queryBuf.toString());
		    ResultSet result = prep.executeQuery();
		    
		    while(result.next()){
		    	ViewBugDetailBean bugBean = new ViewBugDetailBean();
		    	
		    	System.out.println("ID----"+result.getInt("bug_id"));
		    	
		    	bugBean.setBug_ID(result.getString("bug_id"));
		    	bugBean.setUser_ID(result.getInt("user_id"));
		    	bugBean.setProjectID(result.getInt("project_id"));
		    	bugBean.setComponent_ID(result.getInt("component_id"));
		    	
		    	bugBean.setSubscriberGroupID(result.getInt("subscriber_group_id"));
		    	bugBean.setDescription(result.getString("description"));
		    	bugBean.setSummary(result.getString("summary"));
		    	
		    	list.add(bugBean);
			}
		    result.close();
		}catch(Exception ex){
			
		}
		
		return list;	
	}
	
	public void setPriority(String id, String prio){
		
		DBConnection.connectBD();
		PreparedStatement prep ;
		StringBuffer queryBuf = new StringBuffer(); 
		queryBuf.append("update bug set priority = '"+prio+"' where bug_id = '"+id+"'");
		try {
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
	}
	
	public ArrayList<ViewBugDetailBean> viewABugAssign(String bugid){
		ArrayList<ViewBugDetailBean> list = new ArrayList<ViewBugDetailBean>();
		try{
			
			DBConnection.connectBD();
			PreparedStatement prep ;
			StringBuffer queryBuf = new StringBuffer(); 
			
			queryBuf.append("select * from bug where bug_id = "+bugid);
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			System.out.println("Query----"+queryBuf.toString());
		    ResultSet result = prep.executeQuery();
		    
		    while(result.next()){
		    	ViewBugDetailBean bugBean = new ViewBugDetailBean();
		    	
		    	System.out.println("ID----"+result.getInt("bug_id"));
		    	
		    	bugBean.setBug_ID(result.getString("bug_id"));
		    	bugBean.setUser_ID(result.getInt("user_id"));
		    	bugBean.setProjectID(result.getInt("project_id"));
		    	bugBean.setComponent_ID(result.getInt("component_id"));
		    	
		    	bugBean.setSubscriberGroupID(result.getInt("subscriber_group_id"));
		    	bugBean.setDescription(result.getString("description"));
		    	bugBean.setSummary(result.getString("summary"));
		    	
		    	list.add(bugBean);
			}
		    result.close();
		}catch(Exception ex){
			
		}
		return list;
	}
}
