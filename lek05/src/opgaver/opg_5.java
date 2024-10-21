package opgaver;
import javax.xml.transform.Result;

public class opg_5 {
    public static void main (String [] args) {

        int i = 0;
        double salg = 10000;
        while (i <= 15){
            salg = salg + 10000;
            System.out.println("salg er " + salg + " " +"provision er " + provision(salg));
            i++;
        }
}

    public static double provision(double salg) {
double result = 0;

if (salg <=40000) {
    result = salg * 0.06;


} else if ( salg <=100000){
    result = ( salg - 40000) * 0.08 + (40000 * 0.06);

}

else if (salg > 100000) {
        result = (salg - 40000) * 0.1 + (40000 * 0.06) + (60000 * 0.08);

    }
//returner resultatet
        return result;
    }
}
