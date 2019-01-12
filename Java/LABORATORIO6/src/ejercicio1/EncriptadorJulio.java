/*
 * PROGRAMA PARA CODIFICAR UNA PALABRA A JULIO CESAR
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 08/09/2017
*/
package ejercicio1;
//Inclusion de recursos 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class EncriptadorJulio
{
		//Clase main
		public static void main(String arg[]) throws IOException
		{
			//declaracion de variable de ingreso
			BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
			//declaracion de variables de uso
			int opc=0;
			double corrimiento;
			String ingreso; 
			//declaracion del objeto
			Palabra pal=new Palabra();
			System.out.println("Programa para Encriptar una palabra usando el metodo julio Cesar");
			do{
				do{
					System.out.print("\nIngrese La palabra: "); 
					ingreso=cin.readLine();
					if(pal.validarPalabra(ingreso))
						System.out.println("Ingreso no Válido");
				}while(pal.validarPalabra(ingreso));
				do{
					System.out.print("\nIngrese el Corrimiento: "); 
                	corrimiento=Double.parseDouble(cin.readLine());
                	if(corrimiento<0||corrimiento!=(int)(corrimiento))
                		System.out.println("Valor no Válido");
				}while(corrimiento<0||corrimiento!=(int)(corrimiento));
				pal.setCorrimiento((int)corrimiento);
				pal.setPalabra(ingreso);
				System.out.println("\nLa palabra Ingresada es: "+pal.getPalabra()+"\nLa Palabra encriptada es: "+pal.encriptarPalabra(pal.getPalabra(),pal.getCorrimiento()));
				System.out.print("\n\nPresione 1. Para Hacer otro Registro\nOtro Valor para salir");
				opc=Integer.parseInt(cin.readLine());
			}while(opc==1); 
			System.out.print("\nPrograma Finalizado"); 
		}
}
		

