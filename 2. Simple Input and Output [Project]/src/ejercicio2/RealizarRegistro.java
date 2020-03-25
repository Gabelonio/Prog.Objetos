/*
 * PROGRAMA PARA REALIZAR UNA LISTA DE N PERSONAS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/09/2017
*/
package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RealizarRegistro {
			//Clase main
			public static void main(String arg[]) throws IOException
			{
				//declaracion de variable de ingreso
				BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
				//declaracion de variables de uso
				int opc=0;
				double ingresado,edad;
				String ingreso=""; 
				System.out.println("Programa para Realizar un registro de n personas");
				do{
					do{
						System.out.print("\nIngrese La cantidad de personas: "); 
	                	ingresado=Double.parseDouble(cin.readLine());
	                	if(ingresado<=0||ingresado!=(int)(ingresado))
	                		System.out.println("Valor no Válido");
					}while(ingresado<=0||ingresado!=(int)(ingresado));
					//declaracion del arreglo de objetos
					Persona[] per=new Persona[(int)ingresado];
					//Ingresar los registros
					for(int i=0;i<(int)ingresado;i++)
					{
						per[i] =new Persona();
						System.out.print("\nPersona No.: "+(i+1)+"\nIngrese el Nombre: ");
						ingreso=cin.readLine();
						per[i].setNombre(ingreso.toCharArray());
						System.out.print("\nIngrese el Apellido: ");
						ingreso=cin.readLine();
						per[i].setApellido(ingreso.toCharArray());
						System.out.print("\nIngrese la Identificación: ");
						ingreso=cin.readLine();
						per[i].setID(ingreso.toCharArray());
						do{
							System.out.print("\nIngrese la edad: "); 
							edad=Double.parseDouble(cin.readLine());
		                	if(edad<=0||edad!=(int)(edad))
		                		System.out.println("Valor no Válido");
						}while(edad<=0||edad!=(int)(edad));
						per[i].setEdad((int)edad);
					}
					//Imprimir los registros
					System.out.println("\n\tNombre\tApellido\tID\tEdad");
					for(int i=0;i<(int)ingresado;i++)
					{
						System.out.println("\n"+(i+1)+"\t"+String.copyValueOf(per[i].getNombre())+"\t"+String.copyValueOf(per[i].getApellido())+"\t\t"+String.copyValueOf(per[i].getID())+"\t"+per[i].getEdad());
					}
					System.out.println("\nIngrese 1. Para realizar otro Registro\nOtro Valor para salir");
					opc=Integer.parseInt(cin.readLine());
				}while(opc==1); 
				System.out.print("\nPrograma Finalizado");
			}
}
