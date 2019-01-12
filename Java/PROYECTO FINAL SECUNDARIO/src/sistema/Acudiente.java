package sistema;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
/**
 * @author Gabriel Esteban Castillo Ramirez
 */
public class Acudiente 
{
    int ID,ingresos;
    String nombre,telefono;
    boolean padre;
    Acudiente()
    {
        String Line;
        File fl=null; 
        FileReader fr= null; 
        BufferedReader br=null;
        StringTokenizer st=null;
        FileOutputStream fos = null; 
        DataOutputStream sal = null; 
        try{
             fos = new FileOutputStream("acudiente.dat");
             sal = new DataOutputStream(fos); 
             fl=new File("acudiente.txt");
             fr=new FileReader(fl);
             br=new BufferedReader(fr);   
             while((Line=br.readLine())!=null)
             {
                st= new StringTokenizer(Line,";"); 
                while(st.hasMoreTokens())
                {
                    ID=Integer.parseInt(st.nextToken());
                    nombre=st.nextToken();
                    telefono=st.nextToken();
                    ingresos=Integer.parseInt(st.nextToken());
                    padre=Boolean.parseBoolean(st.nextToken());
                }
                sal.writeInt(ID);
                sal.writeUTF(nombre);
                sal.writeUTF(telefono);
                sal.writeInt(ingresos);
                sal.writeBoolean(padre);
             }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (fos != null) 
                {                     
                    fos.close();                 
                }                 
                if (sal != null) 
                {                     
                    sal.close();                 
                } 
                if(fr!=null)
                {
                    fr.close();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    String leerAcudientes()
    {
        String ret="";
        FileInputStream file  = null;         
        DataInputStream input = null; 
        try{
            file = new FileInputStream("acudiente.dat");
            input=new DataInputStream(file);
            for(int i=0;i<26;i++)
            {
                 ret=ret.concat(input.readInt()+";"+input.readUTF()+";"+input.readUTF()+";"+input.readInt()+";"+input.readBoolean()+";");
            }
        }
        catch(Exception ex)
        {
               ex.printStackTrace();
        }
        finally
        {
                try
                {
                    if(file!=null)
                    {
                        file.close();  
                    }
                    if (input!= null) 
                    {                     
			input.close();
                    } 
                }
                catch(Exception ex)
                {
                   ex.printStackTrace();
                }  
        }     
        return ret;
    }
    void listarAcudientes()
    {
        String imp="";
        StringTokenizer st=null;
        st= new StringTokenizer(leerAcudientes(),";");
        while(st.hasMoreTokens())
        {
            imp=imp.concat("\nIdentificación: "+st.nextToken()+"   Nombre: "+st.nextToken()+"   Telefono: "+st.nextToken()+"   Ingresos: "+st.nextToken());
            if(Boolean.parseBoolean(st.nextToken())){imp=imp.concat("  Es Padre");}else{imp=imp.concat("  Es Madre");}
        }
        JOptionPane.showMessageDialog(null,imp,"Lista de Acudientes",JOptionPane.INFORMATION_MESSAGE);
    }
    void filtrarPadres()
    {
        int cont=0; 
        StringTokenizer st;
        st= new StringTokenizer(leerAcudientes(),";");
        while(st.hasMoreTokens())
        {
            st.nextToken();st.nextToken();st.nextToken();st.nextToken();
            padre=Boolean.parseBoolean(st.nextToken());
            if(padre)
            {
                cont++;
            }
        }
        JOptionPane.showMessageDialog(null,"La cantidad de Acudientes Padres es : "+cont,"Cantidad de Padres",JOptionPane.INFORMATION_MESSAGE);
    }
    void filtrarIngresos()
    {
        int cont=0; 
        StringTokenizer st;
        st= new StringTokenizer(leerAcudientes(),";");
        while(st.hasMoreTokens())
        {
            st.nextToken();st.nextToken();st.nextToken();
            ingresos=Integer.parseInt(st.nextToken());           
            if(ingresos>700000)
            {
                cont++;
            }
            st.nextToken();
        }
        JOptionPane.showMessageDialog(null,"La cantidad de Acudientes con Ingresos superiores a 700000 es : "+cont,"Ingresos de Acudientes",JOptionPane.INFORMATION_MESSAGE);
    }
    void mostrarPorIngresos()
    {
        String imp="";
        StringTokenizer st;
        st= new StringTokenizer(leerAcudientes(),";");
        while(st.hasMoreTokens())
        {
            ID=Integer.parseInt(st.nextToken());
            nombre=st.nextToken();st.nextToken();
            ingresos=Integer.parseInt(st.nextToken());           
            if(ingresos<650000)
            {
                imp=imp.concat("\nNombre: "+nombre+"    Identifiación: "+ID);
            }
            st.nextToken();
        }
        JOptionPane.showMessageDialog(null,imp,"Acudientes con ingresos menores a 650000",JOptionPane.INFORMATION_MESSAGE);
    }
    void mostrarPorGenero()
    {
        String imp="";
        StringTokenizer st;
        st= new StringTokenizer(leerAcudientes(),";");
        while(st.hasMoreTokens())
        {
            st.nextToken();
            nombre=st.nextToken();st.nextToken();
            ingresos=Integer.parseInt(st.nextToken()); 
            padre=Boolean.parseBoolean(st.nextToken());
            if(padre==false)
            {
                imp=imp.concat("\nNombre: "+nombre+"    Ingresos: "+ingresos);
            }     
        }
        JOptionPane.showMessageDialog(null,imp,"Nombre e Ingresos de Acudientes Madres",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
