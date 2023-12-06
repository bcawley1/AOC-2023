import java.util.List;

public class Range {
    protected final long range;
    protected final long rangeLength;


    public Range(long range, long rangeLength) {
        this.range = range;
        this.rangeLength = rangeLength;
    }

    public boolean inRange(long num) {
        return (num >= range && num < range + rangeLength);
    }


    public static <T extends Range> T getRange(List<T> ranges, long num) {
        for (T range : ranges) {
            if (range.inRange(num)) {
                return range;
            }
        }
        return null;
    }

    public long getRangeLength() {
        return rangeLength;
    }

    public long getRange() {
        return range;
    }
}
