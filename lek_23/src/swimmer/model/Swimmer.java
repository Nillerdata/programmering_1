package swimmer.model;

import java.util.*;

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

    public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
        this.name = name;
        this.yearGroup = yearGroup;
        this.lapTimes = lapTimes;
        this.club = club;
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
     * Register the club of the swimmer
     *
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
        if (this.trainingPlan != trainingPlan) {
            this.trainingPlan = trainingPlan;
        }

    }

    public TrainingPlan getTrainingPlan() {
        return this.trainingPlan;
    }

    /**
     * Return how many training hours the swimmer has each week.
     */
    public int allTrainingHours(){
       int styrkeTimer =  this.trainingPlan.getWeeklyStrengthHours();
       int poolTimer = this.trainingPlan.getWeeklyWaterHours();
       int træningIAlt = styrkeTimer + poolTimer;
       return træningIAlt;
    }

    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double best = Double.MAX_VALUE;
        for (double time : lapTimes) {
            if (best > time) {
                best = time;
            }
        }
        return best;
    }
}