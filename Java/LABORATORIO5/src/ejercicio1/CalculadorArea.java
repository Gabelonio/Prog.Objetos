/*
 * PROGRAMA PARA OBTENER EL AREA A PARTIR DE SEMIPERIMETRO
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 01/09/2017
*/
package ejercicio1;
//Inclusion de recursos 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CalculadorArea 
{
		//Clase main
		public static void main(String arg[]) throws IOException
		{
			//declaracion de variable de ingreso
			BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
			//declaracion de variables de uso
			double ingreso; 
			int opc=0;
			//creacion del objeto
			Triangulo tri=new Triangulo(); 
			System.out.println("Programa para Calcular el área de un triángulo");
			do{
			do{
				//validar los lados
				do{
					System.out.print("\nIngrese el Lado A: "); 
					ingreso=Double.parseDouble(cin.readLine());
					if(ingreso<=0)
						System.out.println("Valor no Válido");
				}while(ingreso<=0);
				tri.setLadoA(ingreso);
				do{
					System.out.print("\nIngrese el Lado B: "); 
                	ingreso=Double.parseDouble(cin.readLine());
                	if(ingreso<=0)
                		System.out.println("Valor no Válido");
				}while(ingreso<=0);
				tri.setLadoB(ingreso);
				do{
					System.out.print("\nIngrese el Lado C: "); 
					ingreso=Double.parseDouble(cin.readLine());
					if(ingreso<=0)
						System.out.println("Valor no Válido");
				}while(ingreso<=0);
				tri.setLadoC(ingreso);
				if(tri.getLadoA()+tri.getLadoB()<tri.getLadoC()||tri.getLadoA()+tri.getLadoC()<tri.getLadoB()||tri.getLadoB()+tri.getLadoC()<tri.getLadoA())
					System.out.println("Planteamiento inconsistente");
				}while(tri.getLadoA()+tri.getLadoB()<tri.getLadoC()||tri.getLadoA()+tri.getLadoC()<tri.getLadoB()||tri.getLadoB()+tri.getLadoC()<tri.getLadoA());
				//calcular area a partir de semiperimetros
				tri.setSemiperimetro();
				System.out.println("\n\nEl área es: "+Math.sqrt(tri.getSemiperimetro()*(tri.getSemiperimetro()-tri.getLadoA())*(tri.getSemiperimetro()-tri.getLadoB())*(tri.getSemiperimetro()-tri.getLadoC()))+" Unidades Cuadradas");
				System.out.println("\nIngrese 1. Para realizar otro Calculo\nOtro Valor para salir");
				opc=Integer.parseInt(cin.readLine()); 
			}while(opc==1); 
			System.out.println("Programa Finalizado");
		}
}
