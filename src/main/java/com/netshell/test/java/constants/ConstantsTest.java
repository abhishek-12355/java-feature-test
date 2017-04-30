package com.netshell.test.java.constants;

import com.netshell.test.java.Test;

public class ConstantsTest implements Test {
	@Override
	public void execute() throws Exception {
		IDGenerator g = IDGenerator.defaultGenerator();
		System.out.println(g.generateId());
	}
}

@FunctionalInterface
interface IDGenerator {
	String defaultId = "Default Id String";
	String generateId(String input);
	
	default String generateId() {
		return generateId(null);
	}
	
	static IDGenerator defaultGenerator() {
		return new IDGenerator() {
			@Override
			public String generateId(String input) {
				return input == null ? IDGenerator.defaultId : input;
			}
		};
	}
}
