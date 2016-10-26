package com.uow.cs.gpthirteen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.uow.cs.gpthirteen.bean.AddCommentBean;
import com.uow.cs.gpthirteen.bean.LoginBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;
import com.uow.cs.gpthirteen.dao.AddCommentDAO;
import com.uow.cs.gpthirteen.dao.LoginDAO;
import com.uow.cs.gpthirteen.dao.ViewBugDetailDAO;
import com.uow.cs.gpthirteen.dao.ViewProjectDAO;


/**
 * Servlet implementation class ViewBugDetailServ
 */
public class AddCommentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request.setAttribute("message", "hello");
		//RequestDispatcher rd = request.getRequestDispatcher("ViewCommentServ");
		//rd.forward(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
	    String msg = "Comment Added";
	    
	    AddCommentBean addcommentbean= new AddCommentBean();
		AddCommentDAO addcommentdao = new AddCommentDAO();

		int bugid = Integer.parseInt(request.getParameter("Id_comments"));
		String comments = request.getParameter("bugcomment");
		
			
			addcommentbean.setComment_Text(comments);
			//addcommentdao.addcomment(addcommentbean);
			
		 if(addcommentdao.addcomment(addcommentbean))
			 
		 {
			 addcommentbean.setBug_ID(bugid);
			 addcommentdao.addcommentgroup(addcommentbean);
			 
			 response.sendRedirect("BugTracker.html");
			 
		 }
		
		
 		    
		    
			
	}
	
	
}
