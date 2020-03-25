package ejercicio2;
public class Rectangulo extends Figura{
	//Atributos
	private double ancho,largo; 
	//Metodos
	@Override
	public double calcularArea() {
		return this.ancho*this.largo;
	}
	@Override
	public double calcularPerimetro() {
		return this.ancho*2+this.largo*2;
	}
	//Getters y Setters
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}

}
