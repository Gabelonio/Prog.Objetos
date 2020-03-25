/*
 * PROGRAMA PARA OBTENER EL VOLUMEN Y LA SUPERFICIE DE UNA ESFERA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 01/09/2017
*/
package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcularEsfera {

	public static void main(String arg[]) throws IOException
	{
		//declaracion de variable de ingreso
		BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
		//declaracion de variables de uso
		double ingreso; 
		int opc=0;
		Esfera es=new Esfera();
		System.out.println("Programa para Calcular el volumen y la superficie de una esfera");
		//validar los lados y el angulo 
		do{
			do{
				System.out.print("\nIngrese el Radio: "); 
				ingreso=Double.parseDouble(cin.readLine());
				if(ingreso<=0)
					System.out.println("Valor no Válido");
			}while(ingreso<=0);
			//creacion del objeto
			if(ingreso==1)
				es=new Esfera();
			else 
				es=new Esfera(ingreso); 
			es.imprimirInformacion();
			System.out.println("\n\nIngrese 1. Para realizar otro Calculo\nOtro Valor para salir");
			opc=Integer.parseInt(cin.readLine()); 
		}while(opc==1); 	
		System.out.println("Programa Finalizado");
	}
}
