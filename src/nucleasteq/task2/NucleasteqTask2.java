package nucleasteq.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class NucleasteqTask2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Integer> highestScores = new HashMap<>();
        String filePath = "C:\\Users\\Lenovo\\Downloads\\Scores.csv";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String player = data[0];
                int maxScore = 0;
                for (int i = 1; i < data.length; i++) {
                    String[] matchData = data[i].split("_");
                    int score = Integer.parseInt(matchData[1]);
                    if (score > maxScore) {
                        maxScore = score;
                    }
                }
                highestScores.put(player, maxScore);
            }
            for (Map.Entry<String, Integer> entry : highestScores.entrySet()) {
                System.out.println("Player: " + entry.getKey() + ", Highest Score: " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        }
    
    }
    
}
