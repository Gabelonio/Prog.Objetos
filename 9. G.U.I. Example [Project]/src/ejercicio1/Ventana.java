/*
 * PROGRAMA PARA DETERMINAR LAS POSIBLES SOLUCIONES DE UNA ECUACIÓN CUADRÁTICA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 25/10/2017
*/
package ejercicio1;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{
	
	
	private JButton botonSolucion,botonReset;
	private JLabel letreroCuadrado,letreroSingular,letreroOrdenado;
	private JTextField cuadrado,singular,ordenado,resultado;
	private JPanel menu,botones;
	private Ecuacion ecuacion;
		
	
	public Ventana(){
		//Colocacion de Titulo
		this.setTitle("Solucionador de ecuaciones GRADO 2");
		//Determinacion del tamaño
		this.setSize(400,200);
		//Inicializar una Grilla
	    this.setLayout(new GridLayout(3,1));
		//Colocar como salida predeterminada cuando se cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Colocar en el centro la ventana
		this.setLocationRelativeTo(null);
		
		//Configurando la grilla superior
		cuadrado=new JTextField();
		letreroCuadrado=new JLabel("x^2+");
		singular= new JTextField();
		letreroSingular=new JLabel("x+");
		ordenado=new JTextField(); 
		letreroOrdenado=new JLabel("=0"); 
		//Agregando una grilla superior
		menu=new JPanel(); 
		menu.setLayout(new GridLayout(1,6));
		menu.add(cuadrado);
		menu.add(letreroCuadrado);
		menu.add(singular);
		menu.add(letreroSingular);
		menu.add(ordenado);
		menu.add(letreroOrdenado);
		
		//Configurando el resultado
		resultado=new JTextField();
		resultado.setEditable(false);
		
		//Configurando los Botones
		botones=new JPanel();
		botones.setLayout(new GridLayout(1,2));
		botonReset=new JButton("Reset"); 
		botonReset.addActionListener(this);
		botonSolucion = new JButton("Calcular");
		botonSolucion.addActionListener(this);
		botones.add(botonSolucion);
		botones.add(botonReset); 
		
		//Agregando los componentes a la ventana
		this.add(menu);
		this.add(botones);
		this.add(resultado); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Calcular") )
		{
			if(cuadrado.getText().equals("")||singular.getText().equals("")||ordenado.getText().equals(""))
			{
				resultado.setText("SYNTAX-ERROR");
			}
			else
			{
				if(cuadrado.getText().matches("[+-]?\\d*(\\.\\d+)?")&&singular.getText().matches("[+-]?\\d*(\\.\\d+)?")&&ordenado.getText().matches("[+-]?\\d*(\\.\\d+)?"))
				{
					ecuacion = new Ecuacion();
					ecuacion.setCuadrado(Double.parseDouble(cuadrado.getText()));
					ecuacion.setSingular(Double.parseDouble(singular.getText()));
					ecuacion.setOrdenada(Double.parseDouble(ordenado.getText()));
					if(ecuacion.validarEcuacion().equals("La ecuación esta correctamente planteada"))
						resultado.setText(ecuacion.generarSolucion(ecuacion.getCuadrado(),ecuacion.getSingular(),ecuacion.getOrdenada()));
					else
						resultado.setText(ecuacion.validarEcuacion());

				}
				else 
					resultado.setText("SYNTAX-ERROR");
			}	
		}
		else
		{
			cuadrado.setText("");
			singular.setText("");
			ordenado.setText("");
			resultado.setText("");
		}
	}
}