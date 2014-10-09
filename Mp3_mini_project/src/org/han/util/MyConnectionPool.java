package org.han.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Vector;

public class MyConnectionPool {

	List<Connection> conList;
	
	private int idx = 0; 
	
	private static MyConnectionPool instance = new MyConnectionPool();
	
	public static MyConnectionPool getInstance(){
		return instance;
	}
	
	private MyConnectionPool(){
		try{
			conList = new Vector<Connection>();
			Class.forName("oracle.jdbc.OracleDriver");
			
			String urlPath = "jdbc:oracle:thin:@61.72.16.181:5021:ORCL";
			String userName = "han01";
			String pw = "han01";
			
			for(int i = 0; i < 10; i++){				
				conList.add(
				 new MyConnection(
						 DriverManager.getConnection(urlPath,userName,pw),
						 this));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()throws Exception{
		
		return conList.remove(0);
		
	}
	
	public void returnConnection(Connection con)throws Exception{
		
		conList.add(con);
	}
	
}






