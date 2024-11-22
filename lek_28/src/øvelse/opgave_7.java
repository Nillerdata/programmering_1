package øvelse;

public class opgave_7 {

    public static void main(String[] args) {
        String job = "jjjj";
        System.out.println(kens(job, 4));
        System.out.println(kEnsOptimeret(job,4));
    }

    public static boolean kens(String s, int k) {
        boolean resultat = false;
        int i = 0;
        int n = 1;

        while (!resultat && i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                n++;
                if (n == k) {
                    resultat = true;
                }
            } else {
                n = 1;
            }
            i++;
        }

        return resultat;
    }
    //______________________________________________________

    public static boolean kEnsOptimeret(String s, int k){
        boolean resultat = false;

        int i = 0;
        while(!resultat && i<=s.length()-k){
            boolean matchfound = helpcounter(s,k,i);
            if(matchfound){
                resultat = true;
            }else i++;
        }return resultat;
    }
    public static boolean helpcounter(String s, int k, int i) {
        boolean resultat = true;
        int j = 1;
        while (resultat && j < k) {
            if (s.charAt(i) != s.charAt(i + j)) {
                resultat = false;
            } else {
                j++;
            }
        }
        return resultat;
    }


}
