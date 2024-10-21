package modelwhile;

public class LoekkerOpgaver {

    public static void main(String[] args) {

//        Kald af metoder der afprøver opgave 1

        System.out.println(summerEven(100));
        System.out.println(summerSquare(10));
        System.out.println(sumOdd(3, 19));
        allPowers(20);
        System.out.println(sumOfDigits(32677));

    }

    // Metoden returnerer summen af alle lige tal mellem 2 og n
    public static int summerEven(int n) {
        // TODO Opgave 1.a
        int sum = 0;
        int i = 1;
        while (i <= n) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
            i++;
        }
        return sum;
    }

    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        // TODO Opgave 1.b
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum = (sum + (i * i));
            i++;
        }

        return sum;
    }


    // Metoden returnerer summen af alle ulige tal mellem a og b
    // TODO Opgave 1.c
    public static int sumOdd(int a, int b) {
        int i = a;
        int sum = 0;
        while (i <= b) {
            if (i % 2 != 0) {
                sum = sum + i;
            }
            i++;
        }
        return sum;
    }

    // Metoden udskriver 2 potenser
    public static void allPowers(int n) {
        // TODO Opgave 1.d
        int i = 0;
        int potens = 1;
        while (i <= n) {
            System.out.println(potens);
            potens = potens * 2;
            i++;

        }
    }

    public static int sumOfDigits(int tal) {


        int sum = 0;
        // D skal være inde i while grundet at den skal gøre det hver gang
        while (tal >0) {
            int d= tal%10;
            //kontroller at tallet er ulige
            if(d%2 != 0){
                sum= sum +d;
            }
            //rykker komma så vi kommer videre til næste ciffer
            tal = tal/10;
        }


        return sum;
}

}
