package context;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbget2")
public class DBGetServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		DBInform db = (DBInform)context.getAttribute("share_db");
		
		try {
			Class.forName(db.getDriverName());
			Connection con = DriverManager.getConnection(db.getJdbcUrl(), db.getAccount()
					, db.getPassword());
			PreparedStatement pt = 
			con.prepareStatement("select avg(salary) from employees");
			ResultSet rs = pt.executeQuery();
			rs.next();
			
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + rs.getInt("avg(salary)") + " -- 사원급여평균 </h1>");
		
		context.removeAttribute("share_db");//getAttribute호출불가능
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
