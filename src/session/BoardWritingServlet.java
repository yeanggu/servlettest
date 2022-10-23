package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardwriting")
public class BoardWritingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//if(session.getAttribute("session_id") != null
		String session_id = (String)session.getAttribute("session_id");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*String printing = "<h1>글쓰기 폼</h1>";
		printing += "<table>";
		printing += "<tr><td>제목</td><td><input type=text name=\"title\"></td></tr>";
		printing += "<tr><td>내용</td><td><textarea name=\"contents\" row=5 cols=50></textarea></td></tr>";
		printing += "<tr><td>작성자</td><td><input type=text name=\"writer\" value=" + session_id + " readonly></td></tr>";
		printing += "</table>";*/
		
		String printing = "";
				
		//out.println("<h1>"+session_id+" 회원님 글쓰기 가능합니다</h1>");
		out.println(printing);		
	}

}
