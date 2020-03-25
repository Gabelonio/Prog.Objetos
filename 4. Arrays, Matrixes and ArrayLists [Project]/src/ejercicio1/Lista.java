/*
 * PROGRAMA PARA DETERMINAR VALORES MAXIMOS Y MINIMOS Y SUS OCURRENCIAS
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio1;

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
				if(agregado<=vector.get(i))
				{
					vector.add(i,agregado);
					return; 
				}
			vector.add(agregado); 
		}
		public int obtenerNumeroMayor()
		{return vector.get(vector.size()-1);}
		public int obtenerNumeroMenor()
		{return vector.get(0);}
		public int determinarRepeticiones(int repeticion)
		{
			int contador=0; 
			for(int i=0;i<vector.size();i++)
				if(repeticion==vector.get(i))
					contador++;
			return contador;
		}
		
}
