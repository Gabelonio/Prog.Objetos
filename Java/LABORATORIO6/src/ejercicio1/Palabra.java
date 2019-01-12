/*
 * PROGRAMA PARA CODIFICAR UNA PALABRA A JULIO CESAR
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/09/2017
*/
package ejercicio1;
public class Palabra 
{
	private String palabra;
	private int corrimiento; 

	public int getCorrimiento() {
		return corrimiento;
	}

	public void setCorrimiento(int corrimiento) {
		this.corrimiento = corrimiento;
	}

	//metodos
	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	} 
	
	//verificar que solo hayan letas y no hayan espacios
	boolean validarPalabra(String ingreso){
		char[] palabra= ingreso.toLowerCase().toCharArray();
		for(int i=0;i<ingreso.length();i++)
		{
			if((palabra[i]>='a'&&palabra[i]<='z')==false||palabra[i]==' ')
				return true; 
		}
		return false;
	}
	
	//metodo para realizar todo el procedimiento
	String encriptarPalabra(String ingreso, int corrimiento){
		char[] retorno= new char[ingreso.length()];
		for(int i=0;i<ingreso.length();i++)
		{
			if(ingreso.charAt(i)+corrimiento>'z')
				retorno[i]=(char)(ingreso.charAt(i)+corrimiento-26);
			else
				retorno[i]=(char)(ingreso.charAt(i)+corrimiento);
		} 
		return String.copyValueOf(retorno); 
	}
	
}
