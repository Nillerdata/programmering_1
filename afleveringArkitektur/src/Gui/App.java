package Gui;

import controller.Controller;
import model.PladsType;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

    }

    public static void initStorage() {
        //TODO
        //forestillinger_______________________
        Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10),
                LocalDate.of(2023, 8, 20));

        Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1),
                LocalDate.of(2023, 9, 10));

        Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21),
                LocalDate.of(2023, 8, 30));
        //____________________________________
        //Kunder
        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");

        //TODO lave nestede for loops x3
        //første 5 rækker
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                if (j < 2 || j < 17) {
                    Controller.createPlads(i, j, 450, PladsType.STANDARD);
                } else Controller.createPlads(i, j, 500, PladsType.STANDARD);
            }
        }
        //rækker mellem 5 og 10
        for (int i = 5; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j < 2 || j < 17) {
                    Controller.createPlads(i, j, 400, PladsType.STANDARD);
                } else if (j > 6 && j < 11 && i == 9) {//sørger for at få kørestol med
                    Controller.createPlads(i, j, 450, PladsType.KØRESTOL);
                } else Controller.createPlads(i, j, 450, PladsType.STANDARD);
            }

        }
        //bagerste rækker
        for (int i = 10; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                if (j > 6 && j < 11 && i == 10) {
                    Controller.createPlads(i, j, 400, PladsType.EKSTRABEN);
                } else Controller.createPlads(i, j, 400, PladsType.STANDARD);
            }
        }


    }
}
