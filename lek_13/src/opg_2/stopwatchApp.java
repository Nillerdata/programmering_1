package opg_2;
import java.util.Scanner;
public class stopwatchApp {
    //hvis brug af scanner. sæt i main
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        stopwatch s1 = new stopwatch();
        s1.start();


        //prompt bruger til at sige stop
        System.out.println("indtast input");
        scan.nextLine();
        s1.stop();

        s1.print();

    }
}
