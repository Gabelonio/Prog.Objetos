/*
 * PROGRAMA PARA CALCULAR EL MCM Y EL MCD DE 7 NUMEROS 
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 10/11/2017
*/
package ejercicio3;

import java.util.ArrayList;

public class Calculador 
{
	private ArrayList<Integer> numeros; 
	//Constructor
	Calculador()
	{
		numeros=new ArrayList<Integer>();	
	}
	//Getter
	public ArrayList<Integer> getNumeros() {
		return numeros;
	}
	//Metodos
	public void agregarNumero(int agregado)
	{
		for(int i=0;i<this.numeros.size();i++)
			if(agregado<=numeros.get(i))
			{
				this.numeros.add(i,agregado);
				return; 
			}
		this.numeros.add(agregado); 
	}
	public int obtenerNumeroMayor()
	{return this.numeros.get(this.numeros.size()-1);}
	public int obtenerNumeroMenor()
	{return this.numeros.get(0);}
	public int determinarMCM()
	{
		ArrayList<Integer> numeros=new ArrayList<Integer>();
		numeros.addAll(this.numeros);
		int retorno=1; 
		for(int i=2;i<=this.obtenerNumeroMayor();i++)
			while(esDivisible(numeros,i))
			{
				retorno*=i;
			}	
		return retorno;
	}
	public boolean esDivisible(ArrayList<Integer> numeros,int numero)
	{
		boolean divisible=false;
		for(int j=0;j<7;j++)
		{
			if((numeros.get(j)%numero)==0)
			{
				divisible = true;
				numeros.set(j,(numeros.get(j)/numero));
			}
		}
		return divisible;
	}
	public int determinarMCD()
	{
		ArrayList<Integer> numeros=new ArrayList<Integer>();;
		numeros.addAll(this.numeros); 
		int retorno=0,residuo;
		for (int i=0;i<7;i++)
		{
			if (i==0) 
				retorno = numeros.get(i);
			else 
			{
				do{
					residuo=retorno%numeros.get(i);
					if (residuo!=0) 
					{
						retorno=numeros.get(i);
						numeros.set(i,residuo);	
					}			
					else 
					{
						retorno=numeros.get(i);
					}
				}while(residuo!=0);
			}
		}
		return retorno;
	}
}
