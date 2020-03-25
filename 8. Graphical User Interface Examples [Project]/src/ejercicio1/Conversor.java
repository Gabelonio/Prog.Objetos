/*
 * PROGRAMA PARA CONVERTIR DISTINTOS VALORES DE MONEDA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 18/10/2017
*/
package ejercicio1;

public class Conversor {
	//Atributos
	private double entrada;
	//Metodos
	Conversor(double entrada)
	{
		this.entrada=entrada;
	}
	public double convertirMonedas(int entrada,int salida)
	{
		entrada++;
		salida++;
		if(entrada==salida)
			return this.entrada;
		else
			switch(entrada)
			{
				case 1:{
					if(salida==2)
						return this.entrada*0.000288008156; 
					else
						return this.entrada*0.000339;
				}
				case 2:{
					if(salida==1)
						return this.entrada*3472.12389;
					else
						return this.entrada*1.17705;
				}
				case 3:{
					if(salida==1)
						return this.entrada*2949.85251;
					else
						return this.entrada*0.849581581;
				}
			}
		return 0;
	}
		
}
