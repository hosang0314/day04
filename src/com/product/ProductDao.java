package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.ProductVO;


public class ProductDao extends Dao<ProductVO , Integer> {

	@Override
	public void insert(ProductVO o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
		pst=conn.prepareStatement(Sql.insertpro);
		pst.setInt(1, o.getId());
		pst.setString(2,o.getName());
		pst.setDouble(3, o.getPrice());
		pst.executeUpdate();
		}catch(Exception e) {
			throw e;
		} finally {
			close(pst);
		}
	}

	@Override
	public void update(ProductVO o, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
		pst=conn.prepareStatement(Sql.updatepro);
		pst.setInt(3, o.getId());
		pst.setString(1,o.getName());
		pst.setDouble(2, o.getPrice());
		pst.executeUpdate();
		}catch(Exception e) {
			throw e;
		} finally {
			close(pst);
		}
		
	}

	@Override
	public void delete(Integer i, Connection conn) throws Exception {
		PreparedStatement pst = null;
		try {
		pst=conn.prepareStatement(Sql.deletetpro);
		pst.setInt(1, 1);
		pst.executeUpdate();
		}catch(Exception e) {
			throw e;
		} finally {
			close(pst);
		}
		
	}

	@Override
	public ProductVO select(Integer i, Connection conn) throws Exception {
		PreparedStatement pst = null;
		ProductVO pro = null;
		ResultSet rst = null;
		try {
			pst = conn.prepareStatement(Sql.selectpro);
			pst.setInt(1, i);
			rst = pst.executeQuery();
			rst.next();//resultSet에 값을 지정하기 위해 사용. 다음 스트링들~
			int getid = rst.getInt("ID");
			String getname = rst.getString("NAME");
			double getprice = rst.getDouble("PRICE");
			pro = new ProductVO(getid, getname, getprice);
		} catch (Exception e) {
			throw e;
		} finally {
			close(pst);
		} return pro;
		
	}

	
	public ArrayList<ProductVO> selectAll(Connection conn) throws Exception {
		return null;
	}

	@Override
	public ArrayList<ProductVO> select(Connection conn) throws Exception {
		ArrayList<ProductVO> list = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			pst = conn.prepareStatement(Sql.selectAllpro);
			rst = pst.executeQuery();
			while(rst.next()) {	
				ProductVO pro = null;
				int getid = rst.getInt("ID");
				String getname = rst.getString("NAME");
				double getprice = rst.getDouble("PRICE");
				pro = new ProductVO(getid, getname, getprice);
				list.add(pro);
				}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pst);
		}
		return list;
	}
	}


