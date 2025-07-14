package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVUtility {
    private static final String FILE_PATH = "C://Users//Public//Downloads//CricketScoreAutomationSelenium//src//main//resources//csvfiles//cricket_score_log.csv";

    public static void logScore(String team1, String score1, String overs1,
                                String team2, String score2, String overs2, String status) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);
            String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s%n",
                    timestamp, team1, score1, overs1, team2, score2, overs2, status);
            writer.append(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}