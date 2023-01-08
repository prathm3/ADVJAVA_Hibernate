package com.demo.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.beans.Product;

public class TestCriteriaQuery {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Criteria cr = session.createCriteria(Product.class);
		List<Product> plist = cr.list();
		plist.forEach(p -> System.out.println(p));
		
		Criterion gt = Restrictions.gt("price", 1000.0);
		Criterion lt = Restrictions.lt("price", 10.0);
		LogicalExpression expr = Restrictions.or(gt, lt);
		Criteria cr1 = cr.add(expr);
		plist = cr1.list();
		plist.forEach(p -> System.out.println(p));
		
		
		System.out.println("using JPQL");
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Product> cr2=cb.createQuery(Product.class);
		Root<Product> root=cr2.from(Product.class);
		Query q=session.createQuery(cr2.select(root));
	    plist=q.getResultList();
	    plist.forEach(x->{System.out.println(x);});

	}
}
