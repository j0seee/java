import java.time.LocalDateTime;

public class Vuelo {
	
	String nombre;
	String origen;
	String destino;
	
	LocalDateTime salida;
	LocalDateTime llegada;

	public Vuelo()
	{
		this.nombre = "";
		this.origen = "";
		this.destino = "";
		this.salida = null;
		this.llegada = null;
	}
	
	public Vuelo(String nombre, String origen, String destino, LocalDateTime salida, LocalDateTime llegada)
	{
		this.nombre = nombre;
		this.origen = origen;
		this.destino = destino;
		this.salida = salida;
		this.llegada = llegada;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public LocalDateTime getSalida() {
		return salida;
	}
	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}
	public LocalDateTime getLlegada() {
		return llegada;
	}
	public void setLlegada(LocalDateTime llegada) {
		this.llegada = llegada;
	}

}
