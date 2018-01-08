package com.oraclejava.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oraclejava.model.Bbs;
import com.oraclejava.model.BbsDao;
import com.oraclejava.model.BbsFile;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/bbs/Detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		
		int bbsNo = Integer.parseInt(request.getParameter("bbsNo"));
		
		BbsDao dao = new BbsDao();
		
		String read_count = "0";
		
		// 쿠키 통해 동일유저 재방문시 조회수 증가 방지
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("isUpdated")) {
					read_count = c.getValue();
					break;
				}
			}
		}
	
		String new_read_count = "|" + bbsNo;
		
		if(new_read_count.indexOf(read_count) == -1) {
			Cookie cookie = new Cookie("read_count", read_count + new_read_count);
			response.addCookie(cookie);
			dao.updateBbsReadCountByBbsNo(bbsNo);
		}
		
		Bbs bbs = dao.selectBbsByBbsNo(bbsNo);
		
		List<BbsFile> files = dao.selectBbsFilesByBbsNo(bbsNo);
		
		request.setAttribute("bbs", bbs);
		request.setAttribute("bbsFile", files);
		
		getServletContext().getRequestDispatcher("/jsp/bbs/detail.jsp").forward(request, response);
	}
}
