package com.yazid.demojpahibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.yazid.demojpahibernate.entities.EmailGroup;
import com.yazid.demojpahibernate.entities.Employee;

public class AppUpdate {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	Employee employee = entityManager.find(Employee.class, 2L);
    	EmailGroup group  = entityManager.find(EmailGroup.class, 8L);
    	
    	employee.addEmailGroup(group);
    	group.addEmployee(employee);
    	
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(group);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

	}

}
