package cuestion1;

import java.util.*;

public class PruebaTesla {

	public static void main(String[] args) {

		
		Model3 miModel3 = new Model3("electrico",4, 5, false, "RHDJKA2", "5.2", 600, true);
		
		Tesla miTesla = new Tesla("electrico", 4, 5, false);
		Tesla miTesla2 = new Tesla("Electrico", 6, 7, true, "JHIE-3", "6.2", 500);
		
		miModel3.encender();
		System.out.println(miModel3.isEncendido());
		
		miModel3.actualizar();
		
		//EJEMPLO DE LISTA
		ArrayList<Coche> misCoches = new ArrayList<Coche>();
		misCoches.add(miModel3);
		misCoches.add(miTesla);
		misCoches.add(miTesla2);
		System.out.println("ELEMENTOS DEL ARRAYLIST");
		System.out.println(misCoches);
		System.out.println("---------------------");
		//EJEMPLO DE PILA
		Stack<Coche> pila = new Stack<Coche>();
		pila.push(miModel3);
		pila.push(miTesla);
		pila.push(miTesla2);
		System.out.println("ELEMENTOS EN LA PILA");
		System.out.println(pila);
		System.out.println("---------------------");
		//EJEMPLO DE COLA
		ArrayDeque<Coche> cola = new ArrayDeque<Coche>();
		cola.add(miModel3);
		cola.add(miTesla);
		cola.add(miTesla2);
		System.out.println("ELEMENTOS EN LA COLA");
		System.out.println(cola);
		System.out.println("-----------------");
		//EJEMPLO DE VECTOR
		Vector<Coche> vector = new Vector<Coche>();
		vector.add(miModel3);
		vector.add(miTesla);
		vector.add(miTesla2);
		System.out.println("ELEMENTOS DEL VECTOR");
		System.out.println(vector);
	}
}
