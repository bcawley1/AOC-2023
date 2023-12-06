import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day5/src/input.txt"));
        List<Range> seedRanges = new ArrayList<>();
        List<List<ConversionRange>> conversions = new ArrayList<>();

        String[] seedPairs = scanner.nextLine().substring(7).split(" ");
        for (int i = 0; i<seedPairs.length; i+=2) {
            seedRanges.add(new Range(Long.parseLong(seedPairs[i]), Long.parseLong(seedPairs[i+1])));
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

        //Had to print percent completed because my code is so slow, I didn't even know if it was running.
        int progress = 0;
        long min = Long.MAX_VALUE;
        for(Range range : seedRanges){
            System.out.println(progress + "%");
            progress+=10;
            for(long l = 0; l < range.getRangeLength(); l++){
                long converted = getConverted(conversions, l+range.getRange());
                if(converted<min){
                    min = converted;
                }
            }
        }
        System.out.println(min);
    }
    private static long getConverted(List<List<ConversionRange>> conversions, long seed){
        for (List<ConversionRange> ranges : conversions) {
            ConversionRange range = Range.getRange(ranges, seed);
            if (range != null) {
                seed = range.getConvertedNum(seed);
            }
        }
        return seed;
    }
}


