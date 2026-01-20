package mileagetracker;

public class Run extends Activity {

    private double distance;
    private int totalAscent;
    private int totalDescent;
    private int minElevation;
    private int maxElevation;
    private String avgPace;
    private String avgMovingPace;
    private String bestPace;
    private int avgCadence;
    private int maxCadence;
    private int avgStrideLength;
    private int interval;
    private String movingTime;
    private String elapsedTime;
    private int lap;

    public Run(double distance, String avgPace, String title, String duration, int minHeartRate, int maxHeartRate, int avgHeartRate, int calories){
        super(title,minHeartRate,duration,maxHeartRate,avgHeartRate,calories);
        this.distance = distance;
        this.avgPace = avgPace;
    }

    public double getDistance() {
        return distance;
    }

    public int getTotalAscent() {
        return totalAscent;
    }

    public int getTotalDescent() {
        return totalDescent;
    }

    public int getInterval() {
        return interval;
    }

    public int getAvgStrideLength() {
        return avgStrideLength;
    }

    public int getMaxCadence() {
        return maxCadence;
    }

    public int getAvgCadence() {
        return avgCadence;
    }

    public String getBestPace() {
        return bestPace;
    }

    public String getAvgMovingPace() {
        return avgMovingPace;
    }

    public String getAvgPace() {
        return avgPace;
    }

    public int getMaxElevation() {
        return maxElevation;
    }

    public int getMinElevation() {
        return minElevation;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public String getMovingTime() {
        return movingTime;
    }

    public int getLap() {
        return lap;
    }

//    public void ToString(){
//        System.out.println(title + minHeartRate + duration + maxHeartRate + avgHeartRate + caloriesBurned + distance + avgPace);
//    }

}
