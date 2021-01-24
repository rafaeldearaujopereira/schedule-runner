package com.rafpereira.scheduler.data.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.rafpereira.data.util.SessionFactoryUtil;
import com.rafpereira.scheduler.model.ScheduleOwnership;

public class SchedulerSessionFactoryUtil extends SessionFactoryUtil {

	/**
	 * The current implementation (for the user system).
	 */
	protected static SessionFactoryUtil sessionFactoryUtil;

	private static SessionFactory factory;

	private static ServiceRegistry serviceRegistry;

	/**
	 * Obtains the current implementation of the session factory.
	 * 
	 * @return The session factory.
	 */
	public static SessionFactoryUtil getInstance() {
		return sessionFactoryUtil;
	}

	private static SessionFactory getSessionFactory() {
		if (factory == null && sessionFactoryUtil != null) {
			Configuration config = sessionFactoryUtil.getConfiguration();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			factory = config.buildSessionFactory(serviceRegistry);
		}
		return factory;
	}

	@Override
	public Session getSession() {
		return getSessionFactory().openSession();
	}

	@Override
	public Configuration getConfiguration() {
		Configuration config = new Configuration();
		config.configure("/com/rafpereira/scheduler/config/hibernate.cfg.xml");
		config.addAnnotatedClass(ScheduleOwnership.class);
		return config;
	}

	public SchedulerSessionFactoryUtil() {
		if (sessionFactoryUtil == null) {
			sessionFactoryUtil = this;
		}
	}

	@Override
	protected SessionFactory getFactory() {
		return factory;
	}

}