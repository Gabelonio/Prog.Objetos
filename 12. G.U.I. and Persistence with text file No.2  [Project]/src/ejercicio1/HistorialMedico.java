/*
 * PROGRAMA PARA ADMINISTRAR EL SISTEMA DE UN HOSPITAL
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 10/11/2017
*/
package ejercicio1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class HistorialMedico {
	//Metodos
	private String fechaExpedicion,descripcion;
	public Paciente p; 
	//Cosntructores
	HistorialMedico()
	{
	}
	public void generarPaciente(Paciente paciente)
	{
		Paciente p=new Paciente(paciente.getNombre(),paciente.getApellidos(),paciente.getGenero(),paciente.fechaNacimiento); 
		this.p=p;
	}
	HistorialMedico(String nombre,String apellidos,char genero,String fechaNacimiento,String nombreHospital,String ciudad,String direccion,String fecha,String descripcion)
	{
		this.generarPaciente(new Paciente(nombre,apellidos,genero,fechaNacimiento));
		this.p.hospital=new Hospital(nombreHospital,ciudad,direccion);
		this.fechaExpedicion=fecha; 
		this.descripcion=descripcion;
	}
	//Setters y Getters
	public String getFechaExpedicion() {
		return fechaExpedicion;
	}

	public String getDescripcion() {
		return descripcion;
	} 
	//Otros Metodos
	public ArrayList<HistorialMedico> coleccionarHistorialMedicos() 
	{
		ArrayList <HistorialMedico> coleccion=new ArrayList<HistorialMedico>();
		HistorialMedico nuevo; 
		DataInputStream archivo = null;
		try
		{
			archivo = new DataInputStream(new FileInputStream("Registro.txt") );
			while (true)
			{
				nuevo=new HistorialMedico(archivo.readUTF(),archivo.readUTF(),archivo.readChar(),archivo.readUTF(),archivo.readUTF(),archivo.readUTF(),archivo.readUTF(),archivo.readUTF(),archivo.readUTF());
				coleccion.add(nuevo); 
			}
		}	
		catch(FileNotFoundException fnfe) { /* Archivo no encontrado*/  }
		catch (IOException ioe) { /* Error al escribir*/  }
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
	public boolean encontrarHistorialMedico(String Nombre,String apellidos,ArrayList <HistorialMedico> memoria)
	{
		ArrayList <HistorialMedico> coleccion=new ArrayList<HistorialMedico>();
		coleccion.addAll(memoria); 
		for(int i=0;i<coleccion.size();i++)
		{
			if(Nombre.equals(coleccion.get(i).p.getNombre())&&apellidos.equals(coleccion.get(i).p.getApellidos()))
				return true; 
		}
		return false; 
	}
}
