package com.yazid.demojpahibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.yazid.demojpahibernate.entities.Employee;

public class JPQLDemo {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	TypedQuery<Employee> myQuery = entityManager.createQuery("select e from Employee e", Employee.class);
    	
    	TypedQuery<Employee> myQuery2 = entityManager.createQuery("select e from Employee e where e.name like '%Yazid%'", Employee.class);
    	
    	TypedQuery<Employee> myQuery3 = entityManager.createQuery("select e from Employee e where e.age between 20 and 30", Employee.class);
    	
    	//jpql is better than sql join
    	TypedQuery<Employee> joinLike = entityManager.createQuery("select e from Employee e where e.card.isActive = true", Employee.class);
    	
    	TypedQuery<Object[]> query = entityManager.createQuery("select e.name, e.age from Employee e", Object[].class);
    	
    	
    	//List<Employee> resultList = joinLike.getResultList();
    	//resultList.forEach(System.out::println);
    	
    	List<Object[]> resultList = query.getResultList();
    	resultList.forEach(object -> System.out.println(object[0]+ " " + object[1]));
    	
    	entityManager.close();
    	entityManagerFactory.close();
    	
    	
    //	List 
    	
	}

}
