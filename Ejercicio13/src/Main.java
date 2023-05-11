import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            // Seleccionar el ID del Pokemon
            int ID = 472; // Gliscor es uno de mis pokemon favoritos <3
            
            // Hacer una petición GET a la PokeAPI para obtener la información del Pokemon
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + ID);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            
            int tiempoDeRespuesta = con.getResponseCode();
            if (tiempoDeRespuesta != 200) {
                throw new RuntimeException("HttpResponseCode " + tiempoDeRespuesta);
            } else {
            	
            	StringBuilder info = new StringBuilder();
            	Scanner sc = new Scanner(url.openStream());
            	
            	while(sc.hasNext())
            	{
            		info.append(sc.nextLine());
            	}
            	
          
            	
            	JSONObject pokemon = new JSONObject(info.toString());
            	
            	//Obtenemos el nombre del pokemon y lo guardamos en una variable
            	String nombre = pokemon.getString("name");
            	
            	//Obtemos los tipos
            	JSONArray tipos = pokemon.getJSONArray("types");
            	
            	//Guardamos el tipo del pokemon
            	String tipo1 = tipos.getJSONObject(0).getJSONObject("type").getString("name");
            	String tipo2 = "";
            	//Algunos pokemon (no todos) tienen dos tipos
            	if(!tipos.getJSONObject(1).isEmpty())
            	{
            		 tipo2 = tipos.getJSONObject(1).getJSONObject("type").getString("name");
            	}
            	
            	
            	//Guardamos el peso
            	double peso = pokemon.getDouble("weight");
            	
            	//Escribimos esta información en un archivo
            	FileWriter archivo = new FileWriter("Pokemon.txt");
            	PrintWriter pw = new PrintWriter(archivo);
            	
            	pw.println("POKEMON NUMERO " +ID);
            	pw.println("Nombre: " + nombre);
            	if(!tipos.getJSONObject(1).isEmpty())
            	{
            		pw.println("Tipos: " + tipo1 + "/" + tipo2);
            	}
            	else
            	{
            		pw.println("Tipo: " + tipo1);
            	}
            	pw.println("Peso: " + peso);
            	
            	pw.close();
            	
            	System.out.println("Información del pokemon guardada");
            	
            }

           

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
