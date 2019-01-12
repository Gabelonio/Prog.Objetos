/*
 * PROGRAMA PARA GESTIONAR LOS CURSOS DE LOS MAESTROS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/11/2017
*/
package ejercicio1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ejercicio1.CreacionEstudiante.tipedNum;

public class EditarEstudiante extends JFrame implements ActionListener{

	private JButton botonEditar;
	private JLabel letrero,letreroNombre,letreroprimerApellido,letrerosegundoApellido,letreroEdad,letreroPromedio,letreroCurso,advertencia;
	private JTextField nombre,primerApellido,segundoApellido,edad,promedio,curso; 
	private ArrayList<Profesor> TablaProfesores; 
	private ArrayList<Estudiante> TablaEstudiantes; 
	private int ubicacion; 
	public class tipedNum implements KeyListener
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			try {			
				if(e.getKeyChar()!='.')
				{		
					Double.parseDouble(promedio.getText()+e.getKeyChar());	
				}
				Double.parseDouble(edad.getText()+e.getKeyChar());
			}catch (NumberFormatException ex) {
				e.consume();
			}
			finally
			{
				if(e.getKeyChar()=='d'||e.getKeyChar()=='f')
					e.consume();
			}
		}
		@Override
		public void keyPressed(KeyEvent e) {
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
    }
	EditarEstudiante(ArrayList<Estudiante> coleccion,ArrayList<Profesor> profesores,String nombre,String apellidoUno,String apellidoDos)
	{
		//Cargar los estudiantes existentes
		TablaProfesores=new ArrayList<Profesor>();
		TablaProfesores.addAll(profesores);
		TablaEstudiantes=new ArrayList<Estudiante>();
		TablaEstudiantes.addAll(coleccion);
		//Determiar la ubicacion del nombre ingresado
		for(int i=0;i<TablaEstudiantes.size();i++)
		{	
			if(TablaEstudiantes.get(i).getNombre().equalsIgnoreCase((nombre))&&TablaEstudiantes.get(i).getPrimerApellido().equalsIgnoreCase((apellidoUno))&&TablaEstudiantes.get(i).getSegundoApellido().equalsIgnoreCase((apellidoDos)))
			{
				ubicacion=i;
			}
		}
		//Colocacion de Titulo
		this.setTitle("Edición de Estudiantes");
		//Determinacion del tamaño
		this.setSize(400,400);
		//Inicializar una Grilla
	    this.setLayout(null);
	    //Colocar como salida predeterminada cuando se cierre
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //Colocar en el centro la ventana
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    
	   
	    //Configurando los letreros

	    advertencia=new JLabel("Datos Incompletos");
	    advertencia.setFont(new Font("Serif", Font.PLAIN, 15));
	    advertencia.setBounds(130,285,350,70);
	    advertencia.setForeground(Color.red);
	    advertencia.setVisible(false);
	    
	    
	    letrero=new JLabel("Diligencie los Datos");
	    letrero.setFont(new Font("Serif", Font.PLAIN, 20));
	    letrero.setBounds(110,40,350,70);
    	letreroNombre=new JLabel("Nombre:");
    	letreroNombre.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroNombre.setBounds(135,112,120,25);
		letreroprimerApellido=new JLabel("Primer Apellido:");
    	letreroprimerApellido.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroprimerApellido.setBounds(85,142,120,25);
		letrerosegundoApellido=new JLabel("Segundo Apellido:");
    	letrerosegundoApellido.setFont(new Font("Garamond", Font.PLAIN, 17));
		letrerosegundoApellido.setBounds(73,172,140,25);
		letreroEdad=new JLabel("Edad:");
    	letreroEdad.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroEdad.setBounds(157,202,120,25);
		letreroPromedio=new JLabel("Promedio:");
		letreroPromedio.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroPromedio.setBounds(127,232,120,25);
		letreroCurso=new JLabel("Clase:");
		letreroCurso.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroCurso.setBounds(127,262,120,25);
		
		
		this.nombre=new JTextField();
		this.nombre.setBounds(205,110,90,25);
		this.nombre.setText(nombre);
		this.nombre.setEditable(false);
		primerApellido=new JTextField();
		primerApellido.setBounds(205,140,90,25);
		primerApellido.setText(apellidoUno);
		primerApellido.setEditable(false);
		segundoApellido=new JTextField();
		segundoApellido.setBounds(205,170,90,25);
		segundoApellido.setText(apellidoDos);
		segundoApellido.setEditable(false);
		edad=new JTextField();
		edad.setBounds(205,200,40,25);
		edad.addKeyListener(new tipedNum());
		promedio=new JTextField();
		promedio.setBounds(205,230,40,25);
		promedio.addKeyListener(new tipedNum());
		curso=new JTextField();
		curso.setBounds(205,260,90,25);
		curso.setText(TablaEstudiantes.get(ubicacion).getCurso());
		
		//Configurando los letreros
		botonEditar=new JButton("Editar Alumno"); 
		botonEditar.addActionListener(this);
		botonEditar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonEditar.setBounds(110,290,150,25);
		
		//Agregando los componentes
		this.add(advertencia);
		this.add(letrero);
		this.add(letreroNombre);
		this.add(letreroprimerApellido);
		this.add(letrerosegundoApellido);
		this.add(letreroEdad);
		this.add(letreroPromedio); 
		this.add(letreroCurso);
		this.add(this.nombre);
		this.add(curso); 
		this.add(primerApellido);
		this.add(segundoApellido);
		this.add(edad);
		this.add(promedio);
		this.add(botonEditar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Editar Alumno"))
		{
			advertencia.setText("Datos Incompletos");
			boolean encontrarCurso=false;
			if(!nombre.getText().equals("")&&!primerApellido.getText().equals("")&&!segundoApellido.getText().equals("")&&!promedio.getText().equals("")&&!edad.getText().equals(""))
			{
				//Busca el Curso
				for(int i=0;i<TablaProfesores.size();i++)
				{
					if(curso.getText().equalsIgnoreCase(TablaProfesores.get(i).getCurso())&&!encontrarCurso)
					{
						encontrarCurso=true;
					}
				}
				if(curso.getText().equals("NN"))
					encontrarCurso=true; 
				if(!encontrarCurso)
				{
					advertencia.setText("Curso no Encontrado");
					advertencia.setVisible(true);
				}			
				if(encontrarCurso)
				{
					if(Double.parseDouble(edad.getText())<=150&&Double.parseDouble(promedio.getText())<=5)
					{
						TablaEstudiantes.set(ubicacion,new Estudiante(nombre.getText(),primerApellido.getText(),segundoApellido.getText(),Integer.parseInt(edad.getText()),Double.parseDouble(promedio.getText()),curso.getText())); 
						Principal p=new Principal(TablaEstudiantes,TablaProfesores);
						p.setVisible(true);
						this.dispose();
					}
					else
					{
						advertencia.setText("Dato Inválidos");
						advertencia.setVisible(true);
					}
				}
			}
			else
			{
				advertencia.setVisible(true);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

}
