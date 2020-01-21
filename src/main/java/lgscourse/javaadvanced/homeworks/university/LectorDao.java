package lgscourse.javaadvanced.homeworks.university;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LectorDao {
	private static String CREATE = "insert into `lector`(`first_name`, `last_name`, `degree`) values (?, ?, ?)";
	private static String READ_BY_ID = "select * from lector where id = ?";
	private static String READ_ALL = "select * from lector";
	private static String UPDATE_BY_ID = "update lector set first_name=?, last_name=?, degree=? where id = ?";
	private static String DELETE_BY_ID = "delete from lector where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public LectorDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(Lector lector) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, lector.getFirstName());
		preparedStatement.setString(2, lector.getLastName());
		preparedStatement.setString(3, lector.getDegree().name());
		preparedStatement.executeUpdate();
	}

	public Lector read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return LectorMapper.map(result);
	}

	public void update(Lector lector) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, lector.getFirstName());
		preparedStatement.setString(2, lector.getLastName());
		preparedStatement.setString(3, lector.getDegree().name());
		preparedStatement.setInt(4, lector.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Lector> readAll() throws SQLException {
		List<Lector> listLectors = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listLectors.add(LectorMapper.map(result));
		}
		return listLectors;
	}

}
