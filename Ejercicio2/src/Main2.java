import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);
		 
		 String fecha_hoy = new java.util.Date().toString();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		 
		String ruta = "C:\\Users\\jvcalvillo\\Documents\\java";
		String nombre_fichero = "\\informacion_empleados_fechaDeHoy.txt";
		String ruta_y_fichero = ruta + nombre_fichero;
		 
Empleado empleados[] = new Empleado[3];
		
		Empleado empleado1 = new Empleado();
		Empleado empleado2 = new Empleado();
		Empleado empleado3 = new Empleado();
		
		empleado1.nombre = "Juan";
		empleado1.apellido = "García";
		empleado1.ciudad = "Madrid";
		empleado1.edad = 25;
		
		empleado2.nombre = "María";
		empleado2.apellido = "Pérez";
		empleado2.ciudad = "Málaga";
		empleado2.edad = 24;
		
		empleado3.nombre = "Pedro";
		empleado3.apellido = "Rodríguez";
		empleado3.ciudad = "Madrid";
		empleado3.edad = 30;
		
		empleados[0] = empleado1;
		empleados[1] = empleado2;
		empleados[2] = empleado3;
		
		File archivo = new File(ruta_y_fichero);
		
			if(!archivo.exists())
				{
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}
			
			FileWriter fw;
			try {
				fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(fecha_hoy + "\n");
				
				
				for(int i = 0; i < empleados.length; i++)
				{
					int emplead_aux = i +1;
					System.out.println("Ingrese la posición del empleado " + empleados[i].nombre + " " + empleados[i].apellido + ": ");
					empleados[i].posicion = sc.next();
					
					System.out.println("Ingrese el sueldo del empleado " + empleados[i].nombre + " " + empleados[i].apellido + ": ");
					empleados[i].salario = sc.nextInt();
					
					System.out.println("Ingrese la fecha en la que ingresó el empleado " + empleados[i].nombre + " " + empleados[i].apellido + "\n"
							+ " en formato AÑO/MES/DÍA:");
					try {
						empleados[i].fecha_ingreso = sdf.parse(sc.next());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					String mensaje = "Empleado " + emplead_aux + ": \n"
							+ "Nombre: " + empleados[i].nombre + " \n"
							+ "Apellido: " + empleados[i].apellido + " \n"
							+ "Edad: " + empleados[i].edad + "\n"
							+ "Posicion: " + empleados[i].posicion + "\n"
							+ "Salario: " + empleados[i].salario + "\n"
							+ "Fecha de ingreso: " + empleados[i].fecha_ingreso + "\n";
					
					fw.write(mensaje);
				}
				
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			sc.close();
			
		


}
}
