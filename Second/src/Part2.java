import java.util.concurrent.Callable;

public class Part2 implements Callable<Long> {

    int core;
    long start;
    long end;

    public Part2(int core, long start, long end) {
        this.core = core;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        long sum=0;
        for (long temp = this.start; temp <= this.end; temp++) {
            if (Part1.contain(temp, core)) {
                sum += temp;
            }
        }
        return sum;
    }
}
