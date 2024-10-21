package opg_9_2;
//attributter
public class stockOpg {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    //constructor
    public stockOpg(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;

    }

    //beregne procentforskel mellem currentprice og previousclosingprice
    public double getChangePercent() {
        return (currentPrice - previousClosingPrice) / currentPrice * 100;

    }

    //current price
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    //previous closing price
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public String toString() {
        return "the stock :" + name + "(" + symbol + ") " + "\nThe current price is : " + currentPrice + "\nthe previous price was :" + previousClosingPrice +
                "\nthe change in percent is : " + getChangePercent() + "%";

    }

}

