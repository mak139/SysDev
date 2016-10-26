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
import com.uow.cs.gpthirteen.bean.ViewPatchBean;
import com.uow.cs.gpthirteen.bean.ViewProjectBean;
import com.uow.cs.gpthirteen.bean.ViewUserBean;
import com.uow.cs.gpthirteen.dao.LoginDAO;
import com.uow.cs.gpthirteen.dao.ViewCommentDAO;
import com.uow.cs.gpthirteen.dao.ViewPatchDAO;
import com.uow.cs.gpthirteen.dao.ViewProjectDAO;
import com.uow.cs.gpthirteen.dao.ViewUserDAO;


/**
 * Servlet implementation class ViewUserServ
 */
public class ViewPatchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	  
	    ViewPatchBean viewpatchbean= new ViewPatchBean();
		ViewPatchDAO viewpatchdao = new ViewPatchDAO();

		try {
			HttpSession session = request.getSession(true);
			Integer userid=(Integer)session.getAttribute("userID");
			viewpatchbean.setUser_ID(userid);
			viewpatchdao.ViewPatchDetail(viewpatchbean);
			
			ArrayList<ViewPatchBean> allbugs = viewpatchdao.ViewPatchDetail(viewpatchbean);
			
			request.setAttribute("allbugs", allbugs);
			//System.out.println(allProjects);
			System.out.println("Hello");
			/*for (ViewPatchBean user : allbugs) {
				out.println(user.getPatch_ID());
				out.println(user.getBug_ID());
				out.println("a");
				
			}
			*/
			
			
						
					
			//System.out.println(viewpatchbean.getUser_ID());			
			
			request.getRequestDispatcher("ViewPatchDetails.jsp").forward(request,response);
			
				
			   
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 		    
		    
			
	}
	
	
}
