package com.uow.cs.gpthirteen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.uow.cd.gpthirteen.util.DBConnection;

import com.uow.cs.gpthirteen.bean.LoginBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;

public class LoginDAO {


	public boolean authUser(LoginBean loginbean){
		boolean chk = false;
		try{
			
			
			String username= loginbean.getUsername();
			String password= loginbean.getPassword();
			
			DBConnection.connectBD();
			PreparedStatement prep;
			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("select user_id,username, password from user where username='"+username+"' and password='"+password+"'");
		//	queryBuf.append("value ('"+descriptor+"','"+snippet+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			
			ResultSet result = prep.executeQuery();
			
			if(result.next())
			{
			chk=true;
			loginbean.setUser_ID(result.getInt("user_id"));
			}
			else 
			{
				System.out.println("False");
			}
			
			DBConnection.close();
			

		}catch(Exception e){
			e.printStackTrace();
		}
		return chk;
		
	}
	
	public void chkrole(LoginBean loginbean){
		
		try{
			String username= loginbean.getUsername();
			//LoginBean loginBean = new LoginBean();
			
			//int userid= loginBean.getUser_ID();
		
			
			DBConnection.connectBD();
			PreparedStatement prep;
			StringBuffer queryBuf = new StringBuffer(); 
			queryBuf.append("select role.name from role join user on user.role_id=role.role_id where user.username='"+username+"'");
		//	queryBuf.append("value ('"+descriptor+"','"+snippet+"')");
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			
			ResultSet result = prep.executeQuery();
			
			if(result.next())
			{
			
			loginbean.setRole_Name(result.getString("name"));
			}
			else 
			{
				System.out.println("False");
			}
			
			DBConnection.close();
			

		}catch(Exception e){
			e.printStackTrace();
		}
		
}
}
