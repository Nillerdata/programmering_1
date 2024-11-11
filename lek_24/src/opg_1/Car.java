package opg_1;

import java.util.ArrayList;

public class Car {
    //private attributter
    private String license;
    private double pricePerDay;
    private int purchasePerYear;
    private ArrayList<Rental> rentals;


//constructor
    public Car(String license, int purchasePerYear) {
        this.license = license;
        this.purchasePerYear = purchasePerYear;
        rentals = new ArrayList<>();

    }
    //settere
    public double getDayPrice(){
        return pricePerDay;
    }
    // gettere
    public void setDayPrice(double price){
        this.pricePerDay = price;
    }

    public String getLicense(){
        return license;
    }

    public int getPurchasePerYear(){
        return purchasePerYear;
    }


    //linkattributter_____________
    public void addRental (Rental rental){
        if(!rentals.contains(rental)){
            rentals.add(rental);
            rental.addCar(this);
        }
    }
    public void removeRental(Rental rental){
        if(rentals.contains(rental)){
            rentals.remove(rental);
            rental.removeCar(this);
        }
    }
    public ArrayList<Rental>getRentals(){
        return new ArrayList<>(rentals);
    }

    //hjælpeMetoder___________
    public int getMaxDays() {
        int maxDays = 0;
        for (Rental r : rentals) {
            if (r.getDays() > maxDays) {
                maxDays = r.getDays();
            }
        } return maxDays;


    }
}
