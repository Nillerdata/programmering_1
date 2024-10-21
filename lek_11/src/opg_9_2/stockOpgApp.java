package opg_9_2;

public class stockOpgApp {
    public static void main(String[] args) {

        stockOpg s1 = new stockOpg("ORCL", "Oracle");
        s1.setCurrentPrice(34.35);
        s1.setPreviousClosingPrice(34.5);
        s1.getCurrentPrice();
        s1.getPreviousClosingPrice();
        s1.getChangePercent();
        System.out.println(s1.getChangePercent());
        System.out.println(s1);
    }
}
