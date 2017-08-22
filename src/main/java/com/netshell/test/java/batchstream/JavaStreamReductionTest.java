package com.netshell.test.java.batchstream;

import com.netshell.test.java.Test;

import java.util.Spliterator.OfInt;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class JavaStreamReductionTest implements Test {

    private static class IntegerSplitter implements OfInt {

        @Override
        public boolean tryAdvance(Consumer<? super Integer> action) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public long estimateSize() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int characteristics() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public java.util.Spliterator.OfInt trySplit() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean tryAdvance(IntConsumer action) {
            // TODO Auto-generated method stub
            return false;
        }

    }

    @Override
    public void execute() throws Exception {
        FixedBatchSpliterator.withBatchSize(IntStream.rangeClosed(1, 50).boxed(), 5)
                .forEach(x -> System.out.println(Thread.currentThread().getName() + ":\t" + x));
    }

}
