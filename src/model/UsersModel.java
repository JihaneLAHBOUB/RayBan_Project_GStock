package model;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Users;
import util.HibernateUtil2;


public class UsersModel {

	public List<Users> getUsers(){
		Session session = HibernateUtil2.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Users");
			List<Users> listUsers = query.list();
			System.out.println("list users : "+listUsers);
			transaction.commit();
			return listUsers;
			
		}
		catch (Exception ex) {
			if(!(transaction == null))
			transaction.rollback();
		}finally {
			session.close();
		}
		return null;
	}
	
}
