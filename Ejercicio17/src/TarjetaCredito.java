import java.time.LocalDateTime;

public class TarjetaCredito {
	
	double saldoGastado;
	LocalDateTime fechaVencimiento;
	
	public TarjetaCredito()
	{
		this.saldoGastado = 0;
		this.fechaVencimiento = null;
	}
	
	public TarjetaCredito(double saldoGastado, LocalDateTime fechaVencimiento)
	{
		this.saldoGastado = saldoGastado;
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getSaldoGastado() {
		return saldoGastado;
	}

	public void setSaldoGastado(double saldoGastado) {
		this.saldoGastado = saldoGastado;
	}

	public LocalDateTime getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	

}
