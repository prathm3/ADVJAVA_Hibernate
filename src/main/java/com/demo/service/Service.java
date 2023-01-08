package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface Service {

	void addnewProduct();

	List<Product> displayAll();

	Product getById(int pid);

	boolean deleteById(int pid);

	boolean updateProduct(int pid, int qty, double price);

}
