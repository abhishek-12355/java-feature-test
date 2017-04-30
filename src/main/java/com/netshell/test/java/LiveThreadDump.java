package com.netshell.test.java;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.util.Timer;
import java.util.TimerTask;

public class LiveThreadDump implements Test {
	
	private static final String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
	private static final String jstack = "C:\\Softwares\\java\\jdk1.8.0_74\\bin\\jstack";
	private static final String dumpFile = "C:/temp/jstack_%s_%d.tdump";
	
	private static int j = 0;
	
	

	@Override
	public void execute() throws Exception {
		
		final String t = Thread.currentThread().getName();
		
		Timer timer = new Timer();
		TimerTask task = new  TimerTask() {
			@Override
			public void run() {
				try {
					ProcessBuilder b = new ProcessBuilder(jstack, pid);					
					b.redirectOutput(new File(String.format(dumpFile, t, System.currentTimeMillis())));
					Process start = b.start();
//					start.waitFor();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(task, 5000, 1000);
		
		for(int i = 0; i < 100; i++) {
			System.out.println("Inside Thread: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		timer.cancel();
		timer.purge();
	}

}
