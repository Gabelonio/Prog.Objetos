/*
 * PROGRAMA PARA ADMINISTRAR EL SISTEMA DE UN HOSPITAL
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 10/11/2017
*/
package ejercicio1;
public class Hospital {
	//Atributos
	private String nombre,ciudadUbicacion,direccion;
	
	Hospital(String nombre,String ciudad,String direccion)
	{
		this.nombre=nombre;
		this.ciudadUbicacion=ciudad;
		this.direccion=direccion; 
	}
	
	//Setters y Getters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudadUbicacion() {
		return ciudadUbicacion;
	}
	public void setCiudadUbicacion(String ciudadUbicacion) {
		this.ciudadUbicacion = ciudadUbicacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
