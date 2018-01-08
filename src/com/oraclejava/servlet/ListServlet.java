package com.oraclejava.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oraclejava.model.Bbs;
import com.oraclejava.model.BbsDao;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/bbs/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath() + "/jsp/account/login.jsp");
			return;
		} 
	
		BbsDao dao = new BbsDao();
		List<Bbs> list = dao.selectBbs();
		
		request.setAttribute("bbsList", list);
		
		// request에 현재 조회 데이터를 담아 해당 url로 전송 
		getServletContext().getRequestDispatcher("/jsp/bbs/list.jsp").forward(request, response);
	}
}
