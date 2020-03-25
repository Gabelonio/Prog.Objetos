package ejercicio1;

public class DocentePlanta extends Docente 
{
	//Constructor
	DocentePlanta(String nombre,String apellido,int nivel) 
	{
		//Llamado del constructor padre
		super(nombre,apellido,nivel);
		this.setSueldo(this.calcularSueldo(nivel));
	}
	//Métodos
	public double calcularSueldo(int nivel)
	{
		 switch(nivel)
		 {
		 	case 1:{return 7000000;}
		 	case 2:{return 5000000;}
		 	case 3:{return 4000000;}
		 	case 4:{return 3000000;}
		 }
		 return 0;
	}
}
