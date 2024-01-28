package com.coder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coder.conn.HibernateUtil;
import com.coder.dao.EmpDao;
import com.coder.entity.Emp;



@WebServlet("/register")
public class RegisterServlet extends  HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("name");
		String department=req.getParameter("department");
		String salary=req.getParameter("salary");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Emp emp =new Emp(name,department,salary,email,password);
		
		System.out.println(emp);
		
		EmpDao dao=new EmpDao(HibernateUtil.getSessionFactory());
		boolean f=dao.saveEmp(emp);
		
		HttpSession session=req.getSession();
		
		if (f) {
			session.setAttribute("msg", "Emp Register Successfully...");
			System.out.println("Emp Register Successfully...");
		}else {
			
			session.setAttribute("msg","something wrong on server");
			System.out.println("something wrong on server");
			
		}
		resp.sendRedirect("index.jsp");
		
	}
	
	

	
}
