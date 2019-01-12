/*
 * PROGRAMA PARA ADMINISTRAR LOS PRODUCTOS DE UNA EMPRESA ALIMENTARIA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 04/10/2017
*/
package ejercicio1;

public class Producto {
	//Atributos
	private String fechaCad,noLote;
	//Constructor
	Producto(String fechaCad,String noLote)
	{
		this.fechaCad=fechaCad; 
		this.noLote=noLote;
	}
	//Setters y Getters
	public String getFechaCad() {
		return fechaCad;
	}
	public void setFechaCad(String fechaCad) {
		this.fechaCad = fechaCad;
	}
	public String getNoLote() {
		return noLote;
	}
	public void setNoLote(String noLote) {
		this.noLote = noLote;
	}
	//Metodos
	public void imprimirProducto(Producto doc)
	{
		System.out.print("\t"+doc.getFechaCad()+"\t"+doc.getNoLote());
	}
}
