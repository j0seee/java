import java.util.ArrayList;

public class Comida implements iComida{
	
	String nombre;
	ArrayList<String> ingredientes;
	
	
	public Comida()
	{
		this.nombre = "";
		this.ingredientes = null;
	}
	
	public Comida (String nombre, ArrayList<String> ingredientes)
	{
		this.nombre = nombre;
		this.ingredientes = ingredientes;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	

	@Override
	public int tiempo_coccion() {
		
		int tiempo = this.ingredientes.size() * 1;
		return tiempo;
	}

	@Override
	public int calorias() {
		
		int calorias = this.ingredientes.size() * 3;
		return calorias;
	}

	
	
	

}
