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
import com.uow.cs.gpthirteen.bean.ViewCommentBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;
import com.uow.cs.gpthirteen.bean.ViewUserBean;
import com.uow.cs.gpthirteen.dao.LoginDAO;
import com.uow.cs.gpthirteen.dao.ViewCommentDAO;
import com.uow.cs.gpthirteen.dao.ViewProjectDAO;
import com.uow.cs.gpthirteen.dao.ViewUserDAO;


/**
 * Servlet implementation class ViewUserServ
 */
public class ViewUserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	  
	    ViewUserBean viewuserbean= new ViewUserBean();
		ViewUserDAO viewuserdao = new ViewUserDAO();

		try {
			ArrayList<ViewUserBean> allUsers = viewuserdao.ViewUser();
			
			request.setAttribute("allUser", allUsers);
			//System.out.println(allProjects);
		
			/*for (ViewUserBean user : allUsers) {
				out.println(user.getUsername());
				out.println(user.getEmail());
				out.println(user.getRole_Name());
				out.println(user.getTeam_Name());
				out.println(user.getProject_Name());
				
			}*/
			
			request.getRequestDispatcher("ViewUser.jsp").forward(request,response);
			
				
			   
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 		    
		    
			
	}
	
	
}
