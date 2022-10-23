package dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;

@WebServlet("/forward3")
public class ForwardServlet3 extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//요청 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	//MemberDTO 타입 객체 생성
	MemberDTO dto = new MemberDTO(id, pw, name, phone, email, address);
	//처리(구현생략)
	//응답
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	//out.println("<h1> forward1  출력= " + id + "</h1>");

	//다른 파일로 이동 응답. servlet 이동 + html 이동 + jsp 이동(같은 컨텍스트내부)
	RequestDispatcher rd = request.getRequestDispatcher("forward4");
	//	RequestDispatcher rd = request.getRequestDispatcher("loginservlet.html");
	request.setAttribute("dto", dto);
	rd.forward(request, response); //자동 현재파일 out 출력 저장 내용 삭제
	
	//out.println("<h1> forward1  출력= " + id + "</h1>");
}

}




