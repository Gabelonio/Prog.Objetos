/*
 * PROGRAMA PARA ADMINISTRAR LOS PRODUCTOS DE UNA EMPRESA ALIMENTARIA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 04/10/2017
*/
package ejercicio1;
public class ProductoCongelado extends Producto{
	//Atributos
	double temp;
	//Constructor
	ProductoCongelado(String fechaCad, String noLote,double temp) {
		super(fechaCad, noLote);
		this.setTemp(temp);;
	}
	//Getters y Setters
	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}
	//Métodos
	public void imprimirProducto(Producto doc)
	{
		super.imprimirProducto(doc);
		System.out.print("\t"+this.getTemp());
	}

	
}
