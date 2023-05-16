
public class Controlador {
	
	private Vista vista;
	
	public Controlador (Vista vista)
	{
		this.vista = vista;
	}
	
	public void generarRegistro()
	{
		Usuario usuario = new Usuario();
		vista.mostrarRegistro(usuario);
		vista.mostrarInfo(usuario);
	}
	

}
