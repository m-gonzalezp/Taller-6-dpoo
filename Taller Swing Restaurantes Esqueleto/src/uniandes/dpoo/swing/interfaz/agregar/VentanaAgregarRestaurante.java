package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.PanelDetallesRestaurante;
import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;
import uniandes.dpoo.swing.interfaz.agregar.PanelEditarRestaurante;
import uniandes.dpoo.swing.interfaz.mapa.PanelMapaVisualizar;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;
    
    private PanelMapaVisualizar panelmapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        // Agrega el panel donde va a estar el mapa
        // TODO completar
        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        // Agrega en el sur un panel para los detalles del restaurante y para los botones
        // TODO completar
        JPanel panelSur = new JPanel (new BorderLayout());
        panelDetalles = new PanelEditarRestaurante();
        panelBotones = new PanelBotonesAgregar(this);
        
        //agregar los paneles a la ventana 
        panelSur.add(panelDetalles, BorderLayout.CENTER);
        panelSur.add(panelBotones, BorderLayout.SOUTH);
        add(panelSur, BorderLayout.SOUTH);	
        

        // Termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }
    
    
    int x = 0;
    int y = 0;
    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
        // TODO completar
    	String nom = panelDetalles.getNombre();
    	int calif = panelDetalles.getCalificacion();
    	boolean visi = panelDetalles.getVisitado();
    	
    	
        
        
        addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Guardar las coordenadas del clic
                x = e.getX();
                y = e.getY();
                System.out.println("Clic en: (" + x + ", " + y + ")");
            }
        });
        
    	
    	ventanaPrincipal.agregarRestaurante(nom, calif, x, y, visi);

        // Cerrar la ventana de agregar restaurante
        dispose();
    	
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
