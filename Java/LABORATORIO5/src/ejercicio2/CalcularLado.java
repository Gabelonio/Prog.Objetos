/*
 * PROGRAMA PARA OBTENER EL LADO RESTANTE
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 01/09/2017
*/
package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcularLado {

	//Clase main
	public static void main(String arg[]) throws IOException
	{
		//declaracion de variable de ingreso
		BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
		//declaracion de variables de uso
		double ingreso; 
		int opc=0;
		//creacion del objeto
		Triangulo tri=new Triangulo(); 
		System.out.println("Programa para Calcular el lado restante de un triángulo");
		//validar los lados y el angulo 
		do{
			do{
				System.out.print("\nIngrese el Lado A: "); 
				ingreso=Double.parseDouble(cin.readLine());
				if(ingreso<=0)
					System.out.println("Valor no Válido");
			}while(ingreso<=0);
			tri.setLadoA(ingreso);
			do{
				System.out.print("\nIngrese el Lado B: "); 
				ingreso=Double.parseDouble(cin.readLine());
				if(ingreso<=0)
					System.out.println("Valor no Válido");
			}while(ingreso<=0);
			tri.setLadoB(ingreso);
			do{
				System.out.print("\nIngrese el Ángulo: "); 
				ingreso=Double.parseDouble(cin.readLine());
				if(ingreso>180||ingreso<=0)
					System.out.println("Valor no Válido");
			}while(ingreso>180||ingreso<=0);
			tri.setAngulo(ingreso);
			tri.setLadoC();
			System.out.println("El lado restante es:"+tri.getLadoC()+"\n\nIngrese 1. Para realizar otro Calculo\nOtro Valor para salir");
			opc=Integer.parseInt(cin.readLine()); 
		}while(opc==1);
		System.out.println("Programa Finalizado");
	}
}
