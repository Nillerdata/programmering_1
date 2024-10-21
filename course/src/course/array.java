package course;

public class array {
    public static void main(String[] args) {
        int[] newArray;
        newArray = new int[5];

        for(int i = 0 ; i< newArray.length;i++){
            newArray[i] = newArray.length-i;
        }
        for(int i = 0; i< newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }/*for each loop eksempel
        for (declaration:collection){}
        declaration har type og variabel navn og collection har array eller anden form for collection */
        System.out.println("\n_____________________");
        for(int element:newArray){
            System.out.print(element + " ");

        }
    }
}
