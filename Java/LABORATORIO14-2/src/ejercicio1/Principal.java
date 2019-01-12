/*
 * PROGRAMA PARA GESTIONAR LOS CURSOS DE LOS MAESTROS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/11/2017
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

	private JButton botonCrearProfesor,botonCargar,botonBorrarEstudiante,botonBorrarProfesor,botonEditarEstudiante,botonEditarProfesor,botonGuardar;
	private JLabel letrero,letreroSeleccione;
	private ArrayList<Estudiante> TablaEstudiantes;
	private ArrayList<Profesor> TablaProfesores;

		
	
	public Principal(ArrayList<Estudiante> estudiantes,ArrayList<Profesor> profesores)
	{
		File est= new File("Estudiantes.txt");
		File prof= new File("Profesores.txt");
		try {
			est.createNewFile();
			prof.createNewFile(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		TablaEstudiantes=new ArrayList<Estudiante>();
		TablaProfesores=new ArrayList<Profesor>(); 
		//El primer añadido sera para agregar los existentes del documento, los siguientes son para el registro hecho
		if(estudiantes!=null)
			TablaEstudiantes.addAll(estudiantes); 
		else
			TablaEstudiantes.addAll(new Estudiante().coleccionarEstudiantes());
		if(profesores!=null)
			TablaProfesores.addAll(profesores); 
		else
			TablaProfesores.addAll(new Profesor().coleccionarProfesores());
		//Colocacion de Titulo
		this.setTitle("Gestion de Cursos Escolares");
		//Determinacion del tamaño
		this.setSize(400,450);
		//Inicializar una Grilla
	    this.setLayout(null);
		//Colocar como salida predeterminada cuando se cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Colocar en el centro la ventana
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//Configurando Los Titulos
		letrero=new JLabel("Sistema de Gestión de Cursos");
		letrero.setFont(new Font("Serif", Font.PLAIN, 20));
		letrero.setBounds(70,20,350,70);
		letreroSeleccione=new JLabel("Seleccione");
		letreroSeleccione.setFont(new Font("Serif", Font.PLAIN, 18));
		letreroSeleccione.setBounds(140,50,120,70);
		
		
		
		//Configurando los Botones
		botonCrearProfesor=new JButton("Registrar Curso"); 
		botonCrearProfesor.addActionListener(this);
		botonCrearProfesor.setFont(new Font("Garamond", Font.BOLD, 13));
		botonCrearProfesor.setBounds(110,155,150,25);
		botonEditarEstudiante=new JButton("Editar Estudiante"); 
		botonEditarEstudiante.addActionListener(this);
		botonEditarEstudiante.setFont(new Font("Garamond", Font.BOLD, 15));
		botonEditarEstudiante.setBounds(110,190,150,25);
		botonEditarProfesor=new JButton("Editar Profesor"); 
		botonEditarProfesor.addActionListener(this);
		botonEditarProfesor.setFont(new Font("Garamond", Font.BOLD, 15));
		botonEditarProfesor.setBounds(110,225,150,25);
		botonCargar=new JButton("Cargar Registros"); 
		botonCargar.addActionListener(this);
		botonCargar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonCargar.setBounds(110,260,150,25);
		botonBorrarEstudiante=new JButton("Borrar Estudiante"); 
		botonBorrarEstudiante.addActionListener(this);
		botonBorrarEstudiante.setFont(new Font("Garamond", Font.BOLD, 15));
		botonBorrarEstudiante.setBounds(110,295,150,25);
		botonBorrarProfesor=new JButton("Borrar Profesor"); 
		botonBorrarProfesor.addActionListener(this);
		botonBorrarProfesor.setFont(new Font("Garamond", Font.BOLD, 15));
		botonBorrarProfesor.setBounds(110,330,150,25);
		botonGuardar=new JButton("Guardar Todo"); 
		botonGuardar.addActionListener(this);
		botonGuardar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonGuardar.setBounds(110,365,150,25);
		
		
		
		//Agregando los componentes a la ventana
		this.add(letrero);
		this.add(letreroSeleccione);
		this.add(botonCrearProfesor); 
		this.add(botonEditarEstudiante);
		this.add(botonEditarProfesor); 
		this.add(botonGuardar);
		this.add(botonBorrarEstudiante);
		this.add(botonBorrarProfesor);
		this.add(botonCargar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Registrar Curso"))
		{
			this.dispose();
			new CreacionProfesor(TablaProfesores,TablaEstudiantes).setVisible(true);
		}
		if(e.getActionCommand().equals("Editar Estudiante"))
		{
			String nombreCompleto=JOptionPane.showInputDialog(null, "Ingrese el Nombre Completo a Buscar ");
			try
			{
				if(new Estudiante().encontrarEstudiante(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length()),TablaEstudiantes)!=-1)
				{
					this.dispose();
					new EditarEstudiante(TablaEstudiantes,TablaProfesores,nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length())).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
			}
		}
		if(e.getActionCommand().equals("Editar Profesor"))
		{
			String nombreCompleto=JOptionPane.showInputDialog(null, "Ingrese el Nombre Completo a Buscar ");			
			try
			{
				if(new Profesor().encontrarProfesor(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length()),TablaProfesores)!=-1)
				{
					this.dispose();
					new EditarProfesor(TablaEstudiantes,TablaProfesores,nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length())).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
			}
		}
		if(e.getActionCommand().equals("Cargar Registros"))
		{
			String busqueda=JOptionPane.showInputDialog(null, "Ingrese el Curso a Buscar\n(NN para ver los estudiantes sin curso)"),impresion="";
			boolean encontrado=false;
			int ubicacion=0; 
			if(busqueda.equals("NN"))
			{
				encontrado=true; 
			}
			else
			{
				for(int i=0;i<TablaProfesores.size();i++)
		        {
					if(busqueda.equalsIgnoreCase(TablaProfesores.get(i).getCurso()))
					{
						encontrado=true;
						ubicacion=i; 
						impresion=impresion.concat("\nNombre: "+TablaProfesores.get(i).getNombre()+" "+TablaProfesores.get(i).getPrimerApellido()+" "+TablaProfesores.get(i).getSegundoApellido()+" Pregrado: "+TablaProfesores.get(i).getPregrado()+" Edad: "+TablaProfesores.get(i).getEdad()+" Curso: "+TablaProfesores.get(i).getCurso()+"\n");
					}		
		        }
			}
			if(encontrado)
			{
				for(int i=0;i<TablaEstudiantes.size();i++)
		        {
					if(busqueda.equalsIgnoreCase("NN"))
					{
						if(TablaEstudiantes.get(i).getCurso().equals("NN"))
							impresion=impresion.concat("\nNombre: "+TablaEstudiantes.get(i).getNombre()+" "+TablaEstudiantes.get(i).getPrimerApellido()+" "+TablaEstudiantes.get(i).getSegundoApellido()+" Promedio: "+TablaEstudiantes.get(i).getPromedio()+" Edad: "+TablaEstudiantes.get(i).getEdad());	
					}
					else
					{
						if(TablaEstudiantes.get(i).getCurso().equalsIgnoreCase(TablaProfesores.get(ubicacion).getCurso()))
							impresion=impresion.concat("\nNombre: "+TablaEstudiantes.get(i).getNombre()+" "+TablaEstudiantes.get(i).getPrimerApellido()+" "+TablaEstudiantes.get(i).getSegundoApellido()+" Promedio: "+TablaEstudiantes.get(i).getPromedio()+" Edad: "+TablaEstudiantes.get(i).getEdad());
					}
				 }
		        JOptionPane.showMessageDialog(null,impresion,"Lista de Estudiantes",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
		}
		if(e.getActionCommand().equals("Borrar Estudiante"))
		{
			String nombreCompleto=JOptionPane.showInputDialog(null, "Ingrese el Nombre a Borrar ");		
			try
			{
				if(new Estudiante().encontrarEstudiante(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length()),TablaEstudiantes)!=-1)
				{
					TablaEstudiantes.remove(new Estudiante().encontrarEstudiante(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length()),TablaEstudiantes));
					JOptionPane.showMessageDialog(null, "Eliminación Realizada con Éxito");	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
			}
			
		}
		if(e.getActionCommand().equals("Borrar Profesor"))
		{
			String nombreCompleto=JOptionPane.showInputDialog(null, "Ingrese el Nombre a Borrar ");		
			try
			{	
				if(new Profesor().encontrarProfesor(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length()),TablaProfesores)!=-1)
				{
					//Cambia los cursos de estudiante
					for(int i=0;i<TablaEstudiantes.size();i++)
					{
						if(TablaEstudiantes.get(i).getCurso().equalsIgnoreCase(TablaProfesores.get(new Profesor().encontrarProfesor(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length()),TablaProfesores)).getCurso()))
							TablaEstudiantes.get(i).setCurso("NN");
					}
					TablaProfesores.remove((new Profesor().encontrarProfesor(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.lastIndexOf(" ")),nombreCompleto.substring(nombreCompleto.lastIndexOf(" ")+1,nombreCompleto.length()),TablaProfesores)));
					JOptionPane.showMessageDialog(null, "Eliminación Realizada con Éxito");	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
			}
		}
		if(e.getActionCommand().equals("Guardar Todo"))
		{
			DataOutputStream archivoEstudiantes = null,archivoProfesores=null;
			try 
			{
				archivoEstudiantes = new DataOutputStream(new FileOutputStream("Estudiantes.txt"));
				archivoProfesores = new DataOutputStream(new FileOutputStream("Profesores.txt"));
				for(int i=0;i<TablaEstudiantes.size();i++)
				{
					archivoEstudiantes.writeUTF(TablaEstudiantes.get(i).getNombre());
					archivoEstudiantes.writeUTF(TablaEstudiantes.get(i).getPrimerApellido());
					archivoEstudiantes.writeUTF(TablaEstudiantes.get(i).getSegundoApellido());
					archivoEstudiantes.writeInt(TablaEstudiantes.get(i).getEdad());
					archivoEstudiantes.writeDouble(TablaEstudiantes.get(i).getPromedio());
					archivoEstudiantes.writeUTF(TablaEstudiantes.get(i).getCurso());
				}
				for(int i=0;i<TablaProfesores.size();i++)
				{
					archivoProfesores.writeUTF(TablaProfesores.get(i).getNombre());
					archivoProfesores.writeUTF(TablaProfesores.get(i).getPrimerApellido());
					archivoProfesores.writeUTF(TablaProfesores.get(i).getSegundoApellido());
					archivoProfesores.writeUTF(TablaProfesores.get(i).getPregrado());
					archivoProfesores.writeInt(TablaProfesores.get(i).getEdad());
					archivoProfesores.writeUTF(TablaProfesores.get(i).getCurso());
				}
				archivoEstudiantes.close();
				archivoProfesores.close();
				JOptionPane.showMessageDialog(null, "Todos los Registros Guardados con Éxito");			
			}
			catch(FileNotFoundException fnfe) { fnfe.printStackTrace();}
			catch (IOException ioe) { ioe.printStackTrace();}
			catch (Exception ioe) { ioe.printStackTrace();}
		}
	}
}
