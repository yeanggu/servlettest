package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

	@Override
	//<FORM METHOD=POST 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//html 입력데이터 한글 전송받기
		doGet(request, response);

	}
//<FORM METHOD=GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form 입력정보 추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] hobby = request.getParameterValues("hobby");
		
		//MemberDTO객체생성-- MemberDAO 전달 목적
		MemberDTO dto = new MemberDTO(id, pw, name, phone, email,address);
		MemberDAO dao = new MemberDAO();// member.txt파일 저장
		dao.insertMember(dto);
		// html-->servlet--> dto-->dao--> db
		
	//브라우저 인식 내용 타입 - text/plain text/html images/jpg  audio/mp3
		response.setContentType("text/html;charset=utf-8");//서블릿 처리 생성 한글 브라우저 전송하기
		PrintWriter out = response.getWriter();
		out.println("<h1>" + id + "<h1>");
		out.println("<h1>" + pw + "<h1>");
		out.println("<h1>" + name + "<h1>");
		out.println("<h1>" + phone + "<h1>");
		out.println("<h1>" + email + "<h1>");
		out.println("<h1>" + address + "<h1>");
		for(int i = 0; i < hobby.length; i++) {
			out.println("<h1>" + hobby[i] + "<h1>");
		}
	}
}
