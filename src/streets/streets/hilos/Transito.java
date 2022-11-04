package streets.hilos;
import streets.simulacion.Simulacion;
import streets.utilidad.*;
import streets.objetos.*;
import java.security.SecureRandom;
public class Transito implements Runnable {
	public Thread entidad;
	public Direccion miDireccion;
	public SecureRandom aleatorios = new SecureRandom();
	public Transito(Direccion miDireccion) {
		this.miDireccion = miDireccion;
		entidad = new Thread(this);
		entidad.start();
	}
	public void run() {
		while (true) {
			miDireccion.insertarVehiculo();
			try {
				Thread.sleep(aleatorios.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}