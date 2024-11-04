package model;

import java.util.ArrayList;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

    
    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */ 

   public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes,TrainingPlan trainingPlan) {
       this.name = name;
       this.yearGroup = yearGroup;
       this.lapTimes = lapTimes;
       this.trainingPlan = trainingPlan;
   }
    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double best = Double.MAX_VALUE;
        for (double time: lapTimes) {
        	if(best > time) {
        		best = time;
        	}
        }
        return best;
    }

}
