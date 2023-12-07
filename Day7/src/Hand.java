import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Hand implements Comparable {
    String value;
    Type type;

    public Hand(String value) {
        this.value = value;
        this.type = getType(value);
    }

    public Type getType() {
        return type;
    }

    private Type getType(String s){
        Map<Character, Integer> labelCounts = new HashMap<>();
        for (Character c : s.toCharArray()){
                labelCounts.putIfAbsent(c, 0);
                labelCounts.merge(c, 1, Integer::sum);
        }
        return switch (labelCounts.size()){
            case 5 -> Type.HIGH_CARD;
            case 4 -> Type.ONE_PAIR;
            case 3 -> Collections.max(labelCounts.values())==3 ? Type.THREE_OF_KIND : Type.TWO_PAIR;
            case 2 -> Collections.max(labelCounts.values())==4 ? Type.FOUR_OF_KIND : Type.FULL_HOUSE;
            default -> null;
        };
    }

    @Override
    public int compareTo(Object o) {
        return "".compareTo();
    }

    enum Type {FIVE_OF_KIND, FOUR_OF_KIND, FULL_HOUSE, THREE_OF_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD}

}
