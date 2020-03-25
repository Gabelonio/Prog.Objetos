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

import ejercicio1.CreacionProfesor.tipedNum;

public class CreacionEstudiante  extends JFrame implements ActionListener
{
	private JButton botonAgregar,botonMenu;
	private JLabel letrero,letreroNombre,letreroprimerApellido,letrerosegundoApellido,letreroEdad,letreroPromedio,advertencia,exito;
	private JTextField nombre,primerApellido,segundoApellido,edad,promedio; 
	private ArrayList<Profesor> TablaProfesores; 
	private ArrayList<Estudiante> TablaEstudiantes; 
	private String curso;
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
	CreacionEstudiante(ArrayList<Estudiante> coleccion,ArrayList<Profesor> profesores,String curso)
	{
		
		//Cargar los estudiantes existentes
		TablaProfesores=new ArrayList<Profesor>();
		TablaProfesores.addAll(profesores);
		TablaEstudiantes=new ArrayList<Estudiante>();
		TablaEstudiantes.addAll(coleccion);
		//Asignar el curso
		this.curso=curso;
		//Colocacion de Titulo
		this.setTitle("Clase de "+curso);
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

	    exito=new JLabel("Registro Exitoso");
	    exito.setFont(new Font("Serif", Font.PLAIN, 15));
	    exito.setBounds(130,235,350,70);
	    exito.setForeground(Color.blue);
	    exito.setVisible(false);
	    advertencia=new JLabel("Datos Incompletos");
	    advertencia.setFont(new Font("Serif", Font.PLAIN, 15));
	    advertencia.setBounds(130,235,350,70);
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
	
		
		
		nombre=new JTextField();
		nombre.setBounds(205,110,90,25);
		primerApellido=new JTextField();
		primerApellido.setBounds(205,140,90,25);
		segundoApellido=new JTextField();
		segundoApellido.setBounds(205,170,90,25);
		edad=new JTextField();
		edad.setBounds(205,200,40,25);
		edad.addKeyListener(new tipedNum());
		promedio=new JTextField();
		promedio.setBounds(205,230,40,25);
		promedio.addKeyListener(new tipedNum());
		
		//Configurando los letreros
		botonAgregar=new JButton("Registrar Alumno"); 
		botonAgregar.addActionListener(this);
		botonAgregar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonAgregar.setBounds(110,290,150,25);
		botonMenu=new JButton("Menu Principal"); 
		botonMenu.addActionListener(this);
		botonMenu.setFont(new Font("Garamond", Font.BOLD, 15));
		botonMenu.setBounds(110,330,150,25);
		
		//Agregando los componentes
		this.add(exito);
		this.add(advertencia);
		this.add(letrero);
		this.add(letreroNombre);
		this.add(letreroprimerApellido);
		this.add(letrerosegundoApellido);
		this.add(letreroEdad);
		this.add(letreroPromedio); 
		this.add(nombre);
		this.add(primerApellido);
		this.add(segundoApellido);
		this.add(edad);
		this.add(promedio);
		this.add(botonAgregar);
		this.add(botonMenu);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Registrar Alumno"))
		{
			advertencia.setText("Datos Incompletos");
			boolean repeticionNombre=false; 
			if(!nombre.getText().equals("")&&!primerApellido.getText().equals("")&&!segundoApellido.getText().equals("")&&!promedio.getText().equals("")&&!edad.getText().equals(""))
			{
				//Verifica si se repite el nombre
				for(int i=0;i<TablaEstudiantes.size();i++)
				{
					if(nombre.getText().equals(TablaEstudiantes.get(i).getNombre())&&primerApellido.getText().equals(TablaEstudiantes.get(i).getPrimerApellido())&&segundoApellido.getText().equals(TablaEstudiantes.get(i).getSegundoApellido()))
					{
						repeticionNombre=true;
						advertencia.setText("Nombre ya Registrado");
						advertencia.setVisible(true);
					}
				}
				if(!repeticionNombre)
				{
					if(Double.parseDouble(edad.getText())<=150&&Double.parseDouble(promedio.getText())<=5)
					{
						TablaEstudiantes.add(new Estudiante(nombre.getText(),primerApellido.getText(),segundoApellido.getText(),Integer.parseInt(edad.getText()),Double.parseDouble(promedio.getText()),curso)); 
						nombre.setText("");
						primerApellido.setText("");
						segundoApellido.setText("");
						promedio.setText("");
						edad.setText("");
						advertencia.setVisible(false);
						exito.setVisible(true);
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
				exito.setVisible(false); 
				advertencia.setVisible(true);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getActionCommand().equals("Menu Principal"))
		{
			Principal p=new Principal(TablaEstudiantes,TablaProfesores);
			p.setVisible(true);
			this.dispose();
		}
	}
	
}
