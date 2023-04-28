import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.Month;

public class Vuelo implements iVuelo{
	
	String nombre;
	int cant_pasajeros;
	String tipo_pasaje;
	int valor_unitario;
	LocalDate fechaVuelo;
	
	//DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	public Vuelo(String nombre, int cant_pasajeros, String tipo_pasaje, int valor_unitario, LocalDate fechaVuelo)
	{
		this.nombre = nombre;
		this.cant_pasajeros = cant_pasajeros;
		this.tipo_pasaje = tipo_pasaje;
		this.valor_unitario = valor_unitario;
		this.fechaVuelo = fechaVuelo;
	}
	
	public int ValorFinalVuelo()
	{
		return valor_unitario * cant_pasajeros;
	}
	public long DiasDeDiferencia()
	{
		
		LocalDate fecha1 = LocalDate.now();
        LocalDate fecha2 = fechaVuelo;
        
        long diferencia = ChronoUnit.DAYS.between(fecha1, fecha2);
		
		return Math.abs(diferencia);
	}
	public String esRentable()
	{
		
		String esRentable = "No Rentable";
		
		if(tipo_pasaje.equals("Económico"))
		{
			if(ValorFinalVuelo() > 100)
			{
				esRentable = "Rentable";
			}
			else
			{
				esRentable = "No Rentable";
			}
		}
		
		else if(tipo_pasaje.equals("Premier"))
		{
			if (ValorFinalVuelo() > 1500)
			{
				esRentable = "Rentable";
			}
			else
			{
				esRentable = "Rentable";
			}
		}
		
		return esRentable;
	}	

}
