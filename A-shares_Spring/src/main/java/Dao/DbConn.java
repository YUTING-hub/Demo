package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConn {

	public static void main(String[] args) {
		System.out.println(DbConn.getSession());
		
	}
	
	public static Session getSession() {
		Configuration conn = new Configuration().configure();
		SessionFactory sf = conn.buildSessionFactory();
		Session se = sf.openSession();
		return se;
	}

}
