package trainingpaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainingPacesTest {

    @Test
    public void threeMinsTo180Seconds(){
        String input = "3:00";
        Double expected = 180.0;
        double actual = TrainingPaces.convertTimeToSeconds(input);
        assertEquals(expected,actual);
    }

    @Test
    public void fiftyNineSecondsTo59Seconds(){
        String input = "0:59";
        Double expected = 59.0;
        double actual = TrainingPaces.convertTimeToSeconds(input);
        assertEquals(expected,actual);
    }

    @Test
    public void oneHourToThreeThousandSixHundredSeconds(){
        String input = "3:00";
        Double expected = 180.0;
        double actual = TrainingPaces.convertTimeToSeconds(input);
        assertEquals(expected,actual);
    }

}