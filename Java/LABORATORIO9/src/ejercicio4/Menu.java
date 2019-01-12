package ejercicio4;
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
		double cant,filasUno=0,filasDos=0,columnasUno=0,columnasDos=0;
		//Inicio del Programa¡
		System.out.println("Programa para Multiplicar dos Matrices");
		do{
			System.out.println("\n\nMenú:\nIngrese\n1.Para Ingresar las Dos Matrices y Multiplicarlas\n2.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
					String impresion; 
					//Determinar el número de registros
					do{
						//Ingresar Ambos Datos
						for(int i=0;i<4;i++)
						{
							if(i==0)impresion="\nIngrese las Filas de la Matriz 1: "; 
							else if(i==1)impresion="\nIngrese las Columnas de la Matriz 1: "; 
							else if(i==2)impresion="\nIngrese las Filas de la Matriz 2: "; 
							else impresion="\nIngrese las Columnas de la Matriz 2: "; 
							do{
								System.out.print(impresion);
								cant=Integer.parseInt(cin.readLine());
									if(cant!=(int)cant||cant<=0)
										System.out.println("\nIngreso no válido"); 
							}while(cant!=(int)cant||cant<=0);
							if(i==0)filasUno=cant;
							else if(i==1)columnasUno=cant;
							else if(i==2)filasDos=cant; 
							else columnasDos=cant;
						}
						if(columnasUno!=filasDos)
							System.out.println("\nDimensiones no Válidas"); 
					}while(columnasUno!=filasDos);
					
					//Creacion de Matrices
					Matriz matUno=new Matriz((int)filasUno,(int)columnasUno);
					Matriz matDos=new Matriz((int)filasDos,(int)columnasDos);
					
					//Llenado de Matrices
					double[][] matrizUno=new double[(int)filasUno][(int)columnasUno];
					double[][] matrizDos=new double[(int)filasDos][(int)columnasDos];
					System.out.println("LLenado de Matriz Uno\n");
					for(int i=0;i<filasUno;i++)
					{
						for(int j=0;j<columnasUno;j++)
						{
							System.out.print("["+(i+1)+"]"+"["+(j+1)+"]: ");
							matrizUno[i][j]=Double.parseDouble(cin.readLine()); 
						}
					}
					System.out.println("\nLLenado de Matriz Dos\n");
					for(int i=0;i<filasDos;i++)
					{
						for(int j=0;j<columnasDos;j++)
						{
							System.out.print("["+(i+1)+"]"+"["+(j+1)+"]: ");
							matrizDos[i][j]=Double.parseDouble(cin.readLine()); 
						}
					}
					matUno.setMatriz(matrizUno);
					matDos.setMatriz(matrizDos);
					
					//Multiplicar la Matriz
					double[][] Resultado=new double[(int)filasUno][(int)columnasDos];
					Resultado=matUno.multiplicarMatrices((int)filasUno,(int)columnasDos,matDos.getMatriz(),(int)filasDos);
					
					//Visualizar la Matriz
					System.out.println("Matriz Resultante\n");
					for(int i=0;i<filasUno;i++)
					{
						System.out.print("\n");
						for(int j=0;j<columnasDos;j++)
						{
							 System.out.printf("%5.1f", Resultado[i][j]);
						}
					}
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