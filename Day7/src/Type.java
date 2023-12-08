public enum Type {
    FIVE_OF_KIND(7), FOUR_OF_KIND(6), FULL_HOUSE(5), THREE_OF_KIND(4), TWO_PAIR(3), ONE_PAIR(2), HIGH_CARD(1);

    private final int value;

    Type(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}