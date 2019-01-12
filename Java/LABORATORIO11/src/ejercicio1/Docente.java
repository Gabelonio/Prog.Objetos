/*
 * PROGRAMA PARA CALCULAR CALCULAR EL VALOR A PAGAR A N PROFESORES
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio1;
public class Docente 
{
	//atributos
	private String nombre,apellido;
	private int nivel;
	private double sueldo;
	//Constructor
	Docente(String nombre,String apellido,int nivel)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.nivel=nivel;
	}
	
	//Setters y Getters
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getNivel() {
		return nivel;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	//Métodos
	public void imprimirMaestro(Docente doc)
	{
		System.out.print("\t"+doc.getNombre()+"\t"+doc.getApellido()+"\t");
		switch(doc.getNivel())
		{
			case 1:{
				System.out.print("Doctorado");
				break; 
			}
			case 2:{
				System.out.print("Maestría");
				break; 
			}
			case 3:{
				System.out.print("Especialización");
				break; 
			}
			case 4:{
				System.out.print("Sin Postgrado");
				break; 
			}
		}
		System.out.print("\t"+doc.getSueldo());
	}
}
