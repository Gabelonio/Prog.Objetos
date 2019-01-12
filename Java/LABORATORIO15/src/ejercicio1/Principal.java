/*
 * PROGRAMA PARA LLEVAR EL CONTROL DE CALIFICACIONES DE 5 HistorialMedicoS
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
	private ArrayList<HistorialMedico> Tabla; 
		
	
	public Principal(ArrayList<HistorialMedico> coleccion)
	{
		File file = new File("Registro.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Tabla=new ArrayList<HistorialMedico>();
		//El primer añadido sera para agregar los existentes del documento, los siguientes son para el registro hecho
		if(coleccion!=null)
			Tabla.addAll(coleccion); 
		else
			Tabla.addAll(new HistorialMedico().coleccionarHistorialMedicos());
		
		//Colocacion de Titulo
		this.setTitle("Gestion de Historiales Medicos");
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
		letrero=new JLabel("Bienvenido al Sistema de Gestión de Historiales");
		letrero.setFont(new Font("Serif", Font.PLAIN, 20));
		letrero.setBounds(20,20,350,70);
		letreroSeleccione=new JLabel("Seleccione");
		letreroSeleccione.setFont(new Font("Serif", Font.PLAIN, 18));
		letreroSeleccione.setBounds(140,50,120,70);
		
		
		
		//Configurando los Botones
		botonCrear=new JButton("Registrar Pacientes"); 
		botonCrear.addActionListener(this);
		botonCrear.setFont(new Font("Garamond", Font.BOLD, 13));
		botonCrear.setBounds(110,120,150,25);
		botonEditar=new JButton("Editar Registro"); 
		botonEditar.addActionListener(this);
		botonEditar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonEditar.setBounds(110,155,150,25);
		botonCargar=new JButton("Consultar Paciente"); 
		botonCargar.addActionListener(this);
		botonCargar.setFont(new Font("Garamond", Font.BOLD, 14));
		botonCargar.setBounds(110,190,150,25);
		botonBorrar=new JButton("Borrar Paciente"); 
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
		if(e.getActionCommand().equals("Registrar Pacientes"))
		{
			this.dispose();
			new CreacionHistorialMedico(Tabla).setVisible(true);
		}
		if(e.getActionCommand().equals("Editar Registro"))
		{
			String nombreCompleto=JOptionPane.showInputDialog(null, "Ingrese el Nombre Completo a Buscar ");
			try
			{
				if(new HistorialMedico().encontrarHistorialMedico(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.length()),Tabla))
				{
					this.dispose();
					new EditarHistorialMedico(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.length()),Tabla).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
				}
			}
			catch(IndexOutOfBoundsException ex)
			{
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	

			}
		}
		if(e.getActionCommand().equals("Consultar Paciente"))
		{
			String nombreCompleto=JOptionPane.showInputDialog(null, "Ingrese el Nombre Completo a Consultar ");
			int ubicacion=0; 
			try{
				if(new HistorialMedico().encontrarHistorialMedico(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.length()),Tabla))
				{
					for(int i=0;i<Tabla.size();i++)
					{
						if(Tabla.get(i).p.getNombre().equalsIgnoreCase(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")))&&Tabla.get(i).p.getApellidos().equalsIgnoreCase(nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.length())))
							ubicacion=i;
					}
					new VisualizarHistorialMedico(Tabla.get(ubicacion).p.getNombre(),Tabla.get(ubicacion).p.getApellidos(),Tabla).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	
				}
			}
			catch(IndexOutOfBoundsException ex)
			{
				JOptionPane.showMessageDialog(null, "Nombre no Econtrado");	

			}
		}
		if(e.getActionCommand().equals("Borrar Paciente"))
		{
			String nombreCompleto=JOptionPane.showInputDialog(null, "Ingrese el Nombre Completo a Borrar ");			
			int ubicacion=0; 
			try{
				if(new HistorialMedico().encontrarHistorialMedico(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")),nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.length()),Tabla))
				{
					for(int i=0;i<Tabla.size();i++)
					{
						if(Tabla.get(i).p.getNombre().equalsIgnoreCase(nombreCompleto.substring(0,nombreCompleto.indexOf(" ")))&&Tabla.get(i).p.getApellidos().equalsIgnoreCase(nombreCompleto.substring(nombreCompleto.indexOf(" ")+1,nombreCompleto.length())))
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
			catch(IndexOutOfBoundsException ex)
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
					archivo.writeUTF(Tabla.get(i).p.getNombre());
					archivo.writeUTF(Tabla.get(i).p.getApellidos());
					archivo.writeChar(Tabla.get(i).p.getGenero());
					archivo.writeUTF(Tabla.get(i).p.fechaNacimiento);
					archivo.writeUTF(Tabla.get(i).p.hospital.getNombre());
					archivo.writeUTF(Tabla.get(i).p.hospital.getCiudadUbicacion());
					archivo.writeUTF(Tabla.get(i).p.hospital.getDireccion());
					archivo.writeUTF(Tabla.get(i).getFechaExpedicion());
					archivo.writeUTF(Tabla.get(i).getDescripcion());
				}
				archivo.close();
				JOptionPane.showMessageDialog(null, "Todos los Registros Guardados con Éxito");			
			}
			catch(FileNotFoundException fnfe) { fnfe.printStackTrace();}
			catch (IOException ioe) { ioe.printStackTrace();}
		}
	}
}
