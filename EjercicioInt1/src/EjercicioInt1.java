import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;  
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class EjercicioInt1 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Vuelo[] vuelos = new Vuelo[8];
		int i = 0;
		
		
		File archivo = new File("C:\\Users\\jvcalvillo\\Documents\\java\\INFO_VUELOS.txt");
            try {
            	
            	// Primero, leemos los datos que ya tenemos y guardamos los vuelos.
				Scanner sc = new Scanner(archivo);
				sc.nextLine(); // La primera línea no interesa;
				
				while(sc.hasNextLine())
				{
					
					String linea = sc.nextLine();
					
					vuelos[i] = new Vuelo(sc.next(), 
							Integer.parseInt(sc.next()),
							sc.next(),
							Integer.parseInt(sc.next()),
							LocalDate.parse(sc.next(),formater));
					i++;
					
				}
				
				// Ahora imprimos el nuevo archivo con los nuevos datos que vamos a calcular.
				
				String ruta_nombreArchivo = "C:\\Users\\jvcalvillo\\Documents\\java\\nuevos_vuelos.txt";
				File archivo2 = new File(ruta_nombreArchivo);
				
				String[] cabecera = {"NOMBRE_VUELO", "CANT_PASAJEROS", "TIPO_PASAJE",
						"VALOR_UNITARIO", "FECHA_VUELO",
                        "VALOR_FINAL_VUELO", "DIAS_DIFERENCIA", "SEGMENTACION"};
				
				FileWriter fw = new FileWriter(archivo2);
				BufferedWriter bw = new BufferedWriter(fw);
				
				 for (String cabe : cabecera) {
		                bw.write(String.format("%-15s", cabe + "\t"));
		            }
				 
		            bw.write("\n");
		            
		         for (int j = 0; j < vuelos.length-1; j++)
		         {
		        	 bw.write(String.format("%-18s", vuelos[j].nombre));
		        	    bw.write(String.format("%-18s", vuelos[j].cant_pasajeros));
		        	    bw.write(String.format("%-18s", vuelos[j].tipo_pasaje));
		        	    bw.write(String.format("%-18s", vuelos[j].valor_unitario));
		        	    bw.write(String.format("%-18s", vuelos[j].fechaVuelo));
		        	    bw.write(String.format("%-18s", vuelos[j].ValorFinalVuelo()));
		        	    bw.write(String.format("%-18s", vuelos[j].DiasDeDiferencia()));
		        	    bw.write(String.format("%-18s", vuelos[j].esRentable()) + "\n");
		        	 
		         }
		           bw.close();
		           fw.close();
		           
		           
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    
}
	
}


