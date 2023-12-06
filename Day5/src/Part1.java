import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day5/src/input.txt"));
        List<Long> seeds = new ArrayList<>();
        List<List<ConversionRange>> conversions = new ArrayList<>();

        for (String s : scanner.nextLine().substring(7).split(" ")) {
            seeds.add(Long.parseLong(s));
        }


        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                scanner.nextLine();
                line = scanner.nextLine();
                conversions.add(new ArrayList<>());
            }
            String[] split = line.split(" ");


            conversions.get(conversions.size() - 1).add(new ConversionRange(Long.parseLong(split[1]), Long.parseLong(split[0]), Long.parseLong(split[2])));
        }

        Long min = Long.MAX_VALUE;
        for (long seed : seeds) {
            long converted = getConverted(conversions, seed);
            if (converted < min) {
                min = converted;
            }
        }
        System.out.println(min);
    }

    private static long getConverted(List<List<ConversionRange>> conversions, long seed) {
        for (List<ConversionRange> ranges : conversions) {
            ConversionRange range = Range.getRange(ranges, seed);
            if (range != null) {
                seed = range.getConvertedNum(seed);
            }
        }
        return seed;
    }
}


