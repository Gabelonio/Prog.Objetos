package ejercicio4;

public class Matriz {
	private double[][] Matriz;
	//constructor
	Matriz(int filas,int columnas)
	{
		Matriz=new double[filas][columnas]; 
	}
	public double[][] multiplicarMatrices(int filas,int columnas,double[][] multiplicador,int coincidencia)
	{
		double[][] retorno=new double[filas][columnas]; 
		for(int i=0;i<filas;i++)
		{
			for(int j=0;j<columnas;j++)
			{
				for(int k=0;k<coincidencia;k++)
				{
					retorno[i][j]+=this.Matriz[i][k]*multiplicador[k][j]; 
				}
			}
		}
		return retorno;
	}
	//Setters y Getters
	public double[][] getMatriz() {
		return Matriz;
	}
	public void setMatriz(double[][] matriz) {
		Matriz = matriz;
	}
}
