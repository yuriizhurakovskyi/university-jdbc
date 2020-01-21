package lgscourse.javaadvanced.homeworks.university;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LectorMapper {
	public static Lector map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		Degree degree = Degree.valueOf(result.getString("degree"));
		Lector lector = new Lector(id, firstName, lastName, degree);
		return lector;
	}
}
