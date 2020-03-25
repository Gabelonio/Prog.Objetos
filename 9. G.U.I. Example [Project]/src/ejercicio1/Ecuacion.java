/*
 * PROGRAMA PARA DETERMINAR LAS POSIBLES SOLUCIONES DE UNA ECUACIÓN CUADRÁTICA
 * GABRIEL ESTEBAN CASTILLO RAMIREZ - 20171020021 
 * 25/10/2017
*/
package ejercicio1;
public class Ecuacion 
{
	//Atributos
	double cuadrado,singular,ordenada;
	//Setters y Getters	
	public void setCuadrado(double cuadrado) {
		this.cuadrado = cuadrado;
	}
	public void setSingular(double singular) {
		this.singular = singular;
	}
	public void setOrdenada(double ordenada) {
		this.ordenada = ordenada;
	}
	public double getCuadrado() {
		return cuadrado;
	}
	public double getSingular() {
		return singular;
	}
	public double getOrdenada() {
		return ordenada;
	}
	//Métodos
	public String validarEcuacion()
	{
		if(this.cuadrado==0)
        {
              if(this.singular==0)
               {
	                if(this.ordenada==0)
	                	return "No hay x que despejar (0=0)"; 	
	                else
	                	return "La ecuacion es inconsistente"; 
               }	 
        }
		return "La ecuación esta correctamente planteada";
	}
	public String generarSolucion(double a,double b,double c)
	{
		if(a==0)
			return "x= "+String.valueOf(-c/b);
		else
        {
            if(b==0)
            {
                 if(c==0)
                 { 
                	 return "x= 0";
                 }
                 else if(c/a<0)
                 {
                     return "x= "+String.valueOf(Math.sqrt(-c/a))+ "\tx= -"+String.valueOf(Math.sqrt(-c/a)); 
                 }
                 else
                 {
                	 return "x= "+String.valueOf(Math.sqrt(c/a))+"i\tx= -"+String.valueOf(Math.sqrt(c/a))+"i"; 
                 }			
            }
            else
            {
               if(c==0)
               {
                    return "x= 0\tx= "+String.valueOf(-b/a);
               }
               else if(((Math.pow(b,2))-(4*a*c))==0)
               {
          	    	return "x= "+String.valueOf(-b/(2*a));
               }
               else if(((Math.pow(b,2))-(4*a*c))>0)
               {
                	return "x= "+String.valueOf((-b+Math.sqrt((Math.pow(b,2))-(4*a*c)))/(2*a))+"\tx= "+String.valueOf((-b-Math.sqrt((Math.pow(b,2))-(4*a*c)))/(2*a));
               }
         	   else
          	   {
          	    	return "x= "+String.valueOf(-b/(2*a))+"-"+String.valueOf(Math.sqrt(-((Math.pow(b,2))-(4*a*c)))/(a*2))+"i\tx= "+String.valueOf(-b/(2*a))+"+"+String.valueOf(Math.sqrt(-((Math.pow(b,2))-(4*a*c)))/(2*a))+"i";
          	   }
            }
        }
	}
}
