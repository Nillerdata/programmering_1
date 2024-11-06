package opg_1;

import opg_1.Car;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String Date;
    private Car car;
    private ArrayList<Car> cars = new ArrayList<>();

    public Rental(int number, String date, int days) {
        this.number = number;
        Date = date;
        this.days = days;


    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
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

    public double getPrice() {

        double price = 0;
        for (Car c : cars) {
            price +=c.getDayPrice();
        }
        return price * days;

    }
}


