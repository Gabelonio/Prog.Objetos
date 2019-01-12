package sistema;
import javax.swing.JOptionPane;
/**
 * @author Gabriel Esteban Castillo Ramirez
 */
public class Sistema 
{
    public static void main(String[] args) 
    {
        Acudiente ac=new Acudiente();
        ac.listarAcudientes();
        ac.filtrarPadres();
        ac.filtrarIngresos();
        ac.mostrarPorIngresos();
        ac.mostrarPorGenero();
    }
}
