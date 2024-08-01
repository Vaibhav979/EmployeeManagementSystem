package CRUDApp;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	//insert
	public void insertEmployee(Employee employee) throws SQLException {
		try (Connection conn = Databaseutility.connect(); PreparedStatement stm = conn.prepareStatement(Query.insert)) {
			stm.setInt(1, employee.getID());
			stm.setString(2, employee.getName());
			stm.setString(3, employee.getMail());
			stm.setInt(4, employee.getSal());
			stm.executeUpdate();
		}
	}
	
	//read
	public List<Employee> read() throws SQLException{
		List<Employee> employees = new ArrayList<>();
		try(Connection conn = Databaseutility.connect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(Query.select)){
			while(rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getInt(4), rs.getString(3), rs.getString(2));
				employees.add(employee);
			}
		}
		return employees;
	}
	
	//update
	public void update(Employee employee) throws SQLException{
		try(Connection conn = Databaseutility.connect(); PreparedStatement stmt = conn.prepareStatement(Query.update)){
			stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getMail());
            stmt.setInt(3, employee.getSal());
            stmt.setInt(4, employee.getID());
            stmt.executeUpdate();
		}
	}
	
	//delete
	public void delete(int id) throws SQLException{
		try(Connection conn = Databaseutility.connect(); PreparedStatement stm = conn.prepareStatement(Query.delete)){
			stm.setInt(1, id);
            stm.executeUpdate();
		}
	}
}
