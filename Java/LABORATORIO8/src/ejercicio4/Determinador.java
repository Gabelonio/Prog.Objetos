/*
 * PROGRAMA PARA DETERMINAR UNA FRASE PALINDROMA O CAPÍCUA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio4;
//Inclusion de recursos 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Determinador
{
	//Clase main
		public static void main(String arg[]) throws IOException
		{
			//declaracion de variable de ingreso
			BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
			//declaracion de variables de uso
			int opc;
			String ingreso;
			//Creación del objeto
			Oracion orac=new Oracion(); 
			System.out.println("Programa para Determinar una Palabra Palindorma o Capícua");
			do{
				System.out.println("\n\nMenú:\nIngrese\n1.Para Ingresar la Oración\n2.Para Salir");
				opc=Integer.parseInt(cin.readLine());
				switch(opc)
				{
					case 1:{
						System.out.print("Ingrese la Palabra: ");
						ingreso=cin.readLine();
						orac.setOracion(ingreso);
						//quita los espacios de la cadena de Caracteres
						if(orac.determinarCapicuo(orac.getOracion().replaceAll(" ","")))
							System.out.println("\n"+orac.getOracion()+" Es un Palindromo"); 
						else
							System.out.println("\n"+orac.getOracion()+" No es un Palindromo");
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
