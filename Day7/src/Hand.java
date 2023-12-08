import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Hand {
    private final String value;
    private final Type type;

    public Hand(String value) {
        this.value = value;
        this.type = getType(value);
    }

    private Type getType(String s) {
        Map<Character, Integer> labelCounts = new HashMap<>();
        for (Character c : s.toCharArray()) {
            labelCounts.putIfAbsent(c, 0);
            labelCounts.merge(c, 1, Integer::sum);
        }
        //Remove lines 23-32 to get the part 1 answer
        int max = 0;
        char maxChar = 0;
        for (Map.Entry<Character, Integer> entry : labelCounts.entrySet()) {
            if(entry.getValue()>max&&!entry.getKey().equals('J')){
                max = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        labelCounts.merge(maxChar, labelCounts.getOrDefault('J', 0), Integer::sum);
        labelCounts.remove('J');

        return switch (labelCounts.size()) {
            case 5 -> Type.HIGH_CARD;
            case 4 -> Type.ONE_PAIR;
            case 3 -> Collections.max(labelCounts.values()) == 3 ? Type.THREE_OF_KIND : Type.TWO_PAIR;
            case 2 -> Collections.max(labelCounts.values()) == 4 ? Type.FOUR_OF_KIND : Type.FULL_HOUSE;
            case 1 -> Type.FIVE_OF_KIND;
            default -> null;
        };

    }

    public static class PlayerComparator implements Comparator<Player> {
        final private String ORDER;

        public PlayerComparator(String order) {
            this.ORDER = order;
        }

        @Override
        public int compare(Player o1, Player o2) {
            int compare = o1.hand().type.getValue().compareTo(o2.hand().type.getValue());
            if (compare != 0) {
                return compare;
            } else {
                for (int i = 0; i < o1.hand().value.length(); i++) {
                    compare = ORDER.indexOf(o2.hand().value.charAt(i)) - ORDER.indexOf(o1.hand().value.charAt(i));
                    if (compare != 0) {
                        return compare;
                    }
                }
            }
            return 0;
        }
    }
}
