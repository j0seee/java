
public class Artista implements iArtista{
	
	String nombre;
	String genero;
	int cant_rep;
	String pais_mas_esc;
	
	public Artista (String nombre, String genero, int cant, String pais)
	{
		this.nombre = nombre;
		this.genero = genero;
		this.cant_rep = cant;
		this.pais_mas_esc = pais;
	}

	@Override
	public double RecaudacionMonetaria() {
		// TODO Auto-generated method stub
		return this.cant_rep * 0.02;
	}

	@Override
	public double ProyeccionAnual() {
		// TODO Auto-generated method stub
		return this.RecaudacionMonetaria() * 12;
	}

	public String getNombre() {
		return nombre;
	}

	public String getGenero() {
		return genero;
	}

	public int getCant_rep() {
		return cant_rep;
	}

	public String getPais_mas_esc() {
		return pais_mas_esc;
	}

}
