package es.pildoras.aop.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.ClienteDAO;
import es.pildoras.aop.Configuracion;

import java.io.File;
import java.util.Set;

public class main {
    public static void main(String[] args) {
    	
        File archivo = new File("C:\\Users\\jvcalvillo\\Documents\\java\\FICHERO_AOP.txt");

        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
        ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
        Set<Persona> personas = elCliente.leerFichero(archivo);

        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " " + persona.getApellido() + ", " + persona.getEdad());
        }

        contexto.close();
    }
}
