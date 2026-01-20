package mileagetracker;

import java.util.ArrayList;

public class Log {

    private ArrayList<Activity> activities;

    public Log() {
        activities = new ArrayList<>();
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public void displayLog() {
        for (Activity activity : activities){
            System.out.println("Title: " + activity.getTitle() + " Duration: " + activity.getDuration() + " Min Heart Rate: " + activity.getMinHeartRate() +
                    " Max Heart Rate: " + activity.getMaxHeartRate() + " Avg Heart Rate: " + activity.getAvgHeartRate() + " Calories: " + activity.getCaloriesBurned());
        }
    }

}
