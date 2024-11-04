package model;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	private ArrayList<Swimmer> swimmers;


	public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
		swimmers = new ArrayList<>();
	}

	public ArrayList<Swimmer> getSwimmers() {
		return swimmers;
	}




	public void removeSwimmer(String name) {
		for(Swimmer s : swimmers){
			if(s.getName().equals(name)){
				swimmers.remove(s);
				break;
			}

			}

	}
	public Swimmer createSwimmer(String name, int yearGroup, ArrayList<Double> lapTimes,TrainingPlan trainingPlan){
		Swimmer swimmer = new Swimmer(name,yearGroup,lapTimes,trainingPlan);

		swimmers.add(swimmer);
		return swimmer;

	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char niveau) {
		this.level = niveau;
	}

	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}

	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}

	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}

	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}



	
}
