package com.sdi.presentation;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import com.sdi.business.UsersService;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;

@ManagedBean(name = "logController")
@SessionScoped
public class BeanLog implements Serializable {
	private static final long serialVersionUID = 55555L;

	private String login="", password="";
	
	public BeanLog() {
		System.out.println("BeanLogin - No existia");
	}
	
	public String log(){
		UsersService service;
		try{
			service = Factories.services.createUserService();
			System.out.printf("\nLogin: %s, Password:%s\n",login,password);
			User localUser = service.findAdmin(login, password);
			if (localUser == null){
				System.out.println("Error porque no se encontró al user");
				return "error";}
			
			// save user in session
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			session.put("LOGGEDIN_USER", localUser);
			return "exito";
		}catch(Exception e){
			System.out.println("Error excepción");
			return "error";
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}