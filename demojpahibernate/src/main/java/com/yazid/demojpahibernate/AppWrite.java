package com.yazid.demojpahibernate;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.yazid.demojpahibernate.entities.AccessCard;
import com.yazid.demojpahibernate.entities.Employee;
import com.yazid.demojpahibernate.entities.EmployeeType;

/**
 * Hello world!
 *
 */
public class AppWrite 
{
    public static void main( String[] args )
    {
    	
    	
    	Employee e1 =  new Employee();
    	e1.setName("Yazid Elcouhen");
    	e1.setAge(26);
    	e1.setDateOfBirth(new Date());
    	e1.setSsn("fakessn001");
    	e1.setType(EmployeeType.FULL_TIME);
    	e1.setTest("blabla");
    	
    	
    
    	Employee e2 =  new Employee();
    	e2.setName("John Doe");
    	e2.setAge(46);
    	e2.setDateOfBirth(new Date());
    	e2.setSsn("fakessn002");
    	e2.setType(EmployeeType.CONTRACTOR);
    	
    	
    	AccessCard card1 = new AccessCard();
    	card1.setIssuedDate(new Date());
    	card1.setActive(true);
    	card1.setFirmwareVersion("V1");
    	card1.setOwner(e1);
    	e1.setCard(card1);
    	
    	AccessCard card2 = new AccessCard();
    	card2.setIssuedDate(new Date());
    	card2.setActive(false);
    	card2.setFirmwareVersion("V1");
    	card2.setOwner(e2);
    	e2.setCard(card2);
    	
    	
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	
    	//Employee employee_4 = entityManager.find(Employee.class, 4L);
    	//employee_4.setName("MAC");
    	//employee_4.setType(EmployeeType.CONTRACTOR);
    	entityManager.persist(e1);
    	entityManager.persist(e2);
    	entityManager.persist(card1);
    	entityManager.persist(card2);
    	transaction.commit();
    	
    	//Employee employee_1 = entityManager.find(Employee.class, 1L);
    	//Employee employee_3 = entityManager.find(Employee.class, 3L);
    	entityManager.close();
    	entityManagerFactory.close();
    	
    	
    	
    }
}