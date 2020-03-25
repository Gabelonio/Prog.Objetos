package ejercicio1;

public class DocenteCatedra extends Docente{
	//Atributos
	double horas; 
	//Constructor
	DocenteCatedra(String nombre,String apellido,int nivel,double horas) 
	{
		//Llamado del constructor padre
		super(nombre,apellido,nivel);
		this.setHoras(horas);
		this.setSueldo(this.calcularSueldo(nivel,horas));
	
	}
	//Setters y Getters
	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}
	//Métodos
	public double calcularSueldo(int nivel,double horas)
	{
		 switch(nivel)
		 {
		 	case 1:{return 7000000*0.1*horas/4;}
		 	case 2:{return 5000000*0.1*horas/4;}
		 	case 3:{return 4000000*0.1*horas/4;}
		 	case 4:{return 3000000*0.1*horas/4;}
		 }
		 return 0;
	}
}
	
