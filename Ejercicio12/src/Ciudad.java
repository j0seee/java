
public class Ciudad implements iCiudad{
	
	public String nombre;
	public double poblacion_parcial;
	
	
	public double poblacion_final()
	{
		return this.poblacion_parcial * 0.8;
	}
	
	public Ciudad (String nombre, double poblacion_parcial)
	{
		this.nombre = nombre;
		this.poblacion_parcial = poblacion_parcial;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPoblacion_parcial() {
		return poblacion_parcial;
	}
	

}
