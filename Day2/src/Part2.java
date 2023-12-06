import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day2/src/input.txt"));
        int sum = 0;

        while (scanner.hasNext()) {
            Map<String, Integer> maxColors = new HashMap<>();
            maxColors.put("blue", 0);
            maxColors.put("red", 0);
            maxColors.put("green", 0);

            String line = scanner.nextLine();
            String game = line.split(": ")[1];

            for (String handFull : game.split("; ")) {
                for (String color : handFull.split(", ")) {
                    String[] split = color.split(" ");
                    if (Integer.parseInt(split[0]) > maxColors.get(split[1])) {
                        maxColors.put(split[1], Integer.parseInt(split[0]));
                    }
                }
            }

            int power = 1;
            for (int i : maxColors.values()) {
                power *= i;
            }
            sum += power;
        }
        System.out.println(sum);
    }
}
