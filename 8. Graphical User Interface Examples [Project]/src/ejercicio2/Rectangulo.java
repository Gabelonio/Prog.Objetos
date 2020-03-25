/*
 * PROGRAMA PARA CALCULAR EL AREA Y PERIMETRO DE UN RECTANGULO 
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 18/10/2017
*/
package ejercicio2;

public class Rectangulo {
	//Atributos
	private double ancho,largo;
	//Metodos
	//Constructor
	Rectangulo(double ancho,double largo)
	{
		this.ancho=ancho;
		this.largo=largo;
	}
	public double calcularArea()
	{
		return this.ancho*this.largo;
	}
	public double calcularPerimetro()
	{
		return this.ancho*2+this.largo*2;
	}
}
