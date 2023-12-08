import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day7/src/input.txt"));
        List<Player> players = new ArrayList<>();

        while (scanner.hasNext()) {
            String[] split = scanner.nextLine().split(" ");
            players.add(new Player(new Hand(split[0]), Integer.parseInt(split[1])));
        }

//        players.sort(new Hand.PlayerComparator("AKQJT98765432")); //Part 1 Sort
        players.sort(new Hand.PlayerComparator("AKQT98765432J")); //Part 2 Sort

        int sum = 0;
        for (int i = 0; i < players.size(); i++) {
            sum += (players.get(i).bet() * (i + 1));
        }

        System.out.println(sum);
    }
}