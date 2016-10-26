package com.uow.cs.gpthirteen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uow.cs.gpthirteen.bean.LoginBean;
import com.uow.cs.gpthirteen.dao.LoginDAO;


/**
 * Servlet implementation class LoginServ
 */
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	  
		LoginBean loginBean = new LoginBean();
		LoginDAO logindao = new LoginDAO();

	    if(request.getParameter("login")!=null && request.getParameter("login").equals("logincheck") )
		    {
	    	
	    	String username = request.getParameter("username");
	        String password = request.getParameter("password");
	         
	         
	         if (username == null || username.length()==0){
	              out.println("<p>Name: MISSING</p>");
	         }
	         if(password == null || password.length()==0){
	              out.println("<p>Password: MISSING</p>");
	         }
	         
	     	loginBean.setUsername(username);
			loginBean.setPassword(password);		
			logindao.authUser(loginBean);
			logindao.chkrole(loginBean);
			
			if(logindao.authUser(loginBean))
			{
				HttpSession session = request.getSession(true);
                synchronized (session) {  
                session.setAttribute("userName", username);
                session.setAttribute("userID", loginBean.getUser_ID());
                session.setAttribute("roleName", loginBean.getRole_Name());
     
               response.sendRedirect("BugTracker.jsp");
               // out.print(loginBean.getRole_Name());
							}
	         
	       		    
		    }
			
			else
				
			{
		    out.println("Sorry");	
			}
			}
	}
	
	
}
