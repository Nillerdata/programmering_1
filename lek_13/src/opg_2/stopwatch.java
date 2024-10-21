package opg_2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class stopwatch {
    LocalTime startTime;
    LocalTime endTime;


    public void start() {
        startTime = LocalTime.now();

    }

    public void stop() {

        endTime = LocalTime.now();


    }//hej

    public long elapsedTime() {
        long seconds;
        seconds = ChronoUnit.SECONDS.between(startTime, endTime);
        return seconds;
    }
    public void print(){
        System.out.println("startid er : " + startTime);
        System.out.println("sluttid er : " + endTime);
        System.out.println("differencen i sekunder er : " + elapsedTime());
    }

}


