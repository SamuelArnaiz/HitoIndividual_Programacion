package cuestion1;

public class Coche {

	private String motor;
	private int ruedas;
	private int asientos;
	private boolean encendido;
	
	public Coche(String motor, int ruedas, int asientos, boolean encendido) {
		super();
		this.motor = motor;
		this.ruedas = ruedas;
		this.asientos = asientos;
		this.encendido = encendido;
	}

	public String getMotor() {
		return motor;
	}


	public void setMotor(String motor) {
		this.motor = motor;
	}


	public int getRuedas() {
		return ruedas;
	}


	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}


	public int getAsientos() {
		return asientos;
	}


	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}


	public boolean isEncendido() {
		return encendido;
	}


	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}


	public void encender() {
		this.encendido=true;
	}
	public void apagar() {
		this.encendido=false;
	}

	@Override
	public String toString() {
		return "Coche [motor=" + motor + ", ruedas=" + ruedas + ", asientos=" + asientos + ", encendido=" + encendido
				+ "]";
	}
	
	
}
