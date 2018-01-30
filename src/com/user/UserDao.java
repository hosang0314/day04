package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.UserVO;

public class UserDao extends Dao<UserVO, String> {

	@Override
	public void insert(UserVO o, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertUser);
			pstmt.setString(1, o.getId());
			pstmt.setString(2, o.getPwd());
			pstmt.setString(3, o.getName());
			pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
		
	}

	@Override
	public void delete(String i, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteUser);
			pstmt.setString(1, i);
			pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
		
		
	}

	@Override
	public void update(UserVO o, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateUser);
			pstmt.setString(1, o.getPwd());
			pstmt.setString(2, o.getName());
			pstmt.setString(3, o.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
		
	}

	@Override
	public UserVO select(String i, Connection conn) throws Exception {
		UserVO user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUser);
			pstmt.setString(1, i);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("ID");
			String pwd = rset.getString("pwd");
			String name = rset.getString("NAME");
			user = new UserVO(id, pwd, name);
		} catch(Exception e ) {
			throw e ;
		} finally {
			if(rset!=null) close(rset);
			if(pstmt!=null) close(pstmt);
		}
		return user;
	}

	@Override
	public ArrayList<UserVO> select(Connection conn) throws Exception {
		ArrayList<UserVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectAllUser);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				UserVO user = null;
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				user = new UserVO(id, pwd, name);
				list.add(user);
			}
		}catch(Exception e ) {
			throw e;
		}finally {
			if(rset!=null) close(rset);
			if(pstmt!=null) close(pstmt);
		}
		return list;
	}
	
}
