package cuestion1;

public class ModelS extends Tesla{

	private int velocidadPunta;

	public ModelS(String motor, int ruedas, int asientos, boolean encendido, String bateria, String software,
			double autonomia, int velocidadPunta) {
		super(motor, ruedas, asientos, encendido, bateria, software, autonomia);
		this.velocidadPunta = velocidadPunta;
	}

	public int getVelocidadPunta() {
		return velocidadPunta;
	}

	public void setVelocidadPunta(int velocidadPunta) {
		this.velocidadPunta = velocidadPunta;
	}

	@Override
	public String toString() {
		return super.toString()+"ModelS [velocidadPunta=" + velocidadPunta + "]";
	}
	
	
}
