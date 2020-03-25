/*
 * PROGRAMA PARA ORGANIZAR ONCE NUMEROS ENTEROS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio3;
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
		System.out.println("Programa para ordenar diez y once números enteros");
		do{
			System.out.println("\n\nMenú:\nIngrese\n1.Para Agregar 10 números al Vector\n2.Para Agregar 1 número al Vector\n3. Para ver el vector\n4.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:
				case 2:{
					int ciclo=(opc==1)?10:1;
					//Realizar el ciclo cuantas veces sea necesario
					if(list.getVector().isEmpty()&&opc==2)
					{
						System.out.println("\nNo ha Ingresado los 10 primeros números"); 
					}
					else if(list.getVector().size()==11)
					{
						System.out.println("\nLos 11 Números ya estan ingresados"); 
					}
					else
					{
						if(opc==1)
							list.getVector().clear();
						for(int i=0;i<ciclo;i++)
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
					}
					break; 
				}
				case 3:{
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
				case 4:{
					System.out.println("Programa Finalizado");
					break; 
				}
				default:{
					System.out.println("Dato erróneo");
					break; 
				}
			}
		}while(opc!=4); 
	}
}
