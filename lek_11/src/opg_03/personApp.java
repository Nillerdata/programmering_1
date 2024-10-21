package opg_03;

public class personApp {

    //main
    public static void main (String[] args){
        Person p1 = new Person("john","Kalundvej 12",20.0);
        p1.setName("Bo");
        p1.setAdress("klokkevej 12");
        p1.setMonthlySalary(25000);
        p1.setNumberOfFirm(2);
        p1.newFirm();
        p1.printperson();

    }
}
