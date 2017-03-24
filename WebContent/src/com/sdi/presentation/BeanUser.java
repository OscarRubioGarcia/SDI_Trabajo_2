package com.sdi.presentation;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sdi.model.User;
import com.sdi.model.types.UserStatus;

@ManagedBean(name="user")
@SessionScoped
public class BeanUser extends User implements Serializable {
	
	private static final long serialVersionUID = 55557L;
	
	public BeanUser() {
		iniciaUser(null);
	}
	
	public void setUser(User user) {
		setId(user.getId());
		setLogin(user.getLogin());
		setEmail(user.getEmail());
		setPassword(user.getPassword());
		setIsAdmin(user.getIsAdmin());
		setStatus(user.getStatus());
	}
	
	public void iniciaUser(ActionEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle =
		facesContext.getApplication().getResourceBundle(facesContext, "msgs");
		setId(null);
		setLogin(bundle.getString("valorDefectoBeanUserLogin"));
		setEmail(bundle.getString("valorDefectoBeanUserEmail"));
		setPassword(bundle.getString("valorDefectoBeanUserPassword"));
		setIsAdmin(false);
		setStatus(UserStatus.ENABLED);
	}

}
