package com.samples;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public final class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	private Main() { }

	/**
	 * Load the Spring Integration Application Context
	 *
	 * @param args - command line arguments
	 */
	public static void main(final String... args) {


		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/*-context.xml");

		context.registerShutdownHook();

		try {
			Thread.sleep(1*60*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Exiting application...bye.");
		}

		System.exit(0);

	}
}
