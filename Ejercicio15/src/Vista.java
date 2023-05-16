import java.util.Scanner;

public class Vista {
	
	public void mostrarRegistro(Usuario usuario)
	{
		System.out.println("--Bienvenido a la aplicación de registro de usuarios--");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su nombre:");
		usuario.setNombre(sc.next());
		
		System.out.println("Introduzca su apellido:");
		usuario.setApellido(sc.next());
		
		System.out.println("Introduzca su email:");
		usuario.setCorreo(sc.next());
		
		sc.close();
		System.out.println("--Registro completado con éxito--");
		System.out.println("");
		
	}
	
	public void mostrarInfo(Usuario usuario)
	{
		System.out.println("---------------------------");
		System.out.println("Se ha registrado al usuario " + 
				usuario.getNombre() + " " + usuario.getApellido() + 
				" con el correo " + usuario.getCorreo());
	}

}
