import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Aqui vamos a leer el archivo que nos pasan
		String ruta = "receta.txt";
		ArrayList<Comida> comidas = new ArrayList<>();
		
		try {
		    Scanner scanner = new Scanner(new File(ruta));

		    String nombre = "";
		    ArrayList<String> ingredientes = new ArrayList<>();

		    while (scanner.hasNextLine()) {
		        String linea = scanner.nextLine();

		        if (linea.startsWith("Nombre de la receta:")) {
		            // Consideramos que cada receta nueva empieza por la linea "Nombre de la receta"
		            if (!nombre.equals("")) {
		                Comida comida = new Comida(nombre, ingredientes);
		                comidas.add(comida);
		            }
		            // reiniciamos las variables para la nueva receta
		            nombre = linea.split(":")[1].trim();
		            ingredientes = new ArrayList<>();
		        } else if (linea.startsWith("Ingredientes:")) {
		            // si la línea es de ingredientes, extraemos cada ingrediente y lo agregamos a la lista
		            while (scanner.hasNextLine()) {
		                String lineaIngrediente = scanner.nextLine();
		                if (lineaIngrediente.startsWith("\n") || lineaIngrediente.trim().equals("")) {
		                    break;
		                }
		                String ingrediente = lineaIngrediente.split(" ")[0];
		                ingredientes.add(ingrediente);
		            }
		        }
		    }

		    //Añadimos la comida que hemos leido a la lista
		    Comida comida = new Comida(nombre, ingredientes);
		    comidas.add(comida);

		    scanner.close();
			
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}

		// Aqui generamos el JenkinsFile que nos piden
		String contenidoJenkinsfile = 
				"pipeline {\n" +
                        "    agent any\n" +
                        "    stages {\n" +
                        "        stage('Resultados') {\n" +
                        "            steps {\n" +
                        "                script {\n" +
                        "                    echo 'Se ha leido un archivo de recetas que contenía " + comidas.size() + " recetas en total "+ "'\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("Jenkinsfile"));
			{
				pw.write(contenidoJenkinsfile);
				System.out.println("Se genero el Jenkinsfile");
			} 
			
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Ahora generamos un nuevo archivo con la información nueva que queremos saber
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("recetasPro.txt"));
			String contenido = "";
			
			for (int i = 0; i < comidas.size(); i++)
			{
				String aux = "Comida numero " + (i+1) + ": " + comidas.get(i).nombre.toUpperCase() + "\n"
						+ " Ingredientes: " + comidas.get(i).ingredientes + "\n" 
						+ "Tiene un total de " + comidas.get(i).calorias() +  " calorias, y tardamos en prepararla un total de " 
						+ comidas.get(i).tiempo_coccion() + " minutos.\n";
				
				contenido = contenido + "\n" + aux;
			}
			
			pw.write(contenido);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(comidas.get(0).getIngredientes());
	}

}
