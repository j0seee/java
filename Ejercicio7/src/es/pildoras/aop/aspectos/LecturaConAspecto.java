package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import es.pildoras.aop.dao.Persona;

import java.util.Set;
import java.io.File;
import java.util.HashSet;

@Aspect
@Component

public class LecturaConAspecto {

	@Before("execution(Set<Persona> leerFichero(File archivo))")
	public void aviso()
	{
		System.out.println("Se va a leer el fichero");
	}

}
