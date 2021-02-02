package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.TodoDto;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);) {
			
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			
			insertCount = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return insertCount;
		
	}
	
	public List<TodoDto> getTodos() {
		List<TodoDto> todos = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String sql = "select * from todo";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);) {
			
		rs = ps.executeQuery();
		
		while(rs.next()) {
			todos.add(new TodoDto(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("regDate"),
					rs.getInt("sequence"),
					rs.getString("title"),
					rs.getString("type")));
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return todos;
		
	}
	
	public int updateTodo(TodoDto todo) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String sql = "update todo set type = ? where id = ?";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);) {
			
			ps.setString(1, todo.getType());
			ps.setInt(2, todo.getId());
			
			
			updateCount = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return updateCount;
	}
}
