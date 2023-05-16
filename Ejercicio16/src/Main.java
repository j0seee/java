
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		//Creamos los vuelos que vamos a mostrar
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		
		Vuelo vuelo1 = new Vuelo ("Woodvale Flight", "Madrid", "Nashville", 
				LocalDateTime.parse("2022-12-13 13:45:00",formatter), 
				LocalDateTime.parse("2022-12-13 23:30:00", formatter));
		
		Vuelo vuelo2 = new Vuelo ("Solydia Flight", "Málaga", "Bali", 
				LocalDateTime.parse("2023-02-20 11:11:00",formatter), 
				LocalDateTime.parse("2023-02-21 22:22:00", formatter));
		
		Vuelo vuelo3 = new Vuelo ("HolaMajete Flight", "Sevilla", "Tenerife", 
				LocalDateTime.parse("2023-07-11 12:45:00",formatter), 
				LocalDateTime.parse("2023-07-11 14:30:00", formatter));
		
		Vuelo vuelo4 = new Vuelo ("Arrebato Flight", "Sevilla", "Ibiza", 
				LocalDateTime.parse("2023-09-21 12:40:00",formatter), 
				LocalDateTime.parse("2023-09-21 14:30:00", formatter));
		
		vuelos.add(vuelo1);
		vuelos.add(vuelo2);
		vuelos.add(vuelo3);
		vuelos.add(vuelo4);
		
		
		Vista vista = new Vista(vuelos);
		Controlador controlador = new Controlador(vuelos, vista);
		
		

	}

}
