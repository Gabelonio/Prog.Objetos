/*
 * PROGRAMA PARA GENERAR CUADROS MÁGICOS DE 3X3 O 4X4
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 15/09/2017
*/
package ejercicio5;
import java.util.Random;
public class Cuadro 
{
	//atributos
	private int[][] matriz;
	//metodos
	Cuadro(int ingreso)
	{
		matriz=new int[ingreso][ingreso]; 
	}
	public int[][] getMatriz() {
		return matriz;
	}
	//Generador el cuadro
	public void GenerarTres()
	{
		Random rand=new Random(); 
		matriz[1][1]=5;
		while(true)
		{
			matriz[0][0]=1+rand.nextInt(9);
			if(matriz[0][0]%2==0)
			break;  
		}
		//se llena la matriz a partir del numero aleatorio de la esquina
		matriz[2][2]=10-matriz[0][0]; 
		while(true)
		{
			matriz[0][2]=1+rand.nextInt(9);
			if((matriz[0][2]%2==0)&&(matriz[0][2]!=matriz[0][0])&&(matriz[0][2]!=matriz[2][2]))
			break;
		}
		matriz[2][0]=10-matriz[0][2];
		matriz[0][1]=15-matriz[0][0]-matriz[0][2];
		matriz[2][1]=15-matriz[2][0]-matriz[2][2];
		matriz[1][0]=15-matriz[0][0]-matriz[2][0];
		matriz[1][2]=15-matriz[0][2]-matriz[2][2];
	}
	public void GenerarCuatro()
	{
		Random rand=new Random();
		int[][] ESQUINA ={{4,9,13,8},{1,12,15,6},{1,8,14,11},{2,7,11,14},{1,4,15,14},{4,7,9,14},{2,5,15,12},{3,6,13,12},{3,6,13,12	}};
		int[][] CENTRO={{15,10,2,7},{14,3,4,13},{7,2,10,15},{15,10,6,3},{10,7,8,9},{15,12,6,1},{7,4,10,13},{14,11,4,5},{10,7,8,9	}};
		int numeroUno=rand.nextInt(9),numeroDos=rand.nextInt(4); 
		//inicializar matriz
		this.inicializarMatriz(matriz); 
		//generar esquinas y centro
		this.generarNumero(numeroUno,numeroDos,matriz,ESQUINA,CENTRO); 
		//generar contenido
		while(true)
		{
			//generar centro
			inicializarMatriz(matriz);
			while(true)
			{
				inicializarMatriz(matriz);
				matriz[0][1]=generarNumero(matriz);
				matriz[0][2]=generarNumero(matriz);
				matriz[3][1]=generarNumero(matriz);
				matriz[3][2]=generarNumero(matriz);	
				if(((matriz[0][0]+matriz[0][1]+matriz[0][2]+matriz[0][3])==34)&&((matriz[0][1]+matriz[1][1]+matriz[2][1]+matriz[3][1])==34)&&((matriz[0][2]+matriz[1][2]+matriz[2][2]+matriz[3][2])==34)&&((matriz[3][0]+matriz[3][1]+matriz[3][2]+matriz[3][3])==34))
					break;
			}
			matriz[1][0]=generarNumero(matriz);
			matriz[2][0]=generarNumero(matriz);
			matriz[1][3]=generarNumero(matriz);
			matriz[2][3]=generarNumero(matriz);
			if(this.verificarSuma(matriz))
				break;
		}
	}
	private boolean verificarSuma(int arreglo[][])
	{
		int sumauno,sumados;
		for(int i=0;i<4;i++)
		{
			sumauno=0;
			sumados=0; 
			for(int j=0;j<4;j++)
			{
				sumauno+=arreglo[i][j];
				sumados+=arreglo[j][i];
			}
			if(sumauno!=34||sumados!=34)
			{
				return false; 
			}
		}
		return true;
	}	
	private void generarNumero(int numuno,int numdos,int matriz[][], int ESQUINA[][], int CENTRO[][])
	{
		switch(numdos)
		{
			case 0:{
					matriz[0][0]=ESQUINA[numuno][0]; 
					matriz[0][3]=ESQUINA[numuno][1];
					matriz[3][0]=ESQUINA[numuno][2];
					matriz[3][3]=ESQUINA[numuno][3];
					matriz[1][1]=CENTRO[numuno][0];
					matriz[1][2]=CENTRO[numuno][1];
					matriz[2][1]=CENTRO[numuno][2];
					matriz[2][2]=CENTRO[numuno][3];
					break;
			}
			case 1:{
					matriz[0][0]=ESQUINA[numuno][2]; 
					matriz[0][3]=ESQUINA[numuno][0];
					matriz[3][0]=ESQUINA[numuno][3];
					matriz[3][3]=ESQUINA[numuno][1];
					matriz[1][1]=CENTRO[numuno][2];
					matriz[1][2]=CENTRO[numuno][0];
					matriz[2][1]=CENTRO[numuno][3];
					matriz[2][2]=CENTRO[numuno][1];
					break;
			}
			case 2:{
					matriz[0][0]=ESQUINA[numuno][3]; 
					matriz[0][3]=ESQUINA[numuno][2];
					matriz[3][0]=ESQUINA[numuno][1];
					matriz[3][3]=ESQUINA[numuno][0];
					matriz[1][1]=CENTRO[numuno][3];
					matriz[1][2]=CENTRO[numuno][2];
					matriz[2][1]=CENTRO[numuno][1];
					matriz[2][2]=CENTRO[numuno][0];
					break;
			}
			case 3:{
					matriz[0][0]=ESQUINA[numuno][1]; 
					matriz[0][3]=ESQUINA[numuno][3];
					matriz[3][0]=ESQUINA[numuno][0];
					matriz[3][3]=ESQUINA[numuno][2];
					matriz[1][1]=CENTRO[numuno][1];
					matriz[1][2]=CENTRO[numuno][3];
					matriz[2][1]=CENTRO[numuno][0];
					matriz[2][2]=CENTRO[numuno][2];
					break;
			}
		}
	}
	private int generarNumero(int arreglo[][])
	{
		Random rand=new Random();
		int numero;	
		while(true)
		{	
			numero=1+rand.nextInt(16);
			if(verificarRepeticion(numero,arreglo)	)
				break;
		}
		return numero;
	}
	private boolean verificarRepeticion(int numero,int arreglo[][])
	{
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				if(arreglo[i][j]==numero)
					return false;
		return true; 
	}
	private void inicializarMatriz(int matriz[][])
	{
		matriz[0][1]=0;
		matriz[0][2]=0;
		matriz[1][0]=0;
		matriz[2][0]=0;
		matriz[1][3]=0;
		matriz[2][3]=0;
		matriz[3][1]=0;
		matriz[3][2]=0;
	}
}
