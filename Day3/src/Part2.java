import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
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
        for(Symbol sym : symbols){
            int numTouching = 0;
            int productTouching = 1;
            if(sym.isStar()){
                for(Number num : numbers){
                    if (isTouching(num, sym)) {
                        numTouching++;
                        productTouching*=num.getValue();
                    }
                }
                if(numTouching==2){
                    sum+=productTouching;
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

