/*
 * PROGRAMA PARA GESTIONAR LOS CURSOS DE LOS MAESTROS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/11/2017
*/
package ejercicio1;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class Estudiante extends Persona 
{
	//Atributos
	private double promedio; 
	//Metodos
	
	//Constructor
	Estudiante()
	{		
	}
	Estudiante(String nombre,String primerApellido,String segundoApellido,int edad,double promedio,String curso)
	{
		super(nombre,primerApellido,segundoApellido);
		super.setCurso(curso);
		super.setEdad(edad);
		this.promedio=promedio; 
	}
	
	//Getter
	public double getPromedio() {
		return promedio;
	}
	
	//Otros Metodos
	public ArrayList<Estudiante> coleccionarEstudiantes()  
	{
		ArrayList <Estudiante> coleccion=new ArrayList<Estudiante>();
		Estudiante nuevo; 
		DataInputStream archivo = null;
		try
		{
			archivo = new DataInputStream(new FileInputStream("Estudiantes.txt") );
			while (true)
			{	
				
				nuevo=new Estudiante(archivo.readUTF(),archivo.readUTF(),archivo.readUTF(),archivo.readInt(),archivo.readDouble(),archivo.readUTF());
				coleccion.add(nuevo); 
			}
		}	
		catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
		catch (IOException ioe) { /* Error al escribir  */}
		finally
		{
			try 
			{
				if(archivo!=null)
					archivo.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return coleccion; 
	}
	public int encontrarEstudiante(String Nombre,String primerApellido,String segundoApellido,ArrayList <Estudiante> memoria)
	{
		ArrayList <Estudiante> coleccion=new ArrayList<Estudiante>();
		coleccion.addAll(memoria); 
		for(int i=0;i<coleccion.size();i++)
		{
			if(Nombre.equalsIgnoreCase(coleccion.get(i).getNombre())&&primerApellido.equalsIgnoreCase(coleccion.get(i).getPrimerApellido())&&segundoApellido.equalsIgnoreCase(coleccion.get(i).getSegundoApellido()))
				return i; 
		}
		return -1; 
	}
}
