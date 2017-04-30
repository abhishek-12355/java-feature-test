package com.netshell.test.java.methodref;

import java.util.function.Supplier;

import com.netshell.test.java.Test;

public class MethodReferenceTest implements Test {
	@Override
	public void execute() throws Exception {
//		Supplier<IDGenerator> g = () -> IDGenerator.defaultGenerator();
		Supplier<IDGenerator> g = IDGenerator::defaultGenerator;
		System.out.println(g.get().generateId());
	}
}

@FunctionalInterface
interface IDGenerator {
	String defaultId = "Method Ref Id String";
	String generateId(String input);
	
	default String generateId() {
		return generateId(null);
	}
	
	static IDGenerator defaultGenerator() {
		return input -> input == null ? IDGenerator.defaultId : input;
	}
}
