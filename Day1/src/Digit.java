import java.util.List;


public enum Digit {
    ONE("o1e"),TWO("t2o"),THREE("t3e"),FOUR("f4r"),FIVE("f5e"),SIX("s6x"),SEVEN("s7n"),EIGHT("e8t"),NINE("n9e");


    public String getValue() {
        return value;
    }


    public static boolean isDigit(String s){
        return List.of(values()).contains(s);
    }


    String value;


    Digit(String i) {
        value = i;
    }
}

