package overloadChallenge;

public class feetAndInchesToCM {
    public static void main(String[] args) {
        //konvertering fra inch til cm er 2.54 og 12 inches til en fod.
//        System.out.println(convertToCentimeters(1));
//       double result = convertToCentimeters(0,6);
//        System.out.println(result);
        System.out.println("5 ft, 8 in cm is = " + convertToCentimeters(5,8) + " cm");
    }

    public static double convertToCentimeters(int inches) {
        return inches * 2.54;
    }
    public static double convertToCentimeters(int feet,int inches){
    return (convertToCentimeters((feet*12) + inches))*2.54;
    }
}

