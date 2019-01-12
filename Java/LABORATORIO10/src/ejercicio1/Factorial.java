/*
 * PROGRAMA PARA CALCULAR EL FACTORIAL DE UN NUMERO
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio1;
public class Factorial 
{
	private int numero;
	//Getters y Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	//Metodos
	public int calcularFactorialIterativo()
	{
		int retorno=this.numero;
		if(retorno==0) 
			return 1;
		else
		{
			for(int i=this.numero-1;i>=1;i--)
				retorno*=i; 
			return retorno; 
		}
	}
	public int calcularFactorialRecursivo(int numero)
	{
		return(numero==0)?1:numero*calcularFactorialRecursivo(numero-1);
	}
}
