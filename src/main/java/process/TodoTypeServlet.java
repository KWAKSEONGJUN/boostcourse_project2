package process;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

/**
 * Servlet implementation class TodoTypeServlet
 */
@WebServlet("/TodoTypeServlet")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDao dao = new TodoDao();
	
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		
		System.out.println("id : " + id);
		
		if(type.compareTo("TODO") == 0) {
			dao.updateTodo(new TodoDto(id, "DOING"));
		} else {
			dao.updateTodo(new TodoDto(id, "DONE"));
		}
	}

}
