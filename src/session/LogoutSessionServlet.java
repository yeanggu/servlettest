package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String printing = "";
		HttpSession session = request.getSession();
		if(session.getAttribute("session_id") != null) {
			printing = "<h1>"+session.getAttribute("session_id")+" 회원님";
			session.removeAttribute("session_id");
			//session.removeAttribute("cart");
			//session.invalidate();//세션 무효화(세션 모든 속성 삭제)
			//session.setMaxInactiveInterval(60*30);
			
			printing +=" 로그아웃하셨습니다</h1>";
			System.out.println(session.getAttribute("session_id"));
		}else {
			printing = " <h1><a href=loginsession > 로그인 먼저 하세요</a></h1>";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(printing);
	}

}
