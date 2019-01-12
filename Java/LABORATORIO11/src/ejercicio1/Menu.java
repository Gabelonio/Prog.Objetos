/*
 * PROGRAMA PARA CALCULAR CALCULAR EL VALOR A PAGAR A N PROFESORES
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio1;
//Inclusion de recursos 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu 
{
	//Clase main
	public static void main(String arg[]) throws IOException
	{
		//declaracion de variable de ingreso
		BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
		
		//declaracion de variables de uso
		int opc; 
		double cant,nivel,contratacion,horas;
		String nombre,apellido;
		//Creacion de Listas
		ArrayList<DocentePlanta> docPlanta=null;
		ArrayList<DocenteVinculacion> docVin=null;
		ArrayList<DocenteCatedra> docCat=null;
		
		//Inicio del Programa
		System.out.println("Programa para calcular el valor a pagar a los docentes");
		do{
			System.out.println("\n\nMenú:\nSeleccione\n1.Para Ingresar los Docentes \n2.Para Visualizar los Docentes y los Sueldos a Pagar\n3.Para Salir");
			opc=Integer.parseInt(cin.readLine());
			switch(opc)
			{
				case 1:{
					do{
						System.out.print("\nIngrese el Número de Registros a Realizar: ");
						cant=Integer.parseInt(cin.readLine());
							if(cant!=(int)cant||cant<=0)
								System.out.println("\nIngreso no válido"); 
					}while(cant!=(int)cant||cant<=0);
					
					//Creacion de las listas de maestros
					docPlanta=new ArrayList<DocentePlanta>();
					docVin=new ArrayList<DocenteVinculacion>();
					docCat=new ArrayList<DocenteCatedra>();
					
					for(int i=1;i<=cant;i++)
					{
						System.out.print("\nDocente No.: "+(i)+"\nIngrese el Nombre: ");
						nombre=cin.readLine();
						System.out.print("\nIngrese el Apellido: ");
						apellido=cin.readLine();
						do{ 
							System.out.print("\nIngrese el Nivel de Estudios:\n1.Para Doctorado\n2.Para Maestría\n3.Para Especialización\n4.Si no cuenta con Postgrado: ");
							nivel=Double.parseDouble(cin.readLine());
							if(nivel<=0||nivel!=(int)(nivel)||nivel>4)
	                			System.out.println("Valor no Válido");
						}while(nivel<=0||nivel!=(int)(nivel)||nivel>4);
						do{ 
							System.out.print("\nIngrese el Tipo de Contratación:\n1.Para Planta\n2.Para Vinculación\n3.Para Catedrático: ");
							contratacion=Double.parseDouble(cin.readLine());
							if(contratacion<=0||contratacion!=(int)(contratacion)||contratacion>3)
	                			System.out.println("Valor no Válido");
						}while(contratacion<=0||contratacion!=(int)(contratacion)||contratacion>3);
						switch((int)contratacion)
						{
							case 1:{
								docPlanta.add(new DocentePlanta(nombre,apellido,(int)nivel)); 
								break; 
							}
							case 2:{
								docVin.add(new DocenteVinculacion(nombre,apellido,(int)nivel)); 
								break; 
							}
							case 3:{
								do{ 
									System.out.print("\nIngrese La Cantidad de Horas Trabajadas por Mes: ");
									horas=Double.parseDouble(cin.readLine());
									if(horas<=0||horas!=(int)(horas))
			                			System.out.println("Valor no Válido");
								}while(horas<=0||horas!=(int)(horas));
								docCat.add(new DocenteCatedra(nombre,apellido,(int)nivel,horas)); 
								break; 
							}	
						}
					}
					break; 
				}
				case 2:{
					if(docPlanta==null)
						System.out.println("No ha Realizado Registros");
					else
					{
						//Impresion de todos los registros
						double sueldosPlanta=0,sueldosVin=0,sueldosCat=0;
						System.out.println("Maestros de Planta\nNo.\tNombre\tApellido\tEstudios\tSueldo"); 
						for(int i=0;i<docPlanta.size();i++)
						{
							System.out.print(i+1);
							docPlanta.get(i).imprimirMaestro(docPlanta.get(i));
							sueldosPlanta+=docPlanta.get(i).getSueldo(); 
						}
						System.out.println("\n\nMaestros de Vinculación\nNo.\tNombre\tApellido\tEstudios\tSueldo"); 
						for(int i=0;i<docVin.size();i++)
						{
							System.out.print(i+1);
							docVin.get(i).imprimirMaestro(docVin.get(i));
							sueldosVin+=docVin.get(i).getSueldo(); 
						}
						System.out.println("\n\nMaestros de Catedra\nNo.\tNombre\tApellido\tEstudios\tSueldo"); 
						for(int i=0;i<docCat.size();i++)
						{
							System.out.print(i+1);
							docCat.get(i).imprimirMaestro(docCat.get(i));
							sueldosCat+=docCat.get(i).getSueldo(); 
						}
						System.out.println("\nSueldos Planta: "+sueldosPlanta+"\nSueldos Vinculación: "+sueldosVin+"\nSueldos Catedráticos: "+sueldosCat+"\nTotal: "+((int)sueldosPlanta+sueldosVin+sueldosCat)); 
					}
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
