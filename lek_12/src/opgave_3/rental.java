package opgave_3;

import java.time.LocalDate;

public class rental {
    private int number;
    private int days;
    private double price;
    private LocalDate startdate;

    //constructor
    public rental(int number, int days, double price,LocalDate startdate){
    this.number = number;
    this.days = days;
    this.price = price;
    this.startdate = startdate;
    }
    //metoder
    public double getPricePrDay(){
        return price;}

    public void setDays(int days){//mutator
        this.days = days;
    }
    public int getDays(){
        return this.days;
    }
    public LocalDate getStartdate(){
        return this.startdate;
    }

    public LocalDate getEndDate() {
        return startdate.plusDays(days);  /*tager startdato og plusser de antal dage frem som
        din getdays metode har. dernæst beregner den forskel og returnerer differencen*/
    }

    public double getTotalPrice(){
        return days*price;
    }

    public String toString(){
        return "startdatoen er " + getStartdate() + " slutdato er : " + getEndDate() + "\n prisen er : " + price
        + "\n totalprisen er :  " + getTotalPrice();
    }
}
