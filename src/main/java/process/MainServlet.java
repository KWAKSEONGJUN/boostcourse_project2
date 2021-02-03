package process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TodoDto> todos = new ArrayList<>();
		
		TodoDao dao = new TodoDao();		
		todos = dao.getTodos();
		
		List<TodoDto> todo = new ArrayList<>();
		List<TodoDto> doing = new ArrayList<>();
		List<TodoDto> done = new ArrayList<>();
		
		for(int i=0; i<todos.size(); i++) {
			if(todos.get(i).getType().compareTo("TODO") == 0 ) {
				todo.add(todos.get(i));
			}
			else if(todos.get(i).getType().compareTo("DOING") == 0) {
				doing.add(todos.get(i));
			}
			else {
				done.add(todos.get(i));
			}
		}
	
		request.setAttribute("todo", todo);
		request.setAttribute("doing", doing);
		request.setAttribute("done", done);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
	    requestDispatcher.forward(request, response);
	}

 //주석주석주석주
}
