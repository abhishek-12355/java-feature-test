package com.netshell.test.java;

import java.lang.reflect.Constructor;

public class NewInstanceTest implements Test {

	@Override
	public void execute() throws Exception {
//		System.out.println(TestClass.class.newInstance());
		
		Constructor<?> constructor = TestClass.class.getDeclaredConstructors()[0];
		
		constructor.setAccessible(true);
		System.out.println(constructor.newInstance());
	}
	
	private static final class TestClass {
		
//		TestClass instance = new TestClass() ;
		
		private TestClass() {
			
		}
		
//		public TestClass getInstance() {
//			return instance;
//		}
	}

}
