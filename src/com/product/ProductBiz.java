package com.product;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.vo.ProductVO;

public class ProductBiz extends Biz<ProductVO, Integer> {
	
	public ProductBiz() {
		dao = new ProductDao();
	}
	@Override
	public void register(ProductVO o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.insert(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}

	}

	@Override
	public void modify(ProductVO o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.update(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public void remove(Integer i) throws Exception {
		Connection conn = getConnection();
		try {
			dao.delete(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public ProductVO get(Integer i) throws Exception {
		Connection conn = getConnection();
		ProductVO pro = null;
		try {
			pro = dao.select(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}return pro;
	}

	public ArrayList<ProductVO> getAll() throws Exception {
		return null;
	}

	@Override
	public ArrayList<ProductVO> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			list = dao.select(conn);
			conn.commit();
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
		return list;
	}

}
