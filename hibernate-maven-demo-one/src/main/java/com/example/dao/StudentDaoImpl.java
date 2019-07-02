package com.example.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Student;

public class StudentDaoImpl implements StudentDAO {

	private SessionFactory factory;
	private Session session;

	public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		session = factory.openSession();
	}

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub

		session.getTransaction().begin();
		session.persist(student);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		Query query = session.createQuery("from Student");
		return query.getResultList();
	}

	@Override
	public Student getStudentById(int id) {
		Student s = session.get(Student.class, new Integer(id));
		return s;
	}

	@Override
	public List<Student> getStudentByName(String fName) {
		Query query = session.createNamedQuery("getStudentByName").setString("firstName", fName);

		return query.getResultList();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
       
		Student s = session.get(Student.class, id);
		if(s != null) {
			session.getTransaction().begin();
			session.delete(s);
			session.getTransaction().commit();
		}
		
	}

	@Override
	public List<Student> getStudentByLastName(String lName) {
		Query query = session.createNativeQuery("findByLastName").setString("lastName", lName);
		return query.getResultList();
	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		Student s = session.get(Student.class, id);
		Scanner sc = new Scanner(System.in);
		
		if( s != null) {
			System.out.println(s);
			System.out.println("Do you want to change first name:");
			String fName = sc.next();
			if(fName.equals("yes")) {
				System.out.println("Enter first name: ");
				String firstName = sc.next();
				s.setFirstName(firstName);
			}
			
			System.out.println("Do you want to change last name:");
			String lName = sc.next();
			if(lName.equals("yes")) {
				System.out.println("Enter last name: ");
				String lastName = sc.next();
				s.setLastName(lastName);
			}
			
			System.out.println("Do you want to change email:");
			String e = sc.next();
			if(e.equals("yes")) {
				System.out.println("Enter email: ");
				String email = sc.next();
				s.setEmail(email);
			}
			
			session.getTransaction().begin();
			session.merge(s);
			session.getTransaction().commit();
			
		}
	}
}
