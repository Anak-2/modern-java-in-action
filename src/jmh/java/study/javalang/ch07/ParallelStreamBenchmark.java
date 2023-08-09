package study.javalang.ch07;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.All)
public class ParallelStreamBenchmark {

    private static final long N = 10_000_000L;

//    Benchmark method should return something and no parameter requires
    @Benchmark
    public long iterateSum(){
        long sum = 0;
        for(long i = 1L; i <= N; i++){
            sum += i;
        }
        return sum;
    }

    @Benchmark
    public long parallelSum(){
        return Stream.iterate(1L,i -> i+1)
                .limit(N)
                .parallel() // make stream parallel
                .reduce(0L, Long::sum);
    }

//    public static void main(String[] args) throws Exception {
//        org.openjdk.jmh.Main.main(args);               // 벤치마킹 시작
//    }

}



