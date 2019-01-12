/*
 * PROGRAMA PARA LLEVAR EL CONTROL DE CALIFICACIONES DE 5 HistorialMedicoS
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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreacionHistorialMedico  extends JFrame implements ActionListener
{
	private JButton botonAgregar,botonMenu;
	private JLabel letrero,letreroNombre,letreroApellidos,letreroGenero,letreroFechaNacimiento,letreroNombreHospital,letreroUbicacionHospital,letreroDireccion,letreroFechaExpedicion,letreroDescripcion,indicadorFecha1,indicadorFecha2,exito,advertencia;
	private JTextField  Nombre,Apellidos,FechaNacimientoDia,FechaNacimientoMes,FechaNacimientoAnio,NombreHospital,UbicacionHospital,Direccion,FechaExpedicionDia,FechaExpedicionMes,FechaExpedicionAnio;
	private JTextArea Descripcion;
	private ArrayList<HistorialMedico> Tabla; 
	private ButtonGroup selecGenero;
    private JRadioButton radioHombre,radioMujer;
	public class tipedNum implements KeyListener
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			try {
				Double.parseDouble(FechaNacimientoDia.getText()+e.getKeyChar());
				Double.parseDouble(FechaNacimientoMes.getText()+e.getKeyChar());
				Double.parseDouble(FechaNacimientoAnio.getText()+e.getKeyChar());
				Double.parseDouble(FechaExpedicionDia.getText()+e.getKeyChar());
				Double.parseDouble(FechaExpedicionMes.getText()+e.getKeyChar());
				Double.parseDouble(FechaExpedicionAnio.getText()+e.getKeyChar());
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
	
	public JLabel setLabel(String nombre,int x,int y,int ancho,int largo,int tamTexto)
	{
		JLabel label; 
		label=new JLabel(nombre);
	    label.setFont(new Font("Serif", Font.PLAIN, tamTexto));
	    label.setBounds(x,y,ancho,largo);
	    return label; 
	}

	CreacionHistorialMedico(ArrayList<HistorialMedico> coleccion)
	{
		
		//Cargar los HistorialMedicos existentes
		Tabla=new ArrayList<HistorialMedico>();
		Tabla.addAll(coleccion);
		
		//Colocacion de Titulo
		this.setTitle("Agregación de Historiales Medicos");
		//Determinacion del tamaño
		this.setSize(1200,400);
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
	    exito.setBounds(490,210,350,70);
	    exito.setForeground(Color.blue);
	    exito.setVisible(false);
	    advertencia=new JLabel("Datos Incompletos");
	    advertencia.setFont(new Font("Serif", Font.PLAIN, 15));
	    advertencia.setBounds(490,210,350,70);
	    advertencia.setForeground(Color.red);
	    advertencia.setVisible(false);
	    
	    
	    letrero=this.setLabel("Diligencie los Datos",465,40,350,70,20);
	    letreroNombre=this.setLabel("Nombre Paciente:",35,112,150,25,17);
	    letreroApellidos=this.setLabel("Apellidos:",35,142,120,25,17);
	    letreroGenero=this.setLabel("Genero:",35,172,120,25,17);
	    letreroFechaNacimiento=this.setLabel("Fecha Nacimiento:",35,202,150,25,17);	 
	    indicadorFecha1=this.setLabel("DD-MM-AAAA",175,220,150,25,15);
	    /*
	    letrero=new JLabel("Diligencie los Datos");
	    letrero.setFont(new Font("Serif", Font.PLAIN, 20));
	    letrero.setBounds(110,40,350,70);
    	letreroNombre=new JLabel("Nombre Paciente:");
    	letreroNombre.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroNombre.setBounds(75,112,120,25);
		letreroApellidos=new JLabel("Apellidos:");
    	letreroApellidos.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroApellidos.setBounds(75,142,120,25);
		letreroGenero=new JLabel("Genero:");
    	letreroGenero.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroGenero.setBounds(75,172,120,25);
		letreroFechaNacimiento=new JLabel("Examen Final:");
    	letreroFechaNacimiento.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroFechaNacimiento.setBounds(75,202,120,25);
		*/
	    letreroNombreHospital=this.setLabel("Nombre Hospital:",435,112,150,25,17);
	    letreroUbicacionHospital=this.setLabel("Ciudad Ubicación:",435,142,150,25,17);
	    letreroDireccion=this.setLabel("Dirección:",435,172,120,25,17);
	    
	    /*
		letreroNombreHospital=new JLabel("Nombre Hospital:");
    	letreroNombreHospital.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroNombreHospital.setBounds(75,112,120,25);
		letreroUbicacionHospital=new JLabel("Ciudad:");
    	letreroUbicacionHospital.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroUbicacionHospital.setBounds(75,142,120,25);
		letreroDireccion=new JLabel("Direccion:");
    	letreroDireccion.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroDireccion.setBounds(75,202,120,25);
		*/
	    

	    letreroFechaExpedicion=this.setLabel("Fecha Expedición:",785,112,150,25,17);
	    indicadorFecha2=this.setLabel("DD-MM-AAAA",935,130,150,25,15);
	    letreroDescripcion=this.setLabel("Descripción:",785,162,120,25,17);	
	    
	    
	    /*
		letreroFechaExpedicion=new JLabel("Fecha Expedición:");
    	letreroFechaExpedicion.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroFechaExpedicion.setBounds(75,112,120,25);
		letreroDescripcion=new JLabel("Descripcion:");
    	letreroDescripcion.setFont(new Font("Garamond", Font.PLAIN, 17));
		letreroDescripcion.setBounds(75,142,120,25);
	     */
		
		
		Nombre=new JTextField();
		Nombre.setBounds(175,110,120,25);
		Apellidos=new JTextField();
		Apellidos.setBounds(175,140,170,25);
		FechaNacimientoDia=new JTextField();
		FechaNacimientoDia.setBounds(175,200,20,25);
		FechaNacimientoDia.addKeyListener(new tipedNum());
		FechaNacimientoMes=new JTextField();
		FechaNacimientoMes.setBounds(205,200,20,25);
		FechaNacimientoMes.addKeyListener(new tipedNum());
		FechaNacimientoAnio=new JTextField();
		FechaNacimientoAnio.setBounds(235,200,60,25);
		FechaNacimientoAnio.addKeyListener(new tipedNum());
		
		NombreHospital=new JTextField();
		NombreHospital.setBounds(590,112,170,25);
		UbicacionHospital=new JTextField();
		UbicacionHospital.setBounds(590,142,170,25);
		Direccion=new JTextField();
		Direccion.setBounds(590,172,170,25);
		
		FechaExpedicionDia=new JTextField();
		FechaExpedicionDia.setBounds(935,112,20,25);
		FechaExpedicionDia.addKeyListener(new tipedNum());
		FechaExpedicionMes=new JTextField();
		FechaExpedicionMes.setBounds(965,112,20,25);
		FechaExpedicionMes.addKeyListener(new tipedNum());
		FechaExpedicionAnio=new JTextField();
		FechaExpedicionAnio.setBounds(995,112,60,25);
		FechaExpedicionAnio.addKeyListener(new tipedNum());
		Descripcion=new JTextArea();
		Descripcion.setBounds(935,165,190,170);
		Descripcion.setLineWrap(true);
        Descripcion.setWrapStyleWord(true);
		
		
		//Configurando los letreros
		botonAgregar=new JButton("Registrar Paciente"); 
		botonAgregar.addActionListener(this);
		botonAgregar.setFont(new Font("Garamond", Font.BOLD, 15));
		botonAgregar.setBounds(470,270,150,25);
		botonMenu=new JButton("Menu Principal"); 
		botonMenu.addActionListener(this);
		botonMenu.setFont(new Font("Garamond", Font.BOLD, 15));
		botonMenu.setBounds(470,310,150,25);
		

		radioHombre=new JRadioButton("Hombre");
        radioHombre.setFont(new Font("Serif", Font.PLAIN,14));
        radioHombre.setMnemonic(KeyEvent.VK_0);
        radioHombre.setActionCommand("radioHombre");
        radioHombre.setSelected(true);
        radioHombre.setBounds(175,170,90,30);
        radioMujer=new JRadioButton("Mujer");
        radioMujer.setFont(new Font("Serif", Font.PLAIN,14));
        radioMujer.setMnemonic(KeyEvent.VK_1);
        radioMujer.setActionCommand("radioMujer");
        radioMujer.setBounds(270,170,90,30);
        selecGenero=new ButtonGroup();
        selecGenero.add(radioHombre);
        selecGenero.add(radioMujer);
		
		//Agregando los componentes
		this.add(exito);
		this.add(advertencia);
		this.add(letrero);
		this.add(letreroNombre);
		this.add(letreroApellidos);
		this.add(letreroGenero);
		this.add(letreroFechaNacimiento);
		this.add(letreroNombreHospital);
		this.add(letreroUbicacionHospital);
		this.add(letreroDireccion);
		this.add(letreroFechaExpedicion);
		this.add(letreroDescripcion);
		this.add(indicadorFecha1);
		this.add(indicadorFecha2);
		
		//Espacios de Texto
		this.add(Nombre);
		this.add(Apellidos);
		this.add(radioHombre);
		this.add(radioMujer);
		this.add(FechaNacimientoDia);
		this.add(FechaNacimientoMes);
		this.add(FechaNacimientoAnio);
		this.add(NombreHospital);
		this.add(UbicacionHospital);
		this.add(Direccion);
		this.add(FechaExpedicionDia);
		this.add(FechaExpedicionMes);
		this.add(FechaExpedicionAnio);
		this.add(Descripcion);
		this.add(botonAgregar);
		this.add(botonMenu);
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Registrar Paciente"))
		{
			advertencia.setText("Datos Incompletos");
			boolean repeticionNombre=false; 
			if(!Nombre.getText().equals("")&&!Apellidos.getText().equals("")&&!FechaNacimientoDia.getText().equals("")&&!FechaNacimientoMes.getText().equals("")&&!FechaNacimientoAnio.getText().equals("")&&!NombreHospital.getText().equals("")&&!UbicacionHospital.getText().equals("")&&!Direccion.getText().equals("")&&!FechaExpedicionDia.getText().equals("")&&!FechaExpedicionMes.getText().equals("")&&!FechaExpedicionAnio.getText().equals("")&&!Descripcion.getText().equals(""))
			{
				//Verifica si se repite el nombre
				for(int i=0;i<Tabla.size();i++)
				{
					if(Nombre.getText().equals(Tabla.get(i).p.getNombre())&&Apellidos.getText().equals(Tabla.get(i).p.getApellidos()))
					{
						repeticionNombre=true;
						advertencia.setText("Nombre ya Registrado");
						advertencia.setVisible(true);
					}
				}
				if(!repeticionNombre)
				{
					if(Double.parseDouble(FechaNacimientoDia.getText())<=31&&Double.parseDouble(FechaNacimientoMes.getText())<=12&&Double.parseDouble(FechaExpedicionDia.getText())<=31&&Double.parseDouble(FechaExpedicionMes.getText())<=12)
					{
						//HistorialMedico(String nombre,String apellidos,char genero,String fechaNacimiento,String nombreHospital,String ciudad,String direccion,String fecha,String descripcion)
						char genero=(radioHombre.isSelected())?'H':'M';
						Tabla.add(new HistorialMedico(Nombre.getText(),Apellidos.getText(),genero,FechaNacimientoDia.getText()+"/"+FechaNacimientoMes.getText()+"/"+FechaNacimientoAnio.getText(),NombreHospital.getText(),UbicacionHospital.getText(),Direccion.getText(),(FechaExpedicionDia.getText()+"/"+FechaExpedicionMes.getText()+"/"+FechaExpedicionAnio.getText()),Descripcion.getText()));
						Nombre.setText("");
						Apellidos.setText("");
						FechaNacimientoDia.setText("");
						FechaNacimientoMes.setText("");
						FechaNacimientoAnio.setText("");
						NombreHospital.setText("");
						UbicacionHospital.setText("");
						Direccion.setText("");
						FechaExpedicionDia.setText("");
						FechaExpedicionMes.setText("");
						FechaExpedicionAnio.setText("");
						Descripcion.setText("");
						advertencia.setVisible(false);
						exito.setVisible(true);
					}
					else
					{
						advertencia.setText("Datos Inválidos");
						exito.setVisible(false);
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
			Principal p=new Principal(Tabla);
			p.setVisible(true);
			this.dispose();
		}
	}
}
