
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//La ruta del archivo que vamos a leer
		String ruta_lectura = "Biblioteca Nacional de España.txt";
		
		//La ruta del archivo que vamos a escribir.
		String ruta_escritura = "inventario_y_vencimientos_"+LocalDate.now();
		
		//Almacenamos los diversos prestamos que pueda tener el fichero
		
		try {
			
			//Guardamos los prestamos
			List<Prestamo> prestamos = leerPrestamosFichero(ruta_lectura);
			
			//Ahora vamos a escribir.
			FileWriter fw = new FileWriter(ruta_escritura);
			for (Prestamo pr : prestamos)
			{
				escribirPrestamosFichero(fw, pr);
			}
			
			fw.close();
			
			System.out.println("Fichero de salida generado");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
	}
	
	// Este método lee el fichero que le indicamos y obtiene todos los prestamos distintos
	// que hay en él almacenados, y los guarda en un ArrayList de prestamos.
	private static List<Prestamo> leerPrestamosFichero(String ruta)
	{
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		//Para poder trabajar bien con las fechas.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Prestamo prestamoActual = null;
        
        try {
            Scanner scanner = new Scanner(new File(ruta));
            
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                
                if (linea.equals("Nombre")) {
                    prestamoActual = new Prestamo();
                    prestamoActual.setNombre(scanner.nextLine().trim());
                } else if (linea.equals("Autor")) {
                    prestamoActual.setAutor(scanner.nextLine().trim());
                } else if (linea.equals("Fecha de Solicitud")) {
                    prestamoActual.setFechaSolicitud(LocalDate.parse(scanner.nextLine().trim(), formatter));
                } else if (linea.toUpperCase().equals("FECHA DE ENTREGA ESTIPULADA")) {
                    prestamoActual.setFechaEntregaEstip(LocalDate.parse(scanner.nextLine().trim(), formatter));
                } else if (linea.toUpperCase().equals("ESTADO:")) {
                    prestamoActual.setEstado(scanner.nextLine().trim());
                } else if (linea.equals("DNI")) {
                    prestamoActual.setDni_cliente(scanner.nextLine().trim());
                    prestamos.add(prestamoActual);
                }
            }
            
            scanner.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

		
		return prestamos;
	}
	
	private static void escribirPrestamosFichero(FileWriter fw, Prestamo pr)
	{
		try {
			fw.write("Nombre\n" + pr.getNombre() + "\n");
			fw.write("Autor\n" + pr.getAutor() + "\n");
			fw.write("Fecha de Solicitud\n" + pr.getFechaSolicitud() + "\n");
			fw.write("Fecha de Entrega Estipulada\n" + pr.getFechaEntregaEstip() + "\n");
			fw.write("Estado:\n" +pr.getEstado() + "\n");
			fw.write("DNI\n" + pr.getDni_cliente() + "\n");
			fw.write("Días de atraso\n" + pr.diasDeAtraso() + "\n");
			fw.write("Estado del préstamo\n" + pr.estadoPrestamo() + "\n");
			fw.write("Dinero adeudado\n" + pr.dineroAdeudado() + "\n");
			if (pr.clienteMoroso()) fw.write("Cliente Moroso\nSí\n");
			else fw.write("Cliente Moroso\nNo\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
