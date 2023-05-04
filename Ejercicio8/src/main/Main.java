package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuracion.AspectConfig;
import registro.Registro;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AspectConfig.class);
		context.scan("registro", "aspecto"); //escane los Paquetes. 
		context.refresh();
		Registro registro = context.getBean(Registro.class);
		registro.registroDeUsuario();
		context.close();
		
		
		
	}

}
