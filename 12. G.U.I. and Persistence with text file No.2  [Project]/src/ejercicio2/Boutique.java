/*
 * PROGRAMA PARA ADMINISTRAR LAS CONSULTAS DE UNA BOUTIQUE
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 10/11/2017
*/
package ejercicio2;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Boutique extends JFrame implements ActionListener{
	
	private ArrayList<Compra> Registros; 
	private int ubicacion; 
	private JButton botonFormales,botonJean,botonBlusa,botonChaqueta,botonPlataforma,botonZapatos,botonAccesorios,botonDerecha,botonCentro,botonIzquierda;
	private JLabel total;
	private JTextField Formales,Jean,Blusa,Chaqueta,Plataforma,Zapatos,Accesorios,precioFormales,precioJean,precioBlusa,precioChaqueta,precioPlataforma,precioZapatos,precioAccesorios,vacio,totalNum;
	public void resetBotones()
	{
		botonFormales.setEnabled(true);
		botonJean.setEnabled(true);
		botonBlusa.setEnabled(true);
		botonChaqueta.setEnabled(true);
		botonPlataforma.setEnabled(true);
		botonZapatos.setEnabled(true);
		botonAccesorios.setEnabled(true);
	}
	public void resetRegistro()
	{
		Formales.setText("$0");
		Jean.setText("$0");
		Blusa.setText("$0");
		Chaqueta.setText("$0");
		Plataforma.setText("$0");
		Zapatos.setText("$0");
		Accesorios.setText("$0");
	}
	public void setRegistro(int[] determinador)
	{
		if(determinador[0]==1)
			Formales.setText("$65.500");
		if(determinador[1]==1)
			Jean.setText("$70.000");
		if(determinador[2]==1)
			Blusa.setText("$49.800");
		if(determinador[3]==1)
			Chaqueta.setText("$125.600");
		if(determinador[4]==1)
			Plataforma.setText("$215.000");
		if(determinador[5]==1)
			Zapatos.setText("$189.000");
		if(determinador[6]==1)
			Accesorios.setText("$45.000");
	}
	public JTextField setPrecio(String precio)
	{
		JTextField retorno=new JTextField("$"+precio);
		retorno.setEditable(false);
		retorno.setFont(new Font("Garamond", Font.BOLD, 15));
		return retorno; 
	}
	public Boutique()
	{
		Registros=new ArrayList<Compra>();
		
		//Colocacion de Titulo
		this.setTitle("Bienvenido a la Boutique");
		//Determinacion del tamaño
		this.setSize(600,500);
		//Inicializar una Grilla
	    this.setLayout(new GridLayout(9,3));
		//Colocar como salida predeterminada cuando se cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Colocar en el Izquierda la ventana
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//Configurando el Total
		vacio=new JTextField("");
		vacio.setEditable(false);
		total=new JLabel("Total:");
		total.setFont(new Font("FrankRuehl", Font.ITALIC, 15));
		//Colocar Precios
		Formales=this.setPrecio("0");
		precioFormales=this.setPrecio("65.500");
		Jean=this.setPrecio("0");
		precioJean=this.setPrecio("70.000");
		Blusa=this.setPrecio("0");
		precioBlusa=this.setPrecio("49.800");
		Chaqueta=this.setPrecio("0");
		precioChaqueta=this.setPrecio("125.600");
		Plataforma=this.setPrecio("0");
		precioPlataforma=this.setPrecio("215.000");
		Zapatos=this.setPrecio("0");
		precioZapatos=this.setPrecio("189.000");
		Accesorios=this.setPrecio("0");
		precioAccesorios=this.setPrecio("45.000");
		totalNum=this.setPrecio("0");
		
		//Agregando los Botones
		botonFormales = new JButton("Pantalones Formales");
		botonFormales.addActionListener(this);
		botonFormales.setFont(new Font("FrankRuehl", Font.ITALIC, 15));
		botonJean = new JButton("Jeans");
		botonJean.addActionListener(this);
		botonJean.setFont(new Font("FrankRuehl", Font.ITALIC, 15));
		botonBlusa = new JButton("Blusa");
		botonBlusa.addActionListener(this);
		botonBlusa.setFont(new Font("FrankRuehl", Font.ITALIC, 15));
		botonChaqueta = new JButton("Chaqueta");
		botonChaqueta.addActionListener(this);
		botonChaqueta.setFont(new Font("FrankRuehl", Font.ITALIC, 15));
		botonPlataforma = new JButton("Zapatos de Plataforma");
		botonPlataforma.addActionListener(this);
		botonPlataforma.setFont(new Font("FrankRuehl", Font.ITALIC, 15));
		botonZapatos = new JButton("Zapatos sin Plataforma");
		botonZapatos.addActionListener(this);
		botonZapatos.setFont(new Font("FrankRuehl", Font.ITALIC, 15));
		botonAccesorios = new JButton("Accesorios");
		botonAccesorios.addActionListener(this);
		botonAccesorios.setFont(new Font("FrankRuehl", Font.ITALIC, 15));
		
		botonCentro = new JButton("Reset");
		botonCentro.addActionListener(this);
		botonCentro.setFont(new Font("Garamond", Font.BOLD, 17));
		botonDerecha = new JButton("Guardar Compra");
		botonDerecha.addActionListener(this);
		botonDerecha.setFont(new Font("Garamond", Font.BOLD, 15));
		botonIzquierda = new JButton("Visualizar Compras");
		botonIzquierda.addActionListener(this);
		botonIzquierda.setFont(new Font("Garamond", Font.BOLD, 15));
		
		
		//Agregando los componentes a la ventana
		this.add(botonFormales);
		this.add(precioFormales);
		this.add(Formales); 
		this.add(botonJean);
		this.add(precioJean);
		this.add(Jean); 
		this.add(botonBlusa);
		this.add(precioBlusa);
		this.add(Blusa); 
		this.add(botonChaqueta);
		this.add(precioChaqueta);
		this.add(Chaqueta); 
		this.add(botonPlataforma);
		this.add(precioPlataforma);
		this.add(Plataforma); 
		this.add(botonZapatos);
		this.add(precioZapatos);
		this.add(Zapatos); 
		this.add(botonAccesorios);
		this.add(precioAccesorios);
		this.add(Accesorios); 
		this.add(vacio);
		this.add(total); 
		this.add(totalNum);
		this.add(botonIzquierda);
		this.add(botonCentro); 
		this.add(botonDerecha);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Pantalones Formales"))
		{
			Formales.setText("$65.500");
			botonFormales.setEnabled(false);
		}
		if(e.getActionCommand().equals("Jeans"))
		{
			Jean.setText("$70.000");
			botonJean.setEnabled(false);
		}
		if(e.getActionCommand().equals("Blusa"))
		{
			Blusa.setText("$49.800");
			botonBlusa.setEnabled(false);
		}
		if(e.getActionCommand().equals("Chaqueta"))
		{
			Chaqueta.setText("$125.600");
			botonChaqueta.setEnabled(false);
		}
		if(e.getActionCommand().equals("Zapatos de Plataforma"))
		{
			Plataforma.setText("$215.000");
			botonPlataforma.setEnabled(false);
		}
		if(e.getActionCommand().equals("Zapatos sin Plataforma"))
		{
			Zapatos.setText("$189.000");
			botonZapatos.setEnabled(false);
		}
		if(e.getActionCommand().equals("Accesorios"))
		{
			Accesorios.setText("$45.000");
			botonAccesorios.setEnabled(false);
		}
		//Resetear Todo
		if(e.getActionCommand().equals("Reset"))
		{
			//Reset los Botones
			this.resetBotones();
			//Reset los Valores
			this.resetRegistro();
		}
		//Guarda la Compra
		if(e.getActionCommand().equals("Guardar Compra"))
		{
			Compra compra=new Compra();
			if(!Formales.getText().equals("$0"))
				compra.ListadeCompras.add(new Producto("Pantalones Formales",65500));
			if(!Jean.getText().equals("$0"))
				compra.ListadeCompras.add(new Producto("Jeans",70000));
			if(!Blusa.getText().equals("$0"))
				compra.ListadeCompras.add(new Producto("Blusa",49800));
			if(!Chaqueta.getText().equals("$0"))
				compra.ListadeCompras.add(new Producto("Chaqueta",125600));
			if(!Plataforma.getText().equals("$0"))
				compra.ListadeCompras.add(new Producto("Zapatos de Plataforma",215000));
			if(!Zapatos.getText().equals("$0"))
				compra.ListadeCompras.add(new Producto("Zapatos sin Plataforma",189000));
			if(!Accesorios.getText().equals("$0"))
				compra.ListadeCompras.add(new Producto("Accesorios",45000));
			//Agrega si hizo o no compras
			if(compra.ListadeCompras.isEmpty())
				JOptionPane.showMessageDialog(null, "Ninguna Compra Hecha");	
			else
			{
				Registros.add(compra); 
				JOptionPane.showMessageDialog(null, "Compra Guardada con Éxito");
				botonCentro.doClick();
			}		
		}
		if(e.getActionCommand().equals("Visualizar Compras"))
		{
			ubicacion=0; 
			if(Registros.isEmpty())
				JOptionPane.showMessageDialog(null, "Ningun Registro Hecho");
			else
			{
				botonCentro.doClick();
				botonCentro.setText("Anterior");
				botonDerecha.setText("Siguiente");
				botonIzquierda.setText("Volver");
				botonCentro.setEnabled(false);
				botonFormales.setEnabled(false);
				botonJean.setEnabled(false);
				botonBlusa.setEnabled(false);
				botonChaqueta.setEnabled(false);
				botonPlataforma.setEnabled(false);
				botonZapatos.setEnabled(false);
				botonAccesorios.setEnabled(false);	
				this.setRegistro(Registros.get(ubicacion).verificarCompra());
				if(Registros.size()==1)
					botonDerecha.setEnabled(false);
			}
		}
		if(e.getActionCommand().equals("Siguiente"))
		{
			ubicacion++;
			this.resetRegistro();
			this.setRegistro(Registros.get(ubicacion).verificarCompra());
			if(ubicacion==(Registros.size()-1))
				botonDerecha.setEnabled(false);
			botonCentro.setEnabled(true);
		}
		if(e.getActionCommand().equals("Anterior"))
		{
			ubicacion--;
			this.resetRegistro();
			this.setRegistro(Registros.get(ubicacion).verificarCompra());
			if(ubicacion==0)
				botonCentro.setEnabled(false);
			botonDerecha.setEnabled(true);
		}
		if(e.getActionCommand().equals("Volver"))
		{
			this.resetRegistro();
			this.resetBotones();
			botonCentro.setText("Reset");
			botonDerecha.setText("Guardar Compra");
			botonIzquierda.setText("Visualizar Compras");
			botonCentro.setEnabled(true);
			botonDerecha.setEnabled(true);
			botonIzquierda.setEnabled(true);
		}
		//Actualizar Total
		totalNum.setText("$"+String.valueOf(1000*(Double.parseDouble(Formales.getText().substring(1))+Double.parseDouble(Jean.getText().substring(1))+Double.parseDouble(Blusa.getText().substring(1))+Double.parseDouble(Chaqueta.getText().substring(1))+Double.parseDouble(Plataforma.getText().substring(1))+Double.parseDouble(Zapatos.getText().substring(1))+Double.parseDouble(Accesorios.getText().substring(1)))));
	}
}