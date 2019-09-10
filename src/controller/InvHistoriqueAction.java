package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import entities.Achats;
import entities.Articles;
import entities.Commandes;
import entities.Inventaire;
import model.InvHistoriqueModel;

public class InvHistoriqueAction extends ActionSupport implements ServletRequestAware  {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private InvHistoriqueModel invhistoryModel = new InvHistoriqueModel();
	
	private Inventaire inventaire = new Inventaire();
	
	private List<Articles> listArticles = new ArrayList<Articles>();
	private List<Inventaire> lastInventaire = new ArrayList<Inventaire>();
	private List<Inventaire> articleInventaire = new ArrayList<Inventaire>();
	private List<Achats> articleAchat = new ArrayList<Achats>();
	private List<Commandes> articleCommande = new ArrayList<Commandes>();
	
	
	String DateI = "0000-00-00";//Date d'initialisation
	private String DateX;//Date entrée par l'utilisateur
	
	//Initialisation des variables
	int qtyArtInv =0,
		qtyArtAch =0,
		qtyArtVte =0;
	

	public String getDateX() {
		return DateX;
	}

	public void setDateX(String dateX) {
		DateX = dateX;
	}

	
	public List<Inventaire> getLastInventaire() {
		return lastInventaire;
	}

	public void setLastInventaire(List<Inventaire> lastInventaire) {
		this.lastInventaire = lastInventaire;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;

		}
	
	//Envoyer vers page de la historique des inventaires
	public String invhistory() throws Exception {
		return SUCCESS;
	}
	
	//Methode pour calculer l'inventaire de chaque article
	public String processInvhistory() throws Exception {
		this.listArticles = invhistoryModel.getArticles();
		for(int i =0; i< listArticles.size(); i++) {
			int artID=0;
			String artDesc= "";
			int j =0;
			int codeTemp = listArticles.get(i).getCodeArt();
			this.articleInventaire = invhistoryModel.getArticleInventaire(codeTemp);
			//Selection tout les inventaires d'un article
			while(j<this.articleInventaire.size()) {
				String dateArtInv = articleInventaire.get(j).getDateInv().toString();
			//Prendre juste les inventaires entre DateX et DateI
				if(dateArtInv.compareTo(DateI)>0 && dateArtInv.compareTo(DateX)<=0) {
					
					DateI = dateArtInv;
					qtyArtInv = articleInventaire.get(j).getQteArt();
					artID = articleInventaire.get(j).getCodeArt();
					artDesc = articleInventaire.get(j).getDescInv();
					}else {
						DateI = "1000-01-01";
						qtyArtInv = 0;
						artID = articleInventaire.get(j).getCodeArt();
						artDesc = articleInventaire.get(j).getDescInv();
					}
			
			j++;
		}
			if(artID != 0) {
				lastInventaire.add(new Inventaire(artID,qtyArtInv,artDesc, invhistoryModel.convertStringToDate(DateI)));
			}
			qtyArtInv = 0;
			DateI = "0000-00-00";
		}

		for(int i =0; i< lastInventaire.size(); i++) {
			int j=0;
			//Prendre tous les achats apres la derniere date inventaire
			int codeTemp = lastInventaire.get(i).getCodeArt();
			this.articleAchat = invhistoryModel.getArticleAchat(codeTemp);
			
			while(j<this.articleAchat.size()) {
				
				if(articleAchat.get(j).getDateReception().compareTo(lastInventaire.get(i).getDateInv())>0 && articleAchat.get(j).getDateReception().compareTo(invhistoryModel.convertStringToDate(DateX))<=0) {
					
					qtyArtAch += articleAchat.get(j).getQteAchete();
					
				}
				j++;
			}
			
			//Prendre tous les ventes apres la derniere date inventaire
			int k = 0;
			this.articleCommande = invhistoryModel.getArticleCommande(codeTemp);
			
			while(k<this.articleCommande.size()) {
				
				if(articleCommande.get(k).getDateCmd().compareTo(lastInventaire.get(i).getDateInv())>0 && articleCommande.get(k).getDateCmd().compareTo(invhistoryModel.convertStringToDate(DateX))<=0 ) {
					
					qtyArtVte += articleCommande.get(k).getQteCmd();
					
				}
				k++;
			}
			//Calculer la qauntite de chaque article dans l'historique inventaire
			lastInventaire.get(i).setQteArt(lastInventaire.get(i).getQteArt() + qtyArtAch - qtyArtVte);
			qtyArtAch = 0;
			qtyArtVte = 0;
		}
		return SUCCESS;
	}

}
