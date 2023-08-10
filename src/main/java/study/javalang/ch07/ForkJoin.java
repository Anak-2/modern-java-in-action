package study.javalang.ch07;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ForkJoin extends java.util.concurrent.RecursiveTask<Long>{

    private static final long INPUT = 10_000_000;

    public static void main(String[] args) {
        System.out.print("single sum: ");ParallelStream.getSumPerformance(ForkJoin::singleSum, INPUT);
        System.out.print("parallel sum: ");ParallelStream.getSumPerformance(ParallelStream::parallelSum, INPUT);
        System.out.print("fork join sum: ");ParallelStream.getSumPerformance(ForkJoin::forkJoinSum, INPUT);
    }

    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD = 10_000;

    public ForkJoin(long[] numbers){
        this(numbers, 0, numbers.length);
    }
    private ForkJoin(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        int length = end - start;
        if(length <= THRESHOLD){
            return computeSequentially();
        }
        ForkJoin leftTask = new ForkJoin(numbers, start, start+length/2);
        leftTask.fork(); // makes another thread and executes task asynchronously
        ForkJoin rightTask = new ForkJoin(numbers, start+length/2, end);

        Long leftResult = leftTask.compute();
        Long rightResult = rightTask.compute();

        return leftResult + rightResult;
    }

    private long computeSequentially(){
        long sum = 0;
        for(int i = start; i < end; i++){
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n){
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoin(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static long singleSum(long n){
        return LongStream.rangeClosed(1, n).sum();
    }

}
