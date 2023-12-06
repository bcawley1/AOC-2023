import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        final Map<String, Integer> MAX_NUMS = new HashMap<>();
        MAX_NUMS.put("blue", 14);
        MAX_NUMS.put("red", 12);
        MAX_NUMS.put("green", 13);

        Map<String, Integer> colors = new HashMap<>();
        Scanner scanner = new Scanner(new File("Day2/src/input.txt"));
        int sum = 0;

        while (scanner.hasNext()) {
            boolean foundMax = false;
            String line = scanner.nextLine();
            String game = line.split(": ")[1];
            int gameNum = Integer.parseInt(line.split(": ")[0].substring(5));

            for (String handFull : game.split("; ")) {
                colors.clear();
                for (String color : handFull.split(", ")) {
                    String[] split = color.split(" ");
                    colors.put(split[1], Integer.parseInt(split[0]));
                }
                for (Map.Entry<String, Integer> entry : colors.entrySet()) {
                    if (entry.getValue() > MAX_NUMS.get(entry.getKey())) {
                        foundMax = true;
                        break;
                    }
                }
            }
            if (!foundMax) {
                sum += gameNum;
            }
        }
        System.out.println(sum);
    }
}

