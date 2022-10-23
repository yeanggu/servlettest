package dispatch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;

@WebServlet("/alluserlist")
public class AllUserListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 회원정보가져오기 처리 - alluserforward 서블릿 전달받은 list 
		ArrayList<MemberDTO> list = 
				(ArrayList<MemberDTO>)request.getAttribute("memberlist");
		//출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for( MemberDTO dto : list ) {
			//out.println(dto.getId() + " : " + dto.getName()+"<br>");
			out.println(dto + "<br>");
		}//FOR END
	}
}
