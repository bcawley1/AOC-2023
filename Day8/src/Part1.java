import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day8/src/input.txt"));
        Map<String, Direction> map = new HashMap<>();
        String directions = scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            map.put(line.substring(0, 3), new Direction(line.substring(7, 10), line.substring(12, 15)));
        }

        String currentLocation = "AAA";
        char[] directionArray = directions.toCharArray();
        int i = 0;
        while(!currentLocation.equals("ZZZ")){
            currentLocation = directionArray[i%directionArray.length]=='R' ? map.get(currentLocation).right() : map.get(currentLocation).left();
            i++;
        }
        System.out.println(i);
    }
}