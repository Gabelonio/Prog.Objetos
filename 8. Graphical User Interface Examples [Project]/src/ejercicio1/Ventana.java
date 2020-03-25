/*
 * PROGRAMA PARA CONVERTIR DISTINTOS VALORES DE MONEDA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 18/10/2017
*/
package ejercicio1;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{
	
	
	private JButton botonConvertir;
	private JLabel valor;
	private JTextField numero;
	private JComboBox opcionesent,opcionessal; 
	private JPanel menu;
	private Conversor conversor;
		
	
	public Ventana(){
		//Colocacion de Titulo
		this.setTitle("Convertidor");
		//Determinacion del tamaño
		this.setSize(300,200);
		//Inicializar una Grilla
	    this.setLayout(new GridLayout(2,1));
		//Colocar como salida predeterminada cuando se cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Colocar en el centro la ventana
		this.setLocationRelativeTo(null);
		
		//Configurando la grilla superior
		valor=new JLabel("Valor: "); 
		numero=new JTextField();
		String[] lista={"Peso Colombiano","Euro","Dolar"};
		opcionesent= new JComboBox(lista);
		opcionesent.setSelectedIndex(0);
		opcionessal= new JComboBox(lista);
		opcionessal.setSelectedIndex(0);
		//Agregando una grilla superior
		menu=new JPanel(); 
		menu.setLayout(new GridLayout(2,2));
		menu.add(valor);
		menu.add(numero);
		menu.add(opcionesent);
		menu.add(opcionessal);
		//Agregando el Boton 
		botonConvertir = new JButton("Convertir");
		botonConvertir.addActionListener(this);
		
		//Agregando los componentes a la ventana
		this.add(menu);
		this.add(botonConvertir);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			if(numero.getText().equals(""))
				numero.setText("SYNTAX-ERROR");
			if(numero.getText().matches("[+-]?\\d*(\\.\\d+)?"))
			{
				if(Double.parseDouble(numero.getText())<0)
				{
					numero.setText("NUMBER-ERROR");
				}
				else
				{
					conversor = new Conversor(Double.parseDouble(numero.getText()));
					JOptionPane.showMessageDialog(null, "La Conversión es: $"+conversor.convertirMonedas(opcionesent.getSelectedIndex(),opcionessal.getSelectedIndex()));			
				}
			}
			else 
				numero.setText("SYNTAX-ERROR");
	}
}