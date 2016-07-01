import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Future;
import net.spy.memcached.MemcachedClient;

public class Data {
	private MemcachedClient mcc;
	private String datos;
	private Future fo; // object for use memcached
	private Observador[] vistas = new Observador[10]; // part of MVC

	public Data() throws IOException {
		
		//the memcached cliente, connecting to Memcached server on localhost
		mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211)); 
		datos = "";
	}

	/*
	 * Insert 5 different elements with a lapse of 2,8 seconds Each element has
	 * 30 second life
	 */
	public void IntroducirDatos() throws InterruptedException {
		// TODO Auto-generated method stub
		String aux = "ej";
		for (int i = 0; i < 5; i++) {
			fo = mcc.set(aux + i, 30, "Ejemplo " + i + " java"); // writing in memcached
																	
			Thread.sleep(2800);
		}
	}

	// MVC
	public void AnadirVista(Observador v) {
		// TODO Auto-generated method stub
		boolean metido = false;
		int indice = 0;
		while ((metido == false) && (indice < vistas.length)) {
			if (vistas[indice] == null) {
				vistas[indice] = v;
				metido = true;
			} else
				indice++;
		}
	}

	// Get elements from Memcached
	public String getDatos() {
		datos = "";
		String aux = "ej";
		int c = 0;
		for (int i = 0; i < 5; i++) {
			Object o = mcc.get(aux + i);
			if (o != null) {
				datos = datos + "clave: " + aux + i + "  valor: " + o + "\n";
				c++;
			}
		}
		if (c == 0)
			datos = "Memcached is empty! :(";
		for (Observador v : vistas) {
			if (v != null) {
				v.ActualizarDatos(datos);
			}
		}
		return this.datos;
	}

	// Close the client's conexion
	public void CerrarCon() {
		// TODO Auto-generated method stub
		if (mcc != null)
			mcc.shutdown();
	}
}
