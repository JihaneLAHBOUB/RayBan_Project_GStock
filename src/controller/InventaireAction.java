package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.*;

import entities.Articles;
import entities.Inventaire;
import model.InventaireModel;

public class InventaireAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private InventaireModel inventaireModel = new InventaireModel();
	private List<Inventaire> listInventaires;
	private List<Articles> listArticles;
	private Inventaire inventaire = new Inventaire();
	private Integer codeInv;
	private String dateInv;
	
		
	public List<Inventaire> getListInventaires() {
		return listInventaires;
	}
	public void setListInventaires(List<Inventaire> listInventaires) {
		this.listInventaires = listInventaires;
	}
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	
	public int getCodeInv() {
		return codeInv;
	}
	public void setCodeInv(int codeInv) {
		this.codeInv = codeInv;
	}
	public String getDateInv() {
		return dateInv;
	}
	public void setDateInv(String dateInv) {
		this.dateInv = dateInv;
	}
	
	public List<Articles> getListArticles() {
		return listArticles;
	}
	public void setListArticles(List<Articles> listArticles) {
		this.listArticles = listArticles;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
		}
	@Override
	public String execute() throws Exception {
		this.listInventaires = inventaireModel.getInventaires();
		
		return SUCCESS;
	}

	
	//Envoyer vers page d'aventaire
	public String inventaire() throws Exception {
		this.listInventaires = inventaireModel.getInventaires();
		return SUCCESS;
	}

	//Envoyer vers page d'ajouter un inventaire
	public String addNewInv() throws Exception {
		this.listArticles= inventaireModel.getArticles();
		return SUCCESS;
	}

	//Ajouter un inventaire
	public String processAddNewInv() throws Exception {
		
		this.listArticles= inventaireModel.getArticles();
		
		if(this.inventaire.getQteArt() >0) {
			
			this.inventaire.setDateInv(new Date());
		
		}else {
			request.setAttribute("message", "Required Fields !");
			return ERROR;
		}
		boolean isCheck = inventaireModel.addNewInv(this.inventaire);
		if(isCheck) {
			this.listInventaires = inventaireModel.getInventaires();
			return SUCCESS;
		}
		request.setAttribute("message", "Add new item is unsuccessful!");
		return ERROR;
	}

	//Envoyer vers page modifier l'inventaire
	public String updateInv() throws Exception {
		this.inventaire = inventaireModel.getInventoryByID(this.codeInv);
		this.listArticles= inventaireModel.getArticles();	
		return SUCCESS;
	}
	//Modifier l'inventaire
	public String processUpdateInv() throws Exception {
		this.listArticles= inventaireModel.getArticles();	
		
		if(this.inventaire.getQteArt() > 0) {
			
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date receptionDate = format.parse(this.dateInv);
		java.sql.Date DateSQL = new java.sql.Date(receptionDate.getTime());
		this.inventaire.setDateInv(DateSQL);
		
		}else {
			request.setAttribute("message", "Required Fields !");
			return ERROR;
		}
		boolean result = inventaireModel.UpdateInv(this.inventaire);
		if(result) {
			this.listInventaires= inventaireModel.getInventaires();
			return SUCCESS;
		}
		request.setAttribute("message", "Update is unsuccessful!");
		return ERROR;
	}

	//Supprimer l'inventaire
	public String deleteInventory() throws Exception {
		this.inventaire = inventaireModel.getInventoryByID(this.codeInv);
		boolean result = inventaireModel.deleteInv(this.inventaire);
		if(result) {
			this.listInventaires= inventaireModel.getInventaires();
			return SUCCESS;
		}
		request.setAttribute("message", "Delete is unsuccessful!");
		return ERROR;
	}

	//Chercher un inventaire
	public String searchInv() throws Exception {
		this.listInventaires = inventaireModel.getInventaires();
		return SUCCESS;
	}

	//Valider la recherche
	public String processSearchInv() throws Exception {
		if(this.codeInv != null ) {
			this.listInventaires = inventaireModel.searchInventoryByID(this.codeInv);
			
		}else {
			this.listInventaires = inventaireModel.getInventaires();
			request.setAttribute("message", "Required Fields !");
			return ERROR;
		}
			
		return SUCCESS;
	}
}
