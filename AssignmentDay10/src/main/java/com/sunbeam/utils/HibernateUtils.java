package com.sunbeam.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		factory=new Configuration() //empty config
				    .configure() //reads all props n mappings from hibernate.cfg.xml
				    .buildSessionFactory();
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	

}
