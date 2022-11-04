package streets.hilos;
import streets.utilidad.*;
import streets.objetos.*;
public class Interruptor implements Runnable {
	public Direccion norte14sur_a_sanClaudio;
	public Direccion norte14sur_a_sanClaudioCU;
	public Direccion norte14sur_a_sur14sur;
	public Direccion sur14sur_a_sanClaudio;
	public Direccion sur14sur_a_sanClaudioCU;
	public Direccion sur14sur_a_norte14sur;
	public Direccion sanClaudio_a_sur14sur;
	public Direccion sanClaudio_a_norte14sur;

	public Thread entidad;
	public int estado1;
	public int estado2;
	public Interruptor(Direccion norte14sur_a_sanClaudio, Direccion norte14sur_a_sanClaudioCU, Direccion norte14sur_a_sur14sur,
	                   Direccion sur14sur_a_sanClaudio, Direccion sur14sur_a_sanClaudioCU, Direccion sur14sur_a_norte14sur,
	                   Direccion sanClaudio_a_sur14sur, Direccion sanClaudio_a_norte14sur) {

		this.norte14sur_a_sanClaudio = norte14sur_a_sanClaudio;
		this.norte14sur_a_sanClaudioCU = norte14sur_a_sanClaudioCU;
		this.norte14sur_a_sur14sur = norte14sur_a_sur14sur;

		this.sur14sur_a_sanClaudio = sur14sur_a_sanClaudio;
		this.sur14sur_a_sanClaudioCU = sur14sur_a_sanClaudioCU;
		this.sur14sur_a_norte14sur = sur14sur_a_norte14sur;

		this.sanClaudio_a_sur14sur = sanClaudio_a_sur14sur;
		this.sanClaudio_a_norte14sur = sanClaudio_a_norte14sur;

		entidad = new Thread(this);
		entidad.start();
		estado1 = -1;
		estado2 = 0;
	}
	public void reposo(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		while (true) {
			reposo(8000);
			norte14sur_a_sur14sur.cambiarEstado();
			sur14sur_a_norte14sur.cambiarEstado();
			reposo(2000);
			norte14sur_a_sur14sur.cambiarEstado();
			sur14sur_a_norte14sur.cambiarEstado();
			sanClaudio_a_sur14sur.cambiarEstado();
			sanClaudio_a_norte14sur.cambiarEstado();

			reposo(8000);
			sanClaudio_a_sur14sur.cambiarEstado();
			sur14sur_a_sanClaudio.cambiarEstado();
			sur14sur_a_sanClaudioCU.cambiarEstado();
			reposo(3000);
			sanClaudio_a_sur14sur.cambiarEstado();
			
			norte14sur_a_sur14sur.cambiarEstado();
			norte14sur_a_sanClaudio.cambiarEstado();
			norte14sur_a_sanClaudioCU.cambiarEstado();
			
			sur14sur_a_sanClaudio.cambiarEstado();
			sur14sur_a_sanClaudioCU.cambiarEstado();

			reposo(8000);
			sanClaudio_a_norte14sur.cambiarEstado();
			norte14sur_a_sanClaudio.cambiarEstado();
			norte14sur_a_sanClaudioCU.cambiarEstado();
			reposo(3000);
			sanClaudio_a_norte14sur.cambiarEstado();
			norte14sur_a_sanClaudio.cambiarEstado();
			norte14sur_a_sanClaudioCU.cambiarEstado();
			sur14sur_a_norte14sur.cambiarEstado();
			sur14sur_a_sanClaudio.cambiarEstado();
			sur14sur_a_sanClaudioCU.cambiarEstado();
		}
	}
}