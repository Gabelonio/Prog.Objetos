/*
 * PROGRAMA PARA DETERMINAR VALORES MAXIMOS Y MINIMOS Y SUS OCURRENCIAS
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
		double cant,numero;
		
		//Inicio del Programa¡
		System.out.println("Programa para determinar el numero mayor y menor de un vector y sus ocurrencias");
		do{
			System.out.println("\n\nMenú:\nIngrese\n1.Para Agregar números al Vector y realizar los calculos\n2.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
					//creación del objeto
					Lista list=new Lista(); 
					//Determinar el número de registros
					do{
						System.out.print("\nIngrese el tamaño del vector: ");
						cant=Integer.parseInt(cin.readLine());
							if(cant!=(int)cant||cant<=0)
								System.out.println("\nIngreso no válido"); 
					}while(cant!=(int)cant||cant<=0);
					//Llenado del vector
					for(int i=0;i<cant;i++)
					{
						do{
							System.out.print("Número No "+(i+1)+": ");
							numero=Double.parseDouble(cin.readLine());
							if(numero!=(int)numero)
								System.out.println("\nIngreso no válido"); 
						}while(numero!=(int)numero);
						//agrega un nuevo numero al arreglo
						list.agregarNumero((int)numero);
					}
					System.out.println("Número Mayor: "+list.obtenerNumeroMayor()+"\tRepeticiones: "+list.determinarRepeticiones(list.obtenerNumeroMayor()));
					System.out.println("Número Menor: "+list.obtenerNumeroMenor()+"\tRepeticiones: "+list.determinarRepeticiones(list.obtenerNumeroMenor()));
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