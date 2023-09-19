package ar.edu.unq.po2.tp2;
import java.time.LocalDate;

public class ReciboDeHaberes {
	private Empleado empleado;
	private LocalDate fechaEmision;
	private double sueldoNeto;
	private String desgloceConceptos;
	
	public ReciboDeHaberes(Empleado empleado) {
	this.empleado=empleado;
	this.fechaEmision=LocalDate.now();
	this.sueldoNeto=empleado.calcularSueldoNeto();
	this.desgloceConceptos=empleado.desgloceDeConceptos();
	}
	
	private void mostrarNombre() {
		System.out.println("Nombre: "+this.empleado.getNombre()+"\n");
	}
	private void mostrarDireccion() {
		System.out.println("Direccion: "+this.empleado.getDireccion()+"\n");
	}
	private void mostrarFecha() {
		System.out.println("Fecha de Emision: "+this.fechaEmision+"\n");
	}
	private void mostrarDesglose() {
		System.out.println(this.desgloceConceptos);
	}
	private void mostrarTotalNeto() {
		System.out.println("Sueldo Neto: "+this.sueldoNeto);
		
	}
	
	public void mostrar() {
		this.mostrarNombre();
		this.mostrarDireccion();
		this.mostrarFecha();
		this.mostrarDesglose();
		this.mostrarTotalNeto();
	}


	


}
