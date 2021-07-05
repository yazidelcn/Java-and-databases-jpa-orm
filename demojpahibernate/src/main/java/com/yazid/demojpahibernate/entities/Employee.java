package com.yazid.demojpahibernate.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="EMPLOYEE_DATA")
@NamedQuery(query="select e from Employee e order by e.age desc", name="emp age desc")
@NamedQuery(query="select e from Employee e where e.age = :age", name="emp by age")
public class Employee {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="employee_name", length = 100)
	private String name;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(unique = true, nullable = false, updatable = false)
	private String ssn;
	
	@Transient
	private String test;
	
	@OneToOne
	private AccessCard card;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<PayStub> payStubs = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "EMAIL_GROUP_SUBSCRIPTIONS",
		joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
		inverseJoinColumns = @JoinColumn(name="SUBSCRIPTION_EMAIL_ID")
			)
	private List<EmailGroup> emailGroups = new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}


	public AccessCard getCard() {
		return card;
	}

	public void setCard(AccessCard card) {
		this.card = card;
	}
	
	
	
	public List<PayStub> getPayStubs() {
		return payStubs;
	}

	public void setPayStubs(List<PayStub> payStubs) {
		this.payStubs = payStubs;
	}
	
	
	public void addPayStub(PayStub paystub) {
		this.payStubs.add(paystub);
	}
	
	
	public void addEmailGroup(EmailGroup emailGroup) {
		this.emailGroups.add(emailGroup);
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", type=" + type + ", dateOfBirth="
				+ dateOfBirth + ", ssn=" + ssn + ", test=" + test + ", card=" + card + ", payStubs=" + payStubs + "]";
	}

	 

	

	
}
