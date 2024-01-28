package com.coder.conn;

import java.util.*;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.coder.entity.*;
//import com.coder.servlet.*;
//import com.coder.dao.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.cfg.AvailableSettings;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			
			Configuration configuration =new Configuration();
			
			Properties properties=new  Properties();
			
			
			properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db1");
			properties.put(Environment.USER,"root");
			properties.put(Environment.PASS,"9860949212");
			properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
			properties.put(Environment.HBM2DDL_AUTO,"update");
			properties.put(Environment.SHOW_SQL,true);
			
			
			configuration.setProperties(properties);
			
			
			configuration.addAnnotatedClass(Emp.class);
			
			
			ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		}
		return sessionFactory;
		
	}

}
