package model;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Articles;
import entities.Inventaire;
import util.HibernateUtil;
import util.HibernateUtil2;

public class InventaireModel {

	//Lister tous les inventaires
	public  List<Inventaire> getInventaires(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Inventaire");
			List<Inventaire> listInventaires = query.list();
			transaction.commit();
			return listInventaires;
			
		}
		catch (Exception ex) {
			if(!(transaction == null))
			transaction.rollback();
		}finally {
			session.close();
		}
		return null;
	}

	//Ajouter un nouveau inventaire
	public boolean addNewInv(Inventaire inventaire) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(inventaire);
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
	
	//Retourner un inventaire par codeInv
	public Inventaire getInventoryByID(int codeInv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Inventaire inventaire = (Inventaire) session.get(Inventaire.class, codeInv);
			transaction.commit();
			return inventaire;
		} catch (Exception e) {
			if (!(transaction == null)) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}
	
	
	//Modifier un inventaire
	public boolean UpdateInv(Inventaire inventaire) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(inventaire);
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
	
	//supprimer un inventaire
	public boolean deleteInv(Inventaire inventaire) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(inventaire);
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
	
	//Chercher un inventaire par code
	public  List<Inventaire> searchInventoryByID(int code){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String qr = "FROM Inventaire WHERE codeInv ="+code;
			Query query = session.createQuery(qr);
			List<Inventaire> listInventaires = query.list();
			transaction.commit();
			return listInventaires;
			
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
