/*
 * PROGRAMA PARA DETERMINAR LOS DATOS DE TRES ESTUDIANTES
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio2;
public class Estudiante {
	private String nombre,apellido;
	private double notaUno,notaDos,examen,promedio;
	//Constructores 
	Estudiante(String nombre,String apellido,double notaUno,double notaDos,double examen)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.notaUno=notaUno;
		this.notaDos=notaDos;
		this.examen=examen;
		this.promedio=notaUno*0.3+notaDos*0.3+examen*0.4;
	}
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public double getNotaUno() {
		return notaUno;
	}
	public double getNotaDos() {
		return notaDos;
	}
	public double getExamen() {
		return examen;
	}
	public double getPromedio() {
		return promedio;
	}
	
}
