package com.gx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContainer {
	@Test
	public void myTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		FileWriterService service = context.getBean("fileWriterService", FileWriterService.class);
		service.write("hello 什么鬼");
		((ConfigurableApplicationContext) context).close();
	}
}
