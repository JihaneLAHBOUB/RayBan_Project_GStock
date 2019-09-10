package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.*;

import entities.Users;
import model.UsersModel;
import util.EncryptUtil;


public class UsersAction extends ActionSupport implements SessionAware, ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private HttpServletRequest request;
	private UsersModel usersModel = new UsersModel();
	private List<Users> listUsers;

	private String user;
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Users> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<Users> listUsers) {
		this.listUsers = listUsers;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
	this.request= request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}

	//Valider Login de l'utilisateur 
	public String processlogin() throws Exception {
		this.listUsers = usersModel.getUsers();
		for(Users users : listUsers) {
			
			if(this.user.equals(users.getLogin())) {
				if(users.getPass().trim().equals(EncryptUtil.md5(this.password))){
					this.session.put("username", users.getLogin());
					return SUCCESS;
				}else {
					System.out.println("in valid pass");	
				}
					
				}else {
					
					System.out.println("invalid log");		
			}
			
		}
		request.setAttribute("messageL", "invalid Login");
		return ERROR;
	}

	//Envoyer vers la page LOGOUT
	public String logout() throws Exception {
		if(this.session.containsKey("username")) {
			this.session.remove("username");
		}
		return SUCCESS;
	}


}
