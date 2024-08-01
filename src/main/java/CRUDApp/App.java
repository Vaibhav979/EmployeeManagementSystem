package CRUDApp;

import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
		EmployeeDAO dao = new EmployeeDAO();
		int ch;
		do {
			System.out.println("1.Create");
			System.out.println("2.Display");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			ch = sc.nextInt();

			switch (ch) {

			// insert
			case 1:
				System.out.println("id, name, mail, salary");
				int id = sc.nextInt();
				sc.nextLine();
				String name = sc.nextLine();
				String mail = sc.nextLine();
				int sal = sc.nextInt();

				Employee emp = new Employee(id, sal, name, mail);
				try {
					dao.insertEmployee(emp);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			// read
			case 2:
				try {
					List<Employee> employees = dao.read();
					for (Employee employee : employees) {
						System.out.println(employee.getID() + " - " + employee.getName() + " - " + employee.getMail()
								+ " - " + employee.getSal());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			// update
			case 3:
				System.out.println("Enter the ID of the employee to be Updated.");
				int ID = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter new name, email, salary:");
				String newname = sc.nextLine();
				String newmail = sc.nextLine();
				int newsal = sc.nextInt();

				Employee updateEmp = new Employee(ID, newsal, newname, newmail);
				try {
					dao.update(updateEmp);
					System.out.println("Employe updated successfully.");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			// delete
			case 4:
				System.out.println("Enter id of the employee to delete:");
				int deleteId = sc.nextInt();
				try {
					dao.delete(deleteId);
					System.out.println("Employee deleted successfully.");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 0: // Exit
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (ch != 0);
	}
}
