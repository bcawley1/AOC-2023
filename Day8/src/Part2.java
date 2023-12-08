import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day8/src/input.txt"));
        Map<String, Direction> map = new HashMap<>();
        List<String> startingValues = new ArrayList<>();
        String directions = scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            map.put(line.substring(0, 3), new Direction(line.substring(7, 10), line.substring(12, 15)));
            if(line.charAt(2)=='A'){
                startingValues.add(line.substring(0, 3));
            }
        }

        char[] directionArray = directions.toCharArray();
        int i = 0;
        int zCount = 0;
        while(!allEndWithZ(startingValues)){
            for(int j = 0; j < startingValues.size(); j++){
                startingValues.set(j, directionArray[i%directionArray.length]=='R' ? map.get(startingValues.get(j)).right() : map.get(startingValues.get(j)).left());
                if(startingValues.get(j).charAt(2)=='Z') {
                    zCount += 1;
                    System.out.println("Found a Z! #" + zCount);
                }
            }
            i++;
        }
        System.out.println(zCount);
    }
    private static boolean allEndWithZ(List<String> values){
        for(String s : values){
            if(s.charAt(2)!='Z'){
                return false;
            }
        }
        return true;
    }
}