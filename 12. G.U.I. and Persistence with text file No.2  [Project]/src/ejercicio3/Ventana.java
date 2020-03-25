/*
 * PROGRAMA PARA CALCULAR EL MCM Y EL MCD DE 7 NUMEROS 
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 10/11/2017
*/
package ejercicio3;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{
	private JButton botonReset,botonCalcular;
	private JLabel letreronumeroUno,letreronumeroDos,letreronumeroTres,letreronumeroCuatro,letreronumeroCinco,letreronumeroSeis,letreronumeroSiete;
	private JTextField numeroUno,numeroDos,numeroTres,numeroCuatro,numeroCinco,numeroSeis,numeroSiete;
	private Calculador calculador; 
	public JLabel setLetreroNumero(int num)
	{
		JLabel retorno=new JLabel("Numero "+num+":");
		retorno.setFont(new Font("Serif", Font.PLAIN,15));
		return retorno; 
	}
	public class tipedNum implements KeyListener
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			try {
				Double.parseDouble(numeroUno.getText()+e.getKeyChar());
				Double.parseDouble(numeroDos.getText()+e.getKeyChar());
				Double.parseDouble(numeroTres.getText()+e.getKeyChar());
				Double.parseDouble(numeroCuatro.getText()+e.getKeyChar());
				Double.parseDouble(numeroCinco.getText()+e.getKeyChar());
				Double.parseDouble(numeroSeis.getText()+e.getKeyChar());
				Double.parseDouble(numeroSiete.getText()+e.getKeyChar());
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
	Ventana()
	{
		//Colocacion de Titulo
		this.setTitle("Bienvenido a la Boutique");
		//Determinacion del tamaño
		this.setSize(200,300);
		//Inicializar una Grilla
	    this.setLayout(new GridLayout(8,2));
		//Colocar como salida predeterminada cuando se cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Colocar en el Izquierda la ventana
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		numeroUno=new JTextField();	
		numeroUno.addKeyListener(new tipedNum());
		numeroDos=new JTextField();
		numeroDos.addKeyListener(new tipedNum());
		numeroTres=new JTextField();
		numeroTres.addKeyListener(new tipedNum());
		numeroCuatro=new JTextField();
		numeroCuatro.addKeyListener(new tipedNum());
		numeroCinco=new JTextField();
		numeroCinco.addKeyListener(new tipedNum());
		numeroSeis=new JTextField();
		numeroSeis.addKeyListener(new tipedNum());
		numeroSiete=new JTextField();
		numeroSiete.addKeyListener(new tipedNum());
		
		//Set Letreros
		letreronumeroUno=this.setLetreroNumero(1);
		letreronumeroDos=this.setLetreroNumero(2);
		letreronumeroTres=this.setLetreroNumero(3);
		letreronumeroCuatro=this.setLetreroNumero(4);
		letreronumeroCinco=this.setLetreroNumero(5);
		letreronumeroSeis=this.setLetreroNumero(6);
		letreronumeroSiete=this.setLetreroNumero(7);
		
		//Set los Botones
		botonReset=new JButton("Reset");
		botonReset.addActionListener(this);
		botonCalcular=new JButton("Calcular");
		botonCalcular.addActionListener(this);
		
		//Añadir los Botones
		
		this.add(letreronumeroUno);
		this.add(numeroUno);
		this.add(letreronumeroDos);
		this.add(numeroDos);
		this.add(letreronumeroTres);
		this.add(numeroTres);
		this.add(letreronumeroCuatro);
		this.add(numeroCuatro);
		this.add(letreronumeroCinco);
		this.add(numeroCinco);
		this.add(letreronumeroSeis);
		this.add(numeroSeis);
		this.add(letreronumeroSiete);
		this.add(numeroSiete);
		this.add(botonReset);
		this.add(botonCalcular);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Reset"))
		{
			numeroUno.setText("");
			numeroDos.setText("");
			numeroTres.setText("");
			numeroCuatro.setText("");
			numeroCinco.setText("");
			numeroSeis.setText("");
			numeroSiete.setText("");
		}
		if(e.getActionCommand().equals("Calcular"))
		{
			if(!numeroUno.getText().equals("")&&!numeroDos.getText().equals("")&&!numeroTres.getText().equals("")&&!numeroCuatro.getText().equals("")&&!numeroCinco.getText().equals("")&&!numeroSeis.getText().equals("")&&!numeroSiete.getText().equals("")) 
			{
				calculador=new Calculador();
				//Agregar numeros
				calculador.agregarNumero(Integer.parseInt(numeroUno.getText()));
				calculador.agregarNumero(Integer.parseInt(numeroDos.getText()));
				calculador.agregarNumero(Integer.parseInt(numeroTres.getText()));
				calculador.agregarNumero(Integer.parseInt(numeroCuatro.getText()));
				calculador.agregarNumero(Integer.parseInt(numeroCinco.getText()));
				calculador.agregarNumero(Integer.parseInt(numeroSeis.getText()));
				calculador.agregarNumero(Integer.parseInt(numeroSiete.getText()));
				JOptionPane.showMessageDialog(null,"Máximo común Divisor: "+calculador.determinarMCD()+"\nMínimo Común Múltiplo: "+calculador.determinarMCM()+"\nNúmero Mayor: "+calculador.obtenerNumeroMayor()+"\nNúmero Menor: "+calculador.obtenerNumeroMenor());
			}
			else
				JOptionPane.showMessageDialog(null, "Datos Incompletos");
		}
	}
}
