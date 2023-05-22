import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado implements iEmpleado {
	
	String nombre;
	String apellido;
	LocalDate fechaingreso;
	LocalDate fechasalida;
	String sexo;
	String ciudad;
	String posición;
	double salario_base;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(LocalDate fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public LocalDate getFechasalida() {
		return fechasalida;
	}
	public void setFechasalida(LocalDate fechasalida) {
		this.fechasalida = fechasalida;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPosición() {
		return posición;
	}
	public void setPosición(String posición) {
		this.posición = posición;
	}
	public double getSalario_base() {
		return salario_base;
	}
	public void setSalario_base(double salario_base) {
		this.salario_base = salario_base;
	}
	
	
	@Override
	public double Salario_final() {
		// TODO Auto-generated method stub
		return this.salario_base * 0.83;
	}
	@Override
	public long antiguedad_laboral() {
		// TODO Auto-generated method stub
		
		//Devuelve la diferencia en años.
		return this.fechaingreso.until(fechasalida, ChronoUnit.YEARS);
	}
	@Override
	public String rotacion_recomendada() {
		if(this.posición.toUpperCase().equals("INGENIERO") && this.antiguedad_laboral() >= 2)
		{
			return ("Rotación habilitada");
		}
		
		else if (this.posición.toUpperCase().equals("INGENIERO") && this.antiguedad_laboral() < 2)
		{
			return ("Rotación no habilitada");
		}
		
		// Suponngamos que la rotación no está habilitada a menos que seas Ingeniero
		else return "Rotación no habilitada";
	}

}
