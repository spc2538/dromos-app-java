package streets.objetos;
import streets.utilidad.*;
public class Vehiculo {
	public Vehiculo siguiente;
	public Vector2f ubicacion;
	public float avR;
	public float avI;
	public float av;

	public float incXi;
	public float incYi;
	public float incXr;
	public float incYr;

	public float dx;
	public float dy;

	public int rel;
	public Vehiculo(Vector2f ubicacion, Vector2f posig) {
		float k;
		this.ubicacion = new Vector2f(ubicacion.x, ubicacion.y);
		dx = posig.x - ubicacion.x;
		dy = posig.y - ubicacion.y;
		if (dy >= 0)
			incYi = 0.01f;
		else {
			incYi = -0.01f;
			dy = -dy;
		}
		if (dx >= 0)
			incXi = 0.01f;
		else {
			incXi = -0.01f;
			dx = -dx;
		}

		if (dx >= dy) {
			incYr = 0;
			incXr = incXi;
		} else {
			incXr = 0;
			incYr = incYi;
			k = dx;
			dx = dy;
			dy = k;
		}
		avR = 2 * dy;
		av = avR - dx;
		avI = av - dx;
		this.rel = 0;
		siguiente = null;
	}
}
