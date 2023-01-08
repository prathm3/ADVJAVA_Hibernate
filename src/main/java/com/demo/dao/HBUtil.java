package com.demo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HBUtil {
	static private SessionFactory sf = null;
	public static SessionFactory getMyFact() {
		if(sf == null) {
			sf = new Configuration().configure().buildSessionFactory();
		}
		return sf;
	}
}
