package com.tracelogistics.db;

import java.util.ArrayList;
import java.util.List;

import com.tracelogistic.models.Proyecto;
import com.tracelogistic.models.Tarea;
import com.tracelogistic.models.Usuario;

public class BBDDMock {
	private static BBDDMock instance = null;
	
	private static List<Usuario> users;
	private static List<Proyecto> proyectos;
	
	public static BBDDMock getInstance() {
		if (instance == null) {
			instance = new BBDDMock();
		}
		return instance;
	}

	protected BBDDMock() {
		populateUsers();
		this.populateProyectos();
	}
	
	private void populateUsers() {
		users=new ArrayList<Usuario>();
		users.add(new Usuario(1, "Rosa", "Rosae", "ros@r.com", "rrr"));
		users.add(new Usuario(2, "Luis", "Luisae", "luis@r.com", "lll"));
		users.add(new Usuario(3, "Juana", "Juanae", "jun@r.com", "jjj"));
		users.add(new Usuario(4, "Pedro", "Pedrae", "pet@r.com", "ppp"));
	}
	
	private void populateProyectos() {
		proyectos=new ArrayList<Proyecto>();
		proyectos.add(new Proyecto(1, "App Gestion",new ArrayList<Tarea>()));
		proyectos.add(new Proyecto(2, "Web Ventas", new ArrayList<Tarea>()));
		proyectos.add(new Proyecto(3, "Gestor Almacen", new ArrayList<Tarea>()));
		
		List<Tarea> tempTareas=null;
		int cont=0;
		for (Proyecto proj : proyectos) {
			tempTareas=proj.getTareas();
			tempTareas.add(new Tarea(++cont,"Tarea "+cont, 10, 2, 14, 1, users.get(1)));
			tempTareas.add(new Tarea(++cont, "Tarea "+cont,20, 3, 5, 2, users.get(1)));
			tempTareas.add(new Tarea(++cont, "Tarea "+cont, 20, 22, 0, 3, users.get(1)));
		}
	}
	
	/*Usuarios DAO*/
	public Usuario getUser(String email,String pass) {
		Usuario resUser=null;
		for (Usuario usuario : users) {
			if(usuario.getEmail().equals(email) && usuario.getPassword().equals(pass)) {
				resUser=usuario;
				break;
			}
		}
		
		return resUser;
	}
	
	public Usuario getUser(int uid) {
		Usuario resUser=null;
		for (Usuario usuario : users) {
			if(usuario.getUid()==uid) {
				resUser=usuario;
				break;
			}
		}
		
		return resUser;
	}
	
	/*Proyectos DAO*/
	public Proyecto getProyecto(int pid) {
		Proyecto resProj=null;
		for (Proyecto proj : proyectos) {
			if(proj.getPid()==pid) {
				resProj=proj;
				break;
			}
		}
		
		return resProj;
	}
	
	public List<Proyecto> getProyectosForUser(int uid) {
		List<Proyecto> resProjs=new ArrayList<Proyecto>();
		List<Tarea> tempTareas=null;
		for (Proyecto proj : proyectos) {
			tempTareas=proj.getTareas();
			
			for (Tarea tarea : tempTareas) {
				if(tarea.getResponsable().getUid()==uid) resProjs.add(proj);
				break;
			}
			
		}
		
		return resProjs;
	}
	
	/*Tareas DAO*/
	public List<Tarea> getTareasForUser(int uid) {
//		List<Tarea> resTareas=new ArrayList<Tarea>();
//		List<Tarea> tempTareas=null;
//		for (Proyecto proj : proyectos) {
//			tempTareas=proj.getTareas();
//			
//			for (Tarea tarea : tempTareas) {
//				if(tarea.getResponsable().getUid()==uid) resTareas.add(tarea);
//			}
//			
//		}
		
		List<Tarea> tempTareas=new ArrayList<Tarea>();
		int cont=0;
		tempTareas.add(new Tarea(++cont,"Tarea "+cont, 10, 2, 14, 1, users.get(1)));
		tempTareas.add(new Tarea(++cont, "Tarea "+cont,20, 3, 5, 2, users.get(1)));
		tempTareas.add(new Tarea(++cont, "Tarea "+cont, 20, 22, 0, 3, users.get(1)));
		
		return tempTareas;
	}
}
