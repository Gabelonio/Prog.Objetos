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

public class Profesor extends Persona 
{
	private String pregrado;
	//Metodos
	//Constructor
	Profesor()
	{		
	}
	Profesor(String nombre,String primerApellido,String segundoApellido,String pregrado,int edad,String curso)
	{
		super(nombre,primerApellido,segundoApellido);
		super.setCurso(curso);
		super.setEdad(edad);
		this.pregrado=pregrado; 
	}
	public String getPregrado() {
		return pregrado;
	}
	public ArrayList<Profesor> coleccionarProfesores()  
	{
		ArrayList <Profesor> coleccion=new ArrayList<Profesor>();
		Profesor nuevo; 
		DataInputStream archivo = null;
		try
		{
			archivo = new DataInputStream(new FileInputStream("Profesores.txt") );
			while (true)
			{	
				
				nuevo=new Profesor(archivo.readUTF(),archivo.readUTF(),archivo.readUTF(),archivo.readUTF(),archivo.readInt(),archivo.readUTF());
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
	public int encontrarProfesor(String Nombre,String primerApellido,String segundoApellido,ArrayList <Profesor> memoria)
	{
		ArrayList <Profesor> coleccion=new ArrayList<Profesor>();
		coleccion.addAll(memoria); 
		for(int i=0;i<coleccion.size();i++)
		{
			if(Nombre.equalsIgnoreCase(coleccion.get(i).getNombre())&&primerApellido.equalsIgnoreCase(coleccion.get(i).getPrimerApellido())&&segundoApellido.equalsIgnoreCase(coleccion.get(i).getSegundoApellido()))
				return i; 
		}
		return -1; 
	}
}

