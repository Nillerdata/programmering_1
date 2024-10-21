package opg_9_8;

public class fanApp {
    public static void main(String[] args) {
        fan f1 = new fan ();
        System.out.println(f1);

        System.out.println("____________________________");
        fan f2 = new fan();
        f2.getOn();
        f2.setSpeed(fan.FAST);
        f2.setColor("yellow");
        f2.setRadius(10);
        System.out.println(f2);
        System.out.println("____________________________");
        fan f3 = new fan();
        f3.setSpeed(fan.MEDIUM);
        System.out.println(f3);




    }
}
