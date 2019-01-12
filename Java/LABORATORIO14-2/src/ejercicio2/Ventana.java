/*
 * PROGRAMA PARA CONVERTIR DISTINTOS VALORES DE MONEDA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 18/10/2017
*/
package ejercicio2;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{
	
	
	private JButton botonCalcular;
	private JLabel valorUno,valorDos,valorTres,letarea,letperimetro;
	private JTextField numeroUno,numeroDos,numeroTres,area,perimetro;
	private JComboBox opciones; 
	private JPanel menu,resultados;
	private Triangulo triangulo;
	private Circulo circulo;
	private Rectangulo rectangulo;
	private Cuadrado cuadrado; 	
	public class tipedNum implements KeyListener
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			try {
				Double.parseDouble(numeroUno.getText()+e.getKeyChar());
				Double.parseDouble(numeroDos.getText()+e.getKeyChar());
				Double.parseDouble(numeroTres.getText()+e.getKeyChar());
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
	public class mouseclicked implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			switch(opciones.getSelectedIndex())
			{
				case 0:{
					valorUno.setText("Lado 1: "); 
					numeroUno.setEditable(true);
					valorDos.setText("Lado 2: ");
					numeroDos.setEditable(true);
					valorTres.setText("Lado 3: ");
					numeroTres.setEditable(true);
					break; 
				}
				case 1:{
					valorUno.setText("Radio: "); 
					numeroUno.setEditable(true);
					valorDos.setText("");
					numeroDos.setEditable(false);
					valorTres.setText("");
					numeroTres.setEditable(false);
					break; 
				}
				case 2:{
					valorUno.setText("Alto: "); 
					numeroUno.setEditable(true);
					valorDos.setText("Ancho: ");
					numeroDos.setEditable(true);
					valorTres.setText("");
					numeroTres.setEditable(false);
					break; 
				}
				case 3:{
					valorUno.setText("Lado: "); 
					numeroUno.setEditable(true);
					valorDos.setText("");
					numeroDos.setEditable(false);
					valorTres.setText("");
					numeroTres.setEditable(false);
					break; 
				}
			}
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {			
		}
	}
	public Ventana(){
		
		triangulo=new Triangulo();
		circulo=new Circulo();
		rectangulo=new Rectangulo();
		
		//Colocacion de Titulo
		this.setTitle("Convertidor");
		//Determinacion del tamaño
		this.setSize(300,200);
		//Inicializar una Grilla
	    this.setLayout(new GridLayout(4,1));
		//Colocar como salida predeterminada cuando se cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Colocar en el centro la ventana
		this.setLocationRelativeTo(null);
		
		//Configurando la grilla superior
		valorUno=new JLabel("Lado 1: "); 
		numeroUno=new JTextField();
		numeroUno.addKeyListener(new tipedNum());
		numeroUno.setEditable(true);
		valorDos=new JLabel("Lado 2: "); 
		numeroDos=new JTextField();
		numeroDos.setEditable(true);
		numeroDos.addKeyListener(new tipedNum());
		valorTres=new JLabel("Lado 3: "); 
		numeroTres=new JTextField();
		numeroTres.setEditable(true);
		numeroTres.addKeyListener(new tipedNum());
		letarea=new JLabel("Area: ");
		area=new JTextField();
		area.setEditable(false);
		letperimetro=new JLabel("Perimetro: ");
		perimetro=new JTextField();
		perimetro.setEditable(false);
		
		String[] lista={"Triangulo","Circulo","Rectangulo","Cuadrado"};
		opciones= new JComboBox(lista);
		opciones.setSelectedIndex(0);
		opciones.addMouseListener(new mouseclicked());
		//Agregando una grilla superior
		menu=new JPanel(); 
		menu.setLayout(new GridLayout(1,6));
		menu.add(valorUno);
		menu.add(numeroUno);
		menu.add(valorDos);
		menu.add(numeroDos);
		menu.add(valorTres);
		menu.add(numeroTres);
		
		//Agregando el Boton 
		botonCalcular = new JButton("Calcular");
		botonCalcular.addActionListener(this);
		
		//Agregando los reultados
		resultados=new JPanel(); 
		resultados.setLayout(new GridLayout(1,4));
		resultados.add(letarea);
		resultados.add(area);
		resultados.add(letperimetro);
		resultados.add(perimetro);
		//Agregando los componentes a la ventana
		this.add(menu);
		this.add(opciones);
		this.add(resultados); 
		this.add(botonCalcular); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Calcular"))
		{
			switch(opciones.getSelectedIndex())
			{
				case 0:{
					triangulo.setLadoUno(Double.parseDouble(numeroUno.getText()));
					triangulo.setLadoDos(Double.parseDouble(numeroDos.getText()));
					triangulo.setLadoTres(Double.parseDouble(numeroTres.getText()));
					area.setText(String.format("%.4f", triangulo.calcularArea()));
					perimetro.setText(String.valueOf(triangulo.calcularPerimetro()));
					break; 
				}
				case 1:{
					circulo.setRadio(Double.parseDouble(numeroUno.getText()));
					area.setText(String.format("%.4f", circulo.calcularArea()));
					perimetro.setText(String.format("%.4f", circulo.calcularPerimetro()));
					break; 
				}
				case 2:{
					rectangulo.setLargo(Double.parseDouble(numeroUno.getText()));
					rectangulo.setAncho(Double.parseDouble(numeroDos.getText()));
					area.setText(String.valueOf(rectangulo.calcularArea()));
					perimetro.setText(String.valueOf(rectangulo.calcularPerimetro()));
					break; 
				}
				case 3:{
					cuadrado=new Cuadrado(Double.parseDouble(numeroUno.getText())); 
					area.setText(String.valueOf(cuadrado.calcularArea()));
					perimetro.setText(String.valueOf(cuadrado.calcularPerimetro()));
					break; 
				}
				
			}
			numeroUno.setText("");
			numeroDos.setText("");
			numeroTres.setText("");
		}
	}
}