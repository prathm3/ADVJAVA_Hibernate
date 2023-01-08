package com.demo.test;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.Service;
import com.demo.service.ServiceImpl;


public class Test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Service pservice=new ServiceImpl();
		int choice=0;
		do {
		System.out.println("1.Add product\n 2. delete product\n3. update Product\n4. display All5. displayBy Id6.exit\n ");
		System.out.println("Choice :");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			pservice.addnewProduct();
			break;
		case 2:
			System.out.println("enter pid");
			int pid=sc.nextInt();
			boolean status=pservice.deleteById(pid);
			if(status) {
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 3:
			System.out.println("enter pid");
			pid=sc.nextInt();
			System.out.println("enetr qty");
			int qty=sc.nextInt();
			System.out.println("enetr price");
			double price=sc.nextDouble();
			status=pservice.updateProduct(pid,qty,price);
			if(status) {
				System.out.println("updated successfully");
			}
			else {
				System.out.println("not found");
			}
			break;
			
		case 4:
			List<Product> plist=pservice.displayAll();
			if(plist!=null) {
				plist.forEach(x->{System.out.println(x);});
			}
			else {
				System.out.println("no product object exists");
			}
			break;
		case 5:
			System.out.println("enter pid");
			pid=sc.nextInt();
			Product p=pservice.getById(pid);
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.out.println("not found");
			}
			break;
		case 6:
			System.out.println("Thank you for visitiong .....");
			//pservice.closeSessionFactory();
			break;
		default:
			System.out.println("Wrong choice");
		}
		}while(choice!=6);
	}
}
