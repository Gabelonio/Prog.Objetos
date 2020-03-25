/*
 * PROGRAMA PARA OBTENER EL VOLUMEN Y LA SUPERFICIE DE UNA ESFERA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 01/09/2017
*/
package ejercicio3;

public class Esfera {
	//atributos
	private double radio; 
	//metodos

	//constructores
	public Esfera()
	{
		this.radio=1;
	}
	public Esfera(double radio)
	{
		this.radio=radio;
	}
	//normales
	public double getRadio() {
		return radio;
	}
	public double calcularVolumen() {
		return 4/3*Math.PI*Math.pow(radio,3);
	}
	public double calcularSuperficie() {
		return Math.PI*Math.pow(radio,2);
	}
	public void imprimirInformacion(){
		System.out.println("Esfera\nRadio: "+this.getRadio()+"\nVolumen: "+this.calcularVolumen()+"\nSuperficie "+this.calcularSuperficie());
	}
}
