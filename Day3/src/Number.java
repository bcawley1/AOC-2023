public class Number {
    private int value;
    private int leftIndex;
    private int rightIndex;
    private int verticleIndex;

    public Number(int value, int leftIndex, int rightIndex, int verticleIndex) {
        this.value = value;
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.verticleIndex = verticleIndex;
    }

    public int getValue() {
        return value;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public int getVerticleIndex() {
        return verticleIndex;
    }

    @Override
    public String toString() {
        return "(%s | Left: %s, Right: %s)".formatted(value, leftIndex, rightIndex);
    }
}
