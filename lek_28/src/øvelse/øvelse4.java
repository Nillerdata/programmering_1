package øvelse;

public class øvelse4 {
    public static void main(String[] args) {
        Boolean isequal = false;
        boolean isequalIgnoreCase = false;
        int x = 0;
        int x1 = 0;
        String s1 = "Welcome";
        String s2 = "welcome";

        if(s1.equals(s2)) {
            isequal = true;
        }
        if(s1.equalsIgnoreCase(s2)){
            isequalIgnoreCase = true;
        }
        x = s1.compareTo(s2);
        x1 = s1.compareToIgnoreCase(s2);

        System.out.println(isequal);
        System.out.println(isequalIgnoreCase);
        System.out.println(x);
        System.out.println(x1);
    }


}
