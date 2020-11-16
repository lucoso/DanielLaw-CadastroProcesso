package br.com.lucaswagner.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("DanielLaw");
	}

	public static EntityManager getEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("DanielLaw");
		}
		return factory.createEntityManager();
	}

	public static void close() {
		factory.close();
	}

}
