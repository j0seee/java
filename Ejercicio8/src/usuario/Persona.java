package usuario;

import java.time.LocalDate;

public class Persona {
	
	String nombre;
	String apellido;
	LocalDate fecha_nacimiento;
	

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	

}
