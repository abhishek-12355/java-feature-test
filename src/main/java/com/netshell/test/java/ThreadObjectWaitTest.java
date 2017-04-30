package com.netshell.test.java;

public class ThreadObjectWaitTest implements Test {

	@Override
	public void execute() throws Exception {
		final ThreadObjectWaitTest t = this;
		Thread.currentThread().setName("Main Thread");
		System.out.println(System.currentTimeMillis());
		Thread thread = new Thread(()->{
			try {
				while(true) {
					Thread.sleep(10000);
					System.out.println("Inner Thread");
					this.notify();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
		thread.setName("Inner Thread");
		System.out.println(System.currentTimeMillis());
		thread.start();
		this.wait();
		thread.notify();
		System.out.println(System.currentTimeMillis());
	}

}
