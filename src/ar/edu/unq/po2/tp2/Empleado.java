package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Empleado {
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaNacimiento;
	private double sueldoBasico;
	
	
	public Empleado(String nombre, String direccion,String estadoCivil, LocalDate fechaNacimiento, int sueldoBasico) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setEstadoCivil(estadoCivil);
		this.setFechaNacimiento(fechaNacimiento);
		this.setSueldoBasico(sueldoBasico);
	}
	
	protected abstract double calcularRetenciones();
	protected abstract double calcularSueldoBruto();
	protected abstract double calcularObraSocial();
	protected abstract double calculcarAportesJubilatorios();
	public abstract String desgloceDeConceptos();
	

	public double calcularSueldoNeto() {
		return this.calcularSueldoBruto()-this.calcularRetenciones();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getEdad() {
		LocalDate fechaActual = LocalDate.now();
		int edad = fechaActual.getYear() - fechaNacimiento.getYear();
		if (fechaNacimiento.getDayOfYear() > fechaActual.getDayOfYear()) {
            // Si no ha ocurrido, resta 1 año de la edad
            edad--;
        }
		return edad;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(int sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	

	
}

