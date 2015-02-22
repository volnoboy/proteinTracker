package com.volnoboy;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Reuven on 2/8/15.
 */
public class HibernateUtilities {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {
		try {
			Configuration configuration = new Configuration().setInterceptor(new AuditInterceptor()).configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch (HibernateException e) {
			System.out.print("Problem creating SessionFactory");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
