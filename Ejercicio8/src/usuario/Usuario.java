package usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Usuario extends Persona implements iUsuario{
	
	String email;
	String usuario;
	long edad;

	
	public Usuario(String nombre, String apellido, LocalDate fecha_nac, String email, String user)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nac;
		this.email = email;
		this.usuario = user;
	}

	public String getEmail() {
		return email;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public long calcularEdad(LocalDate fecha_nac)
	{
		long edad = ChronoUnit.YEARS.between(fecha_nac, LocalDate.now());
		
		return edad;
	}

}
