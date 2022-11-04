package streets.utilidad;
import java.awt.*;
import streets.utilidad.*;
import streets.objetos.*;
import streets.hilos.*;
public class Direccion {
	public Vehiculo fin;
	public int initx;
	public int inity;
	public int avanzeX;
	public int avanzeY;
	public Vector2f[] direccion;
	public Semaforo ubicacionSemaforo;
	public Direccion(Vector2f[] direccion, Semaforo ubicacionSemaforo) {
		fin = null;
		this.ubicacionSemaforo = ubicacionSemaforo;
		this.avanzeX = 1;
		this.avanzeY = 1;
		this.direccion = direccion;
	}
	public synchronized void cambiarEstado() {
		ubicacionSemaforo.estado = (ubicacionSemaforo.estado + 1) % 3;
		if (ubicacionSemaforo.estado == 0) {
			ubicacionSemaforo.r = 115;
			ubicacionSemaforo.g = 210;
			ubicacionSemaforo.b = 22;
		} else if (ubicacionSemaforo.estado == 2) {
			ubicacionSemaforo.r = 239;
			ubicacionSemaforo.g = 41;
			ubicacionSemaforo.b = 41;
		} else {
			ubicacionSemaforo.r = 252;
			ubicacionSemaforo.g = 233;
			ubicacionSemaforo.b = 79;
		}
	}
	public synchronized void insertarVehiculo() {
		Vehiculo noob = new Vehiculo(direccion[0], direccion[1]);
		new Conductor(this, noob);
		if (fin == null) {
			fin = noob;
			noob.siguiente = null;
		} else {
			noob.siguiente = fin;
			fin = noob;
		}
	}
	public synchronized void eliminarVehiculo(Vehiculo vehiculo) {
		Vehiculo aux = fin;
		while (aux.siguiente != vehiculo)
			aux = aux.siguiente;
		aux.siguiente = null;
	}
	public synchronized boolean comprobarEstado(Vehiculo vehiculo) {
		if (vehiculo.ubicacion.x == this.direccion[direccion.length - 1].x && vehiculo.ubicacion.y == this.direccion[direccion.length - 1].y) {
			return false;
		} else
			return true;
	}
	public synchronized boolean desplazarVehiculo(Vehiculo vehiculo) {
		boolean dev;
		float top = 0.04f;
		if ((vehiculo.ubicacion.x >= (this.ubicacionSemaforo.ubicacion.x - 0.04f) && vehiculo.ubicacion.x <= (this.ubicacionSemaforo.ubicacion.x + 0.04f)) && (vehiculo.ubicacion.y >= (this.ubicacionSemaforo.ubicacion.y - 0.04f) && vehiculo.ubicacion.y <= (this.ubicacionSemaforo.ubicacion.y + 0.04f)) && ubicacionSemaforo.estado == 2) {
			//nothing			
		} else if(((vehiculo.ubicacion.x >= (this.ubicacionSemaforo.ubicacion.x - 0.04f) && vehiculo.ubicacion.x <= (this.ubicacionSemaforo.ubicacion.x + 0.04f)) && (vehiculo.ubicacion.y >= (this.ubicacionSemaforo.ubicacion.y - 0.04f) && vehiculo.ubicacion.y <= (this.ubicacionSemaforo.ubicacion.y + 0.04f)) && ubicacionSemaforo.estado == 1)){
			
		}
		else{
			if (vehiculo.siguiente == null) {
				if (vehiculo.av >= 0) {
					vehiculo.ubicacion.x = vehiculo.ubicacion.x + vehiculo.incXi;
					vehiculo.ubicacion.y = vehiculo.ubicacion.y + vehiculo.incYi;
					vehiculo.av = vehiculo.av + vehiculo.avI;
				} else {
					vehiculo.ubicacion.x = vehiculo.ubicacion.x + vehiculo.incXr;
					vehiculo.ubicacion.y = vehiculo.ubicacion.y + vehiculo.incYr;
					vehiculo.av = vehiculo.av + vehiculo.avR;
				}
			} else {

				if ((vehiculo.ubicacion.x >= (vehiculo.siguiente.ubicacion.x - top) && vehiculo.ubicacion.x <= (vehiculo.siguiente.ubicacion.x + top)) && (vehiculo.ubicacion.y >= (vehiculo.siguiente.ubicacion.y - top) && vehiculo.ubicacion.y <= (vehiculo.siguiente.ubicacion.y + top))) {
					//nothing
				} else {
					if (vehiculo.av >= 0) {
						vehiculo.ubicacion.x = vehiculo.ubicacion.x + vehiculo.incXi;
						vehiculo.ubicacion.y = vehiculo.ubicacion.y + vehiculo.incYi;
						vehiculo.av = vehiculo.av + vehiculo.avI;
					} else {
						vehiculo.ubicacion.x = vehiculo.ubicacion.x + vehiculo.incXr;
						vehiculo.ubicacion.y = vehiculo.ubicacion.y + vehiculo.incYr;
						vehiculo.av = vehiculo.av + vehiculo.avR;
					}

				}
			}
		}

		if ((vehiculo.ubicacion.x >= (this.direccion[direccion.length - 1].x - top) && vehiculo.ubicacion.x <= (this.direccion[direccion.length - 1].x + top)) && (vehiculo.ubicacion.y >= (this.direccion[direccion.length - 1].y - top) && vehiculo.ubicacion.y <= (this.direccion[direccion.length - 1].y + top))) {
			dev = false;
			vehiculo.ubicacion.x = 3.0f;
			vehiculo.ubicacion.y = 3.0f;
		} else {
			dev = true;
			if ( (vehiculo.ubicacion.x >= (this.direccion[vehiculo.rel + 1].x - top) && vehiculo.ubicacion.x <= (this.direccion[vehiculo.rel + 1].x + top)) && (vehiculo.ubicacion.y >= (this.direccion[vehiculo.rel + 1].y - top) && vehiculo.ubicacion.y <= (this.direccion[vehiculo.rel + 1].y + top)) ) {
				vehiculo.rel++;
				vehiculo.dx = direccion[vehiculo.rel + 1].x - vehiculo.ubicacion.x;
				vehiculo.dy = direccion[vehiculo.rel + 1].y - vehiculo.ubicacion.y;
				if (vehiculo.dy >= 0)
					vehiculo.incYi = 0.01f;
				else {
					vehiculo.incYi = -0.01f;
					vehiculo.dy = -vehiculo.dy;
				}
				if (vehiculo.dx >= 0)
					vehiculo.incXi = 0.01f;
				else {
					vehiculo.incXi = -0.01f;
					vehiculo.dx = -vehiculo.dx;
				}

				if (vehiculo.dx >= vehiculo.dy) {
					vehiculo.incYr = 0;
					vehiculo.incXr = vehiculo.incXi;
				} else {
					float k;
					vehiculo.incXr = 0;
					vehiculo.incYr = vehiculo.incYi;
					k = vehiculo.dx;
					vehiculo.dx = vehiculo.dy;
					vehiculo.dy = k;
				}
				vehiculo.avR = 2 * vehiculo.dy;
				vehiculo.av = vehiculo.avR - vehiculo.dx;
				vehiculo.avI = vehiculo.av - vehiculo.dx;
			}
		}
		return dev;

	}
	public synchronized void pintar(Graphics g, Matrix3x3f view) {
		Vector2f S, R;
		Vector2f filo = new Vector2f(0.00000001f, 0.00000001f);
		Vector2f sem = view.mul(this.ubicacionSemaforo.ubicacion);
		R = view.mul(filo);

		Vehiculo aux = fin;
		g.setColor(new Color(ubicacionSemaforo.r, ubicacionSemaforo.g, ubicacionSemaforo.b));
		g.fillOval((int)sem.x, (int)sem.y, 10, 10 );
		g.setColor(new Color(255, 255, 255));
		while (aux != null) {
			S = view.mul(aux.ubicacion);
			g.fillOval((int)S.x, (int)S.y, 7, 7 );
			aux = aux.siguiente;
		}
	}
}