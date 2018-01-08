package com.oraclejava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.model.AlreadyEntryException;
import com.oraclejava.model.Encryption;
import com.oraclejava.model.Member;
import com.oraclejava.model.MemberService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/account/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			MemberService service = new MemberService();
			
			Member member = new Member();
			member.setMemberId(request.getParameter("memberid"));
			
			final String algorithmNm = "SHA-256";
			String passwd = request.getParameter("passwd");
			
			Encryption e = new Encryption(algorithmNm);
			byte[] bytes = e.toHashValue(passwd); 
	 		passwd = e.toEncryptedString(bytes);
			
			member.setPasswd(passwd);
			member.setEmail(request.getParameter("email"));
			member.setUserType("user");
			member.setActive("1");
			
			service.insertMember(member);
			
			response.sendRedirect(request.getContextPath() + "/jsp/account/login.jsp");
			
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

}
