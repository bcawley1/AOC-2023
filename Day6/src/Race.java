public class Race {
    private long time;
    private long recordDistance;

    public Race(long time, long recordDistance) {
        this.time = time;
        this.recordDistance = recordDistance;
    }

    public long getNumOfWaysToBeat(){
        long sum = 0;
        for(long i = 0; i <= time; i++){
            if((time-i)*i>recordDistance){
                sum++;
            }
        }
        return sum;
    }
}
