public class ConversionRange extends Range {
    private final long destRange;


    public ConversionRange(long sourceRange, long destRange, long rangeLength) {
        super(sourceRange, rangeLength);
        this.destRange = destRange;
    }


    public long getConvertedNum(long num) {
        return inRange(num) ? destRange + (num - range) : num;
    }
}
