package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class EmpleadoContratado extends Empleado {
	private int numeroContrato;
	private String medioDePago;
	

	public EmpleadoContratado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,
			int sueldoBasico,int numeroContrato,String medioDePago) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.numeroContrato=numeroContrato;
		this.medioDePago=medioDePago;
	}
	
	private int gastosAdministrativos() {
		return 50;
	}
	
	@Override
	protected double calcularRetenciones() {
		return this.gastosAdministrativos();
	}
	

	@Override
	protected double calcularSueldoBruto() {
		return this.getSueldoBasico();
	}

	@Override
	protected double calcularObraSocial() {
		return 0;
	}

	
	@Override
	protected double calculcarAportesJubilatorios() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String desgloceDeConceptos() {
		return "Sueldo bruto está compuesto por:\n" 
				+ "\tSueldo básico: $" + this.getSueldoBasico() + "\n"
				+ "\tTotal: "+this.calcularSueldoBruto()+"\n"
				+ "Se descuenta en calidad de retenciones:\n"
				+ "\tGastos Administrativos: $" + this.calcularRetenciones() + "\n" 
				+"\tTotal: "+this.calcularRetenciones();
	}

}
