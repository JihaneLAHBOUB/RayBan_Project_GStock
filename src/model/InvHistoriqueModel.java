package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Achats;
import entities.Articles;
import entities.Commandes;
import entities.Inventaire;
import util.HibernateUtil;
import util.HibernateUtil2;

public class InvHistoriqueModel {

	private Date dateConvert;
	private String DateX;
	
	public String getDate() {
		return DateX;
	}

	public void setDate(String date) {
		this.DateX = date;
	}
	
	public Date getDateConvert() {
		return dateConvert;
	}

	public void setDateConvert(Date dateConvert) {
		this.dateConvert = dateConvert;
	}

	//Lister tous les articles
	public List<Articles> getArticles(){
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
	
	//Retourner inventaire d'un article
	public List<Inventaire> getArticleInventaire(int i){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String qr ="FROM Inventaire WHERE codeArt ="+i;
			Query query = session.createQuery(qr);
			List<Inventaire> listArticleInventaire = query.list();
			transaction.commit();
			return listArticleInventaire;
			
		}
		catch (Exception ex) {
			if(!(transaction == null))
			transaction.rollback();
		}finally {
			session.close();
		}
		return null;
	}
	
	//Retourner tous les achats d'un article
	public List<Achats> getArticleAchat(int i){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String qr ="FROM Achats WHERE codeArt ="+i;
			Query query = session.createQuery(qr);
			List<Achats> listArticleAchat = query.list();
			transaction.commit();
			return listArticleAchat;
			
		}
		catch (Exception ex) {
			if(!(transaction == null))
			transaction.rollback();
		}finally {
			session.close();
		}
		return null;
	}
	
	//Retourner tous les commandes d'un article
	public List<Commandes> getArticleCommande(int i){
		Session session = HibernateUtil2.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String qr ="FROM Commandes WHERE codeArt ="+i;
			Query query = session.createQuery(qr);
			List<Commandes> listArticleAchat = query.list();
			transaction.commit();
			return listArticleAchat;
			
		}
		catch (Exception ex) {
			if(!(transaction == null))
			transaction.rollback();
		}finally {
			session.close();
		}
		return null;
	}
	
	//Methode pour convertir la date
	public Date convertStringToDate(String date) {
		try {
			this.dateConvert = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.dateConvert;
	}
	
}
