/*
 * PROGRAMA PARA ADMINISTRAR LOS PRODUCTOS DE UNA EMPRESA ALIMENTARIA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 04/10/2017
*/
package ejercicio1;
//Inclusión de Recursos
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestHerencia
{
	//Clase main
	public static void main(String arg[]) throws IOException
	{
		//declaracion de variable de ingreso
		BufferedReader cin= new BufferedReader (new InputStreamReader(System.in));
		
		//declaracion de variables de uso
		int opc; 
		double cant,temp,tipo,dia,mes,anio; 
		String fechaCad,fechaEnv,noLote,pais,codigo;
		//Creacion de Listas
		ArrayList<ProductoFresco> prodFres=null;
		ArrayList<ProductoRefrigerado> prodRef=null;
		ArrayList<ProductoCongelado> prodCon=null;
		
		//Inicio del Programa
		System.out.println("Programa para calcular el valor a pagar a los docentes");
		do{
			System.out.println("\n\nMenú:\nSeleccione\n1.Para Ingresar los Productos \n2.Para Visualizar los Productos\n3.Para Salir");
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
					prodFres=new ArrayList<ProductoFresco>();
					prodRef=new ArrayList<ProductoRefrigerado>();
					prodCon=new ArrayList<ProductoCongelado>();
					
					for(int i=1;i<=cant;i++)
					{
						//Ingresar Fecha
						System.out.print("\nProducto No.: "+(i)+"\nIngrese la Fecha de Caducidad: ");
						do{ 
							System.out.print("\nDía: ");
							dia=Double.parseDouble(cin.readLine());
							if(dia<=0||dia!=(int)(dia)||dia>31)
	                			System.out.println("Valor no Válido");
						}while(dia<=0||dia!=(int)(dia)||dia>31);
						do{ 
							System.out.print("\nMes: ");
							mes=Double.parseDouble(cin.readLine());
							if(mes<=0||mes!=(int)(mes)||mes>12)
	                			System.out.println("Valor no Válido");
						}while(mes<=0||mes!=(int)(mes)||mes>12);
						do{ 
							System.out.print("\nAño: ");
							anio=Double.parseDouble(cin.readLine());
							if(anio<=0||anio!=(int)(anio))
	                			System.out.println("Valor no Válido");
						}while(anio<=0||anio!=(int)(anio));
						fechaCad=(int)dia+"/"+(int)mes+"/"+(int)anio;
						
						//Ingresar numero de serie
						do{ 
							System.out.print("\nIngrese numero de Serie: ");
							noLote=cin.readLine();
							if(noLote.matches("\\d+")==false)
	                			System.out.println("Valor no Válido");
						}while(noLote.matches("\\d+")==false);
						
						do{ 
							System.out.print("\nIngrese el Tipo de Producto:\n1.Para Fresco\n2.Para Refrigerado\n3.Para Congelado: ");
							tipo=Double.parseDouble(cin.readLine());
							if(tipo<=0||tipo!=(int)(tipo)||tipo>3)
	                			System.out.println("Valor no Válido");
						}while(tipo<=0||tipo!=(int)(tipo)||tipo>3);
						
						switch((int)tipo)
						{
							case 1:{
								System.out.print("\nIngrese la Fecha de Envasado: ");
								do{ 
									System.out.print("\nDía: ");
									dia=Double.parseDouble(cin.readLine());
									if(dia<=0||dia!=(int)(dia)||dia>31)
			                			System.out.println("Valor no Válido");
								}while(dia<=0||dia!=(int)(dia)||dia>31);
								do{ 
									System.out.print("\nMes: ");
									mes=Double.parseDouble(cin.readLine());
									if(mes<=0||mes!=(int)(mes)||mes>12)
			                			System.out.println("Valor no Válido");
								}while(mes<=0||mes!=(int)(mes)||mes>12);
								do{ 
									System.out.print("\nAño: ");
									anio=Double.parseDouble(cin.readLine());
									if(anio<=0||anio!=(int)(anio))
			                			System.out.println("Valor no Válido");
								}while(anio<=0||anio!=(int)(anio));
								fechaEnv=(int)dia+"/"+(int)mes+"/"+(int)anio;
								
								System.out.print("\nIngrese el Pais de Origen: ");
								pais=cin.readLine(); 
								
								prodFres.add(new ProductoFresco(fechaCad,noLote,fechaEnv,pais)); 
								break; 
							}
							case 2:{
								do{ 
									System.out.print("\nIngrese el código del Organismo de Supervisión Alimentaria: ");
									codigo=cin.readLine();
									if(codigo.matches("\\d+")==false)
			                			System.out.println("Valor no Válido");
								}while(codigo.matches("\\d+")==false);
								
								prodRef.add(new ProductoRefrigerado(fechaCad,noLote,codigo)); 
								break; 
							}
							case 3:{
								System.out.print("\nIngrese La Temperatura de Congelación Recomendada: ");
								temp=Double.parseDouble(cin.readLine());
								
								prodCon.add(new ProductoCongelado(fechaCad,noLote,temp));  
								break; 
							}	
						}
					}
					break; 
				}
				case 2:{
					if(prodFres==null)
						System.out.println("No ha Realizado Registros");
					else
					{
						System.out.println("Productos Frescos\nNo.\tF.Caducidad\tLote\tEnvasado\tPais de Origen"); 
						for(int i=0;i<prodFres.size();i++)
						{
							System.out.print(i+1);
							prodFres.get(i).imprimirProducto(prodFres.get(i));
							System.out.print("\n");
						}
						System.out.println("\n\nProductos Refrigerados\nNo.\tF.Caducidad\tLote\tCodigo"); 
						for(int i=0;i<prodRef.size();i++)
						{
							System.out.print(i+1);
							prodRef.get(i).imprimirProducto(prodRef.get(i));
							System.out.print("\n");
						}
						System.out.println("\n\nProductos Congelados\nNo.\tF.Caducidad\tLote\tTemperatura de Congelado"); 
						for(int i=0;i<prodCon.size();i++)
						{
							System.out.print(i+1);
							prodCon.get(i).imprimirProducto(prodCon.get(i));
							System.out.print("\n");
						}
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
