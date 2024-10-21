package klasser.modelemployee;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans","jensen",32);
		e1.printEmployee();
		e1.setFornavn("Viggo");
		e1.printEmployee();
		e1.birthday();
		System.out.println("efter fødseldag" + e1.getAge());
		e1.printEmployee();





		System.out.println(e1);
		System.out.println("Navn: " + e1.getFornavn());

		Employee e2 = new Employee();
		System.out.println(e2);
		e2.printEmployee();
		System.out.println("Navn: " + e2.getFornavn());


	}

}
