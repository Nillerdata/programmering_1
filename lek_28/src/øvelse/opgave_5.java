package øvelse;

public class opgave_5 {

    public static void main(String[] args) {
        System.out.println(lineærKvadrat(111));
        System.out.println(binærKvadrat(10));
    }

    public static int lineærKvadrat(int n){
    int r = 0;
    int maxR = -1;
    while(maxR == -1 && r <= n){
        if((r*r)<=n && n<(r+1)*(r+1)){
        maxR = r;
        }else{
            r++;
        }
    }

    return maxR;
    }
    public static int binærKvadrat(int n) {
        // Variabel til at gemme resultatet, initialiseret til -1
        int maxR = -1;
        // Initialiserer venstre og højre grænser for binær søgning
        int left = 0;
        int right = n;
        // Udfører binær søgning
        while (maxR == -1 && left <= right) {
            // Finder midterelementet mellem left og right
            int middle = (left + right) / 2;
            // Tjekker om kvadratet af middle er lig med eller mindre end n og
            // om kvadratet af (middle + 1) er større end n
            if ((middle * middle) <= n && n < (middle + 1) * (middle + 1)) {
                // Hvis betingelsen er opfyldt, sæt maxR til middle
                maxR = middle;
            }
            // Hvis kvadratet af middle er mindre end n
            else if ((middle * middle) < n) {
                // Skift venstre grænse til middle + 1
                left = middle + 1;
            }
            // Hvis kvadratet af middle er større end n
            else {
                // Skift højre grænse til middle - 1
                right = middle - 1;
            }
        }

        // Returner resultatet
        return maxR;
    }

}
