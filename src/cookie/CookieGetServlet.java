package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieget")
public class CookieGetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//cookie c_id 이름 쿠키 가져와서 로그인 id로 사용
		Cookie[] c_array = request.getCookies();
		for(Cookie c : c_array) {
			out.println("<h1>쿠키이름=" + c.getName() +"</h1>");
			out.println("<h1>쿠키값=" + 

java.net.URLDecoder.decode(c.getValue() , "utf-8") +"</h1>");
		}
	
	}

}






