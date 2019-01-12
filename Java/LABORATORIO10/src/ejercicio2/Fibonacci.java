/*
 * PROGRAMA PARA CONSULTAR LA SUCESION DE FIBONACCI
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio2;
public class Fibonacci {
	//Funciones
	public int fibonacciRecursivo(int numero)
	{
		return(numero<=1)? numero:fibonacciRecursivo(numero-2)+fibonacciRecursivo(numero-1); 
	}
	public int fibonacciIterativo(int numero)
	{
		if(numero<=1)
			return numero;
		else
		{
			int retorno=0,sumUno=1,sumDos; 
			for(int i=0;i<numero;i++)
			{
				sumDos=sumUno+retorno; 
				retorno=sumUno;
				sumUno=sumDos;
			}
			return retorno;  
		}
	}
	
}
