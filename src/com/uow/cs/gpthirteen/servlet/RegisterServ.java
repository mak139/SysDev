package com.uow.cs.gpthirteen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.uow.cs.gpthirteen.bean.RegisterBean;

import com.uow.cs.gpthirteen.dao.RegisterDAO;

/**
 * Servlet implementation class RegisterServ
 */

public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	  
		RegisterBean registerBean = new RegisterBean();
		RegisterDAO registerdao = new RegisterDAO();
	    
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        if (username == null || username.length()==0){
             out.println("<p>Name: MISSING</p>");
        }
        if (password == null || password.length()==0){
            out.println("<p>password: MISSING</p>");
       }
        if (email == null || email.length()==0){
           out.println("<p>email: MISSING</p>");
      	
        }
        
           registerBean.setUsername(username);
		   registerBean.setPassword(password);
		   registerBean.setEmail(email);
		 
		   //registerdao.registerUser(registerBean);
		   if (registerdao.registerUser(registerBean))
		   {
			 out.print("Account Successfully Created");  
		   }
		   else
		   {
			   out.println("Sorry, Something went wrong");
		   }
		   
		   
		   
	}
	}

