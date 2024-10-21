package course;

public class casting {
    public static void main(String[] args) {
        short myMinShortValue = Short.MIN_VALUE; int myMinIntValue = Integer.MIN_VALUE;
        System.out.println(myMinShortValue + " " + myMinIntValue);

        int myTotal = (myMinIntValue/2);
        System.out.println(myTotal);
    }
}
