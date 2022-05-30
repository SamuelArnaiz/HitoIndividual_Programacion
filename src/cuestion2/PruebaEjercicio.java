package cuestion2;
import java.io.*;

public class PruebaEjercicio {

	public static void main(String[] args) {
		
		double nota=0;
		File preguntas = new File("Documentos/preguntas.txt");
		File respuestas = new File("Documentos/respuestas.txt");
		
		if(preguntas.exists()&&respuestas.exists()) {
			
			try {
				FileReader frp = new FileReader(preguntas); //Archivo de las preguntas
				FileReader frr = new FileReader(respuestas); //Archivo de las respuestas
				
				BufferedReader brp = new BufferedReader(frp); //Bufer para las preguntas
				BufferedReader brr = new BufferedReader(frr); //Bufer para las respuestas
				
				String pregunta = brp.readLine();
				String respuesta = brr.readLine();
				
				while(pregunta!=null) {

					System.out.println(pregunta);
					
					String resp = Utilidades.pedirTexto("");
					if(resp.equalsIgnoreCase(respuesta)) {	//Si la respuesta es correcta se le suma un punto
						nota++;
					}else nota-=0.5; //Si no es correcta se resta 0.5
					
					pregunta = brp.readLine();
					respuesta = brr.readLine();
				}
				System.out.println("Has sacado un: " + nota);	//Impresión de la nota final
			}catch (IOException e) {
				System.out.println("Error en la ejecución");
			}
		}
	}

}
