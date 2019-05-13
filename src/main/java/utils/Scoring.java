package utils;

import Pentathlon.data.Athlete;

public abstract class Scoring {

	protected void fencingScore(Athlete athlete) {
		if(athlete.getFencingWins()*10/230>=70)
			athlete.setFencingScore((23-athlete.getFencingWins())*40+1000);
		else {
			athlete.setFencingScore(1000-(23-athlete.getFencingWins())*40);
		}
	}
	
	protected void ridingScore(Athlete athlete) {
		athlete.setRidingScore(1200-
				((athlete.getRidingKnock()*28)+
				(athlete.getRidingRefusal()*40)+
				(athlete.getRidingDisobedience()*60)
				));
	}
	
	protected void swimmingScore(Athlete athlete) {
		athlete.setSwimmingScore(
				1000-((int)(150*3-athlete.getSwimmingTime()*3)*4)
				);
	}
	
	protected void shootingScore(Athlete athlete) {
		athlete.setShootingScore(
				1000-(172-athlete.getShooting())*12
				);
	}
	
	public static int stringToMilis(String runTime) {
		String[] units = runTime.split(":");
		int minutes = Integer.parseInt(units[0]);
		double seconds = Double.parseDouble(units[1]);
		return (int)((60 * minutes + seconds));
	}
	
}
