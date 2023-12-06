import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day4/src/input.txt"));
        List<List<Integer>> winningNums = new ArrayList<>();
        List<List<Integer>> haveNums = new ArrayList<>();

        List<Integer> numOfMatches = new ArrayList<>();


        while (scanner.hasNext()) {
            String line = scanner.nextLine().substring(10);
            String[] split = line.split(" \\| ");
            winningNums.add(new ArrayList<>());
            haveNums.add(new ArrayList<>());
            for (String s : split[0].split(" ")) {
                if (!s.isEmpty()) {
                    winningNums.get(winningNums.size() - 1).add(Integer.parseInt(s));
                }
            }
            for (String s : split[1].split(" ")) {
                if (!s.isEmpty()) {
                    haveNums.get(haveNums.size() - 1).add(Integer.parseInt(s));
                }
            }
        }


        for (int i = 0; i < winningNums.size(); i++) {
            int timesWon = 0;
            for (int num : haveNums.get(i)) {
                if (winningNums.get(i).contains(num)) {
                    timesWon++;
                }
            }
            numOfMatches.add(timesWon);
        }

        int sumPart2 = 0;
        for (int i = 0; i < winningNums.size(); i++) {
            sumPart2 += getTotal(numOfMatches, i);
        }
        System.out.println(sumPart2);


    }

    private static int getTotal(List<Integer> numMatches, int num) {
        int sum = 1;
        for (int i = 1; i < numMatches.get(num) + 1; i++) {
            sum += getTotal(numMatches, num + i);
        }
        return sum;
    }
}

