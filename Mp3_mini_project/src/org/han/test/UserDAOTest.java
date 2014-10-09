package org.han.test;

import java.util.ArrayList;
import java.util.List;

import org.han.dao.UserDAO;
import org.han.dao.UserDAOImpl;
import org.han.vo.UserVo;
import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {
	UserDAO dao;
	@Before
	public void setUp() throws Exception {
		
		dao= new UserDAOImpl();
	}

	@Test
	public void test() {
		
		try {
			UserVo vo = new UserVo();
			
			vo.setUserid("¿À´Ã2");
//			vo.setPw("¿À´Ã");
			dao.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
		
		try {
			
			UserVo uvo = new UserVo();
			
			uvo = dao.read("han03");
			
			System.out.println(uvo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void test3() {
		
		try {
			UserVo vo = new UserVo();
			
			vo.setPw("han100");
			vo.setUserid("han33");
			dao.update(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test4() {
		
		try {
			
			dao.delete("¿À´Ã2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test5() {
		
		try {
			List<UserVo> list = new ArrayList<UserVo>();
			list = dao.allread();
			for (UserVo userVo : list) {
				System.out.println(userVo.toString());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
