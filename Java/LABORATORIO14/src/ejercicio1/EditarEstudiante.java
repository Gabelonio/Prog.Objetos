/*
 * PROGRAMA PARA LLEVAR EL CONTROL DE CALIFICACIONES DE 5 ESTUDIANTES
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 25/10/2017
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

public class EditarEstudiante extends JFrame implements ActionListener{

	private int ubicacion;
	private JButton botonEditar;
	private JLabel letrero,letreroNombre,letreroNotaUno,letreroNotaDos,letreroNotaTres,advertencia;
	private JTextField nombre,notaUno,notaDos,notaParcial; 
	private ArrayList<Estudiante> Tabla; 
	public class tipedNum implements KeyListener
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			try {
				if(e.getKeyChar()!='.')
				{
					Double.parseDouble(notaUno.getText()+e.getKeyChar());
					Double.parseDouble(notaDos.getText()+e.getKeyChar());
					Double.parseDouble(notaParcial.getText()+e.getKeyChar());	
				}
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
	EditarEstudiante(ArrayList<Estudiante> coleccion,String busqueda)
	{
		Tabla=new ArrayList<Estudiante>();
		if(coleccion!=null)
			Tabla.addAll(coleccion); 
		else
		{
			JOptionPane.showMessageDialog(null, "No hay Registros que Editar");		
			Principal p=new Principal(Tabla);
			p.setVisible(true);
			this.dispose();
		}
		//Determiar la ubicacion del nombre ingresado
		for(int i=0;i<Tabla.size();i++)
		{
			if(Tabla.get(i).getNombre().equals(busqueda))
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
	    advertencia.setBounds(130,220,350,70);
	    advertencia.setForeground(Color.red);
	    advertencia.setVisible(false);
	    letrero=new JLabel("Diligencie los Datos");
	    letrero.setFont(new Font("Serif", Font.PLAIN, 20));
	    letrero.setBounds(110,40,350,70);
    	letreroNombre=new JLabel("Nombre:");
    	letreroNombre.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroNombre.setBounds(75,112,120,25);
		letreroNotaUno=new JLabel("Parcial 1:");
    	letreroNotaUno.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroNotaUno.setBounds(75,142,120,25);
		letreroNotaDos=new JLabel("Parcial 2:");
    	letreroNotaDos.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroNotaDos.setBounds(75,172,120,25);
		letreroNotaTres=new JLabel("Examen Final:");
    	letreroNotaTres.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroNotaTres.setBounds(75,202,120,25);
	
		
		
		nombre=new JTextField();
		nombre.setBounds(175,110,120,25);
		nombre.setText(busqueda);
		nombre.setEditable(false);
		notaUno=new JTextField();
		notaUno.setBounds(175,140,40,25);
		notaUno.addKeyListener(new tipedNum());
		notaDos=new JTextField();
		notaDos.setBounds(175,170,40,25);
		notaDos.addKeyListener(new tipedNum());
		notaParcial=new JTextField();
		notaParcial.setBounds(175,200,40,25);
		notaParcial.addKeyListener(new tipedNum());
		
		//Configurando los letreros
		botonEditar=new JButton("Guardar Alumno"); 
		botonEditar.addActionListener(this);
		botonEditar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonEditar.setBounds(110,270,150,25);
		
		//Agregando los componentes
		this.add(advertencia);
		this.add(letrero);
		this.add(letreroNombre);
		this.add(letreroNotaUno);
		this.add(letreroNotaDos);
		this.add(letreroNotaTres);
		this.add(nombre);
		this.add(notaUno);
		this.add(notaDos);
		this.add(notaParcial);
		this.add(botonEditar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Guardar Alumno"))
		{
			if(!notaUno.getText().equals("")&&!notaDos.getText().equals("")&&!notaParcial.getText().equals(""))
			{
				if(Double.parseDouble(notaUno.getText())<=5&&Double.parseDouble(notaDos.getText())<=5&&Double.parseDouble(notaParcial.getText())<=5)
				{
					Tabla.set(ubicacion,new Estudiante(nombre.getText(),Double.parseDouble(notaUno.getText()),Double.parseDouble(notaDos.getText()),Double.parseDouble(notaParcial.getText())));
					JOptionPane.showMessageDialog(null, "Edición Exitosa\nRecuerde Guardar los Cambios");	
					Principal p=new Principal(Tabla);
					p.setVisible(true);
					this.dispose();
				}
				else
				{
					advertencia.setText("Notas Inválidas");
					advertencia.setVisible(true);
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
