package com.tracelogistics.models;

public class Tarea {
	private int tid;
	private String descripcion;
	private int estimado;
	private int dedicado;
	private int restante;
	private int estado;
	private Usuario responsable;
	
	public Tarea(int tid,String desc, int estimado, int dedicado, int restante, int estado, Usuario responsable) {
		this.tid = tid;
		this.descripcion=desc;
		this.estimado = estimado;
		this.dedicado = dedicado;
		this.restante = restante;
		this.estado = estado;
		this.responsable = responsable;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstimado() {
		return estimado;
	}
	public void setEstimado(int estimado) {
		this.estimado = estimado;
	}
	public int getDedicado() {
		return dedicado;
	}
	public void setDedicado(int dedicado) {
		this.dedicado = dedicado;
	}
	public int getRestante() {
		return restante;
	}
	public void setRestante(int restante) {
		this.restante = restante;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Usuario getResponsable() {
		return responsable;
	}
	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}
	
}
