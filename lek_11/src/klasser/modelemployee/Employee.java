package klasser.modelemployee;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String firstName;
	private String lastName;
	private boolean trainee;
	private int age;
	private int birthday;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String inputFirstName,String inputLastName, int inputAge) {
		firstName = inputFirstName;
		lastName = inputLastName;
		trainee = true;
		age = inputAge;
	}public Employee() {

	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setFornavn(String inputName) {
		firstName = inputName;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getFornavn() {
		return firstName;
	}
	// få fat i efternavn
	public void setLastName(String inputLastName){lastName = inputLastName;}
	public String getLastName(){return lastName;}
	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	// alder
	public void setAge (int inputAge){ age = inputAge;}
	public int getAge(){return age;}
	public void birthday (){
		age++;
	}




	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("first Name " + firstName);
		System.out.println("last Name " + lastName);
		System.out.println("Trainee " + trainee);
		System.out.println("alder er " + age);

	}


	/*
	 * Returnerer en kort tekst repræsentation af objektet
	 */
//	public String toString(){
//		return name;
//	}
}
