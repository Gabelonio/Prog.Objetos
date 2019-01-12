/*
 * PROGRAMA PARA GESTIONAR LOS CURSOS DE LOS MAESTROS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/11/2017
*/
package ejercicio1;
public class Persona 
{
	//Atributos
	private String nombre,primerApellido,segundoApellido,curso;
	
	private int edad;
	//Metodos
	Persona()
	{
	}
	Persona(String nombre,String primerApellido,String segundoApellido)
	{
		this.nombre=nombre;
		this.primerApellido=primerApellido;
		this.segundoApellido=segundoApellido; 
	}
	//Getters y Setters
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
