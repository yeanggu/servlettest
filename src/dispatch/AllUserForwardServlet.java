package dispatch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/alluserforward")
public class AllUserForwardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.selectMember();//모든사용자조회

		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		for( MemberDTO dto : list ) {
			//out.println(dto.getId() + " : " + dto.getName()+"<br>");
			out.println(dto + "<br>");
		 */			
		
		//list 전달하여 alluserlist 서블릿 이동
		//@WebServlet("/alluserlist")
		request.setAttribute("memberlist", list);
		RequestDispatcher rd = request.getRequestDispatcher("alluserlist");
		rd.forward(request, response);
	}

}
