package CRUDApp;

public class Query {
	static String insert = "INSERT INTO employees (id,name,mail,salary) VALUES (?,?,?,?)";
	static String update = "UPDATE employees SET name = ?, mail=?, salary=? WHERE id = ?";
	static String delete = "DELETE FROM employees WHERE ID = ?";
	static String select = "SELECT * FROM employees";
}
