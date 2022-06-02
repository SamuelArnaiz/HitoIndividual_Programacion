package cuestion1;

public class ModelX extends Tesla{

	private boolean puertasAbatibles;

	public ModelX(String motor, int ruedas, int asientos, boolean encendido, String bateria, String software,
			double autonomia, boolean puertasAbatibles) {
		super(motor, ruedas, asientos, encendido, bateria, software, autonomia);
		this.puertasAbatibles = puertasAbatibles;
	}

	public boolean isPuertasAbatibles() {
		return puertasAbatibles;
	}

	public void setPuertasAbatibles(boolean puertasAbatibles) {
		this.puertasAbatibles = puertasAbatibles;
	}

	@Override
	public String toString() {
		return super.toString()+"ModelX [puertasAbatibles=" + puertasAbatibles + "]";
	}
	
	
}
