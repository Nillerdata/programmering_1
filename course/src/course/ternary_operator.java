package course;

public class ternary_operator {

    public static void main(String[] args) {
/*the ternary operator is a shortcut to assigning one of two values to a variable, depending
* on a given condition. think of it as a shortcut of the if-then-else statement. */
        String makeOfCar = "Volkswagen";
        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true;

        if(isDomestic){
            System.out.println("this car is domestic to our country");
        }
        if(!isDomestic){
            System.out.println("this car is not domestic");
        }
/* in the first example we looked at in our code we returned a boolean value from a ternary operation
* good demonstration but wouldn't be something to do when writing proper code*/
    //a much simpler way is
    boolean isdomestic = (makeOfCar != "Volkswagen");
    //same effect but much easier to read


        //example
        //god ide med parentes for at gøre koden mere læselig
        int ageofClient = 20;
        String ageText = (ageofClient >= 18) ? "over eighteen" : "still a kid";
        System.out.println("our client is " + ageText);
        /* operand one -ageOfClient >= 18 in this case is the condition we're checking.
        it need to return true, or false*/
        /*operand two - "over eighteen" is the value to assign to the variable age Text,
        * if the condition above is true*/
        /*operand three - "Still a kid" is the value to assign to the variable age text,
        * if the condition above is false*/
        String s = (isdomestic)? "this car is domestic" : "this car is not domestic";
        System.out.println(s);
        /* ternary operator could replace the if statement*/
    }
}
