package registro;
import usuario.*;

import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component

public class Registro {
	
	Usuario[] usuarios = new Usuario[1];
	
	public void registroDeUsuario()
	{
		System.out.println("--Bienvenido al programa de registro de usuario--");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre:");
		String nombre = sc.next();
		
		System.out.println("Introduzca el apellido:");
		String apellido = sc.next();
		
		System.out.println("Introduzca la fecha de nacimiento en formato DD/MM/YYY:");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fec = LocalDate.parse(sc.next(), formatter);
		
		System.out.println("Introduzca el correo electrónico:");
		String email = sc.next();
		
		sc.close();
		
		Usuario aux = new Usuario(nombre,apellido,fec, email, System.getProperty("user.name"));
		
		
		System.out.println();
		System.out.println("El usuario " + aux.getUsuario() + " tiene de nombre "
				+ aux.getNombre() + " " + aux.getApellido()
				+ ", su edad es de " + aux.calcularEdad(aux.getFecha_nacimiento()) +
				" años, y su correo electrónico es " + aux.getEmail());
		
	}

}
