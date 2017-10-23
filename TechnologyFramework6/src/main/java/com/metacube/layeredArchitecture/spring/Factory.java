package main.java.com.metacube.layeredArchitecture.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Monil on 26-Sep-17.
 */
public class Factory
{

	static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

}