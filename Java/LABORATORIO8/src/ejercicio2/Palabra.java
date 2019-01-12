/*
 * PROGRAMA PARA DETERMINAR UNA PALABRA PALINDROMA O CAPÍCUA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio2;
public class Palabra 
{
	//atributos
	private String palabra;
	//Metodos
	//Getters y Setters
	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	//Determinar la Palabra
	public boolean determinarCapicuo(String palabra)
	{
		boolean retorno=true; 
		for(int i=0;i<palabra.length();i++)
		{
			retorno =(palabra.toLowerCase().charAt(palabra.length()-1-i)==palabra.toLowerCase().charAt(i));
			if(retorno==false)
				break; 
		}
		return retorno; 
	}
	
}
