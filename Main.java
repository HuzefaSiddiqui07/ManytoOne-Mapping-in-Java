package com.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		// Create an Object of CompanyAddress Class

		CompanyAddress companyAddress = new CompanyAddress();

		companyAddress.setCity("Pune");
		companyAddress.setState("MH");
		companyAddress.setCountry("India");
		companyAddress.setPincode("123456");

		// Create an Object-1 of Employee Class

		Employee employee1 = new Employee();

		employee1.setName("Shyam");
		employee1.setEmail("shyam12@gmail.com");
		employee1.setCompanyAddress(companyAddress);

		// Create an Object-2 of Employee Class

		Employee employee2 = new Employee();

		employee2.setName("Ram");
		employee2.setEmail("ram12@gmail.com");
		employee2.setCompanyAddress(companyAddress);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(employee1);
		session.save(employee2);

		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
