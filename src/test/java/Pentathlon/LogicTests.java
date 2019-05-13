package Pentathlon;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import Pentathlon.data.Athlete;
import utils.Reader;
import utils.Scoring;


public class LogicTests {
	


	    @Test
	    public void convertingTimeTest() throws Exception {
	        assertThat(Scoring.stringToMilis("2:00.4")).isEqualTo(120);
	        assertThat(Scoring.stringToMilis("10:00.0")).isEqualTo(600);
	    }
	    
	    @Test
	    public void scoreCountingTest() throws Exception {
	    	List<Athlete> athletes = Reader.readData(System.getProperty("user.dir")+"\\dataFiles\\Athlete_Results.csv");
	        assertThat(athletes.size()).isEqualTo(10);
	        System.out.println(System.getProperty("user.dir")+"\\dataFiles\\Athlete_Results.csv");
	        assertThat(athletes.get(3).getFencingWins()).isEqualTo(0);
	        assertThat(athletes.get(1).getShootingScore()).isEqualTo(1276);
	        assertThat(athletes.get(3).getTotalScore()).isEqualTo(3356);
	        assertThat(athletes.get(9).getPlace()).isEqualTo("10");
	        assertThat(athletes.get(6).getRidingScore()).isEqualTo(1200);
	        assertThat(athletes.get(4).getRunTime()).isEqualTo(-524);
	        assertThat(athletes.get(0).getTotalScore()>athletes.get(1).getTotalScore()).isEqualTo(true);
	    }
	    
	    
}
