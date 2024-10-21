package eksempler.momsprocentstatic;


public class BankAccount {
    //attributter
    private double balance;
    private int id;
    //static data field
    private static int antalKonti;
    //constructor
    public BankAccount(double initialBalance) {
        //attributter
        balance = initialBalance;
        antalKonti++;
        id = antalKonti;
    }
    //metoder (mutator) hvor man kan indsætte og trække
    public void deposit(double amount) {balance += amount;}
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }


    public static int getAntalKonti(){
        return antalKonti;
    }
}

