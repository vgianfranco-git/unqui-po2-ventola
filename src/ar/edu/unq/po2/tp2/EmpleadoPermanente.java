package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoPermanente extends Empleado{
	private int cantidadHijos;
	private int antiguedad;
	private boolean conyuge;
	

	public EmpleadoPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			int sueldoBasico, int antiguedad,int cantidadHijos, boolean conyuge) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.antiguedad=antiguedad;
		this.cantidadHijos=cantidadHijos;
		this.conyuge=conyuge;	
	}

	@Override
	protected double calcularRetenciones() {
		return this.calcularObraSocial()+this.retencionPorHijo()+this.calculcarAportesJubilatorios();
	}

	private double retencionPorHijo() {
		
		return 20*this.cantidadHijos;
	}
	@Override
	protected double calcularObraSocial() {
		
		return this.calcularSueldoBruto()*0.10;
	}

	@Override
	protected double calcularSueldoBruto() {
		return this.getSueldoBasico()+this.calcularSalarioFamiliar();
	}

	private int calcularSalarioFamiliar() {
		return this.calcularAsignacionPorHijo()+this.asignacionPorConyuge()+this.calcularAntigueda();
	}

	private int calcularAntigueda() {
		return this.antiguedad*50;
	}

	private int asignacionPorConyuge() {
		int valor = 0;
		if(this.conyuge) {valor=100;}
		return valor;
	}

	private int calcularAsignacionPorHijo() {
		return this.cantidadHijos*150;
	}

	@Override
	protected double calculcarAportesJubilatorios() {
		
		return this.calcularSueldoBruto()*0.15;
	}
	
	@Override
	public String desgloceDeConceptos() {
		return "Sueldo bruto está compuesto por:\n" 
				+ "\tSueldo básico: $" + this.getSueldoBasico() + "\n"
				+ "\tSalario Familiar: $" + this.calcularSalarioFamiliar() + "\n"
				+ "\tTotal: "+this.calcularSueldoBruto()+"\n"
				+ "Se descuenta en calidad de retenciones:\n"
				+ "\tObra social: $" + this.calcularObraSocial() + "\n" 
				+ "\tJubilación: $"+ this.calculcarAportesJubilatorios()+"\n"
				+"\tTotal: "+this.calcularRetenciones();
	}

}
