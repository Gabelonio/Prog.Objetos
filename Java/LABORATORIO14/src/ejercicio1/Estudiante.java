/*
 * PROGRAMA PARA LLEVAR EL CONTROL DE CALIFICACIONES DE 5 ESTUDIANTES
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 25/10/2017
*/
package ejercicio1;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Estudiante 
{
	//Atributos
	private String nombre; 
	private double notaUno,notaDos,notaParcial,notaDefinitiva; 

	//Metodos
	//Constructor
	Estudiante()
	{		
	}
	Estudiante(String nombre,double notaUno,double notaDos,double notaParcial)
	{
		this.nombre=nombre;
		this.notaUno=notaUno;
		this.notaDos=notaDos;
		this.notaParcial=notaParcial; 
		this.notaDefinitiva=this.notaUno*0.3+this.notaDos*0.3+this.notaParcial*0.4; 
	}
	//Setters y Getters
	public double getNotaDefinitiva() {
		return notaDefinitiva;
	}
	public String getNombre() {
		return nombre;
	}
	public double getNotaUno() {
		return notaUno;
	}
	public double getNotaDos() {
		return notaDos;
	}
	public double getNotaParcial() {
		return notaParcial;
	}
	
	//Otros Metodos
	public ArrayList<Estudiante> coleccionarEstudiantes() 
	{
		ArrayList <Estudiante> coleccion=new ArrayList<Estudiante>();
		Estudiante nuevo; 
		DataInputStream archivo = null;
		try
		{
			archivo = new DataInputStream(new FileInputStream("Registro.txt") );
			while (true)
			{	
				nuevo=new Estudiante(archivo.readUTF(),archivo.readDouble(),archivo.readDouble(),archivo.readDouble());
				archivo.readDouble(); 
				coleccion.add(nuevo); 
			}
		}	
		catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
		catch (IOException ioe) { /* Error al escribir */ }
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
	public boolean encontrarEstudiante(String Nombre,ArrayList <Estudiante> memoria)
	{
		ArrayList <Estudiante> coleccion=new ArrayList<Estudiante>();
		if(memoria==null)
		{
			DataInputStream archivo = null;
			try
			{
				archivo = new DataInputStream(new FileInputStream("Registro.txt"));
				while (true)
				{
					if(archivo.readUTF().equals(Nombre))
					{
						archivo.close();
						return true;
					}
					for(int i=0;i<4;i++)
						archivo.readDouble();		
				}
			}
			catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
			catch (IOException ioe) { /* Error al escribir */ }
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
			return false;
		}
		else
		{
			coleccion.addAll(memoria); 
			for(int i=0;i<coleccion.size();i++)
			{
				if(Nombre.equals(coleccion.get(i).getNombre()))
					return true; 
			}
			return false; 
		}
	}
}
