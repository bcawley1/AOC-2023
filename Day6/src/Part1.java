import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day6/src/input.txt"));
        List<Race> races = new ArrayList<>();

        List<String> times = new ArrayList<>(List.of(scanner.nextLine().substring(12).split(" ")));
        times.removeIf(String::isEmpty);

        List<String> distance = new ArrayList<>(List.of(scanner.nextLine().substring(12).split(" ")));
        distance.removeIf(String::isEmpty);

        for(int i = 0; i < times.size(); i++){
            races.add(new Race(Long.parseLong(times.get(i)), Long.parseLong(distance.get(i))));
        }

        int product = 1;
        for(Race race : races){
            product*=race.getNumOfWaysToBeat();
        }

        System.out.println(product);
    }
}