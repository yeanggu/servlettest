package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="a" , urlPatterns = {"/loginsession"} )
public class LoginSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id, pw  입력받아 로그인정보 받아온다
		//세션 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// db 정상로그인사용자 인증 상태 구현 생략
		
		//요청브라우저세션객체 가져온다
		/* 최초 브라우저 열고 현재파일 요청 - 세션객체 새로 생성
		 * 브라우저 열려진 상태로 이전 다른 서블릿 실행 후 현재파일 요청  - 이미 생성된 세션객체 가져온다  */
		HttpSession session = request.getSession();
		session.setAttribute("session_id", id);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id != null & pw != null) {
			out.println("<h1>로그인하셨습니다</h1>");
			out.println("<h1>사용 가능 메뉴는 다음과 같습니다.</h1>");
			out.println("<ul><li><a href=mypage> 내정보확인하러 가기 </a></li>");
			out.println("<li><a href=boardwriting> 글쓰러 가기 </a></li>");
			out.println("<li><a href=logout> 로그아웃하러 가기 </a></li></ul>");
		}
		else {
			out.println("<h1>로그인정보를 입력하세요</h1>");
		}
		
	}

}




