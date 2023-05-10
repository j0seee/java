import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ciudad Barcelona = new Ciudad("Barcelona", 100000);
		Ciudad Madrid = new Ciudad("Madrid", 1000000);
		Ciudad Malaga = new Ciudad("Malaga",50000 );
		Ciudad Sevilla = new Ciudad("Sevilla", 80000);
		
		String contenidoJenkinsfile = 
				"pipeline {\n" +
                        "    agent any\n" +
                        "    stages {\n" +
                        "        stage('Barcelona') {\n" +
                        "            steps {\n" +
                        "                script {\n" +
                        "                    echo 'La ciudad de " + Barcelona.nombre + " tiene una poblacion de " + Barcelona.poblacion_final() + "'\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "        stage('Madrid') {\n" +
                        "            steps {\n" +
                        "                script {\n" +
                        "                    echo 'La ciudad de " + Madrid.nombre + " tiene una poblacion de " + Madrid.poblacion_final() + "'\n"+
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "         stage('Malaga') {\n" +
                        "            steps {\n" +
                        "                script {\n" +
                        "                    echo 'La ciudad de " + Malaga.nombre + " (la mejor de todas) tiene una poblacion de " + Malaga.poblacion_final() + "'\n"+
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "		stage('Sevilla') {\n" +
                        "            steps {\n" +
                        "                script {\n" +
                        "                    echo 'La ciudad de " + Sevilla.nombre + " tiene una poblacion de " + Sevilla.poblacion_final() + "'\n"+
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
		
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("Jenkinsfile"));
			{
				pw.write(contenidoJenkinsfile);
				System.out.println("Se genero el Jenkinsfile");
			} 
			
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
