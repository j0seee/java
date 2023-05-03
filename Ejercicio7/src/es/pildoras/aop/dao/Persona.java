package es.pildoras.aop.dao;

public class Persona {
	
	public String nombre;
	public String apellido;
	public int edad;
	
	public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getApellido()
	{
		return this.apellido;
	}
	
	public int getEdad()
	{
		return this.edad;
	}

}
