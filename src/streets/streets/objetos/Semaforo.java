package streets.objetos;
import streets.utilidad.*;
public class Semaforo {
	public Vector2f ubicacion;
	public static int l = 10;
	public int estado;
	public int r;
	public int g;
	public int b;
	public int radio;
	public Semaforo(Vector2f a, int estado) {
		this.ubicacion = new Vector2f(a);
		this.estado = estado;
		if (estado == 0) {
			r = 115;
			g = 210;
			b = 22;
		}else{
			r = 239;
			g = 41;
			b = 41;
		}
		radio = l;
		l+=10;
	}
}