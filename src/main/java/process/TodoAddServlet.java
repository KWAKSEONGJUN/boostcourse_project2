package process;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		String work = null;
		String name = null;
		Integer priority = 0;

		try {
			work = request.getParameter("work");
			name = request.getParameter("name");
			priority = Integer.parseInt(request.getParameter("priority"));
		}catch(Exception e) {
			out.println("<script>alert('입력을 완료해주세요.');</script> location.href='http://localhost:8080/mylist/upload.jsp';");
			out.flush();
		}
	
		
		TodoDto todo = new TodoDto(name, priority, work);
		
		TodoDao dao = new TodoDao();
		dao.addTodo(todo);
		
		out.println("<script>alert('등록 완료 :)');location.href='http://localhost:8080/mylist/MainServlet';</script>");
		out.flush();

		//response.sendRedirect("http://localhost:8080/mylist/main.jsp");
	}

}
