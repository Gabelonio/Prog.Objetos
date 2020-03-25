/*
 * PROGRAMA PARA ORGANIZAR ONCE NUMEROS ENTEROS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio3;

import java.util.ArrayList;

public class Lista
{
	//atributos
	private ArrayList<Integer> vector; 
	//Métodos
	public Lista()
	{
		vector=new ArrayList<Integer>();
	}
	//Getter y Setter
	public ArrayList<Integer> getVector() {
		return vector;
	}
	public void setVector(ArrayList<Integer> vector) {
		this.vector = vector;
	}
	//Métodos
	public void agregarNumero(int agregado)
	{
		for(int i=0;i<vector.size();i++)
		{
			if(agregado<=vector.get(i))
			{
				vector.add(i,agregado);
				return; 
			}
		}
		vector.add(agregado); 
	}
}