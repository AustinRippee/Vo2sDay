package mileagetracker;

public class MileageTracker {

    double totalDailyMileage;
    double totalWeeklyMileage;
    double totalYearlyMileage;

    public static void main(String[] args)
    {

        //add in the ability to take a Garmin .fit file and populate the fields automatically
        //or from a CSV file that has the activity data

        Log currentLog = new Log();
        Run thursdayRun = new Run(7.0,"7:26","Morning Run","52:08",119,171,156,764);
        Run fridayRun = new Run(8.4,"7:01","Lunch Run","58:59",89,179,166,920);

        Activity newAct = new Run(12.0,"7:30","Long Run","1:20:08",110,165,148,1054);

        currentLog.addActivity(thursdayRun);
        currentLog.addActivity(fridayRun);
        currentLog.addActivity(newAct);

        currentLog.displayLog();

    }
}
