package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {
//get방식요청 -  init 1번 호출 - doGet 요청할때마다 호출   - 브라우저 응답 출력   - 
// 서블릿코드 수정-재컴파일(자동)-서버 서블릿 reload(이전 서블릿 삭제)	- destroy
	
	int count = 0;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버 시스템 콘솔창 출력
		System.out.println("===doGet 호출중(수정)===");
		response.getWriter().append("<h1>" + ++count + "</h1>");
	}

	@Override
	public void destroy() {
		System.out.println("===destroy 호출중===");
		//초상태변수값 메모리정리
	}

	@Override
	public void init() throws ServletException {
		System.out.println("===init 호출중===");
		//서블릿 최초상태변수값 설정

	}


}
