/*
 * PROGRAMA PARA DETERMINAR EL MES Y SUS DIAS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio3;
public class Calendario {
	//Atributos
	private String nombreMes; 
	private int dias; 
	//Constructor
	Calendario(int numero)
	{
		String[] nombreMes={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		this.nombreMes = nombreMes[numero-1];
		if(numero==3)
			this.dias=28;
		else
			this.dias=(numero%2==0)?31:30;
	}
	//Getters
	public String getNombreMes() {
		return nombreMes;
	}
	public int getDias() {
		return dias;
	}
	
}
