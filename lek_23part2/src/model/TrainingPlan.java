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


	public void addSwimmers(Swimmer swimmer) {
		if (!swimmers.contains(swimmer)) {
			this.swimmers.add(swimmer);
		}
	}

	public void removeSwimmer(Swimmer swimmer) {
		if (swimmers.contains(swimmer)) {
			this.swimmers.remove(swimmer);
		}
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

	public String toString() {
		String træner = " niveau er :" + level
				+ " timer i vand er : " + weeklyWaterHours +
				"\n timer i træningscenter er : " + weeklyStrengthHours;
		return træner;
	}

	
}
