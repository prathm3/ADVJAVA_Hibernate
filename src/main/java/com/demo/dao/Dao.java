package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface Dao {

	void insertNewProduct(Product p);

	List<Product> display();

	Product get(int pid);

	boolean delete(int pid);

	boolean update(int pid, int qty, double price);

}
