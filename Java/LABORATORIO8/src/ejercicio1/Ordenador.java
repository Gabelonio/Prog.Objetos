/*
 * PROGRAMA PARA ORGANIZAR SIETE NUMEROS ENTEROS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio1;
//Inclusion de recursos 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Ordenador 
{
	//Clase main
	public static void main(String arg[]) throws IOException
	{
		//declaracion de variable de ingreso
		BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
		//declaracion de variables de uso
		int opc;
		double numero; 
		//Creación del objeto 
		Lista list=new Lista(); 
		System.out.println("Programa para ordenar siete numeros enteros");
		do{
			System.out.println("\n\nMenú:\nIngrese\n1.Para Agregar números al Vector\n2.Para Ver el Vector\n3. Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
					//Realizar el ciclo cuantas veces sea necesario
					list.getVector().clear();
					for(int i=0;i<7;i++)
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
					break; 
				}
				case 2:{
					ArrayList<Integer> impresion=list.getVector(); 
					//Verificar el llenado del arreglo
					if(impresion.isEmpty())
						System.out.println("No ha Ingresado Números"); 
					else
					{
						System.out.println("\nLista Ascendente\n");
						for(int i=0;i<impresion.size();i++)
							System.out.print(impresion.get(i)+"  ");
						System.out.println("\nLista Descendente\n");
						for(int i=impresion.size()-1;i>=0;i--)
							System.out.print(impresion.get(i)+"  ");
					}
					break; 
				}
				case 3:{
					System.out.println("Programa Finalizado");
					break; 
				}
				default:{
					System.out.println("Dato erróneo");
					break; 
				}
			}
		}while(opc!=3); 
	}
}
