/*
 * PROGRAMA PARA REALIZAR UNA LISTA DE N PERSONAS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/09/2017
*/ 
package ejercicio2;

public class Persona {
	//Atributos
	private char[] nombre,apellido,ID; 
	private int edad;
	//metodos
	public void setNombre(char[] nombre) {
		this.nombre = nombre;
	}
	public void setApellido(char[] apellido) {
		this.apellido = apellido;
	}
	public void setID(char[] iD) {
		ID = iD;
	}
	public char[] getNombre() {
		return nombre;
	}
	public char[] getApellido() {
		return apellido;
	}
	public char[] getID() {
		return ID;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
