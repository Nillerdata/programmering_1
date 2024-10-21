package udleveret_if;
import javax.xml.transform.Result;
public class ChildApp {

    // Metoden skal returenre en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
    // Reglerne for dette kan ses på opgavedsedlen
    //
    public static String institution(int age) {
        String institution = "";
        if (age == 0) {
            institution = "Home";
        } else if (age >= 1) {
            institution = "nursery";
        } else if (age >= 3) {
            institution = "kindergarden";
        } else if (age >= 6) {
            institution = "school";
        } else {
            institution = "out of school";
        }


        return institution;

    }


    // Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen

    public static String team(boolean isBoy, int age) {
        String team = "";
        if (isBoy && age < 8) {
            team = " youngcubs";
        } else if (isBoy && age >= 8) {
            team = " cool boys";
        } else if (!isBoy && age < 8) {
            team = " tumbling girls";
        } else if (!isBoy && age >= 8) {
            team = " springy girls";
        }
        else {
            System.out.println("Kontroller venligst alder før du prøver igen");
        }

return team;




    }

    public static void main(String[] args) {
        System.out.println("Et barn på 5 skal i " + institution(5));
        System.out.println("En dreng på 8 skal i" + team(true,8));
        System.out.println("en pige på 8 skal i" + team(false, 8));


    }
}
