package cuestion1;

public class ModelY extends Tesla{

	private boolean techoPanoramico;

	public ModelY(String motor, int ruedas, int asientos, boolean encendido, String bateria, String software,
			double autonomia, boolean techoPanoramico) {
		super(motor, ruedas, asientos, encendido, bateria, software, autonomia);
		this.techoPanoramico = techoPanoramico;
	}

	public boolean isTechoPanoramico() {
		return techoPanoramico;
	}

	public void setTechoPanoramico(boolean techoPanoramico) {
		this.techoPanoramico = techoPanoramico;
	}

	@Override
	public String toString() {
		return super.toString()+"ModelY [techoPanoramico=" + techoPanoramico + "]";
	}
	
	
	
}
