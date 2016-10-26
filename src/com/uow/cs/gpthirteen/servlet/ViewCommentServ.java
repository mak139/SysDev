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
import com.uow.cs.gpthirteen.dao.LoginDAO;
import com.uow.cs.gpthirteen.dao.ViewCommentDAO;
import com.uow.cs.gpthirteen.dao.ViewProjectDAO;


/**
 * Servlet implementation class ViewProjectServ
 */
public class ViewCommentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request.setAttribute("message", "hello");
        
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	  
	    ViewCommentBean viewcommentbean= new ViewCommentBean();
		ViewCommentDAO viewcommentdao = new ViewCommentDAO();

		try {
			ArrayList<ViewCommentBean> allComments = viewcommentdao.ViewComment();
			
			request.setAttribute("allComments", allComments);
			//System.out.println(allProjects);
		
			/*for (ViewCommentBean comment : allComments) {
				out.println(comment.getComment_ID());
				out.println(comment.getUser_ID());
				out.println(comment.getComment_Text());
				out.println(comment.getDate());
			}*/
			
			request.getRequestDispatcher("ViewComments.jsp").forward(request,response);
			
			//out.println(allProjects);
			
			
			//details for project
			
			   
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 		    
		    
			
	}
	
	
}
