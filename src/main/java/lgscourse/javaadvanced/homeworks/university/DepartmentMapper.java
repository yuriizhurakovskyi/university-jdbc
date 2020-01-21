package lgscourse.javaadvanced.homeworks.university;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper {
	public static Department map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		Department department = new Department(id, name);
		return department;
	}
}
