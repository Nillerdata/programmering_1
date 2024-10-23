package course;

public class operator_challenge {
    public static void main(String[] args) {
        double first = 20.00d;
        System.out.println("first er : " +first);
        double second = 80.00d;
        System.out.println("second er : " +second);
        double third  = (first + second) * 100.00;
        System.out.println("third er : " + third);
        third = third % 40.00;
        System.out.println("third efter modolus med 40 er : " + third);

        //Hans løsning er
         boolean isNoRemainder =( third ==0) ? true : false;
        System.out.println("har vi noget tilover : " + isNoRemainder);
        if(!isNoRemainder){
            System.out.println("got some remainder");
        }
// min løsning var
//        boolean isTrue = false;
//        if(third==0){
//            isTrue = true;
//            System.out.println(isTrue);
//        } else if (third != 0) {
//            System.out.println("got some remainder");
//        }

    }
}
