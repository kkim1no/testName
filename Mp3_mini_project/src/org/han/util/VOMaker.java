package org.han.util;

import java.sql.ResultSetMetaData;

public class VOMaker {
	public static void main(String[] args) throws Exception{
		
		String query = "select * from tbl_mp3 where rownum =1";
		
		new SqlAgent(){

			@Override
			protected void doJob() throws Exception {
				// TODO Auto-generated method stub
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				ResultSetMetaData mete = rs.getMetaData();
				int colClount = mete.getColumnCount();
				System.out.printf("ÄÃ·³¼ö %d \n", colClount);
				
				for (int i = 1; i <= colClount; i++) {
					
					int type = mete.getColumnType(i);
					//System.out.println(type);
					String javaType = getType(type);
					
					String name = mete.getColumnName(i).toLowerCase();
					//System.out.println(name);
					
					System.out.printf("private %s %s; \n",javaType, name);
					
				}
			
				
			}
			private String getType(int type){
				
				String result = "String";
				
				switch (type) {
				case 2:
					result = "Integer";
					break;
					
				case 93:
					result = "Date";
					break;

				default:
					break;
				}
				
				
				return result;
			}	
		}.doExecute();
		
	}
}
