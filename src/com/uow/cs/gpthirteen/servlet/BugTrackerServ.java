package com.uow.cs.gpthirteen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uow.cs.gpthirteen.bean.BugTrackerBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;
import com.uow.cs.gpthirteen.dao.BugTrackerDAO;
import com.uow.cs.gpthirteen.dao.ViewProjectDAO;

/**
 * Servlet implementation class BugTrackerServ
 */
public class BugTrackerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ViewProjectDAO viewprojectdao = new ViewProjectDAO();
		
		try {
			ArrayList<ViewProjectBean> allProjects = viewprojectdao.ViewProject();
		
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();

		BugTrackerBean bugBean = new BugTrackerBean();
		BugTrackerDAO bugdao = new BugTrackerDAO();

	      
		String descriptor = request.getParameter("des");
		String snippet = request.getParameter("snip");
		bugBean.setDescriptor(descriptor);
		bugBean.setSnippet(snippet);		
		bugdao.insertBugDetails(bugBean);
		
		request.setAttribute("allProjects", allProjects);
		/*for (ViewProjectBean project : allProjects) {
		out.println(project.getProjectID());
		out.println(project.getName());
		
		}*/
		
			
		request.getRequestDispatcher("BugTracker.html").forward(request,response);
		//response.sendRedirect("BugTracker.html");
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
