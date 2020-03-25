/*
 * PROGRAMA PARA DETERMINAR UNA PALABRA PALINDROMA O CAPÍCUA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio4;
public class Oracion 
{
	//atributos
	private String oracion;
	//Metodos
	//Getters y Setters
	public String getOracion() {
		return oracion;
	}

	public void setOracion(String oracion) {
		this.oracion= oracion;
	}
	//Determinar la Palabra
	public boolean determinarCapicuo(String ingreso)
	{
		boolean retorno=true; 
		System.out.println(ingreso); 
		for(int i=0;i<ingreso.length();i++)
		{
			retorno =(ingreso.toLowerCase().charAt(ingreso.length()-1-i)==ingreso.toLowerCase().charAt(i));
			if(retorno==false)
				break; 
		}
		return retorno; 
	}
	
}