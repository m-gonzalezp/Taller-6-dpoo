package uniandes.dpoo.swing.interfaz.agregar;

//import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
        // Crea el campo para el nombre con una etiqueta al frente
    	setLayout(new GridLayout(3, 2, 5, 5));
    	
    	//nombre restaurante
    	JLabel lblNom = new JLabel ("Nombre: ");
    	txtNombre = new JTextField(20); //Campo para que el usuario ingrese el nombre
    	add(lblNom);
        add(txtNombre);
        
        // calificacion restaurantes
        JLabel lblCali = new JLabel ("Calificación: ");
        String[] cali = {"1","2","3","4","5"}; //deben ser strings
        cbbCalificacion = new JComboBox<>(cali);
        add(lblCali);
        add(cbbCalificacion);
        
        //visitado
        JLabel lblVisi = new JLabel ("Visitado: ");
        String[] visi = {"Sí", "No"};
        cbbVisitado = new JComboBox <>(visi);
        add(lblVisi);
        add(cbbVisitado);


    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( )
    {
        // TODO completar
    	String selecVisi = (String) cbbVisitado.getSelectedItem();
        return "Sí".equals(selecVisi);
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
        // TODO completar
    	String nomb = (String) txtNombre.getText();
        return nomb;
    }
}
