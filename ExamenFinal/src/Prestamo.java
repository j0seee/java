import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo implements iPrestamo{
	String nombre;
	String autor;
	LocalDate fechaSolicitud;
	LocalDate fechaEntregaEstip;
	String Estado;
	String dni_cliente;
	
	public Prestamo()
	{
		
	}
	public Prestamo(String nombre, String autor, LocalDate fechas, LocalDate fechae, String Estado, String DNI)
	{
		this.nombre = nombre;
		this.autor = autor;
		this.fechaSolicitud = fechas;
		this.fechaEntregaEstip = fechae;
		this.Estado = Estado;
		this.dni_cliente = DNI;
	}
	

	//Los setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public void setFechaEntregaEstip(LocalDate fechaEntregaEstip) {
		this.fechaEntregaEstip = fechaEntregaEstip;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}

	//Los getters

	public String getNombre() {
		return nombre;
	}
	public String getAutor() {
		return autor;
	}
	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}
	public LocalDate getFechaEntregaEstip() {
		return fechaEntregaEstip;
	}
	public String getEstado() {
		return Estado;
	}
	public String getDni_cliente() {
		return dni_cliente;
	}
	
	@Override
	public String toString() {
		return "Prestamo [nombre=" + nombre + ", autor=" + autor + ", fechaSolicitud=" + fechaSolicitud
				+ ", fechaEntregaEstip=" + fechaEntregaEstip + ", Estado=" + Estado + ", dni_cliente=" + dni_cliente
				+ "]";
	}



	@Override
	public int diasDeAtraso() {
		// TODO Auto-generated method stub
		return (int)this.fechaEntregaEstip.until(LocalDate.now(), ChronoUnit.DAYS);
	}
	
	@Override
	public String estadoPrestamo() {
		// TODO Auto-generated method stub
		
		// Si no ha entregado el día que debía entregar, se ha vencido el préstamo
		if ((int)this.fechaEntregaEstip.until(LocalDate.now(), ChronoUnit.DAYS) >= 1)
		{
			return "VENCIDO";
		}
		else
		{
			return "EN REGLA";
		}
	}
	@Override
	public int dineroAdeudado() {
		// TODO Auto-generated method stub
		// Solo debe dinero si tiene días de retraso.
		if (this.diasDeAtraso() > 0) return this.diasDeAtraso() * 1;
		else return 0;
	}
	@Override
	public boolean clienteMoroso() {
		// TODO Auto-generated method stub
		if (this.estadoPrestamo().equals("VENCIDO"))
		{
			return true;
		}
		else return false;
	}
	
}


