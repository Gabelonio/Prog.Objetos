/*
 * PROGRAMA PARA ADMINISTRAR LAS CONSULTAS DE UNA BOUTIQUE
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 10/11/2017
*/
package ejercicio2;
import java.util.ArrayList;

public class Compra {
	public ArrayList<Producto> ListadeCompras;
	Compra()
	{
		ListadeCompras=new ArrayList<Producto>(); 
	}
	//Verificar que hay o no en las compras
	public int[] verificarCompra()
	{
		int retorno[]=new int[7];
		for(int i=0;i<7;i++)
			retorno[i]=0;
		for(int i=0;i<ListadeCompras.size();i++)
		{
			if(ListadeCompras.get(i).getNombre().equals("Pantalones Formales"))
				retorno[0]=1; 
			if(ListadeCompras.get(i).getNombre().equals("Jeans"))
				retorno[1]=1; 
			if(ListadeCompras.get(i).getNombre().equals("Blusa"))
				retorno[2]=1; 
			if(ListadeCompras.get(i).getNombre().equals("Chaqueta"))
				retorno[3]=1; 
			if(ListadeCompras.get(i).getNombre().equals("Zapatos de Plataforma"))
				retorno[4]=1; 
			if(ListadeCompras.get(i).getNombre().equals("Zapatos sin Plataforma"))
				retorno[5]=1; 
			if(ListadeCompras.get(i).getNombre().equals("Accesorios"))
				retorno[6]=1; 
		}
		return retorno;
	}
}
