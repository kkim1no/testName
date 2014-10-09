package org.han.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayerController
 */
@WebServlet("/player")
public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fileName= req.getParameter("song");
		
		System.out.println(fileName);
		
		req.setAttribute("fileName", fileName);
		
	FileInputStream fin = new FileInputStream("C:\\zzz\\"+fileName);
		
		OutputStream fos = res.getOutputStream();
		
		byte[] buf = new byte[1024 * 8];
		while (true) {
			int count = fin.read(buf);
			if (count == -1) {
				break;
			}
			fos.write(buf,0, count);
		}

		fin.close();
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Mp3play.jsp");
		
	
		dispatcher.forward(req, res);
					
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
