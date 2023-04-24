import java.util.Date;

public class Empleado extends Persona implements iSalario{

	String posicion;
	int salario;
	Date fecha_ingreso;
	
	public void salario_neto()
	{
		double salario_neto = salario * 0.8;

	}
}
