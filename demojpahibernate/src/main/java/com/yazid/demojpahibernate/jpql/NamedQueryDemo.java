package com.yazid.demojpahibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.yazid.demojpahibernate.entities.Employee;

public class NamedQueryDemo {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	int age = 26;
    	//TypedQuery<Employee> emp_age_desc = entityManager.createNamedQuery("emp age desc", Employee.class)
    	
    	;
    	TypedQuery<Employee> emp_by_age = entityManager.createNamedQuery("emp by age", Employee.class);
    	emp_by_age.setParameter("age", age);
    	
    	
    	List<Employee> resultList = emp_by_age.getResultList();
    	resultList.forEach(System.out::println);
    	
    	
    	entityManager.close();
    	entityManagerFactory.close();
    	
	}

	}


