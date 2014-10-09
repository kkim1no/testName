package org.han.dao;

import java.util.ArrayList;
import java.util.List;

import org.han.util.SqlAgent;
import org.han.vo.Mp3Vo;

public class Mp3DAOImpl implements Mp3DAO {

	enum SQL {
		// 모든 SQL문에 세미콜론은 없다	
		//파일 이름에서 UUID 잘라내기
		//select title, filename, substr(filename, instr(filename, '_')+1) from tbl_mp3
		
		INSERT("INSERT into tbl_mp3(mno, title, dsc, cate, userid, filename, artist, img, albname) values (seq_mp3.nextval, ?, ?, ?, ?, ?, ?, ?, ?)"),
		SELECT("select * from tbl_mp3 where mno = ?"), 
		UPDATE("update tbl_mp3"
                + " set title = ?, dsc = ?, cate = ?, userid = ?, filename = ?, rcount = ?, vcount = ?,"
                + " artist = ?, img = ?, albname = ?"
                + " where mno = ?"),
		DELETE("delete tbl_mp3 where mno=? "),
		ALLSEL("select	rn, title, filename,artist,img, count(mno) over() cnt" +
				" from( select /*+INDEX_DESC(tbl_bbs pk_bbs) */"
				+ " rownum rn, mno, title, filename,artist,img, count(mno) over() cnt"
				+ " from tbl_mp3"
				+ " where mno > 0 and rownum <= (ceil((1/10)) * (10*5) ) + 1)"
				+ " where rn > ((1-1)*10) and rn <= (1*10)");
		
//		ALLSEL("select	rn, mno, title, dsc, cate, filename, cnt" +
//				"from( select /*+INDEX_DESC(tbl_bbs pk_bbs) */"
//				+ "rownum rn, mno, title, dsc, cate, filename, count(mno) over() cnt"
//				+ "from tbl_mp3"
//				+ "where mno > 0 and rownum <= (ceil((페이지번호/게시물수)) * (게시물수*페이지수) ) + 1)"
//				+ "where rn > ((페이지번호-1)*게시물수) and rn <= (페이지번호*게시물수)");
		
		String value;

		SQL(String value) {
			this.value = value;
		}
	}

	@Override
	public void create(Mp3Vo vo) throws Exception {
	
		
		new SqlAgent() {
			
			@Override
			protected void doJob() throws Exception {
				
				pstmt = con.prepareStatement(SQL.INSERT.value);
	
				System.out.println(vo.toString());
				//title, dsc, cate, userid, filename, artist, img, albname
				
				pstmt.setString(1,vo.getTitle());
				pstmt.setString(2,vo.getDsc());
				pstmt.setString(3,vo.getCate());
				pstmt.setString(4,vo.getUserid());
				pstmt.setString(5,vo.getFilename());
				pstmt.setString(6,vo.getArtist());
				pstmt.setString(7,vo.getImg());
				pstmt.setString(8,vo.getAlbname());
				
				 int resultCount = pstmt.executeUpdate();

		            if (resultCount < 1) {
		               throw new Exception("MP3_INSERT ERROR");
		            }

				
			}
		}.doExecute();

	}

	@Override
	public Mp3Vo read(Integer no) throws Exception {

		final Mp3Vo vo = new Mp3Vo();

		new SqlAgent() {
	
			
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.SELECT.value);

				pstmt.setInt(1, no);

				rs = pstmt.executeQuery();
				rs.next();

				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setDsc(rs.getString(3));
				vo.setCate(rs.getString(4));
				vo.setUserid(rs.getString(5));
				vo.setFilename(rs.getString(6));
				vo.setRcount(rs.getInt(7));
				vo.setVcount(rs.getInt(8));
				vo.setArtist(rs.getString(9));
				vo.setImg(rs.getString(10));
				vo.setAlbname(rs.getString(11));
				
				   int resultCount = pstmt.executeUpdate();

		            if (resultCount < 1) {
		               throw new Exception("MP3_READ ERROR");
		            }

			}
		}.doExecute();

		return vo;
	}

	@Override
	public void update(Mp3Vo vo) throws Exception {
		 new SqlAgent() {
	         @Override
	         protected void doJob() throws Exception {
	            pstmt = con.prepareStatement(SQL.UPDATE.value);

	            pstmt.setString(1, vo.getTitle());
	            pstmt.setString(2, vo.getDsc());
	            pstmt.setString(3, vo.getCate());
	            pstmt.setString(4, vo.getUserid());
	            pstmt.setString(5, vo.getFilename());
	            pstmt.setInt(6, vo.getRcount());
	            pstmt.setInt(7, vo.getVcount());
	            pstmt.setString(8, vo.getArtist());
	            pstmt.setString(9, vo.getImg());
	            pstmt.setString(10, vo.getAlbname());
	            pstmt.setInt(11, vo.getMno());

	            System.out.println(vo.toString());
	            int resultCount = pstmt.executeUpdate();

	            if (resultCount < 1) {
	               throw new Exception("MP3_UPDATE ERROR");
	            }
	         }
	      }.doExecute();


	}

	@Override
	public void delete(Integer no) throws Exception {
		
		 new SqlAgent(){
	         @Override
	         protected void doJob() throws Exception {
	            pstmt = con.prepareStatement(SQL.DELETE.value);
	            pstmt.setInt(1, no);
	            
	            int resultCount = pstmt.executeUpdate();
	            
	            if(resultCount < 1){
	               throw new Exception("MP3_DELETE ERROR");
	            }
	         }
	         
	      }.doExecute();

	}

	@Override
	public List<Mp3Vo> allread() throws Exception {

		final List<Mp3Vo> voList = new ArrayList<Mp3Vo>();

		new SqlAgent() {

			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.ALLSEL.value);
				
				rs = pstmt.executeQuery();
				rs.next();

//				+ "where mno > 0 and rownum <= (ceil((페이지번호/게시물수)) * (게시물수*페이지수) ) + 1)"
//				+ "where rn > ((페이지번호-1)*게시물수) and rn <= (페이지번호*게시물수)")
				
				//rn, title, filename,artist,img, count(mno) over() cnt
				
				while (rs.next()) {
					Mp3Vo mvo = new Mp3Vo();
					mvo.setRn(rs.getInt(1));
					mvo.setTitle(rs.getString(2));
					mvo.setFilename(rs.getString(3));
					mvo.setArtist(rs.getString(4));
					mvo.setImg(rs.getString(5));
					mvo.setCnt(rs.getInt(6));
					voList.add(mvo);

				}

			}
		}.doExecute();
		return voList;

	}
}