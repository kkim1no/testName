package org.han.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.han.dao.Mp3DAO;
import org.han.dao.Mp3DAOImpl;
import org.han.vo.Mp3Vo;
import org.junit.Before;
import org.junit.Test;

public class Mp3DAOTest {

	Mp3DAO dao;
	
	@Before
	public void setUp() throws Exception {
		
		dao = new Mp3DAOImpl();
		
	}

	  @Test
	   public void Mp3Insert() {
	      try {
	         Mp3Vo vo = new Mp3Vo();
	         
	         vo.setTitle("볼링핀");
	         vo.setDsc("볼링핀은 계속 쓰러지지지요");
	         vo.setCate("대중가요");
	         vo.setUserid("han33");
	         //UserID(FK) 존재하는 놈으로 하기!
	         vo.setFilename("볼링핀.mp3");
	         vo.setArtist("김은애");
	         vo.setImg("image");
	         vo.setAlbname("DongHyuk-1stTitle");

	         dao.create(vo);
	         
	         
	         
	      } catch (Exception e) {
	         fail(e.getMessage());
	      }
	   }

	   @Test
	   public void Mp3Select() {
	   
	      try {
	         Mp3Vo vo = new Mp3Vo();
	            vo = dao.read(5);         
	            System.out.println(vo);

	      } catch (Exception e) {
	         fail(e.getMessage());
	      }

	   }

	   @Test
	   public void Mp3Update() {
	      try {
	         Mp3Vo vo = new Mp3Vo();
	         vo.setTitle("수요일에 만나요");
	         vo.setDsc("수요일 다음날 연휴 예~");
	         vo.setCate("대중가요");
	         vo.setUserid("han01");
	         vo.setFilename("수요일에 만나요.mp3");
	         vo.setRcount(0);
	         vo.setVcount(15);
	         vo.setImg("image");
	         vo.setAlbname("DongHyuk-2ndTitle");
	         vo.setMno(23);

	         dao.update(vo);
	      } catch (Exception e) {
	         fail(e.getMessage());
	      }
	   }

	   @Test
	   public void Mp3allSelect() {
	      try {
	         List<Mp3Vo> list = new ArrayList<Mp3Vo>();
	            list = dao.allread();
	            for (Mp3Vo Mp3Vo : list) {
	               System.out.println(Mp3Vo.toString());
	               
	            }

	      } catch (Exception e) {
	         fail(e.getMessage());
	      }
	   }
	   
	   @Test
	   public void Mp3Delete() {
	      try{      
	         dao.delete(23);

	      }catch(Exception e){
	      fail(e.getMessage());
	      }
	   }
}
