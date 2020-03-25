/*
 * PROGRAMA PARA OBTENER EL AREA A PARTIR DE SEMIPERIMETRO
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 01/09/2017
*/
package ejercicio1;

public class Triangulo {

	//atributos
	private double ladoA,ladoB,ladoC,semiperimetro;

	public double getSemiperimetro() {
		return semiperimetro;
	}

	public void setSemiperimetro() {
		this.semiperimetro = (ladoA+ladoB+ladoC)/2;
	}

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

	public double getLadoC() {
		return ladoC;
	}

	public void setLadoC(double ladoC) {
		this.ladoC = ladoC;
	}
	
}
