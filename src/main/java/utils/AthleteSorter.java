package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Pentathlon.data.Athlete;

public abstract class AthleteSorter {

	public static List<Athlete> sortAthletes(List<Athlete> athletes) {
		int maxValue = 0;
		List<Integer> scoreArray = new ArrayList<Integer>(athletes.size());
		for (Athlete athlete : athletes) {
			if (athlete.getTotalScore() > maxValue) {
				maxValue = athlete.getTotalScore();
			}
			scoreArray.add(athlete.getTotalScore());
		}
		for (Athlete athlete : athletes) {
			athlete.setRunTime(0-(maxValue - athlete.getTotalScore()));
		}
		athletes.sort(Comparator.comparing(Athlete::getTotalScore).thenComparing(Athlete::getRunTime));
		Collections.reverse(athletes);

		for (int i = 0; i < athletes.size(); i++) {
			final int finalI = i;
			int duplicates = (int) scoreArray.stream().filter(o -> o == athletes.get(finalI).getTotalScore()).count();
			if (duplicates != 1) {
				for (int j = i; j < duplicates + i; j++) {
					athletes.get(j).setPlace((i + 1) + "-" + (i + duplicates));
				}
				i += duplicates - 1;
			} else {
				athletes.get(i).setPlace("" + (i + 1));
			}
		}
		return athletes;
	}
}
