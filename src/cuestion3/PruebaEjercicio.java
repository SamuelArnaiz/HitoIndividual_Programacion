package cuestion3;

import java.sql.*;
import cuestion2.Utilidades;

public class PruebaEjercicio {

	public static void main(String[] args) {

		Connection conn = conexionBBDD();
		
		int menu = 0;
		
		do {
			System.out.println("MENU DE GESTIÓN DE PRODUCTOS");
			System.out.println("----------------------------");
			System.out.println("Seleccione una opción: ");
			System.out.println("1. Añadir un producto.");
			System.out.println("2. Eliminar un producto");
			System.out.println("3. Modificar un producto");
			System.out.println("4. Mostrar Producto");
			System.out.println("5. SALIR");
			
			do {
				menu=Utilidades.pedirEntero("OPCIÓN:");
				if(menu<=0||menu>5) {
					System.out.println("Opción no válida");
				}
			}while(menu<=0||menu>5);
			
			switch (menu) {
			case 1:
				insertar();
				break;
			case 2:
				eliminar();
				break;
			case 3:
				modificar();
				break;
			case 4:
				try {
					mostrarDatos(conn);
				}catch(NullPointerException e) {
					System.out.println("Problema con la conexión, saliendo del programa...");
					System.exit(0);
				}
				break;
			case 5: 
				System.out.println("SALIENDO DEL PROGRAMA...");
				break;
			default:
				break;
			}
		}while (menu<5&&menu>=0);
	}
	/**
	 * En un futuro se podría integrar para pedir por pantalla la conexion
	 * @return una conexión con la base de datos 
	 */
	public static Connection conexionBBDD() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/hito?useSSL=false";
			String user="root";
			String pws="root";
			Connection conn = DriverManager.getConnection(url,user,pws);
			return conn;
		} catch (ClassNotFoundException e) {
			Connection Connection = null;
			return Connection;
		} catch (SQLException e) {
			Connection Connection = null;
			return Connection;
		}
	}
	/**
	 * Muestra los datos de la BBDD a la que se conecta
	 * @param Objeto Connection de la BBDD
	 */
	public static void mostrarDatos(Connection c){
		
		try {
			
			Statement st= c.createStatement();
			st = c.createStatement();
			
			ResultSet r = st.executeQuery("SELECT * FROM productos");
			
			while(r.next()) {
				System.out.println("ID: " + r.getInt("idProducto"));
				System.out.println("Nombre: " + r.getString("nombre"));
				System.out.println("Fecha de Envasado: " + r.getDate("fechaEnvasado"));
				System.out.println("Unidades: " + r.getInt("unidades"));
				System.out.println("Precio: " + r.getFloat("precio"));
				System.out.println("Disponible: "+ r.getBoolean("disponible"));
				System.out.println("--------------------------------------");
			}
		} catch (SQLException e) {
			System.out.println("Problemas con la conexión a la BBDD");
		}
	}
	
	public static void insertar() {
		
	}
	
	public static void eliminar() {
		
	}
	private static void modificar() {
		// TODO Auto-generated method stub
		
	}

}
