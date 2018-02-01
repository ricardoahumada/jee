package com.tracelogistic.models;

import java.util.List;

public class Proyecto {
	private int pid; 
	private String titulo;
	private List<Tarea> tareas;
	
	public Proyecto(int pid, String titulo, List<Tarea> tareas) {
		super();
		this.pid = pid;
		this.titulo = titulo;
		this.tareas = tareas;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	
}
