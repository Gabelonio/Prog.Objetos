/*
 * PROGRAMA PARA LLEVAR EL CONTROL DE CALIFICACIONES DE 5 ESTUDIANTES
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 25/10/2017
*/
package ejercicio1;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends JFrame implements ActionListener{

	private JButton botonCrear,botonCargar,botonBorrar,botonGuardar,botonEditar;
	private JLabel letrero,letreroSeleccione;
	private ArrayList<Estudiante> Tabla; 
		
	
	public Principal(ArrayList<Estudiante> coleccion)
	{
		File file = new File("Registro.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Tabla=new ArrayList<Estudiante>();
		//El primer añadido sera para agregar los existentes del documento, los siguientes son para el registro hecho
		if(coleccion!=null)
			Tabla.addAll(coleccion); 
		else
			Tabla.addAll(new Estudiante().coleccionarEstudiantes());
		
		//Colocacion de Titulo
		this.setTitle("Gestion de Notas Estudiantiles");
		//Determinacion del tamaño
		this.setSize(400,400);
		//Inicializar una Grilla
	    this.setLayout(null);
		//Colocar como salida predeterminada cuando se cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Colocar en el centro la ventana
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//Configurando Los Titulos
		letrero=new JLabel("Bienvenido al Sistema de Gestión de Notas");
		letrero.setFont(new Font("Serif", Font.PLAIN, 20));
		letrero.setBounds(20,20,350,70);
		letreroSeleccione=new JLabel("Seleccione");
		letreroSeleccione.setFont(new Font("Serif", Font.PLAIN, 18));
		letreroSeleccione.setBounds(140,50,120,70);
		
		
		
		//Configurando los Botones
		botonCrear=new JButton("Registrar Alumnos"); 
		botonCrear.addActionListener(this);
		botonCrear.setFont(new Font("Garamond", Font.BOLD, 14));
		botonCrear.setBounds(110,120,150,25);
		botonEditar=new JButton("Editar Registro"); 
		botonEditar.addActionListener(this);
		botonEditar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonEditar.setBounds(110,155,150,25);
		botonCargar=new JButton("Cargar Registros"); 
		botonCargar.addActionListener(this);
		botonCargar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonCargar.setBounds(110,190,150,25);
		botonBorrar=new JButton("Borrar Registro"); 
		botonBorrar.addActionListener(this);
		botonBorrar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonBorrar.setBounds(110,225,150,25);
		botonGuardar=new JButton("Guardar Registros"); 
		botonGuardar.addActionListener(this);
		botonGuardar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonGuardar.setBounds(110,260,150,25);
		
		
		//Agregando los componentes a la ventana
		this.add(letrero);
		this.add(letreroSeleccione);
		this.add(botonCrear);
		this.add(botonEditar);
		this.add(botonGuardar);
		this.add(botonBorrar);
		this.add(botonCargar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Registrar Alumnos"))
		{
			this.dispose();
			new CreacionEstudiante(Tabla).setVisible(true);
		}
		if(e.getActionCommand().equals("Editar Registro"))
		{
			String nombre=JOptionPane.showInputDialog(null, "Ingrese el Nombre a Buscar ");			
			if(new Estudiante().encontrarEstudiante(nombre,Tabla))
			{
				this.dispose();
				new EditarEstudiante(Tabla,nombre).setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
			}
		}
		if(e.getActionCommand().equals("Cargar Registros"))
		{
			String impresion="";
			for(int i=0;i<Tabla.size();i++)
	        {
	            impresion=impresion.concat("\nNombre: "+Tabla.get(i).getNombre()+"   Nota 1: "+Tabla.get(i).getNotaUno()+"   Nota 2: "+Tabla.get(i).getNotaDos()+"   Nota Parcial: "+Tabla.get(i).getNotaParcial()+"   Definitiva: "+Tabla.get(i).getNotaDefinitiva());
	        }
	        JOptionPane.showMessageDialog(null,impresion,"Lista de Estudiantes",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("Borrar Registro"))
		{
			String nombre=JOptionPane.showInputDialog(null, "Ingrese el Nombre a Borrar ");			
			int ubicacion=0; 
			if(new Estudiante().encontrarEstudiante(nombre,Tabla))
			{
				for(int i=0;i<Tabla.size();i++)
				{
					if(Tabla.get(i).getNombre().equals(nombre))
						ubicacion=i;
				}
				Tabla.remove(ubicacion);
				JOptionPane.showMessageDialog(null, "Eliminación Realizada con Éxito");	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
			}
		}
		if(e.getActionCommand().equals("Guardar Registros"))
		{
			DataOutputStream archivo = null;
			try 
			{
				archivo = new DataOutputStream(new FileOutputStream("Registro.txt"));
				for(int i=0;i<Tabla.size();i++)
				{
					archivo.writeUTF(Tabla.get(i).getNombre());
					archivo.writeDouble(Tabla.get(i).getNotaUno());
					archivo.writeDouble(Tabla.get(i).getNotaDos());
					archivo.writeDouble(Tabla.get(i).getNotaParcial());
					archivo.writeDouble(Tabla.get(i).getNotaDefinitiva());
				}
				archivo.close();
				JOptionPane.showMessageDialog(null, "Todos los Registros Guardados con Éxito");			
			}
			catch(FileNotFoundException fnfe) { fnfe.printStackTrace();}
			catch (IOException ioe) { ioe.printStackTrace();}
		}
	}
}
