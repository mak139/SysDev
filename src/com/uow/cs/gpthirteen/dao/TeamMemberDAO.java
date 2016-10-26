package com.uow.cs.gpthirteen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uow.cd.gpthirteen.util.DBConnection;
import com.uow.cs.gpthirteen.bean.TeamMemberBean;
import com.uow.cs.gpthirteen.bean.ViewBugDetailBean;

public class TeamMemberDAO {
	
	public ArrayList getMember(String bugid){
		
		ArrayList<TeamMemberBean> list = new ArrayList<TeamMemberBean>();
		
		DBConnection.connectBD();
		
		PreparedStatement prep ;

		StringBuffer queryBuf = new StringBuffer(); 
		queryBuf.append("select distinct(project_team.user_id) from project_team  ");
		queryBuf.append("join project ON project.project_id = project_team.project_team_id ");
		queryBuf.append("join bug on project.project_id = bug.project_id and bug.bug_id = "+bugid);
		try {
			prep= DBConnection.conn.prepareStatement(queryBuf.toString());
			ResultSet rs =prep.executeQuery();
			
			while(rs.next()){
				TeamMemberBean teamBean = new TeamMemberBean();
				
				System.out.println("ID---"+rs.getInt("user_id"));
				
				teamBean.setUserId(rs.getInt("user_id"));
				list.add(teamBean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
