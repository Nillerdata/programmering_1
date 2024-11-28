package Switch;

public class Main {
    public static void main(String[] args) {

        String month = "APRIL";
        month = "OCTOBER";
        System.out.println(month + " is in the " + getQuarter(month) + " quarter of the year ");

//        int value = 1;
//        if(value == 1){
//            System.out.println("Value was 1");
//        }else if (value == 2){
//            System.out.println("Value was 2");
//        }else{
//            System.out.println("Was not 1 or 2");
//        }
        //enchanced switch statement
     int enchancedSwitchvalue = 4;
     switch(enchancedSwitchvalue){
         case 1 ->
             System.out.println("value was 1");

         case 2->
             System.out.println("value was 2");

         case 3,4,5 -> {
             System.out.println("was a 3, 4 or 5");
             System.out.println("actually it was a " + enchancedSwitchvalue);
         }
         default->
             System.out.println("value was above 5 or below 1");

     }
     //traditionel switch statement
     int switchvalue = 1;
     switch (switchvalue){
         case 1:
             System.out.println("value er 1");
             break;
         case 2:
             System.out.println("value is 2");
             break;
         case 3,4,5:
             System.out.println("value is" + switchvalue);
             break;
         default:
             System.out.println("value was below 1 or above 5");
     }
    }
    public static String getQuarter(String month){

        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" ->{yield "1st";}
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMPER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default -> {
                String badResponse = month + "is bad";
                yield badResponse;
            }

        };

    }
}
