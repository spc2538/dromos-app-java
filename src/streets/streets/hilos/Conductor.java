package streets.hilos;
import java.security.SecureRandom;
import streets.utilidad.*;
import streets.objetos.*;
public class Conductor implements Runnable {
	public SecureRandom aleatorios = new SecureRandom();
	public Direccion miDireccion;
	public Vehiculo miAuto;
	public Thread entidad;
	boolean corre;
	public Conductor(Direccion miDireccion, Vehiculo auto) {
		this.miDireccion = miDireccion;
		miAuto = auto;
		entidad = new Thread(this);
		entidad.start();
		corre = true;
	}
	public void reposo(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		
		while (corre) {
			reposo(60);
			corre = miDireccion.desplazarVehiculo(miAuto);
		}
	}
}