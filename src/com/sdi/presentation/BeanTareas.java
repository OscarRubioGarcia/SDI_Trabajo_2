package com.sdi.presentation;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sdi.business.TasksService;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Task;

@ManagedBean(name="listadosController")
@SessionScoped
public class BeanTareas implements Serializable{
	      private static final long serialVersionUID = 55555L;
		  // Se añade este atributo de entidad para recibir el alumno concreto selecionado de la tabla o de un formulario
	      // Es necesario inicializarlo para que al entrar desde el formulario de AltaForm.xml se puedan
	      // dejar los avalores en un objeto existente.
	      
	    //uso de inyección de dependencia
	      @ManagedProperty(value="#{tarea}")
	      private BeanTarea tarea;
		
          private Task[] tareas = null;
          
          private List<Task> tareasList = null;
          private List<Task> tareasFiltrado = null;
          
          private Date currentDate;
          
		//Se inicia correctamente el MBean inyectado si JSF lo hubiera crea
		//y en caso contrario se crea. (hay que tener en cuenta que es un Bean de sesión)
		//Se usa @PostConstruct, ya que en el contructor no se sabe todavía si el ManagedBean
		//ya estaba construido y en @PostConstruct SI.
		@PostConstruct
		public void init() {
			System.out.println("BeanTareas - PostConstruct");
			
			setCurrentDate(new Date());
			
			//Buscamos el alumno en la sesión. Esto es un patrón factoría claramente.
			tarea = (BeanTarea)
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("tarea"));
			
			//si no existe lo creamos e inicializamos
			if (tarea == null) {
				System.out.println("BeanTarea - No existia");
				tarea = new BeanTarea();
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "tarea", tarea);
			}
		}
	        
		@PreDestroy
		public void end() {
		System.out.println("BeanTareas - PreDestroy");
		}
          
		  
		  public Task[] getTareas () {
			    return(tareas);
		  }
		  
	      public void setTask(BeanTarea tarea) {
	    	   this.tarea = tarea;
	      }
	       
	      public BeanTarea getTarea() {
	    	  return tarea;
	      }
	       
	      public void setTareas(Task[] tareas) {
	    	  this.tareas = tareas;
		  }  
	       
	       public void iniciaTarea(ActionEvent event) {
	    	   FacesContext facesContext = FacesContext.getCurrentInstance();
	    	   //Obtenemos el archivo de propiedades correspondiente al idioma que
	    	   //tengamos seleccionado y que viene envuelto en facesContext
	    	   ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msgs");
	    	   tarea.setId(null);
	    	   tarea.setCategoryId(null);
	    	   tarea.setComments(bundle.getString("valorDefectoComments"));
	   		   tarea.setCreated(new Date());
	   		   tarea.setFinished(new Date());
	   	       tarea.setPlanned(new Date());
	   		   tarea.setTitle(bundle.getString("valorDefectoTittle"));
	   		   tarea.setUserId(null);
	       }
	       
	       public String listado() {
		       TasksService service;
				  try {
					service = Factories.services.createTaskService();
					tareas = (Task [])service.getAllTasks().toArray(new Task[0]);
					
					setTareasList(service.getAllTasks());
					
					return "exito"; 
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";  
				  }
				  
	       }
	       
	       public String baja(Task tarea) {
		       TasksService service;
				  try {
					service = Factories.services.createTaskService();
					service.deleteTarea(tarea.getId());
					tareas = (Task [])service.getAllTasks().toArray(new Task[0]);
					
					setTareasList(service.getAllTasks());
					
					return "exito";  
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";     
				  }
				  
	       }
	       
	       public String edit() {
		       TasksService service;
				  try {
					service = Factories.services.createTaskService();
					tarea = (BeanTarea) service.findById(tarea.getId());
					return "exito";  
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";
				  }
				  
	       }
	       
	       public String salva() {
		       TasksService service;
				  try {
					service = Factories.services.createTaskService();
					if (tarea.getId() == null) {
						service.saveTarea(tarea);  
					}
					else {
						service.updateTarea(tarea); 
					} 
					tareas = (Task [])service.getAllTasks().toArray(new Task[0]);
					setTareasList(service.getAllTasks());
					return "exito"; 
					
				  } catch (Exception e) {
					  e.printStackTrace();
					return "error";   
				  }
				  
		 	  }

		public List<Task> getTareasFiltrado() {
			return tareasFiltrado;
		}

		public void setTareasFiltrado(List<Task> tareasFiltrado) {
			this.tareasFiltrado = tareasFiltrado;
		}

		public Date getCurrentDate() {
			return currentDate;
		}

		public void setCurrentDate(Date currentDate) {
			this.currentDate = currentDate;
		}

		public List<Task> getTareasList() {
			return tareasList;
		}

		public void setTareasList(List<Task> tareasList) {
			this.tareasList = tareasList;
		}

		
	}


	
