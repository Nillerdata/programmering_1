package opg_03;

public class Person {
    //attributter der beskriver den ansattes tilstand
    private String name;
    private String adress;
    private double monthlySalary;
    /*redundant info da måned og årsløn hænger sammen.
    bedre at lave beregningen ud fra objektets tilstand.
     ergo er yearly pay bare monthlysalary * 12*/
    private double yearlypay;
    private int numberOfFirms;

    // constructor
    public Person(String inputname, String inputAdress, double inputMonthlySalary) {
        name = inputname;
        adress = inputAdress;
        monthlySalary = inputMonthlySalary;
    }

    //metoder
    //navn
    public void setName(String inputName) {
        name = inputName;
    }

    public String getName() {
        return name;
    }

    //adresse
    public void setAdress(String inputAdress) {
        adress = inputAdress;
    }

    public String getAdress() {
        return adress;
    }

    //måneds løn
    public void setMonthlySalary(double inputMonthlySalary) {
        monthlySalary = inputMonthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    //års løn med feriepenge af en eller anden dum årsag
    public double getYearlypay() {
        double vacationMoney = monthlySalary / 100 * 2.5;
        yearlypay = (monthlySalary + vacationMoney) * 12;
        return yearlypay;
    }

    // antal virksomheder person har været ansat i
    public void setNumberOfFirm(int inputNumberOfFirms) {
        numberOfFirms = inputNumberOfFirms;
    }

    public int getNumberOfFirms() {
        return numberOfFirms;
    }

    public void newFirm() {//mulighed for at tilføje et ekstra firma
        numberOfFirms++;
    }

    // hvad der skal printes om enkelte person
    public void printperson() {
        System.out.println("Navn er : " + getName());
        System.out.println("adresse er : " + getAdress());
        System.out.println("månedsløn er : " + getMonthlySalary());
        System.out.println("årsløn + feriepenge er : " + getYearlypay());
        System.out.println("antal firmaer : " + getNumberOfFirms());
    }
}
