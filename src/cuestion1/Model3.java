package cuestion1;

public class Model3 extends Tesla{

	private boolean volante2_0;

	public Model3(String motor, int ruedas, int asientos, boolean encendido, String bateria, String software,
			double autonomia, boolean volante2_0) {
		super(motor, ruedas, asientos, encendido, bateria, software, autonomia);
		this.volante2_0 = volante2_0;
	}

	@Override
	public void actualizar() {
		System.out.println("Model 3 actualizado");
	}

	@Override
	public String toString() {
		return super.toString()+"Model3 [volante2_0=" + volante2_0 + "]";
	}
	
	
}
