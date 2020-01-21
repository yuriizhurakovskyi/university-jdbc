package lgscourse.javaadvanced.homeworks.university;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DepartmentDao departmentDao = new DepartmentDao(ConnectionUtils.openConnection());
		LectorDao lectorDao = new LectorDao(ConnectionUtils.openConnection());

		List<Department> lDepartments = new ArrayList<>();
		lDepartments.add(new Department("NHJD"));
		lDepartments.add(new Department("SRYS"));
		lDepartments.add(new Department("YTFD"));
		lDepartments.add(new Department("TYGD"));
		lDepartments.add(new Department("HTCS"));

		List<Lector> lectors = new ArrayList<>();
		lectors.add(new Lector("Inge", "Klarts", Degree.ASSISTANT));
		lectors.add(new Lector("Max", "Klein", Degree.ASSOCIATE_PROFESSOR));
		lectors.add(new Lector("Leon", "Vic", Degree.PROFESSOR));
		lectors.add(new Lector("Moriz", "Petrov", Degree.PROFESSOR));
		lectors.add(new Lector("James", "Brown", Degree.ASSOCIATE_PROFESSOR));

//		// INSERT
//		lDepartments.forEach(department -> {
//			try {
//				departmentDao.insert(department);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});
//
//		lectors.forEach(lector -> {
//			try {
//				lectorDao.insert(lector);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});

		// READ-ALL
		System.out.println("Departments: \n");
		departmentDao.readAll().stream().forEach(System.out::println);
		System.out.println("\nLectors: \n");
		lectorDao.readAll().stream().forEach(System.out::println);
		System.out.println("===================================================================\n");

		// READ-BY-ID
		Department departmentFromDB = departmentDao.read(3);
		System.out.println(departmentFromDB);
		Lector lectorFromDB = lectorDao.read(3);
		System.out.println(lectorFromDB);
		System.out.println("===================================================================\n");

		// UPDATE - ById
		departmentFromDB.setName("IHSN");
		lectorFromDB.setLastName("Neumann");
		departmentDao.update(departmentFromDB);
		lectorDao.update(lectorFromDB);
		System.out.println("===================================================================\n");

		// READ-BY-ID
		departmentFromDB = departmentDao.read(3);
		lectorFromDB = lectorDao.read(3);
		System.out.println(departmentFromDB);
		System.out.println(lectorFromDB);
		System.out.println("===================================================================\n");

		// DELETE
		departmentDao.delete(4);
		lectorDao.delete(4);

		// READ-ALL
		System.out.println("Departments: \n");
		departmentDao.readAll().stream().forEach(System.out::println);
		System.out.println("Lectors: \n");
		lectorDao.readAll().stream().forEach(System.out::println);
		System.out.println("===================================================================\n");
	}

}
