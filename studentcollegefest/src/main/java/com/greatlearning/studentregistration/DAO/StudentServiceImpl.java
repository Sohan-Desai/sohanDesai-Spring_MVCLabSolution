package com.greatlearning.studentregistration.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.studentregistration.entity.Student;
import com.greatlearning.studentregistration.service.StudentService;

@Repository
public class StudentServiceImpl implements StudentService {

	private Session session;

	/*
	 * the sessionFactory dependency from 'servlet.xml' file is injected using @Autowired
	 * 
	 * On failing to fetch current session the constructor attempts starting new session
	 */
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	/*
	 * All service methods are annotated with @Transactional annotation to maintain
	 * data integrity.
	 * Also each method needs to create its own transaction, as the changes need to be 
	 * committed for every operation
	 */

	/*
	 * Starts transaction, retrieves all records from DB using 'from' query
	 * and stores them Student List object, which is then returned to calling
	 * function after committing the transaction
	 */
	@Transactional
	public List<Student> findAll() {

		Transaction tx = session.beginTransaction();

		List<Student> students = session.createQuery("from Student").list();

		tx.commit();

		return students;
	}

	/*
	 * Takes id as parameter
	 * Starts transaction, retrieves record with matching id from DB using session.get()
	 * function and stores it in Student object
	 * commits the transaction
	 * and returns the Student object
	 */
	@Transactional
	public Student findById(int id) {

		Transaction tx = session.beginTransaction();

		Student student1 = session.get(Student.class, id);

		tx.commit();

		return student1;
	}
	
	/*
	 * takes a Student object to be saved as argument
	 * Starts transaction, saves the object record
	 * commits the transaction
	 */
	@Transactional
	public void save(Student student2) {

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(student2);

		tx.commit();
	}

	/*
	 * takes id as a parameter
	 * Starts transaction, retrieves record with matching id from DB using session.get()
	 * function and stores it in newly created Student object
	 * deletes the corresponding record from DB using session.delete() method
	 * commits the transaction
	 */
	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();

		Student student3 = session.get(Student.class, id);

		session.delete(student3);

		tx.commit();

	}

}
