package lek04_opgaver;

public class opg3_og7 {
    public static String Inorder(int tal1, int tal2, int tal3) {


        //if sætninger

        if (tal1 < tal2 && tal2 < tal3) {
            return "stigende";

        } else if (tal1 > tal2 && tal2 > tal3) {
            return ("faldende");

        } else {
            return "hverken eller";
        }

    }

    public static void main(String[] args) {
        System.out.println(Inorder(3, 2, 1));
        System.out.println(Inorder(1,2,3));
        System.out.println(Inorder(4,2,3));
    }
}
