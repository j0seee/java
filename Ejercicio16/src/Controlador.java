
import java.util.List;

public class Controlador {
	
	private List<Vuelo> vuelos;
	private Vista vista;
	
	public Controlador(List<Vuelo> vuelos, Vista vista)
	
	{
		this.vuelos = vuelos;
		this.vista = vista;
		
		vista.setVisible(true);
	}
	

}
