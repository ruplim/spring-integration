package com.samples;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.integration.monitor.IntegrationMBeanExporter;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
/*
 * 
 * Provides access to Shutdown() from JConsole
 * 
 * */
@ManagedResource(objectName="com.samples.AppManagement:type=Shutdown")
public class GracefulShutdown implements ApplicationContextAware {
	
	private IntegrationMBeanExporter integrationMBeanExporter;
    private AbstractApplicationContext ctx;
    
	public IntegrationMBeanExporter getIntegrationMBeanExporter() {
		return integrationMBeanExporter;
	}

	public void setIntegrationMBeanExporter(IntegrationMBeanExporter integrationMBeanExporter) {
		this.integrationMBeanExporter = integrationMBeanExporter;
	}

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = (AbstractApplicationContext)ctx;
		
	}
	
    public void stopIntegrationComponents() {
		//This only stops the Integratin components; does not destroy context
    	integrationMBeanExporter.stopActiveComponents(10L);
    }
    @ManagedOperation
	public void Shutdown() {
		
		stopIntegrationComponents();
		ctx.close();
		ctx.destroy();
		
	}
	
	
	

}
