package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoTemporario extends Empleado {
	private LocalDate fechaFinalizacionRelacion;
	private int cantidadHorasExtra;
	
	
	public EmpleadoTemporario(String nombre, String direccion,String estadoCivil, LocalDate fechaNacimiento,int sueldoBasico, LocalDate fechaFinalizacionRelacion, int cantidadHorasExtra) {
		super(estadoCivil, estadoCivil, estadoCivil, fechaNacimiento,sueldoBasico);
		this.fechaFinalizacionRelacion=fechaFinalizacionRelacion;
		this.cantidadHorasExtra=cantidadHorasExtra;
	}

	@Override
	protected double calcularRetenciones() {
		
		return this.calcularObraSocial()+this.calculcarAportesJubilatorios();
	}

	@Override
	protected double calcularSueldoBruto() {
		
		return this.getSueldoBasico()+this.calcularMontoHorasExtras(40);
	}

	private int calcularMontoHorasExtras(int valor) {
		
		return this.cantidadHorasExtra*valor;
	}

	@Override
	protected double calculcarAportesJubilatorios() {
		
		return this.calcularSueldoBruto()*0.10+this.calcularMontoHorasExtras(5);
	}

	@Override
	protected double calcularObraSocial() {
		return this.calcularSueldoBruto()*0.10+this.agregadoPorEdad();
	}

	private double agregadoPorEdad() {
		int valor=0;
		if(this.getEdad()>50) {valor=25;}
		return valor;
	}
	
	@Override
	public String desgloceDeConceptos() {
		return "Sueldo bruto está compuesto por:\n" 
				+ "\tSueldo básico: $" + this.getSueldoBasico() + "\n"
				+ "\tSalario Horas Extra: $" + this.calcularMontoHorasExtras(40) + "\n"
				+ "\tTotal: "+this.calcularSueldoBruto()+"\n"
				+ "Se descuenta en calidad de retenciones:\n"
				+ "\tObra social: $" + this.calcularObraSocial() + "\n" 
				+ "\tJubilación: $"+ this.calculcarAportesJubilatorios() + "\n"
				+"\tTotal: "+this.calcularRetenciones();
	}

	

}
