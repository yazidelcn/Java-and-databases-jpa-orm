package com.yazid.demojpahibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.yazid.demojpahibernate.entities.AccessCard;
import com.yazid.demojpahibernate.entities.Employee;
import com.yazid.demojpahibernate.entities.PayStub;

public class AppRead {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	Employee e1 =  entityManager.find(Employee.class, 1L);
    	System.out.println(e1);
        AccessCard c1 = entityManager.find(AccessCard.class, 3L);
        System.out.println(c1);
        
        PayStub p1 = entityManager.find(PayStub.class, 5L);
        System.out.println(p1);

	}

}
