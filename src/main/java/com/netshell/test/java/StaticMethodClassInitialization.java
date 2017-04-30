package com.netshell.test.java;

public class StaticMethodClassInitialization implements Test {

	@Override
	public void execute() throws Exception {
		Thread t1 = new Thread(new ThreadTest("ABC", 550));
		Thread t2 = new Thread(new ThreadTest("XYZ", 500));
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	
	static class A {
		public static <T> T createObject(Class<T> tClass, String arg) throws Exception {
			System.out.println(arg);
			System.out.println(arg);
			return tClass.getConstructor(String.class).newInstance(arg);
		}
	}
	
	static class ThreadTest implements Runnable {

		private String arg;
		private int pause;

		public ThreadTest(String arg, int pause) {
			this.arg = arg;
			this.pause = pause;
		}
		
		@Override
		public void run() {
			try {
				B createObject = A.createObject(B.class, arg);
				Thread.sleep(pause);
				createObject.out();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	static class B {
		private String arg;

		public B(String arg) {
			this.arg = arg;
		}

		public void out() {
			System.out.println(arg);
		}
	}
}
