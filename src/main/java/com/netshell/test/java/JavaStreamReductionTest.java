package com.netshell.test.java;

import java.util.Spliterator.OfInt;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.netshell.test.java.batchstream.FixedBatchSpliterator;

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
		FixedBatchSpliterator.withBatchSize(IntStream.rangeClosed(1, 500).boxed(), 50).forEach(System.out::println);
	}

}
