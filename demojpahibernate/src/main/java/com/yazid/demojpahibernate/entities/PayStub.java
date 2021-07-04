package com.yazid.demojpahibernate.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class PayStub {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start")
	private Date PayPeriodStart;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end")
	private Date PayPeriodEnd;
	
	private double salary;
	
	@ManyToOne
	@JoinColumn(name="paystub_for")
	private Employee employee;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getPayPeriodStart() {
		return PayPeriodStart;
	}
	public void setPayPeriodStart(Date payPeriodStart) {
		PayPeriodStart = payPeriodStart;
	}
	public Date getPayPeriodEnd() {
		return PayPeriodEnd;
	}
	public void setPayPeriodEnd(Date payPeriodEnd) {
		PayPeriodEnd = payPeriodEnd;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "PayStub [id=" + id + ", PayPeriodStart=" + PayPeriodStart + ", PayPeriodEnd=" + PayPeriodEnd
				+ ", salary=" + salary + "]";
	}
	
	

}
