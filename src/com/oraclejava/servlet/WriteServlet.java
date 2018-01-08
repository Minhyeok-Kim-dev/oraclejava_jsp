package com.oraclejava.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.oraclejava.model.Bbs;
import com.oraclejava.model.BbsDao;
import com.oraclejava.model.BbsFile;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/bbs/Write")
@MultipartConfig(
	fileSizeThreshold = 5_242_880,	// 5MB	
	maxFileSize = 20_971_520L,		// 20MB	
	maxRequestSize = 41_943_040L	// 40MB	
)
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
		
		getServletContext().getRequestDispatcher("/jsp/bbs/writeForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("attach");
		String originalName = this.getFileName(part);
		
		Date date = new Date();
		SimpleDateFormat fommatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = fommatter.format(date);
		String savedFileName = now + "_" + originalName;
		
		File file = new File("c:/upload/" + savedFileName); 
		try (InputStream is = part.getInputStream()) {
				Files.copy(is, file.toPath());
		} catch(Exception e) {
			
		}
		
		Bbs bbs = new Bbs();
		
		bbs.setTitle(request.getParameter("title"));
		bbs.setUploader((request.getParameter("uploader")));
		bbs.setContent((request.getParameter("content")));
	
		BbsDao dao = new BbsDao();
		dao.insertBbs(bbs);
		
		BbsFile bbsFile = new BbsFile();
		bbsFile.setBbsNo(bbs.getBbsNo());
		bbsFile.setSavedFileName(savedFileName);
		bbsFile.setUserFileName(originalName);
		
		dao.insertBbsFile(bbsFile);
		
		response.sendRedirect(request.getContextPath() + "/bbs/List");
	}

	private String getFileName(Part part) {
		String name = "";
		
		for(String disposition : part.getHeader("Content-Disposition").split(";")) {
			if(disposition.trim().startsWith("filename")) {
				name = disposition.substring(disposition.indexOf("=") + 1)
						.replace("\"", "").trim();
				
				name = name.substring(name.lastIndexOf("\\") + 1);
			}
		}
		return name;
	}
}
