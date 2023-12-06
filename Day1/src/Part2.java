import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day1/src/input.txt"));
        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int first = -1;
            int last = -1;
            while(containsLetterNum(line)!=null){
                line = line.replaceAll(containsLetterNum(line), String.valueOf(Digit.valueOf(containsLetterNum(line).toUpperCase()).getValue()));
            }
            for (Character c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    if (first == -1) {
                        first = digit;
                    } else {
                        last = digit;
                    }
                }
            }
            sum += Integer.parseInt(first + "" + (last != -1 ? last : first));
        }
        System.out.println(sum);
    }


    private static String containsLetterNum(String s){
        for(Digit d : Digit.values()){
            if(s.contains(d.toString().toLowerCase())){
                return d.toString().toLowerCase();
            }
        }
        return null;
    }
}



