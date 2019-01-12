/*
 * PROGRAMA PARA CALCULAR EL FACTORIAL DE UN NUMERO
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio1;
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
		Factorial fac=new Factorial(); 
		//Inicio del Programa¡
		System.out.println("Programa para calcular el factorial de un número");
		do{
			System.out.println("\n\nMenú:\nSeleccione\n1.Para Calcular el Factorial \n2.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
					do{
						System.out.print("\nIngrese el Número: ");
						cant=Integer.parseInt(cin.readLine());
							if(cant!=(int)cant||cant<0)
								System.out.println("\nIngreso no válido"); 
					}while(cant!=(int)cant||cant<0);
					fac.setNumero((int)cant);
					System.out.print("\nFactorial por Metodo Iterativo: "+fac.calcularFactorialIterativo());
					System.out.print("\nFactorial por Metodo Recursivo: "+fac.calcularFactorialRecursivo(fac.getNumero()));
					break; 
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
