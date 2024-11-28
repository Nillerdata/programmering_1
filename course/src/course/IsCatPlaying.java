package course;

public class IsCatPlaying {
    // write code here

    public static boolean isCatPlaying(boolean summer,int temperature){

        boolean catIsPlaying = false;
        if(summer &&  temperature <= 45 && temperature >= 25){
            catIsPlaying = true;
        }else if (!summer && temperature <= 35 && temperature >= 25){
            catIsPlaying = true;
        } return catIsPlaying;
    }

    public static void main(String[] args) {
        System.out.println(isCatPlaying(true,10));
        System.out.println(isCatPlaying(false,36));
        System.out.println(isCatPlaying(false,35));
    }
}




