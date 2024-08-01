package CRUDApp;

public class Employee {
	int empID, empsal;
	String empname, empmail;
	Employee(int empID, int empsal, String empname, String empmail){
		this.empID = empID;
		this.empsal = empsal;
		this.empname = empname;
		this.empmail = empmail;
	}
	
	public int getID() {
		return empID;
	}
	
	public int getSal() {
		return empsal;
	}
	
	public String getName() {
		return empname;
	}
	
	public String getMail() {
		return empmail;
	}
	
	public String toString() {
		return "Employee[id = "+empID+" ,name = "+empname+" ,mail = "+empmail+" Salary = "+empsal+"]";
	}
}
