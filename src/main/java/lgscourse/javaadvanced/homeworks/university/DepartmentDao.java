package lgscourse.javaadvanced.homeworks.university;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
	private static String CREATE = "insert into department(`name`) values (?)";
	private static String READ_BY_ID = "select * from department where id = ?";
	private static String READ_ALL = "select * from department";
	private static String UPDATE_BY_ID = "update department set name=? where id = ?";
	private static String DELETE_BY_ID = "delete from department where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public DepartmentDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(Department department) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, department.getName());
		preparedStatement.executeUpdate();
	}

	public Department read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return DepartmentMapper.map(result);
	}

	public void update(Department department) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, department.getName());
		preparedStatement.setInt(2, department.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Department> readAll() throws SQLException {
		List<Department> departments = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			departments.add(DepartmentMapper.map(result));
		}
		return departments;
	}
}
