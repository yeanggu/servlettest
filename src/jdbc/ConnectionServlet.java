package jdbc;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			for(int i=1;i<=1000;i++) {
				Connection conn = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
				System.out.println(i+" 번째 mysql db연결성공");
				conn.close();
			*/
			
			//1. context = dynamic web project
			 //servlettest 관련설정 가능 
			 Context initContext = new InitialContext();
			//2. context.xml : 설정 읽어와라.
			 Context envContext = (Context)initContext.lookup("java:/comp/env"); 
			//3. name=jdbc/myoracle 설정 객체 읽어와라
			 //ds = connectionpool 객체 
			 DataSource ds = (DataSource)envContext.lookup("jdbc/mydb"); 
			//4. connectionpool 객체 con 빌려와라
			 for(int i=1;i<=1000;i++) {
				 Connection conn = ds.getConnection();
				 System.out.println(i+"번째 mysql db연결성공");
				 conn.close();
			 }
			 
			 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
