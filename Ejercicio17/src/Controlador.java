
public class Controlador {
	
	private Vista vista;
	
	public Controlador(Vista vista)
	{
		this.vista = vista;
	}
	
	public void AbrirApp() {
		vista.setVisible(true);
	}

}
