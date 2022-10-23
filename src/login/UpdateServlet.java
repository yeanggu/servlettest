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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 6개 정보(중 pw, name, address 세개 수정 가능 + 수정불가능한 값)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id,pw,name,phone,email,address);
		dao.updateMember(dto);
		
		//2. 수정된 부분 무엇인지 알려주는 출력 응답
		response.setContentType("text/html;charset=utf-8");//브라우저 전송문서타입 알려주는 형태 
		PrintWriter out = response.getWriter();   //서버가 출력=클라이언로 전송
		out.println(dto.getPassword() +"<br>");
		out.println(dto.getName()+"<br>");
		out.println(dto.getAddress() +"<br>");
		out.println("사항들을 수정하셨습니다.");
		
	}

}
