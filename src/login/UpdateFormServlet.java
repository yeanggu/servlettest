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

//?id=aaa&pw=1234
@WebServlet("/updateform")
public class UpdateFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id,pw 입력받아서 db 해당 아이디 pw 맞다면 회원 정보 가져와서 수정폼 미리 입력
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.updateFormMember(id, pw);
		//select * from member_table where id=? and password=?
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(dto != null) {
			//dto 모든 정보 html form 양식으로 보여주자
			String printing = "<form action = >";
			printing += "아이디(수정불가)<input type=text name=id value="+dto.getId()+"readonly><br>";
			printing += "암호변경<input type=text name=password value="+dto.getPassword()+"><br>";
			printing += "이름변경<input type=text name=name value="+dto.getName()+"><br>";
			printing += "폰번호(수정불가)<input type=text name=phone value="+dto.getPhone()+"readonly><br>";
			printing += "이메일(수정불가)<input type=text name=email value="+dto.getEmail()+"readonly><br>";
			printing += "주소변경<input type=text name=address value="+dto.getAddress()+"><br>";
			printing += "<input type=submit value=수정><br></form>";
			out.println(printing);
		}else {
			out.println("<h1>해당 회원 정보는 찾을 수 없습니다</h1>");
		}
		
	}

}
