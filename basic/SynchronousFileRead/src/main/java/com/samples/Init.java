package com.samples;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Init {

	public static void main(String[] args) {
	    AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("fileread-bean.xml");
		ctx.registerShutdownHook();
		
		try {
			//Sleep for 10 seconds
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ctx.close();	
		}

	}

}
