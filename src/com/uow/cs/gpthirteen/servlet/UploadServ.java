package com.uow.cs.gpthirteen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;

import java.util.Iterator;
import java.util.List;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.uow.cs.gpthirteen.bean.ViewPatchBean;
import com.uow.cs.gpthirteen.dao.ViewPatchDAO;

/**
 * Servlet implementation class ViewBugDetailServ
 */
public class UploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String UPLOAD_DIRECTORY = "D:/upload";
	 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	

	String filename="";
	String bugid="";
	String version="";
	 
	if(ServletFileUpload.isMultipartContent(request)){
        try {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
           
            for(FileItem item : multiparts){
                if(!item.isFormField()){
                    String name = new File(item.getName()).getName();
                   
					filename= UPLOAD_DIRECTORY + File.separator + name;
                    item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                }
                if(item.isFormField()){
                
                	if(item.getFieldName().equals("bug_id"))
                    bugid = item.getString();
                    
                
                if(item.getFieldName().equals("version"))
                {
                	version = item.getString();
                }
                }
                
            }
            
            ViewPatchBean viewpatchbean= new ViewPatchBean();
    		ViewPatchDAO viewpatchdao = new ViewPatchDAO();
    		
    		HttpSession session = request.getSession(true);
    		Integer userid=(Integer)session.getAttribute("userID");
    		viewpatchbean.setUser_ID(userid);
    		
            viewpatchbean.setFile(filename);
            viewpatchbean.setBug_ID(bugid);
            viewpatchbean.setPatch_Version(version);
            viewpatchdao.addpatchdata(viewpatchbean);
            
    		//System.out.print("Hello"+version);
    		//System.out.print("Hello"+bugid);
    		
           //File uploaded successfully
           //request.setAttribute("message", "File Uploaded Successfully");
        }
        catch (Exception ex) {
          System.out.println(ex);
        }          
     
    }else{
    	
        request.setAttribute("message",
                             "Sorry this Servlet only handles file upload request");
    }

   
	
	request.getRequestDispatcher("UploadSuccess.jsp").forward(request, response);
 
}

}


