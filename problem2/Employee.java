
/* bz2309
 * Beichen Zhang
 * E3.11 in Big Java
 */
public class Employee {
	private String name;
	private double salary;
	public Employee(String employeeName, double currentSalary){
		name = employeeName;
		salary = currentSalary;
	}
	public String getName(){
		 return name;
	}
	public double getSalary(){
		return salary;
	}
	public void raiseSalary(double byPercent) {
		salary += (byPercent*salary/100);
	}
}
