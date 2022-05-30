package cuestion3;

import java.sql.*;
import java.time.LocalDate;

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
				insertar(conn);
				break;
			case 2:
				eliminar(conn);
				break;
			case 3:
				modificar(conn);
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
	 * @return Connection con la base de datos 
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
			System.out.println("--------Registros------------");
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
	/**
	 * Inserta en la BBDD un registro
	 * @param Connection con BBDD
	 */
	public static void insertar(Connection c) {
		try {
			Statement st = c.createStatement();
			String nombre = Utilidades.pedirTexto("Dame el nombre de Producto: ");
			int year = Utilidades.pedirYear("Dime el año de envasado:");
			int mes = Utilidades.pedirMes("Dame el mes de envasado:");
			int dia = Utilidades.pedirDia("Dime el día de envasado:", mes, year);
			LocalDate fechaEnvasado = LocalDate.of(year,mes,dia);
			int unidades = Utilidades.pedirEntero("¿De cuántas unidades se disponen?");
			double precio = Utilidades.pedirDecimal("¿Cuál es su precio?");
			boolean disponible;
			
			if(Utilidades.pedirChar("El producto está disponible en almacen? s|n")=='s') {
				disponible = true;
			}else disponible = false;
			
			String add = "INSERT INTO productos (nombre,fechaEnvasado,unidades,precio,disponible) VALUES('"+ nombre
					+"','"+ fechaEnvasado+"',"+unidades+","+precio +","+ disponible+")";
			
			if(st.executeUpdate(add) == 1) {
				System.out.println("Añadido el registro");
			}else System.out.println("No se ha podido añadir");
			
		} catch (SQLException e) {
			System.out.println("Problema con la conexión a la BBDD");
		}
	}
	/**
	 * Elimina productos según su id
	 * @param Connection con la BBDD
	 */
	public static void eliminar(Connection c) {
		int id=Utilidades.pedirEntero("¿Que id de Producto quieres eliminar?");
		
		try {
			Statement st = c.createStatement();
			
			String del = "DELETE FROM productos WHERE idProducto="+id;
			int afected = st.executeUpdate(del);
			if (afected==0) {
				System.out.println("No hay ningún registro con ese id");
			}else System.out.println("Productos afectados: " + afected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	private static void modificar(Connection c) {
		
	}

}
