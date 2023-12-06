public class Symbol {
    private int index;
    private int verticleIndex;
    private boolean isStar;

    public Symbol(int index, int verticleIndex, boolean isStar) {
        this.index = index;
        this.verticleIndex = verticleIndex;
        this.isStar = isStar;
    }

    public int getIndex() {
        return index;
    }

    public boolean isStar() {
        return isStar;
    }

    public int getVerticleIndex() {
        return verticleIndex;
    }
}
