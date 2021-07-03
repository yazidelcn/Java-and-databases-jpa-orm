package com.yazid.demojpahibernate;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.yazid.demojpahibernate.entities.Employee;
import com.yazid.demojpahibernate.entities.EmployeeType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*Employee e1 =  new Employee();
    	e1.setName("Yazid Elcouhen");
    	e1.setAge(26);
    	e1.setDateOfBirth(new Date());
    	e1.setSsn("fakessn001");
    	e1.setType(EmployeeType.FULL_TIME);
    	e1.setTest("blabla");*/
    	
    	
    	/*
    	Employee e2 =  new Employee();
    	e2.setName("John Doe");
    	e2.setAge(46);
    	e2.setDateOfBirth(new Date());
    	e2.setSsn("fakessn002");
    	e2.setType(EmployeeType.CONTRACTOR);
    	
    	Employee e3 =  new Employee();
    	e3.setName("Dennis Reynolds");
    	e3.setAge(30);
    	e3.setDateOfBirth(new Date());
    	e3.setSsn("fakessn003");
    	e3.setType(EmployeeType.FULL_TIME);
    	
    	*/
    	/*
    	Employee e4 =  new Employee();
    	e4.setName("Ronald \"Mac\" McDonald");
    	e4.setAge(32);
    	e4.setDateOfBirth(new Date());
    	e4.setSsn("fakessn004");
    	e4.setType(EmployeeType.FULL_TIME);*/
    
    	
    	
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	
    	Employee employee_4 = entityManager.find(Employee.class, 4L);
    	employee_4.setName("MAC");
    	employee_4.setType(EmployeeType.CONTRACTOR);
    	//entityManager.persist(e1);
    	//entityManager.persist(e2);
    	entityManager.persist(employee_4);
    	transaction.commit();
    	
    	//Employee employee_1 = entityManager.find(Employee.class, 1L);
    	//Employee employee_3 = entityManager.find(Employee.class, 3L);
    	entityManager.close();
    	entityManagerFactory.close();
    	
    	
    	
    }
}
