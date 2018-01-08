package com.oraclejava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oraclejava.model.Encryption;
import com.oraclejava.model.Member;
import com.oraclejava.model.MemberDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/account/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberid = request.getParameter("memberid");
		
		final String algorithmNm = "SHA-256";
		String passwd = request.getParameter("passwd");
		
		Encryption e = new Encryption(algorithmNm);
		byte[] bytes = e.toHashValue(passwd); 
 		passwd = e.toEncryptedString(bytes);
		
		MemberDao dao = new MemberDao();
		
		//if(memberid.equals("oraclejava") && passwd.equals("1")) {
		if(dao.selectMemberByIdAndPw(memberid, passwd) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", memberid);
			response.sendRedirect(request.getContextPath());
		} else {
			response.sendRedirect(request.getContextPath() + "/jsp/account/login.jsp");
		}
	}

}
