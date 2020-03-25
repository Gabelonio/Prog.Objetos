/*
 * PROGRAMA PARA ADMINISTRAR LAS CONSULTAS DE UNA BOUTIQUE
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 10/11/2017
*/
package ejercicio2;

public class Producto {
	//atributos
	private String nombre;
	private double precio; 
	//Contructor
	Producto(String nombre,double precio)
	{
		this.nombre=nombre;
		this.precio=precio; 
	}
	//Getters
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	
	
}
