package course;

public class primitive_type_challenge {
    public static void main(String[] args) {
        byte john = 10;
        short bob = 20;
        int arthur = 50;
        long hosea = 50000L + 10L * (john + bob + arthur);
        System.out.println(hosea);
        float myFloatValue = 5.25f;
        System.out.println(myFloatValue);
        double myDoubleValue = 5.25d;
        System.out.println(myDoubleValue);

        double doubleValue = myFloatValue;
    }
}
