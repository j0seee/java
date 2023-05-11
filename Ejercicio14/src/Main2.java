import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        // Pedimos los datos de los artistas por consola
        Scanner sc = new Scanner(System.in);
        Artista[] artistas = new Artista[3];
        for (int i = 0; i < artistas.length; i++) {
            System.out.println("Introduce los datos del artista " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Género: ");
            String genero = sc.nextLine();
            System.out.print("Reproducciones mensuales: ");
            int reproducciones = Integer.parseInt(sc.nextLine());
            System.out.print("País donde mas se escucha: ");
            String pais = sc.nextLine();

            artistas[i] = new Artista(nombre, genero, reproducciones, pais);
            
        }
        
        sc.close();

        // Escribimos los datos de los artistas en un archivo de texto
        try {
            FileWriter fw = new FileWriter("artistas.txt");
            for (int i = 0; i < artistas.length; i++) {
                fw.write("Artista numero: "+ (i+1) +": Nombre:" +  artistas[i].getNombre() + " ; Género: " + artistas[i].getGenero() + "; Cantidad de reproducciones: " +
                        artistas[i].getCant_rep() + "; País donde más se le escucha: " + artistas[i].getPais_mas_esc() + "; Recaudación monetaria: "+ artistas[i].RecaudacionMonetaria() + 
                        "; Proyección anual: " + artistas[i].ProyeccionAnual() + "\n");
            }
            fw.close();
            System.out.println("Los datos de los artistas se han guardado en el archivo artistas.txt");
        } catch (IOException e) {
            System.out.println();
        }
    }
}