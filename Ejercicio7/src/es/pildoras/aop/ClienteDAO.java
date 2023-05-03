package es.pildoras.aop;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import es.pildoras.aop.dao.Persona;

import java.util.Set;
import java.util.HashSet;

import org.springframework.stereotype.Component;

@Component 

public class ClienteDAO 
{
	public Set<Persona> leerFichero(File archivo)
	{
		Set<Persona> personas = new HashSet<>();
		try {
			Scanner sc = new Scanner(archivo);
			
			while(sc.hasNextLine())
			{
				String nombre = sc.nextLine().substring(8);
				String apellido = sc.nextLine().substring(10);
				int edad = Integer.parseInt(sc.nextLine().substring(6));
				
				personas.add(new Persona(nombre, apellido, edad));
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personas;
		
	}
}