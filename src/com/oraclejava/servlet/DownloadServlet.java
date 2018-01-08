package com.oraclejava.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.model.Bbs;
import com.oraclejava.model.BbsDao;
import com.oraclejava.model.BbsFile;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/bbs/Download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bbsFileNo = Integer.parseInt(request.getParameter("bbsFileNo"));
		
		BbsDao dao = new BbsDao();
		BbsFile bbsFile = dao.selectBbsFileByBbsFileNo(bbsFileNo);
		
		// 서버 내 파일 경로 가져옴
		String file = "c:/upload/" + bbsFile.getSavedFileName();
		
		// 해당 파일로 inputstream 생성
		FileInputStream fis = new FileInputStream(file);
		
		// 파일의 mimetype 설정
		String mimetype = getServletContext().getMimeType(file);
		
		if(mimetype == null) {
			mimetype = "application/octet-stream";
		}
		
		// Response 객체 설정 (한글 인코딩 포함)
		String fileName = URLEncoder.encode(bbsFile.getUserFileName(), "UTF-8");
		
		response.setContentType(mimetype + ";charset=UTF-8");
		response.setHeader("Content-Disposition"
				, "attachment;filename=" + fileName);
		
		// ServletOutputStream으로 btye단위로 읽어서 전송 
		ServletOutputStream sos = response.getOutputStream();
		
		// DownloadCount 증가
		dao.updateBbsFileDownloadCountByBbsFileNo(bbsFileNo);
		
		int numRead = 0;
		
		byte[] b = new byte[4096];
		while((numRead = fis.read(b, 0, b.length)) != -1) {
			sos.write(b, 0, numRead);
		}
		
		sos.flush();
		sos.close();
		fis.close();
	}

}
