package Pentathlon.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import utils.Scoring;

@Entity
public class Athlete extends Scoring{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String name, surname;
	private int fencingWins, totalScore, fencingScore, swimmingScore, ridingScore, shootingScore;
	private int swimmingTime;
	private int ridingKnock;
	private int ridingRefusal;
	private int ridingDisobedience;
	private int shooting;
	private int runTime;
	private String place;
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPlace() {
		return place;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getFencingWins() {
		return fencingWins;
	}
	public void setFencingWins(int fencingWins) {
		this.fencingWins = fencingWins;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public void calcTotalScore() {
		this.totalScore = fencingScore+ridingScore+swimmingScore+shootingScore;
	}
	public void setRunTime(double runTime) {
		this.runTime = (int) (runTime);
	}
	
	public int getFencingScore() {
		return fencingScore;
	}
	public void setFencingScore(int fencingScore) {
		this.fencingScore = fencingScore;
	}
	public int getSwimmingScore() {
		return swimmingScore;
	}
	public void setSwimmingScore(int swimmingScore) {
		this.swimmingScore = swimmingScore;
	}
	public int getRidingScore() {
		return ridingScore;
	}
	public void setRidingScore(int ridingScore) {
		this.ridingScore = ridingScore;
	}
	public int getShootingScore() {
		return shootingScore;
	}
	public void setShootingScore(int shootingScore) {
		this.shootingScore = shootingScore;
	}
	public double getSwimmingTime() {
		return swimmingTime;
	}
	public void setSwimmingTime(String swimmingTime) {
		this.swimmingTime = Scoring.stringToMilis(swimmingTime);
	}
	public int getRidingKnock() {
		return ridingKnock;
	}
	public void setRidingKnock(int ridingKnock) {
		this.ridingKnock = ridingKnock;
	}
	public int getRidingRefusal() {
		return ridingRefusal;
	}
	public void setRidingRefusal(int ridingRefusal) {
		this.ridingRefusal = ridingRefusal;
	}
	public int getRidingDisobedience() {
		return ridingDisobedience;
	}
	public void setRidingDisobedience(int ridingDisobedience) {
		this.ridingDisobedience = ridingDisobedience;
	}
	public int getShooting() {
		return shooting;
	}
	public void setShooting(int shooting) {
		this.shooting = shooting;
	}
	public double getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = Scoring.stringToMilis(runTime);
		swimmingScore(this);
		ridingScore(this);
		shootingScore(this);
		fencingScore(this);
	}
}
