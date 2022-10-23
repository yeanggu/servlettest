package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieset")
public class CookieSetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 로그인 id 파라미터 입력받아서 쿠키로 저장
		String id = request.getParameter("id");
		Cookie id_cookie = new Cookie("c_id", id);
		id_cookie.setMaxAge(60*60*24);
		
		// db id 입력값 name 조회 가정
		Cookie name_cookie = new Cookie("c_name", "김삼성");
		
		//로그인 시각 쿠키로 저장
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Cookie time_cookie = new Cookie("c_time", 
				java.net.URLEncoder.encode(sdf.format(now) , "utf-8"));
		
		response.addCookie(id_cookie);
		response.addCookie(name_cookie);
		response.addCookie(time_cookie);
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>쿠키를 저장하였습니다</h1>");
	
	}

}




