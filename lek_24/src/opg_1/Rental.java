package opg_1;

import opg_1.Car;

import java.util.ArrayList;

public class Rental {
    //private attributter
    private int number;
    private int days;
    private String Date;
    private ArrayList<Car> cars = new ArrayList<>();

    //constructor
    public Rental(int number, String date, int days) {
        this.number = number;
        Date = date;
        this.days = days;


    }
    //settere
    public void setDays(int days) {
        this.days = days;
    }
    //gettere
    public int getDays() {
        return days;
    }




    //linkattributter_________________________
    public ArrayList<Car>getCars(){
        return new ArrayList<>(cars);
    }
    public void addCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
            car.addRental(this);
        }
    }
    public void removeCar(Car car){
        if(cars.contains(car)){
            cars.remove(car);
            car.removeRental(this);
        }
    }
    //hjælpeMetoder________________
    public double getPrice() {

        double price = 0;
        for (Car c : cars) {
            price +=c.getDayPrice();
        }
        return price * days;

    }
}


