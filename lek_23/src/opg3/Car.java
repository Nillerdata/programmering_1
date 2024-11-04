package opg3;

public class Car {
    private String license;
    private double pricePerDay;
    private int purchasePerYear;

    public Car(String license, int purchasePerYear) {
        this.license = license;
        this.purchasePerYear = purchasePerYear;

    }
    public void setDayPrice(double price){
        this.pricePerDay = price;
    }

    public double getDayPrice(){
        return pricePerDay;
    }

    public String getLicense(){
        return license;
    }

    public int getPurchasePerYear(){
        return purchasePerYear;
    }
}
