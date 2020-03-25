/*
 * PROGRAMA PARA CONSULTAR LA SUCESION DE FIBONACCI
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio2;
//Inclusion de recursos 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Menu 
{
	//Clase main
	public static void main(String arg[]) throws IOException
	{
		//declaracion de variable de ingreso
		BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
		//declaracion de variables de uso
		int opc;
		double cant;
		//Creacion del Objeto
		Fibonacci fib=new Fibonacci(); 
		//Inicio del Programa¡
		System.out.println("Programa para consultar la sucesión de Fibonacci");
		do{
			System.out.println("\n\nMenú:\nSeleccione\n1.Para Consultar la sucesión \n2.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
						do{
							System.out.print("\nIngrese el último número a consultar: ");
							cant=Integer.parseInt(cin.readLine());
							if(cant!=(int)cant||cant<0)
									System.out.println("\nIngreso no válido"); 
						}while(cant!=(int)cant||cant<0);
						System.out.println("\nFibonacci por Metodo Iterativo: ");
						for(int i=0;i<=cant;i++)
						{
							System.out.print(fib.fibonacciIterativo(i)+" "); 
						}
						System.out.println("\nFibonacci por Metodo Recursivo: ");
						for(int i=0;i<=cant;i++)
						{
							System.out.print(fib.fibonacciRecursivo(i)+" "); 
						}break; 
					}
				case 2:{
						System.out.println("Programa Finalizado");
						break;
					}
				default:{
							System.out.println("Dato erróneo");
							break; 
						}
					}
			}while(opc!=2); 
		}	
}


