package cuestion2;
import java.io.*;

public class PruebaEjercicio {

	public static void main(String[] args) {
		
		double nota=0;
		File preguntas = new File("Documentos/preguntas.txt");
		File respuestas = new File("Documentos/respuestas.txt");
		
		if(preguntas.exists()&&respuestas.exists()) {
			
			try {
				FileReader frp = new FileReader(preguntas);
				FileReader frr = new FileReader(respuestas);
				
				BufferedReader brp = new BufferedReader(frp);
				BufferedReader brr = new BufferedReader(frr);
				
				String pregunta = brp.readLine();
				String respuesta = brr.readLine();
				
				while(pregunta!=null) {

					System.out.println(pregunta);
					
					String resp = Utilidades.pedirTexto("");
					if(resp.equalsIgnoreCase(respuesta)) {
						nota++;
					}else nota-=0.5;
					
					pregunta = brp.readLine();
					respuesta = brr.readLine();
				}
				System.out.println("Has sacado un: " + nota);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
