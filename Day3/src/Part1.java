import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day3/src/input.txt"));
        List<Symbol> symbols = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();

        int lineNum = 0;
        while (scanner.hasNext()) {
            String number = "";

            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '.' && !(47 < chars[i] && chars[i] < 58)) {
                    symbols.add(new Symbol(i, lineNum, chars[i]=='*'));
                } else if (chars[i] != '.') {
                    number = number + chars[i];
                    if (i == chars.length - 1 || !(47 < chars[i + 1] && chars[i + 1] < 58)) {
                        numbers.add(new Number(Integer.parseInt(number), i - number.length() + 1, i, lineNum));
                        number = "";
                    }
                }
            }
            lineNum++;
        }

        int sum = 0;
        for (Number num : numbers) {
            for (Symbol sym : symbols) {
                if (isTouching(num, sym)) {
                    sum+=num.getValue();
                }
            }
        }
        System.out.println(sum);
    }
    private static boolean isTouching(Number num, Symbol sym){
        return (sym.getVerticleIndex() >= num.getVerticleIndex() - 1 && sym.getVerticleIndex() <= num.getVerticleIndex() + 1) &&
                sym.getIndex()>=num.getLeftIndex()-1&&sym.getIndex()<=num.getRightIndex()+1;
    }
}

