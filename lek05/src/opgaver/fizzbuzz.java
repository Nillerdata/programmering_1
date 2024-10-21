package opgaver;
import java.util.Scanner;
public class fizzbuzz {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        //integer
        int fizz = 3 ;
        int buzz = 5;
        int i= 1;
        System.out.println("hvad skal der spilles til? ");
        int runder = scan.nextInt();
        //while statements

        while (i <= runder){
           if(i%3 == 0) {
               System.out.print("fizz");
           }
           if (i%5==0){
               System.out.print("buzz");
           }
           //fjerner 3 og 5
           if (!(i%3 == 0) && !(i%5==0)){
               System.out.print(i);

           }
           //laver komma mellem tallene
               System.out.print(", ");




           i++;
        }

        }
    }
