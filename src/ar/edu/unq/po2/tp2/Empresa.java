package ar.edu.unq.po2.tp2;

import java.util.ArrayList;
import java.util.Collection;



public class Empresa {
	private String nombre;
	private String cuit;
	private Collection<Empleado> empleados = new ArrayList<>();
	private Collection<ReciboDeHaberes> recibos = new ArrayList<>();
	
	public double montoTotalSueldosBrutos(){
		return this.empleados.stream().mapToDouble(e->e.calcularSueldoBruto()).sum();
	}
	
	public double montoTotalSueldosNetos() {
		return this.empleados.stream().mapToDouble(e->e.calcularSueldoNeto()).sum();
	}
	
	public double montoTotalRetencionesEmpleados(){
		return this.empleados.stream().mapToDouble(e->e.calcularRetenciones()).sum();
	}
	
	public void liquidarSueldo() {
		this.empleados.stream().forEach(e->this.generarReciboHaberes(e));
	}
	
	private void generarReciboHaberes(Empleado empleado) {
		this.agregarRecibo(new ReciboDeHaberes(empleado));
		
	}
	private void agregarRecibo(ReciboDeHaberes recibo) {
		this.recibos.add(recibo);
		
	}

}
