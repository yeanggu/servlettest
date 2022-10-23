package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청브라우저세션객체 가져온다
		/* 최초 브라우저 열고 현재파일 요청 - 세션객체 새로 생성
		 * 브라우저 열려진 상태로 이전 다른 서블릿 실행 후 현재파일 요청 - 이미 생성된 세션객체 가져온다
		 */
		HttpSession session = request.getSession();
		String session_id = null;
		if(session.getAttribute("session_id") != null) {
			session_id = (String)session.getAttribute("session_id");
		}else {
			session_id = "로그인먼저!!";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>로그인하셨습니다</h1>");
		out.println("<h1>"+session_id+" 회원님 환영합니다</h1>");
	}

}
