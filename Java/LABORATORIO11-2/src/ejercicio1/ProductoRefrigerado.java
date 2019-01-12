/*
 * PROGRAMA PARA ADMINISTRAR LOS PRODUCTOS DE UNA EMPRESA ALIMENTARIA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 04/10/2017
*/
package ejercicio1;

public class ProductoRefrigerado extends Producto{
	//Atributos
	String cod;
	//Constructor
	ProductoRefrigerado(String fechaCad, String noLote,String cod) {
		super(fechaCad, noLote);
		this.setCod(cod);
	}
	//Getters y Setters
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	//Métodos
	public void imprimirProducto(Producto doc)
	{
		super.imprimirProducto(doc);
		System.out.print("\t"+this.getCod());
	}
}
