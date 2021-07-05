package com.yazid.demojpahibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.yazid.demojpahibernate.entities.Employee;

public class JPQLParameterDemo {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	//Avoiding sql injections with Parameters
    	int minAge = 30;
    	TypedQuery<Employee> minAgeQuery = entityManager.createQuery("select e from Employee e where e.age > :minAge", Employee.class);
    	minAgeQuery.setParameter("minAge", minAge);
    	
    	List<Employee> resultList = minAgeQuery.getResultList();
    	resultList.forEach(System.out::println);
    	entityManager.close();
    	entityManagerFactory.close();
    	
	}

}
