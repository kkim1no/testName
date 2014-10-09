package org.han.dao;


import java.util.ArrayList;
import java.util.List;

import org.han.util.SqlAgent;
import org.han.vo.UserVo;

public class UserDAOImpl implements UserDAO {
	
	enum SQL {
		// 모든 SQL문에 세미콜론은 없다
		INSERT("INSERT into tbl_user(userid, pw) values (?, ?)"),
		SELECT("select * from tbl_user where userid = ? "),
		UPDATE("update tbl_user set pw = ? where userid=? "),
		DELETE("delete tbl_user where userid=? "),
		ALLSEL("select*from tbl_user");
	
		String value;

		SQL(String value) {
			this.value = value;
		}
	}

	@Override
	public void create(UserVo vo) throws Exception {
		new SqlAgent() {
			
			@Override
			protected void doJob() throws Exception {
				
				pstmt = con.prepareStatement(SQL.INSERT.value);
				
				pstmt.setString(1,vo.getUserid());
				pstmt.setString(2, vo.getPw());
				
				int resultCount = pstmt.executeUpdate();
				// 인설트가 제대로 실행 될 경우 1을 반환
				
				if (resultCount < 1) {
					throw new Exception("INSERT ERROR");
				}
				
				
			}
		}.doExecute();

	}

	@Override
	public UserVo read(final String no) throws Exception {

		final UserVo uvo = new UserVo();
		
		new SqlAgent() {
			
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.SELECT.value);
				
				pstmt.setString(1, no);
				
				rs = pstmt.executeQuery();
				rs.next();
				uvo.setUserid(rs.getString(1));
				uvo.setPw(rs.getString(2));
				
			}
		}.doExecute();
		
		return uvo;
	}

	@Override
	public void update(UserVo vo) throws Exception {
		new SqlAgent() {
			
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.UPDATE.value);
				
				pstmt.setString(1, vo.getPw());
				pstmt.setString(2, vo.getUserid());
				
				pstmt.executeUpdate();
				
			}
		}.doExecute();

	}

	@Override
	public void delete(String no) throws Exception {
		
		new SqlAgent() {
			
			@Override
			protected void doJob() throws Exception {
				
				pstmt=con.prepareStatement(SQL.DELETE.value);
				
				pstmt.setString(1, no);
				
				pstmt.executeUpdate();
			}
		}.doExecute();
		

	}

	@Override
	public List<UserVo> allread() throws Exception {
		
		List<UserVo> list = new ArrayList<UserVo>();
		
		new SqlAgent() {
			
			@Override
			protected void doJob() throws Exception {
				
				pstmt=con.prepareStatement(SQL.ALLSEL.value);
				rs=pstmt.executeQuery();
				
				
				
				while(rs.next()){
					UserVo uvo= new UserVo();
					uvo.setUserid(rs.getString(1));
					uvo.setPw(rs.getString(2));
					uvo.setRegdate(rs.getDate(3));
					
					list.add(uvo);
					
					
				}
				
			}
		}.doExecute();
		return list;
	}

}
