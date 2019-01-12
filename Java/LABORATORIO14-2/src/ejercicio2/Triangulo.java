/*
 * PROGRAMA PARA DETERMINAR AREAS Y PERIMETROS DE DISTINTAS FIGURAS 
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/11/2017
*/
package ejercicio2;

public class Triangulo extends Figura{

	//Atributos
	private double ladoUno,ladoDos,ladoTres;
	//Metodos
	@Override
	public double calcularArea() {
		return Math.sqrt(((ladoUno+ladoDos+ladoTres)/2)*(((ladoUno+ladoDos+ladoTres)/2)-this.getLadoUno())*(((ladoUno+ladoDos+ladoTres)/2)-this.getLadoDos())*(((ladoUno+ladoDos+ladoTres)/2)-this.getLadoTres()));
	}

	@Override
	public double calcularPerimetro() {
		return this.ladoUno+this.ladoDos+this.ladoTres; 
	}
	//Getters y Setters
	public double getLadoUno() {
		return ladoUno;
	}
	public void setLadoUno(double ladoUno) {
		this.ladoUno = ladoUno;
	}
	public double getLadoDos() {
		return ladoDos;
	}
	public void setLadoDos(double ladoDos) {
		this.ladoDos = ladoDos;
	}
	public double getLadoTres() {
		return ladoTres;
	}
	public void setLadoTres(double ladoTres) {
		this.ladoTres = ladoTres;
	}
	
}
