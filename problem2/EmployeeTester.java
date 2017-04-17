
/* bz2309
 * Beichen Zhang
 * E3.11 in Big Java
 */
public class EmployeeTester {
	public static void main(String[] argv){
		Employee emp = new Employee("Harry Potter", 243242);
		System.out.printf("%s's salary is %.2f\n",
				emp.getName(),emp.getSalary());
		emp.raiseSalary(20.0);
		System.out.printf("%s's new salary is %.2f\n",
				emp.getName(),emp.getSalary());
		System.out.printf("%s's new salary is expected to be %.2f\n\n",
				emp.getName(),243242*(1.2));
		Employee emp1 = new Employee("David Raborson", 6465465);
		System.out.printf("%s's salary is %.2f\n",
				emp1.getName(),emp1.getSalary());
		emp1.raiseSalary(62.0);
		System.out.printf("%s's new salary is %.2f\n",
				emp1.getName(),emp1.getSalary());
		System.out.printf("%s's new salary is expected to be %.2f\n",
				emp1.getName(),6465465*(1.62));
	}
}
