package cuestion3;

import java.sql.*;
import java.time.LocalDate;

import cuestion2.Utilidades;

public class PruebaEjercicio {

	public static void main(String[] args) {

		Connection conn = conexionBBDD();
		
		int menu = 0;
		
		do {
			System.out.println("MENU DE GESTI�N DE PRODUCTOS");
			System.out.println("----------------------------");
			System.out.println("Seleccione una opci�n: ");
			System.out.println("1. A�adir un producto.");
			System.out.println("2. Eliminar un producto");
			System.out.println("3. Modificar un producto");
			System.out.println("4. Mostrar Producto");
			System.out.println("5. SALIR");
			
			do {
				menu=Utilidades.pedirEntero("OPCI�N:");
				if(menu<=0||menu>5) {
					System.out.println("Opci�n no v�lida");
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
					System.out.println("Problema con la conexi�n, saliendo del programa...");
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
	 * En un futuro se podr�a integrar para pedir por pantalla la conexion
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
			System.out.println("Problemas con la conexi�n a la BBDD");
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
			int year = Utilidades.pedirYear("Dime el a�o de envasado:");
			int mes = Utilidades.pedirMes("Dame el mes de envasado:");
			int dia = Utilidades.pedirDia("Dime el d�a de envasado:", mes, year);
			LocalDate fechaEnvasado = LocalDate.of(year,mes,dia);
			int unidades = Utilidades.pedirEntero("�De cu�ntas unidades se disponen?");
			double precio = Utilidades.pedirDecimal("�Cu�l es su precio?");
			boolean disponible;
			
			if(Utilidades.pedirChar("El producto est� disponible en almacen? s|n")=='s') {
				disponible = true;
			}else disponible = false;
			
			String add = "INSERT INTO productos(nombre,fechaEnvasado,unidades,precio,disponible) VALUES('"+ nombre
					+"','"+ fechaEnvasado+"',"+unidades+","+precio +","+ disponible+")";
			int result = st.executeUpdate(add);
			if(result == 1) {
				System.out.println("A�adido el registro");
			}else System.out.println("No se ha podido a�adir");
			
		} catch (SQLException e) {
			System.out.println("Problema con la conexi�n a la BBDD");
		}
	}
	/**
	 * Elimina productos seg�n su id
	 * @param Connection con la BBDD
	 */
	public static void eliminar(Connection c) {
		int id=Utilidades.pedirEntero("�Que id de Producto quieres eliminar?");
		
		try {
			Statement st = c.createStatement();
			
			String del = "DELETE FROM productos WHERE idProducto="+id;
			int afected = st.executeUpdate(del);
			if (afected==0) {
				System.out.println("No hay ning�n registro con ese id");
			}else System.out.println("Productos afectados: " + afected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	private static void modificar(Connection c) {
		int id = Utilidades.pedirEntero("Dame el id del producto que quieras modificar: ");
		
		try {
			Statement st = c.createStatement();
			ResultSet r = st.executeQuery("SELECT * FROM productos where idProducto= "+ id);
			if(r.next()) {
				do {
					System.out.println("ID: " + r.getInt("idProducto"));
					System.out.println("Nombre: " + r.getString("nombre"));
					System.out.println("Fecha de Envasado: " + r.getDate("fechaEnvasado"));
					System.out.println("Unidades: " + r.getInt("unidades"));
					System.out.println("Precio: " + r.getFloat("precio"));
					System.out.println("Disponible: "+ r.getBoolean("disponible"));
					System.out.println("--------------------------------------");
				}while(r.next());
			}else {
				System.out.println("No hay ning�n art�culo con este id");
				return;
			}
			int opcion;
			System.out.println("�Qu� quieres cambiar?");
			System.out.println("1. Nombre.");
			System.out.println("2. Fecha de Envasado.");
			System.out.println("3.Unidades.");
			System.out.println("4.Precio.");
			System.out.println("5.Disponibilidad.");
			System.out.println("6.Todos los datos.");
			
			do {
				opcion=Utilidades.pedirEntero("");
				if(opcion<1||opcion>6) {
					System.out.println("Valor incorrecto");
				}
			}while(opcion<1||opcion>6);
			
			switch (opcion) {
			case 1: //NOMBRE
				String nuevoNombre=Utilidades.pedirTexto("Dame el nombre: ");
				String updNombre = "UPDATE productos set nombre='"+nuevoNombre + "' where idproducto="+id;
				int registro = st.executeUpdate(updNombre);
				if(registro==1) {
					System.out.println("Modificado correctamente");
				}
				break;
			case 2: //FECHA ENVASADO
				int year = Utilidades.pedirYear("Dime el a�o de envasado:");
				int mes = Utilidades.pedirMes("Dame el mes de envasado:");
				int dia = Utilidades.pedirDia("Dime el d�a de envasado:", mes, year);
				LocalDate fechaEnvasado = LocalDate.of(year,mes,dia);
				String updFecha = "UPDATE productos set fechaEnvasado='"+fechaEnvasado + "' where idproducto="+id;
				int result = st.executeUpdate(updFecha);
				if(result==1) {
					System.out.println("Modificado correctamente");
				}
				break;
			case 3: //UNIDADES
				int nuevUnid=Utilidades.pedirEntero("�Cu�ntas unidades?");
				String updUnid = "UPDATE productos set unidades="+nuevUnid+ " where idproducto="+id;
				result = st.executeUpdate(updUnid);
				if(result==1) {
					System.out.println("Modificado correctamente");
				}
				break;
			case 4: //PRECIO
				double nuevPrecio=Utilidades.pedirDecimal("Dame el nuevo precio: ");
				String updPrecio = "UPDATE productos set precio="+nuevPrecio+ " where idproducto="+id;
				result = st.executeUpdate(updPrecio);
				if(result==1) {
					System.out.println("Modificado correctamente");
				}
				break;
			case 5: //Disponibilidad
				String nuevDisp = Utilidades.pedirTexto("Disponibilidad del producto: s|n : ");
				boolean nuevDisp1=false;
				if(nuevDisp.equalsIgnoreCase("S")) {
					nuevDisp1 = true;
				}
				String updDisp = "UPDATE productos set disponible="+nuevDisp1+ " where idproducto="+id;
				result = st.executeUpdate(updDisp);
				if(result==1) {
					System.out.println("Modificado correctamente");
				}
				break;
			case 6:	//MODIFICAR TODO
				//NOMBRE
				nuevoNombre=Utilidades.pedirTexto("Dame el nombre: ");
				//Fecha Envasado
				year = Utilidades.pedirYear("Dime el a�o de envasado:");
				mes = Utilidades.pedirMes("Dame el mes de envasado:");
				dia = Utilidades.pedirDia("Dime el d�a de envasado:", mes, year);
				fechaEnvasado = LocalDate.of(year,mes,dia);
				//UNIDADES
				nuevUnid=Utilidades.pedirEntero("�Cu�ntas unidades?");
				//PRECIO
				nuevPrecio=Utilidades.pedirDecimal("Dame el nuevo precio: ");
				//DISPONIBLE
				nuevDisp = Utilidades.pedirTexto("Disponibilidad del producto: s|n : ");
				nuevDisp1=false;
				if(nuevDisp.equalsIgnoreCase("S")) {
					nuevDisp1 = true;
				}
				
				String updTodo = "UPDATE productos set nombre'" + nuevoNombre + "', fechaEnvasado='" + fechaEnvasado + "', unidades="+ nuevUnid+ ", precio="+ nuevPrecio
						+ ", disponible=" + nuevDisp1+" where idProducto="+id;
				result = st.executeUpdate(updTodo);
				if(result==1) {
					System.out.println("Modificado correctamente");
				}
			default:
				break;
			}
			
		} catch (SQLException e) {
			System.out.println("Problema con la conexi�n");
		}
	}

}
