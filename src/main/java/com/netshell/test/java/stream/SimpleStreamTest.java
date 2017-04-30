package com.netshell.test.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.netshell.test.java.Test;

public class SimpleStreamTest implements Test {
	private static final String[] intString = new String[]{
		"ZERO", "ONE", "TWO", "THREE", "FOUR",
		"FIVE", "SIX", "SEVEN", "EIGHT", "NINE",
		"TEN", "DEFAULT"
	};
	
	private static final List<Integer> list = 
			Arrays.asList(0, 1, 2, 3, 4, 5, 
					6, 7, 8, 9, 10, 11, 
					12, 13, 14, 15, 16, 
					17, 18, 19, 20);
	@Override
	public void execute() throws Exception {
		filter();
		map();
		group();
		groupCount();
	}

	private void groupCount() {
		Map<Boolean, Long> groupCount = list.stream()
				.collect(Collectors.groupingBy(
						i -> i < 10, 
						Collectors.counting()));
		
		System.out.println(groupCount);
	}

	private void group() {
		Map<Boolean, List<Integer>> group = list.stream()
				.collect(Collectors.groupingBy(i -> i < 10));
		System.out.println(group);
	}

	private void map() {
		List<String> strings = list.stream()
				.map(SimpleStreamTest::map)
				.collect(Collectors.toList());
		
		System.out.println(strings);
	}

	private void filter() {
		List<Integer> listL10 = list.stream()
				.filter(i -> i < 10)
				.collect(Collectors.toList());
		
		System.out.println("Items < 10: " + listL10);
	}
	
	private static String map(Integer i) {
		return i <= 10 ? intString[i] : intString[11];
	}
}
