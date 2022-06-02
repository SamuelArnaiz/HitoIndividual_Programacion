package cuestion1;

public class Tesla extends Coche{

	private String bateria;
	private String software;
	private double autonomia;
	
	public Tesla(String motor, int ruedas, int asientos, boolean encendido, String bateria, String software,double autonomia) {
		super(motor, ruedas, asientos, encendido);
		this.bateria = bateria;
		this.software = software;
		this.autonomia = autonomia;
	}
	
	public Tesla(String motor, int ruedas, int asientos, boolean encendido) {
		super(motor, ruedas, asientos, encendido);
	}



	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	public void actualizar() {
		
	}

	@Override
	public String toString() {
		return super.toString()+"Tesla: [bateria=" + bateria + ", software=" + software + ", autonomia=" + autonomia + "]";
	}
	
}
