package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.Dao;
import com.demo.dao.DaoImpl;

public class ServiceImpl implements Service {
	private Dao pdao;
	public ServiceImpl() {
		pdao = new DaoImpl();
	}
	public void addnewProduct() {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter pid");
			int pid=sc.nextInt();
			System.out.println("enter productname");
			String pname=sc.next();
			System.out.println("Enter qty");
			int qty=sc.nextInt();
			System.out.println("enter price");
			double pr=sc.nextDouble();
			Product p=new Product(pid,pname,qty,pr);
			pdao.insertNewProduct(p);
		
	}
	public List<Product> displayAll() {
		// TODO Auto-generated method stub
		return pdao.display();
	}
	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.get(pid);
	}
	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		return pdao.delete(pid);
	}
	@Override
	public boolean updateProduct(int pid, int qty, double price) {
		// TODO Auto-generated method stub
		return pdao.update(pid, qty, price);
	}
	
}
