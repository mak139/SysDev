package com.uow.cs.gpthirteen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.uow.cs.gpthirteen.bean.LoginBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;
import com.uow.cs.gpthirteen.dao.LoginDAO;
import com.uow.cs.gpthirteen.dao.ViewProjectDAO;


/**
 * Servlet implementation class ViewProjectServ
 */
public class ViewProjectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	  
	    ViewProjectBean projectbean= new ViewProjectBean();
		ViewProjectDAO viewprojectdao = new ViewProjectDAO();

		try {
			ArrayList<ViewProjectBean> allProjects = viewprojectdao.ViewProject();
			
			request.setAttribute("allProjects", allProjects);
			System.out.println(allProjects);
		
			/*for (ViewProjectBean employee : allProjects) {
				out.println(employee.getProjectID());
				out.println(employee.getStart_date());
				out.println(employee.getEnd_date());
			}*/
			
			request.getRequestDispatcher("ViewProjects.jsp").forward(request,response);
			
			//out.println(allProjects);
			
			
			//details for project
			
			 String viewdetail = request.getParameter("viewprojdetails");
			
			 projectbean.setName(viewdetail);
			 viewprojectdao.viewprojectdetail(projectbean);
			 
			// System.out.println(projectbean.getProjectID());
			
			 		
		      // System.out.print(viewdetail);
		     
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 		    
		    
			
	}
	
	
}
