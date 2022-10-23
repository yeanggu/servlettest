package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

//http://localhost:9090/servlettest/logindb

@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청정보에서 id, pw 추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//처리
		
		//MemberDTO객체생성-- MemberDAO 전달 목적
		
		MemberDAO dao = new MemberDAO();// member.txt파일 저장
	
		// html-->servlet--> dto-->dao--> db
		
		int result = dao.selectMember(id,pw);
	
		String printing = "";
		if(result == 0) {
			printing = "<h3 style=color:green>"+id+ " 회원님 정상 로그인되셨습니다.</h3>";
			printing += "<h3><a href = alluser> 모든 회원 리스트 조회 </a></h3>";
			printing += "<h3><a href = paiginguser> 페이지처리 회원 리스트 조회 </a></h3>";
			printing += "<h3><a href = updateform?id="+id+"&pw="+pw+"> 자기정보 조회 및 수정 </a></h3>";
			printing += "<h3><a href = delete?id="+id+">회원탈퇴</a></h3>";
		}else if(result == 1) {
			printing = "<h3 style=color:blue>"+id+ " 회원님 암호 확인하세요.</h3>";
			printing += "<a href=logindbservlet2.html> 다시 로그인 하러가기</a>";
		}else if(result == 2) {
			printing = "<h3 style=color:red>"+id+ " 는 존재하지 않습니다.</h3>";
			printing += "<a href=insertservlet.html2.html>회원가입하러가기</a>";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//서버가 출력-> 클라이언트 전송
		out.println(printing);
		
		//결과 응답(브라우저 한글인코딩-컴퓨터(????) - 서블릿(utf-8)
//		out.println("<h3 style='color:green' > 입력하신 아이디는" + id +  " 이고 암호는" +pw + "입니다</h3>");
//		out.println("<h3> 정상적으로 로그인외셨습니다. </h3> ");
		
	}	
}
