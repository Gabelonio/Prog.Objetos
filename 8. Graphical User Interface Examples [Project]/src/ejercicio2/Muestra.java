/*
 * PROGRAMA PARA CALCULAR EL AREA Y PERIMETRO DE UN RECTANGULO 
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 18/10/2017
*/
package ejercicio2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Muestra extends JPanel{
	private int ancho,largo; 
  	Muestra()
    {
        this.ancho=100;
        this.largo=100;
    }
    public void paint(Graphics g)
	{
    	g.setColor(Color.DARK_GRAY);
    	g.fillRect(0,0,this.ancho,this.largo);
    	g.setColor(Color.red);
    	g.drawRect(0,0,250,200);
    }
	public void setAncho(int ancho) {
		if(ancho>250)
  			this.ancho=250;
		else
			this.ancho = ancho;
	}
	public void setLargo(int largo) {
		if(largo>200)
            this.largo=200; 
		else
			this.largo = largo;
	}
    
}
