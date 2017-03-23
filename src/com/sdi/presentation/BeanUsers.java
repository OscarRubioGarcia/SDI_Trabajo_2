package com.sdi.presentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sdi.business.UsersService;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;

@ManagedBean(name = "userController")
@SessionScoped
public class BeanUsers implements Serializable {
	private static final long serialVersionUID = 55555L;
	// Se añade este atributo de entidad para recibir el alumno concreto
	// selecionado de la tabla o de un formulario
	// Es necesario inicializarlo para que al entrar desde el formulario de
	// AltaForm.xml se puedan
	// dejar los avalores en un objeto existente.

	// uso de inyección de dependencia
	@ManagedProperty(value = "#{user}")
	private BeanUser user;

	private String login="", password="";
	
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

	private User[] users = null;

	private List<User> usersList = null;
	private List<User> usersFiltrado = null;

	private Date currentDate;

	// Se inicia correctamente el MBean inyectado si JSF lo hubiera crea
	// y en caso contrario se crea. (hay que tener en cuenta que es un Bean de
	// sesión)
	// Se usa @PostConstruct, ya que en el contructor no se sabe todavía si el
	// ManagedBean
	// ya estaba construido y en @PostConstruct SI.
	@PostConstruct
	public void init() {
		System.out.println("BeanTareas - PostConstruct");

		setCurrentDate(new Date());

		// Buscamos el alumno en la sesión. Esto es un patrón factoría
		// claramente.
		user = (BeanUser) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get(new String("user"));

		// si no existe lo creamos e inicializamos
		if (user == null) {
			System.out.println("BeanUser - No existía");
			user = new BeanUser();
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("user", user);
		}
	}

	@PreDestroy
	public void end() {
		System.out.println("BeanUsers - PreDestroy");
	}

	public User[] getUsers() {
		return (users);
	}

	public void setUser(BeanUser user) {
		this.user = user;
	}

	public BeanUser getUser() {
		return user;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public void iniciaUser(ActionEvent event) {
		user.iniciaUser(event);
	}

	public String listado() {
		UsersService service;
		try {
			service = Factories.services.createUserService();
			users = (User[]) service.listUsers().toArray(new User[0]);

			setUsersList(service.listUsers());

			return "exito"; // vamos a vista admindex.xhtml

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public String baja(User user) {
		UsersService service;
		try {
			service = Factories.services.createUserService();
			service.disableUser(user.getId()); // CHRSN: or delete?
			users = (User[]) service.listUsers().toArray(new User[0]);

			setUsersList(service.listUsers());

			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public String edit() {
		UsersService service;
		try {
			service = Factories.services.createUserService();
			// TODO: user = (BeanUser) service.findLoggableUser(user.getId());
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public String salva() {
		UsersService service;
		try {
			service = Factories.services.createUserService();
			if (user.getId() == null) {
				service.save(user);
			} else {
				service.update(user);
			}
			users = (User[]) service.listUsers().toArray(new User[0]);
			setUsersList(service.listUsers());
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public String log(){
		System.out.println("Entro en log");
		UsersService service;
		try{
			service = Factories.services.createUserService();
			User localUser = service.findAdmin(login, password);
			if (localUser == null)
				return "error";
			// save user in session
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			session.put("LOGGEDIN_USER", localUser);
			return "exito";
		}catch(Exception e){
			return "error";
		}
	}
	
	public List<User> getUsersFiltrado() {
		return usersFiltrado;
	}

	public void setUsersFiltrado(List<User> usersFiltrado) {
		this.usersFiltrado = usersFiltrado;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

}
