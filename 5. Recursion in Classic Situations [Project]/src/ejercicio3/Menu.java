/*
 * PROGRAMA PARA CALCULAR EL DETERMINANTE DE UNA MATRIZ DE ORDEN 3
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
		//Creacion del Objeto
		Matriz mat=new Matriz();
		//Inicio del Programa¡
		System.out.println("Programa para calcular el determinante de un arreglo 3x3");
		do{
			System.out.println("\n\nMenú:\nSeleccione\n1.Para Realizar el calculo \n2.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
							double[][] matriz=new double[3][3];
							System.out.println("LLenado de Matriz Uno\n");
							for(int i=0;i<3;i++)
							{
								for(int j=0;j<3;j++)
								{
									System.out.print("["+(i+1)+"]"+"["+(j+1)+"]: ");
									matriz[i][j]=Double.parseDouble(cin.readLine()); 
								}
							}
							mat.setMatriz(matriz);
							System.out.print("\nDeterminante por Metodo Iterativo: "+mat.calcularDeterminanteIterativo(mat.getMatriz()));
							System.out.print("\nDeterminante por Metodo Recursivo: "+mat.calcularDeterminanteRecursivo(mat.getMatriz()));
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