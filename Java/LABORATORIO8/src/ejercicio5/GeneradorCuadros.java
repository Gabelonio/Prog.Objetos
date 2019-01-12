/*
 * PROGRAMA PARA GENERAR CUADROS M�GICOS DE 3X3 O 4X4
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio5;
//Inclusion de recursos 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GeneradorCuadros 
{
		//Clase main
		public static void main(String arg[]) throws IOException
		{
			//declaracion de variable de ingreso
			BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
			//declaracion de variables de uso
			int opc;
			//Creaci�n del objeto
			Cuadro magico; 
			System.out.println("Programa para Generar Cuadros de 3x3 y 4x4");
			do{
				System.out.println("\n\nMen�:\nIngrese\n1.Para Generar un Cuadro de 3x3\n2.Para Generar un Cuadro de 4x4\n3.Para Salir");
				opc=Integer.parseInt(cin.readLine());
				switch(opc)
				{
					case 1:
					case 2:{
						if(opc==1)
						{
							magico=new Cuadro(3);
							//genera el cuadro
							magico.GenerarTres();
						}	
						else
						{
							magico=new Cuadro(4);
							//genera el cuadro
							magico.GenerarCuatro();
						}
						//Imprime la matriz
						int[][] impresion=magico.getMatriz(); 
						for(int i=0;i<opc+2;i++)
						{
							System.out.print("\n");
							for(int j=0;j<opc+2;j++)
								System.out.printf("%3d ",impresion[i][j]);
						}
						break; 
					}
					case 3:{
						System.out.println("Programa Finalizado");
						break; 
					}
					default:{
						System.out.println("Dato err�neo");
						break; 
					}
				}
			}while(opc!=3);
		}
}
