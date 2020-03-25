/*
 * PROGRAMA PARA OBTENER EL LADO RESTANTE DEL TRIANGULO
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 01/09/2017
*/
package ejercicio2;

public class Triangulo {

	//atributos
	private double ladoA,ladoB,ladoC,angulo;

	//metodos
	public double getLadoA() {
		return ladoA;
	}

	public void setLadoA(double ladoA) {
		this.ladoA = ladoA;
	}

	public double getLadoB() {
		return ladoB;
	}

	public void setLadoB(double ladoB) {
		this.ladoB = ladoB;
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	public double getLadoC() {
		return ladoC;
	}

	public void setLadoC() {
		this.ladoC = Math.sqrt(Math.pow(ladoA,2)+Math.pow(ladoB,2)-2*ladoA*ladoC*Math.cos(Math.toRadians(angulo))); 
	}

	
	

}
