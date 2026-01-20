package mileagetracker;

public class Activity {

    private String title;
    private String duration;
    private int minHeartRate;
    private int maxHeartRate;
    private int avgHeartRate;
    private int caloriesBurned;

    public Activity(String title, int minHeartRate, String duration, int maxHeartRate, int avgHeartRate, int calories) {
        this.title = title;
        this.minHeartRate = minHeartRate;
        this.duration = duration;
        this.maxHeartRate = maxHeartRate;
        this.avgHeartRate = avgHeartRate;
        this.caloriesBurned = calories;
    }

    public int getAvgHeartRate() {
        return avgHeartRate;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public int getMaxHeartRate() {
        return maxHeartRate;
    }

    public int getMinHeartRate() {
        return minHeartRate;
    }

    public String getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

}
