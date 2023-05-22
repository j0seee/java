import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleado empl1 = new Empleado();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		
		// Introducimos todos los datos del empleado por consola.
		System.out.println("--Bienvenido al sistema de registro de empleados--");
		System.out.println();
		
		System.out.println("Introduzca el nombre del empleado: ");
		empl1.setNombre(sc.nextLine());
		
		System.out.println("Introduzca el apellido del empleado");
		empl1.setApellido(sc.nextLine());
		
		System.out.println("Introduzca la fecha de ingreso del empleado en formato DD/MM/YYYY");
		empl1.setFechaingreso(LocalDate.parse(sc.nextLine(), formatter));
		
		System.out.println("Introduzca la fecha de salida del empleado en formato DD/MM/YYYY");
		empl1.setFechasalida(LocalDate.parse(sc.nextLine(), formatter));
		
		System.out.println("Introduzca el sexo del empleado:");
		empl1.setSexo(sc.nextLine());
		
		System.out.println("Introduzca la ciudad del empleado:");
		empl1.setCiudad(sc.nextLine());
		
		System.out.println("Introduzca ls posición del empleado: ");
		empl1.setPosición(sc.nextLine());
		
		System.out.println("Introduzca el salario base del empleado: ");
		empl1.setSalario_base(Double.parseDouble(sc.next()));
		
		
		// Al principio creía que había que imprimirlo así, pero cambié de opinión
		/*String aux = "Datos del empleado " + empl1.getNombre() + " " + empl1.getApellido()+ ": \n"
				+ " Fecha de ingreso: " + empl1.getFechaingreso() + " \n"
				+" Fecha de salida: " + empl1.getFechasalida() + "\n"
				+ " Sexo: " + empl1.getSexo() + "\n"
				+ " Ciudad: " + empl1.getCiudad() + " \n"
				+ " Posicion: " + empl1.getPosición() + "\n"
				+ " Salario base: " + empl1.getSalario_base() + "\n"
				+ "   El salario final es: " + empl1.Salario_final() + "\n"
				+ "   Su antigüedad laboral es de : " + empl1.antiguedad_laboral() +  " años \n"
				+ "   ¿Está recomendada su rotación? " + empl1.rotacion_recomendada();
		*/
		
		//Creamos un objeto JSON con los datos del empleado para poder guardarlo en el documento .json
		JSONObject js = new JSONObject();
		js.put("Nombre",empl1.getNombre() );
		js.put("Apellido", empl1.getApellido());
		js.put("Fecha de ingreso", empl1.getFechaingreso());
		js.put("Fecha de salida", empl1.getFechasalida());
		js.put("Sexo", empl1.sexo);
		js.put("Ciudad", empl1.getCiudad());
		js.put("Posicion", empl1.getPosición());
		js.put("Salario base", empl1.getSalario_base());
		js.put("Salario final", empl1.Salario_final());
		js.put("Antigüedad laboral", empl1.antiguedad_laboral());
		js.put("Rotacion habilitada", empl1.rotacion_recomendada());
		
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter("archivo.json"));
			bf.write(js.toString());
			
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
