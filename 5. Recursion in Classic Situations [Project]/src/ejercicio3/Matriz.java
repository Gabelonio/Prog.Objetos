/*
 * PROGRAMA PARA CALCULAR EL DETERMINANTE DE UNA MATRIZ DE ORDEN 3
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 27/09/2017
*/
package ejercicio3;

public class Matriz {
	//Atributos
	private double[][]Matriz= new double[3][3];
	//Getters y Setters
	public double[][] getMatriz() {
		return Matriz;
	}

	public void setMatriz(double[][] matriz) {
		Matriz = matriz;
	}
	//Metodos
	double calcularDeterminanteIterativo(double[][] matriz)
	{
		return ((matriz[0][0]*matriz[1][1]*matriz[2][2])+(matriz[0][1]*matriz[1][2]*matriz[2][0])+(matriz[0][2]*matriz[1][0]*matriz[2][1]))-((matriz[2][0]*matriz[1][1]*matriz[0][2])+(matriz[2][1]*matriz[1][2]*matriz[0][0])+(matriz[2][2]*matriz[1][0]*matriz[0][1]));
	}
	double calcularDeterminanteRecursivo(double[][] matriz){
		double det = 0;
		for(int i =0; i < matriz[0].length; i++)
		{
			double indice = Math.pow(-1,i) * matriz[0][i];
			double[][] subMatriz = new double[matriz[0].length- 1][matriz[0].length- 1];
			for(int j = 1; j < matriz[0].length; j++)
			{
				int m = 0;
				for(int k = 0; k < matriz[0].length; k++)
				{
					if(k != i){
						subMatriz[j-1][m] = matriz[j][k];
						m++;
					}
				}
			}
			if(2== matriz[0].length)
			{
				double detAux;detAux =(matriz[0][0]*matriz[1][1])-(matriz[0][1]*matriz[1][0]);
				return	detAux;
			}
			else
				det+= indice *calcularDeterminanteRecursivo(subMatriz);
		}
		return det;
	}
}
