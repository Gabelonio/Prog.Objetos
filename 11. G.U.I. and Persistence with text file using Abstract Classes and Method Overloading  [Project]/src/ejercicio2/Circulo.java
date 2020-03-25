/*
 * PROGRAMA PARA DETERMINAR AREAS Y PERIMETROS DE DISTINTAS FIGURAS 
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/11/2017
*/
package ejercicio2;

public class Circulo extends Figura{

	private double radio;
	//metodos abstractos
	@Override
	public double calcularArea() {
		return Math.PI*Math.pow(this.radio,2);
	}
	@Override
	public double calcularPerimetro() {
		return Math.PI*this.radio*2; 
	}
	//metodos propios
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
}
