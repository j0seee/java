
import java.io.IOException;
import java.math.RoundingMode;
import java.net.*;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Creo un array de String con las latitudes y longitudes de las direcciones para poder usarlas despues. El orden es Barcelona, Buenos Aires, Madrid y Berlín
		String[] coordenadas_ciudades = {"latitude=41.39&longitude=2.16",
				"latitude=-34.61&longitude=-58.38",
				"latitude=40.42&longitude=-3.70",
				"latitude=52.52&longitude=13.41"
				};
		
		/*String madrid = "latitude=40.42&longitude=-3.70&hourly=temperature_2m";
		String barcelona = "latitude=41.39&longitude=2.16&hourly=temperature_2m";
		String berlin = "latitude=52.52&longitude=13.41&hourly=temperature_2m";
		String buenos_aires = "latitude=-34.61&longitude=-58.38&hourly=temperature_2m";
		*/
		
		//Realizamos una conexión por cada ciudad que tenemos que mostrar.
		for (String ciudad : coordenadas_ciudades)
		{
			try {
				URL url = new URL("https://api.open-meteo.com/v1/forecast?" + ciudad + "&hourly=temperature_2m&current_weather=true&forecast_days=1");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.connect(); //Establece la conexion.
				int tiempoDeRespuesta = con.getResponseCode();
				if (tiempoDeRespuesta != 200)
				{
					throw new RuntimeException("HttpResponseCode" + tiempoDeRespuesta);			
				}
				else
				{
					//Guardamos  información de la API
					StringBuilder informacion = new StringBuilder();
					Scanner sc = new Scanner(url.openStream());
					while (sc.hasNext())
					{
						informacion.append(sc.nextLine());
					}
					sc.close();
					
					//Me interesa el array que almacena las temperaturas del día cada hora.
					JSONObject data = new JSONObject(informacion.toString());
					JSONObject hourly = data.getJSONObject("hourly");
					JSONArray array_temp = hourly.getJSONArray("temperature_2m");
					
					
					//Calculo la media de esas temperaturas
					double media = array_temp.getDouble(0);
					
					for (int i = 1; i < array_temp.length(); i++)
					{
						media = media + array_temp.getDouble(i);
					}
					media = media/array_temp.length();
					
					
					//Me ayudo de una variable auxiliar para poder imprimir en que ciudad estoy.
					String ciudad_aux = "";
					if(ciudad.equals(coordenadas_ciudades[0]))
					{
						ciudad_aux = "Barcelona";
					}
					else if (ciudad.equals(coordenadas_ciudades[1]))
					{
						ciudad_aux = "Buenos Aires";
					}
					else if(ciudad.equals(coordenadas_ciudades[2]))
					{
						ciudad_aux = "Madrid";
					}
					else if(ciudad.equals(coordenadas_ciudades[3])) 
					{
						ciudad_aux = "Berlin";
					}
                    
					
					//Finalmente imprimo por consola la información que se me pide. Redondeo la media para que solo tenga un decimal.
					System.out.println("--- Bienvenido a " + ciudad_aux + " ---");
					System.out.println("La temperatura media para hoy en " + ciudad_aux +" es de " + (Math.round(media * 10.0) / 10.0) + "ºC");
					if (media < 10)
					{
						System.out.println("Se recomienda salir abrigado hoy");
					}
					else if (media >= 10)
					{
						System.out.println("Se recomienda el uso de abrigo, aunque con no el uso de mudas de ropa pesadas");
					}
					System.out.println("\n");
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		

	}

}
