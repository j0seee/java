package aspecto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeLoggerAspect 
{
	@Before("execution (* registro.Registro.registroDeUsuario())")
	public void avisar()
	{
		System.out.println("--------Se está ejecutando la función registroDeUsuario-------");
		System.out.println();
	}
	
	@Around("execution (* registro.Registro.registroDeUsuario())")
	public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable
	{
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		System.out.println("Tiempo de ejecución de la funcion: " + (endTime - startTime));
		return result;
	}
	
	@After("execution (* registro.Registro.registroDeUsuario())")
	public void finDePrograma()
	{
		System.out.println();
		System.out.println("---El programa ha finalizado su uso---");
	}
}