package utils;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Pentathlon.data.Athlete;
import Pentathlon.data.AthleteRepository;

public abstract class Reader {

	public static void readData(String path, AthleteRepository repository) {

		refreshRepository(repository);
		List<Athlete> athletes = new ArrayList<Athlete>();
		try (Scanner scanner = new Scanner(new File(path));) {
			scanData(scanner, athletes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		athletes = AthleteSorter.sortAthletes(athletes);
		repository.saveAll(athletes);
	}
	
	public static List<Athlete> readData(String path) {
		List<Athlete> athletes = new ArrayList<Athlete>();
		try (Scanner scanner = new Scanner(new File(path));) {
			scanData(scanner, athletes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		athletes = AthleteSorter.sortAthletes(athletes);
		return athletes;
	}
	
	

	public static void readData(ByteArrayInputStream inputStream, AthleteRepository repository) {
		refreshRepository(repository);
		List<Athlete> athletes = new ArrayList<Athlete>();
		try (Scanner scanner = new Scanner(inputStream);) {
			scanData(scanner, athletes);
		}
		athletes = AthleteSorter.sortAthletes(athletes);
		repository.saveAll(athletes);
	}

	public static void readDataAdd(ByteArrayInputStream inputStream, AthleteRepository repository) {
		List<Athlete> athletes = repository.findAll();
		refreshRepository(repository);
		try (Scanner scanner = new Scanner(inputStream);) {
			scanData(scanner, athletes);
		}
		athletes = AthleteSorter.sortAthletes(athletes);
		repository.saveAll(athletes);
	}
	
	private static void scanData(Scanner scanner, List<Athlete> athletes) {
		scanner.useDelimiter(",|\\n");
		while (scanner.hasNext()) {
			Athlete athlete = new Athlete();
			String[] fullName = scanner.next().split(" ");
			athlete.setName(fullName[0]);
			athlete.setSurname(fullName[1]);
			athlete.setFencingWins(scanner.nextInt());
			athlete.setSwimmingTime(scanner.next());
			athlete.setRidingKnock(scanner.nextInt());
			athlete.setRidingRefusal(scanner.nextInt());
			athlete.setRidingDisobedience(scanner.nextInt());
			athlete.setShooting(scanner.nextInt());
			athlete.setRunTime(scanner.next());
			athlete.calcTotalScore();
			athletes.add(athlete);
		}
		scanner.close();
	}

	private static void refreshRepository(AthleteRepository repository) {
		if (repository.count() > 0)
			repository.deleteAll();
	}
}
