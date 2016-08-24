package com.samples;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Init 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("endpoint-bean.xml");
        ctx.registerShutdownHook();
        
		try {
			Thread.sleep(1*60*1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} finally {
			ctx.close();	
		}        
    }
}
