package com.demo.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Product;


public class DaoImpl implements Dao {
	static SessionFactory sf;
	static {
		sf = HBUtil.getMyFact();
	}
	public void insertNewProduct(Product p) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(p);
		tr.commit();
		session.close();
	}
	public List<Product> display() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		//String str = "from product";
		//Query q=session.createQuery(str);
		Criteria cr = session.createCriteria(Product.class);
		List<Product> plist=cr.list();
		session.close();
		return plist;
	}
	@Override
	public Product get(int pid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p = session.get(Product.class, pid);
		tr.commit();
		session.close();
		return p;
	}
	@Override
	public boolean delete(int pid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p = session.get(Product.class, pid);
		if(p!=null) {
			session.remove(p);
			tr.commit();
			session.close();
			return true;
		}
		tr.commit();
		session.close();
		return false;
	}
	@Override
	public boolean update(int pid, int qty, double price) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p = session.get(Product.class, pid);
		if(p!=null) {
			p.setQty(qty);
			p.setPrice(price);
			session.update(p);
			tr.commit();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	
}
