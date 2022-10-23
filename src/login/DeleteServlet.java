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


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 파라미터 id 읽어온다
		String id = request.getParameter("id");
		if(id == null) {id="손님";}
		
		//MemberDAO객체 deleteMember(요청 파라미터 id값);
		MemberDAO dao = new MemberDAO();
		int i = dao.deleteMember(id);
		
		response.setContentType("text/html;charset=utf-8");//브라우저 전송문서타입 알려주는 형태 
		PrintWriter out = response.getWriter();   //서버가 출력=클라이언로 전송
		out.println("<h3>"+id+"회원님 정보가 삭제되었습니다.</h3>");
		//delete from 테이블명 where id='multi2'
		
		
	}

}
