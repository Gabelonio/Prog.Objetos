/*
 * PROGRAMA PARA ADMINISTRAR EL SISTEMA DE UN HOSPITAL
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 10/11/2017
*/
package ejercicio1;


public class Paciente {
	//Atributos
	private String nombre,apellidos;
	private char genero; 
	public String fechaNacimiento; 
	Hospital hospital; 
	
	
	Paciente(String nombre,String apellidos,char genero,String fechaNacimiento)
	{
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.genero=genero; 
		this.fechaNacimiento=fechaNacimiento; 
	}
	//Setters y Getters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
}
