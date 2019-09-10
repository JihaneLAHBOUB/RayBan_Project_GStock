package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Achats;
import entities.Articles;
import util.HibernateUtil;
import util.HibernateUtil2;

public class AchatModel {
	
	//Lister tous les achats
	public  List<Achats> getAchats(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Achats");
			List<Achats> listAchats = query.list();
			transaction.commit();
			return listAchats;
			
		}
		catch (Exception ex) {
			if(!(transaction == null))
			transaction.rollback();
		}finally {
			session.close();
		}
		return null;
	}
	
	//Ajouter un nouveau achat
	public boolean addNew(Achats achat) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(achat);
			transaction.commit();
			
			return true;
			
		}
		catch (Exception ex) {
			if(!(transaction == null))
			transaction.rollback();
		}finally {
			session.close();
		}
		return false;
	}
	
	//Retourber un achat par codeAchat
	public Achats getAchatByID(int codeAchat) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Achats achat = (Achats) session.get(Achats.class, codeAchat);
			transaction.commit();
			return achat;
		} catch (Exception e) {
			if (!(transaction == null)) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}
	
	//Modifier un achat
	public boolean Update(Achats achat) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(achat);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (!(transaction == null)) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return false;
	}
	
	//Supprimer un achat
	public boolean delete(Achats achat) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(achat);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (!(transaction == null)) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return false;
	}

	//Chercher un achat par codeAchat
	public  List<Achats> searchAchatByID(int code){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String qr = "FROM Achats WHERE codeAchat ="+code;
			Query query = session.createQuery(qr);
			List<Achats> listAchats = query.list();
			transaction.commit();
			return listAchats;
			
		}
		catch (Exception ex) {
			if(!(transaction == null))
			transaction.rollback();
		}finally {
			session.close();
		}
		return null;
	}
	
	//Lister tous les articles
	public  List<Articles> getArticles(){
		Session session = HibernateUtil2.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			System.out.println("in achat model get articles ");
			Query query = session.createQuery("FROM Articles");
			List<Articles> listArticles = query.list();
			transaction.commit();
			return listArticles;
			
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
