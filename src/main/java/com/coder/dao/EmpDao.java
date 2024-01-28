package com.coder.dao;

import org.hibernate.*;

import com.coder.entity.Emp;

public class EmpDao {
	
	
	private SessionFactory  sessionFactory;

	public EmpDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	
	public boolean  saveEmp(Emp emp) {
		
		boolean  f =false; 
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		 
		
		int i=(Integer)session.save(emp);
		
		if(i>0) {
			f=true;
		}
		tx.commit(); // database save
		session.close();
		
		return f;
	}
}
