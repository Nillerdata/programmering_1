package Switch;


public class TraditionelSwitch {

    public static void main(String[] args) {

        char switchvalue = 'c';

        switch (switchvalue) {
            case 'a':
                System.out.println("a is able");
                break;
            case 'b':
                System.out.println("b is baker");
                break;
            case 'c':
                System.out.println("c is charlie");
                break;
            case 'd':
                System.out.println("d is dog");
                break;
            case 'e':
                System.out.println("e is easy");
                break;
            default:
                System.out.println("letter was not found. type letter between a & e and not : " + switchvalue);
        }

    }
}
