/*
 * PROGRAMA PARA ADMINISTRAR LOS PRODUCTOS DE UNA EMPRESA ALIMENTARIA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 04/10/2017
*/
package ejercicio1;
public class ProductoFresco extends Producto{
	//Atributos
	String fechaEnv,pais;
	//Constructor
	ProductoFresco(String fechaCad,String noLote,String fechaEnv,String pais) {
		super(fechaCad, noLote);
		this.setFechaEnv(fechaEnv);
		this.setPais(pais);
	}
	//Getters y Setters
	public String getFechaEnv() {
		return fechaEnv;
	}
	public void setFechaEnv(String fechaEnv) {
		this.fechaEnv = fechaEnv;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	//Métodos
	public void imprimirProducto(Producto doc)
	{
		super.imprimirProducto(doc);
		System.out.print("\t"+this.getFechaEnv()+"\t"+this.getPais());
	}
	
}
