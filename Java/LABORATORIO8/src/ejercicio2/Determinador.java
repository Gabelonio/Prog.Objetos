/*
 * PROGRAMA PARA DETERMINAR UNA PALABRA PALINDROMA O CAPÍCUA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio2;
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
			Palabra pal=new Palabra(); 
			System.out.println("Programa para Determinar una Palabra Palindorma o Capícua");
			do{
				System.out.println("\n\nMenú:\nIngrese\n1.Para Ingresar la Palabra\n2.Para Salir");
				opc=Integer.parseInt(cin.readLine());
				switch(opc)
				{
					case 1:{
						boolean validar=false; 
						do{
							validar=false;
							System.out.print("Ingrese la Palabra: ");
							ingreso=cin.readLine();
							for(int i=0;i<ingreso.length();i++)
								if(ingreso.charAt(i)==' ')
								{
									validar=true;
									break;
								}
							if(validar)
								System.out.println("\nIngreso no válido"); 
						}while(validar);
						pal.setPalabra(ingreso);
						if(pal.determinarCapicuo(pal.getPalabra()))
							System.out.println("\n"+pal.getPalabra()+" Es un Palindromo"); 
						else
							System.out.println("\n"+pal.getPalabra()+" No es un Palindromo");
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
