package com.uow.cs.gpthirteen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.uow.cs.gpthirteen.bean.LoginBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;
import com.uow.cs.gpthirteen.bean.ViewCommentBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;
import com.uow.cs.gpthirteen.dao.LoginDAO;
import com.uow.cs.gpthirteen.dao.ViewBugDetailDAO;
import com.uow.cs.gpthirteen.dao.ViewCommentDAO;
import com.uow.cs.gpthirteen.dao.ViewProjectDAO;


/**
 * Servlet implementation class ViewBugDetailServ
 */
public class ViewBugDetailServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

				
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	  
	    ViewCommentBean viewcommentbean= new ViewCommentBean();
		ViewCommentDAO viewcommentdao = new ViewCommentDAO();
	    
	    
	    ViewBugDetailBean bugdetailbean= new ViewBugDetailBean();
		ViewBugDetailDAO viewbugdetaildao = new ViewBugDetailDAO();

		try {
			
ArrayList<ViewCommentBean> allComments = viewcommentdao.ViewComment();
			
			request.setAttribute("allComments", allComments);
			
			String bugid=request.getParameter("bug_id");
			
			bugdetailbean.setBug_ID(bugid);
			
			viewbugdetaildao.ViewBugDetail(bugdetailbean);
			
			ArrayList<ViewBugDetailBean> allbugs = viewbugdetaildao.ViewBugDetail(bugdetailbean);
			
			request.setAttribute("allbugs", allbugs);
			
			//System.out.println(allProjects);
			
			
		
//			for (ViewBugDetailBean bug : allbugs) {
//				out.println("hi"+bug.getBug_ID());
//				out.println(bug.getUser_ID());
//				out.println(bug.getProjectID());
//				out.println(bug.getComponent_ID());
//				out.println(bug.getReported_Date());
//				out.println(bug.getCode());
//				out.println(bug.getDescription());
//				out.println(bug.getSummary());
//			}
			
			
			
			System.out.println(bugid);
			
			request.getRequestDispatcher("ViewBugDetails.jsp").forward(request,response);
			
			
		  /*  if(request.getParameter("commentsubmit")!=null && request.getParameter("commentsubmit").equals("Comment_submit") )			
			//details for comments added on bugs
		    {
		    	 int bugid = Integer.parseInt(request.getParameter("Id_comments"));
				 String comments = request.getParameter("bugcomment");
				 
				 
					bugdetailbean.setBug_ID(bugid);
					bugdetailbean.set(password);		
					logindao.authUser(loginBean);
					
				 System.out.println(bugid);
		    	
		    }*/
			
			
		//	 projectbean.setName(viewdetail);
			// viewprojectdao.viewprojectdetail(projectbean);
			 
			//System.out.println(bugid);
			//System.out.println(comments);
			
			 		
		      // System.out.print(viewdetail);
		     
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 		    
		    
			
	}
	
	
}
