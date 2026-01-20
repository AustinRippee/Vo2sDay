package trainingpaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Scanner;

public class TrainingPaces {

    public static void main(String[] args) {
        double dblTotalTime;
        String[] totalTime;
        Scanner scanner = new Scanner(System.in);

        introPrompt();

        while (true) {

            System.out.println("Please enter your most recent race distance (e.g., 800):");
            String raceDistance = scanner.nextLine().trim();
            System.out.println("Please enter your most recent race time (e.g., 1:59.75):");
            String raceTime = scanner.nextLine().trim();

            if (raceTime.contains(":")) {
                totalTime = raceTime.split(":");
                if (totalTime.length == 3) {
                    double timeHr = Double.parseDouble(totalTime[0]);
                    double timeMin = Double.parseDouble(totalTime[1]);
                    double timeSec = Double.parseDouble(totalTime[2]);
                    dblTotalTime = (timeHr * 3600) + (timeMin * 60) + timeSec;
                } else if (totalTime.length == 2) {
                    double timeMin = Double.parseDouble(totalTime[0]);
                    double timeSec = Double.parseDouble(totalTime[1]);
                    dblTotalTime = (timeMin * 60) + timeSec;
                } else {
                    System.out.println("Invalid time format.");
                    return;
                }
            } else {
                System.out.println("Invalid time format. Must contain ':'");
                return;
            }

            int foundVDOT = -1;
            int lastFasterVDOT = -1;

            String sqlVDOT = "SELECT vdot, \"" + raceDistance + "\" FROM vdot_estimate ORDER BY \"" + raceDistance + "\" ASC";

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlVDOT)) {

                while (rs.next()) {
                    String timeStr = rs.getString(raceDistance);
                    double rowSeconds = convertTimeToSeconds(timeStr);

                    if (rowSeconds < dblTotalTime) {
                        lastFasterVDOT  = rs.getInt("vdot");
                    } else {
                        break;
                    }
                }

                foundVDOT = lastFasterVDOT;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (foundVDOT == -1) {
                System.out.println("No matching VDOT score found.");
                return;
            }

            System.out.println("Matched VDOT: " + foundVDOT);

            String sqlPaces = "SELECT * FROM vdot_paces WHERE vdot = ?";

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
                 PreparedStatement ps = conn.prepareStatement(sqlPaces)) {

                ps.setInt(1, foundVDOT);

                try (ResultSet paceRs = ps.executeQuery()) {
                    if (paceRs.next()) {
                        for (int col = 2; col <= paceRs.getMetaData().getColumnCount(); col++) {
                            String colName = paceRs.getMetaData().getColumnName(col);
                            String value = paceRs.getString(col);
                            System.out.println(colName + ": " + value);
                        }
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void introPrompt() {
        System.out.println("========================================");
        System.out.println("\t\t\t\t******");
        System.out.println("\t\t\tTrainingPaces");
        System.out.println("\t\tWritten by: Austin Rippee");
        System.out.println("\t\t\t\t******");
        System.out.println("========================================");
    }

    public static double convertTimeToSeconds(String timeStr) {
        if (timeStr == null || timeStr.isEmpty()) return Double.MAX_VALUE;
        String[] parts = timeStr.split(":");
        double totalSeconds;
        if (parts.length == 3) {
            totalSeconds = Integer.parseInt(parts[0]) * 3600 +
                    Integer.parseInt(parts[1]) * 60 +
                    Double.parseDouble(parts[2]);
        } else if (parts.length == 2) {
            totalSeconds = Integer.parseInt(parts[0]) * 60 +
                    Double.parseDouble(parts[1]);
        } else {
            totalSeconds = Double.parseDouble(parts[0]);
        }
        return totalSeconds;
    }
}