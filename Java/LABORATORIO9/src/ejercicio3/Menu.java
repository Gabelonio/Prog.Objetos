/*
 * PROGRAMA PARA DETERMINAR EL MES Y SUS DIAS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio3;
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
		//Inicio del Programa�
		System.out.println("Programa para determinar el mes y sus d�as seg�n su n�mero");
		do{
			System.out.println("\n\nMen�:\nIngrese\n1.Para Ingresar el n�mero del mes que desea averiguar\n2.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
					do{
						System.out.print("\nIngrese el n�mero del mes: ");
						cant=Integer.parseInt(cin.readLine());
							if(cant!=(int)cant||cant<=0||cant>12)
								System.out.println("\nIngreso no v�lido"); 
					}while(cant!=(int)cant||cant<=0||cant>12);
					Calendario cal=new Calendario((int)cant);
					System.out.println("Mes: "+cal.getNombreMes()+"\nD�as: "+cal.getDias());
					break;
				}
				case 2:{
					System.out.println("Programa Finalizado");
					break;
				}
				default:{
					System.out.println("Dato err�neo");
					break; 
				}
			}
		}while(opc!=2);
	}
}