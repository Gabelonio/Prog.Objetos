/*
 * PROGRAMA PARA DETERMINAR LOS DATOS DE TRES ESTUDIANTES
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio2;
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
		double notaUno,notaDos,examen;
		String nombre,apellido;
		//Crecaión del arreglo de objetos
		Estudiante[] estudiantes=null;
		//Inicio del Programa¡
		System.out.println("Programa para Registrar 3 Alumnos y realizar un promedio entre ellos");
		do{
			System.out.println("\n\nMenú:\nIngrese\n1.Para Registrar a los 3 Alumnos\n2.Para Visualizar los Registros\n3.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
					estudiantes=new Estudiante[3];
					for(int i=0;i<3;i++)
					{
						System.out.print("\nPersona No.: "+(i+1)+"\nIngrese el Nombre: ");
						nombre=cin.readLine();
						System.out.print("\nIngrese el Apellido: ");
						apellido=cin.readLine();
						do{
							System.out.print("\nIngrese la Nota 1: "); 
							notaUno=Double.parseDouble(cin.readLine());
		                	if(notaUno<0||notaUno>5)
		                		System.out.println("Valor no Válido");
						}while(notaUno<0||notaUno>5);
						do{
							System.out.print("\nIngrese la Nota 2: "); 
							notaDos=Double.parseDouble(cin.readLine());
		                	if(notaDos<0||notaDos>5)
		                		System.out.println("Valor no Válido");
						}while(notaDos<0||notaDos>5);
						do{
							System.out.print("\nIngrese la Nota del Examen: "); 
							examen=Double.parseDouble(cin.readLine());
		                	if(examen<0||examen>5)
		                		System.out.println("Valor no Válido");
						}while(examen<0||examen>5);
						estudiantes[i]=new Estudiante(nombre,apellido,notaUno,notaDos,examen);
					}		
					break;
				}
				case 2:{
					if(estudiantes!=null)
					{
						double sumatoria=0; 
						//Imprimir los registros
						System.out.println("\n\tNombre\tApellido\tNota 1\tNota 2\tNota Final\tPromedio");
						for(int i=0;i<3;i++)
						{
							System.out.println("\n"+(i+1)+"\t"+estudiantes[i].getNombre()+"\t"+estudiantes[i].getApellido()+"\t\t"+estudiantes[i].getNotaUno()+"\t"+estudiantes[i].getNotaDos()+"\t"+estudiantes[i].getExamen()+"\t      "+estudiantes[i].getPromedio());
							sumatoria+=estudiantes[i].getPromedio(); 
						}
						System.out.println("\nPromedio del Grupo: "+sumatoria/3); 
						
					}			
					else
						System.out.println("Usted no ha Ingresado los Registros");
					break;
				}
				case 3:{
					System.out.println("Programa Finalizado");
					break;
				}
				default:{
					System.out.println("Dato erróneo");
					break;
				}
			}
		}while(opc!=3); 
	}
}
