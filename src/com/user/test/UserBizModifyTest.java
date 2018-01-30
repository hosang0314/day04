package com.user.test;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.UserVO;

class UserBizModifyTest {

	@Test
	void testModifyUserVO() {
		UserBiz biz = new UserBiz();
		UserVO user = new UserVO("id02", "0000", "±è¸»ÀÚ");
		try {
			biz.modify(user);
			System.out.println("Modify Completed..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
