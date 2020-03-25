/*
 * PROGRAMA PARA CALCULAR EL AREA Y PERIMETRO DE UN RECTANGULO 
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 18/10/2017
*/
package ejercicio2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Ventana extends JFrame implements ActionListener{
	 
	private Rectangulo rect;
	private JButton calcular; 
	private Muestra muestra; 
	private JTextField ancho,largo,respuesta; 
    private JLabel letreroAncho,letreroLargo,letreroOpcion,letreroAns;
    private ButtonGroup menu;
    private JRadioButton area,perimetro;
    public class tiped implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			try {
                Double.parseDouble(ancho.getText()+e.getKeyChar());
                Double.parseDouble(largo.getText()+e.getKeyChar());
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
			muestra.setLargo((int)Double.parseDouble(largo.getText()));
			muestra.setAncho((int)Double.parseDouble(ancho.getText()));	
			revalidate();
			validate();
			repaint();
		}
    }
	public Ventana()
	{
		//Colocacion de Titulo
		this.setTitle("Calculadora del Rectángulo");
		//Determinacion del tamaño
		this.setSize(400,400);
		//Inicializar el cuadro
		this.setLayout(null);
		//Colocar como salida predeterminada cuando se cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Colocar en el centro la ventana
		this.setLocationRelativeTo(null);
		//No cambiar dimensiones
		this.setResizable(false);
		
		//Configurando el Panel
		muestra=new Muestra();
		muestra.setBounds(25,25,300,300);
        ancho=new JTextField("0");
        ancho.setBounds(150,235,40,25);
        ancho.addKeyListener(new tiped());
        largo=new JTextField("0");
        largo.setBounds(325,110,40,25);
        largo.addKeyListener(new tiped());
        letreroAncho=new JLabel("Ancho: ");
        letreroAncho.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroAncho.setBounds(100,228,60,40);
        letreroLargo=new JLabel("Largo: ");
        letreroLargo.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroLargo.setBounds(280,102,60,40);
        letreroOpcion=new JLabel("Hallar: ");
        letreroOpcion.setFont(new Font("Serif", Font.PLAIN, 17));
        letreroOpcion.setBounds(298,150,90,30);
        letreroAns=new JLabel("Ans.:");
        letreroAns.setFont(new Font("Serif", Font.PLAIN,14));
        letreroAns.setBounds(265,235,90,20);
        respuesta=new JTextField();
        respuesta.setEditable(false);
        respuesta.setBounds(295,235,90,20);
        
        //Configurar las opciones
        area=new JRadioButton("Área");
        area.setFont(new Font("Serif", Font.PLAIN,14));
        area.setMnemonic(KeyEvent.VK_0);
        area.setActionCommand("Área");
        area.setSelected(true);
        area.setBounds(295,200,90,30);
        perimetro=new JRadioButton("Perimetro");
        perimetro.setFont(new Font("Serif", Font.PLAIN,14));
        perimetro.setMnemonic(KeyEvent.VK_1);
        perimetro.setActionCommand("Perimetro");
        perimetro.setBounds(295,175,90,30);
        menu=new ButtonGroup();
        menu.add(area);
        menu.add(perimetro);
		
        //Configurando el boton
		calcular=new JButton(); 
		calcular.setBounds(0,275,400,100);
		calcular.setText("Calcular");
		calcular.addActionListener(this);
		
		//Agregando los componentes a la ventana
		this.add(letreroAncho);
		this.add(letreroLargo);
		this.add(letreroOpcion); 
        this.add(letreroAns);
		this.add(muestra);
    	this.add(largo);
        this.add(ancho); 
		this.add(calcular);
		this.add(area);
		this.add(perimetro); 
		this.add(respuesta); 
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Calcular"))
		{
			if(Double.parseDouble(largo.getText())<0||Double.parseDouble(ancho.getText())<0)
				{
					respuesta.setText("NUMBER-ERROR");
				}
				else
				{
					rect = new Rectangulo(Double.parseDouble(ancho.getText()),Double.parseDouble(largo.getText()));
					if(area.isSelected())
						respuesta.setText(String.valueOf(rect.calcularArea()));
					if(perimetro.isSelected())
						respuesta.setText(String.valueOf(rect.calcularPerimetro()));
				}
		}
	}
}
