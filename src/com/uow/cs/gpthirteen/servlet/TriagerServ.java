package com.uow.cs.gpthirteen.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uow.cs.gpthirteen.bean.TeamMemberBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;
import com.uow.cs.gpthirteen.dao.BugTrackerDAO;
import com.uow.cs.gpthirteen.dao.TeamMemberDAO;

/**
 * Servlet implementation class TriagerServ
 */

public class TriagerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String operation = request.getParameter("operation");
		
		System.out.println("hello"+operation);
		System.out.println("hello"+action);
		
		BugTrackerDAO bugDAO = new BugTrackerDAO();
		if("Triager".equals(action)){
	    	try{
	    		ArrayList<ViewBugDetailBean> allbugs = bugDAO.viewBugs();
	    		request.setAttribute("allbugs", allbugs);
	    		request.getRequestDispatcher("TriagePage.jsp").forward(request,response);
	    	}catch(Exception e){
	    		
	    	}
		}if("Submit".equals(operation)){
			TeamMemberDAO teamDAO = new TeamMemberDAO();
			
			String view = request.getParameter("viewprojdetails");
			String bugid = request.getParameter("viewprojdetails");
			String priority = request.getParameter("priority");
			
			bugDAO.setPriority(bugid, priority);
			System.out.println("Ok");
			
			ArrayList<ViewBugDetailBean> allbugs = bugDAO.viewABugAssign(bugid);
    		request.setAttribute("allbugs", allbugs);
    		
    		ArrayList<TeamMemberBean> mem = teamDAO.getMember(bugid);
    		request.setAttribute("members", mem);
    		
    		for (TeamMemberBean bug : mem) {
				System.out.println(bug.getUserId());
    		}
    		
    		request.getRequestDispatcher("Assign.jsp").forward(request,response);
		}
	}
}
