package controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.*;

import entities.Achats;
import entities.Articles;
import model.AchatModel;

public class AchatAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private AchatModel achatModel = new AchatModel();
	private Articles articles = new Articles();
	
	private List<Achats> listAchats;
	private List<Articles> listArticles;
	
	private Achats achat = new Achats();
	
	private int codeAchat;
	private String dateReception;
	private String codeArt;
	private String qteAchete;
	

	public String getDateReception() {
		return dateReception;
	}
	public void setDateReception(String dateReception) {
		this.dateReception = dateReception;
	}
	public String getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(String codeArt) {
		this.codeArt = codeArt;
	}
	public String getQteAchete() {
		return qteAchete;
	}
	public void setQteAchete(String qteAchete) {
		this.qteAchete = qteAchete;
	}
	public Achats getAchat() {
		return achat;
	}
	public void setAchat(Achats achat) {
		this.achat = achat;
	}
	
	public int getCodeAchat() {
		return codeAchat;
	}
	public void setCodeAchat(int codeAchat) {
		this.codeAchat = codeAchat;
	}
	
	public Articles getArticles() {
		return articles;
	}
	public void setArticles(Articles articles) {
		this.articles = articles;
	}
	public List<Achats> getListAchats() {
		return listAchats;
	}
	public void setListAchats(List<Achats> listAchats) {
		this.listAchats = listAchats;
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
		this.listAchats = achatModel.getAchats();
		System.out.println("in execute");
		return SUCCESS;
	}
	
	public String home() throws Exception {
		return SUCCESS;
	}
	
	//Envoyer vers page ajouter un nouveau article
	public String addNew() throws Exception {
		this.listArticles = achatModel.getArticles();
		return SUCCESS;
	}

	//Ajouter un nouveau article
	public String processAddNew() throws Exception {
		
		this.listArticles = achatModel.getArticles();
		
		if(this.achat.getQteAchete() >0) {
			if(!this.dateReception.equals("")) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date receptionDate = format.parse(this.dateReception);
				System.out.println("reception date "+this.dateReception);
				System.out.println("reception date "+this.achat.getDateReception());
				java.sql.Date DateSQL = new java.sql.Date(receptionDate.getTime());				
				this.achat.setDateReception(DateSQL);
			}else {				
				request.setAttribute("messageD", "Required Fields Date !");
			}
		
		}else {
			request.setAttribute("messageQ", "Required Fields quantity!");
		}
		
		boolean result = achatModel.addNew(this.achat);
		if(result) {
			this.listAchats = achatModel.getAchats();
			return SUCCESS;
		}else if(!result){
		request.setAttribute("message", "Add new item is unsuccessful!");
		return ERROR;
		}
		return ERROR;
	}

	//Envoyer vers page modifier l'article
	public String update() throws Exception {
		this.listArticles = achatModel.getArticles();
		this.achat = achatModel.getAchatByID(this.codeAchat);
		return SUCCESS;
	}

	//Modifier l'article
	public String processUpdate() throws Exception {
		this.listArticles = achatModel.getArticles();
		if(this.achat.getQteAchete() >0) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date receptionDat = format.parse(this.dateReception);
		java.sql.Date DatSQL = new java.sql.Date(receptionDat.getTime());
		this.achat.setDateReception(DatSQL);
		}else {

			request.setAttribute("message", "Required Fields !");
			return ERROR;
		}
		boolean result = achatModel.Update(this.achat);
		if(result) {
			this.listAchats = achatModel.getAchats();
			return SUCCESS;
		}else if(!result){
		request.setAttribute("message", "Update is unsuccessful!");
		return ERROR;
		}
		return ERROR;
	}

	//Supprimer un article
	public String delete() throws Exception {
		this.achat = achatModel.getAchatByID(this.codeAchat);
		boolean result = achatModel.delete(this.achat);
		if(result) {
			this.listAchats = achatModel.getAchats();
			
		}
		return SUCCESS;
	}

	//Chercher un article
	public String search() throws Exception {
		this.listAchats = achatModel.getAchats();
		return SUCCESS;
	}

	//Valider la recherche
	public String processSearch() throws Exception {
		Integer code= this.codeAchat;
		if(code.equals("")) {
			this.listAchats = achatModel.getAchats();
		}else {
			this.listAchats = achatModel.searchAchatByID(this.codeAchat);
		}
			
		return SUCCESS;
	}
}
