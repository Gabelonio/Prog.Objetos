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
import javax.swing.JTextField;

public class CreacionProfesor  extends JFrame implements ActionListener
{
	private JButton botonAgregar;
	private JLabel letrero,letreroNombre,letreroprimerApellido,letrerosegundoApellido,letreroEdad,letreroPregrado,letreroCurso,advertencia;
	private JTextField nombre,primerApellido,segundoApellido,edad,curso,pregrado; 
	private ArrayList<Profesor> TablaProfesores; 
	private ArrayList<Estudiante> TablaEstudiantes; 
	public class tipedNum implements KeyListener
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			try {
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
	CreacionProfesor(ArrayList<Profesor> profesores,ArrayList<Estudiante> estudiantes)
	{
		
		//Cargar los estudiantes existentes
		TablaProfesores=new ArrayList<Profesor>();
		TablaProfesores.addAll(profesores);
		TablaEstudiantes=new ArrayList<Estudiante>();
		TablaEstudiantes.addAll(estudiantes);
		
		//Colocacion de Titulo
		this.setTitle("Registro del Curso");
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
	    advertencia.setBounds(130,265,350,70);
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
		letreroEdad.setBounds(155,202,120,25);
		letreroPregrado=new JLabel("Pregrado:");
		letreroPregrado.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroPregrado.setBounds(130,232,120,25);
		letreroCurso=new JLabel("Clase:");
		letreroCurso.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroCurso.setBounds(153,262,120,25);
	
		
		
		nombre=new JTextField();
		nombre.setBounds(205,110,90,25);
		primerApellido=new JTextField();
		primerApellido.setBounds(205,140,90,25);
		segundoApellido=new JTextField();
		segundoApellido.setBounds(205,170,90,25);
		edad=new JTextField();
		edad.setBounds(205,200,40,25);
		edad.addKeyListener(new tipedNum());
		pregrado=new JTextField();
		pregrado.setBounds(205,230,90,25);
		curso=new JTextField();
		curso.setBounds(205,260,90,25);
		
		//Configurando los letreros
		botonAgregar=new JButton("Registrar Profesor"); 
		botonAgregar.addActionListener(this);
		botonAgregar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonAgregar.setBounds(110,320,150,25);
		
		//Agregando los componentes
		this.add(advertencia);
		this.add(letrero);
		this.add(letreroNombre);
		this.add(letreroprimerApellido);
		this.add(letrerosegundoApellido);
		this.add(letreroEdad);
		this.add(letreroPregrado);
		this.add(letreroCurso);
		this.add(nombre);
		this.add(primerApellido);
		this.add(segundoApellido);
		this.add(edad);
		this.add(pregrado);
		this.add(curso);
		this.add(botonAgregar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Registrar Profesor"))
		{
			advertencia.setText("Datos Incompletos");
			boolean repeticion=false;  
			if(!nombre.getText().equals("")&&!primerApellido.getText().equals("")&&!segundoApellido.getText().equals("")&&!edad.getText().equals("")&&!pregrado.getText().equals("")&&!curso.getText().equals(""))
			{
				//Verifica si se repite el nombre
				for(int i=0;i<TablaProfesores.size();i++)
				{
					if(nombre.getText().equalsIgnoreCase(TablaProfesores.get(i).getNombre())&&primerApellido.getText().equalsIgnoreCase(TablaProfesores.get(i).getPrimerApellido())&&segundoApellido.getText().equalsIgnoreCase(TablaProfesores.get(i).getSegundoApellido()))
					{
						repeticion=true;
						advertencia.setText("Nombre ya Registrado");
						advertencia.setVisible(true);
					}
					if(curso.getText().equalsIgnoreCase(TablaProfesores.get(i).getCurso()))
					{
						repeticion=true;
						advertencia.setText("Curso ya Registrado");
						advertencia.setVisible(true);
					}
				}
				if(!repeticion)
				{
					if(Double.parseDouble(edad.getText())<=150)
					{
						TablaProfesores.add(new Profesor(nombre.getText(),primerApellido.getText(),segundoApellido.getText(),pregrado.getText(),Integer.parseInt(edad.getText()),curso.getText())); 
						CreacionEstudiante p=new CreacionEstudiante(TablaEstudiantes,TablaProfesores,curso.getText());			
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
