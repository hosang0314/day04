package com.user.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.UserVO;

class UserBizTest {

	@Test
	void testRegisterUserVO() {
		UserBiz biz = new UserBiz();
		UserVO user = new UserVO("id99", "pwd99", "±è¸»ÀÌ");
		try {
			biz.register(user);
			System.out.println("insert");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testRemoveString() {
		UserBiz biz = new UserBiz();
		String i = "id99";
		try {
			biz.remove(i);
			System.out.println("delete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testModifyUserVO() {
		UserBiz biz = new UserBiz();
		UserVO user = new UserVO("id99", "pwd88", "±è¼÷ÀÚ");
		try {
			biz.modify(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetString() {
		UserBiz biz = new UserBiz();
		String id = "id01";
		try {
			biz.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGet() {
		UserBiz biz = new UserBiz();
		try {
			ArrayList<UserVO> list = biz.get();
			for(UserVO u :list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
