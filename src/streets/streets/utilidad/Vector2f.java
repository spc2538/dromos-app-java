package streets.utilidad;
public class Vector2f {
	public float x;
	public float y;
	public float w;
	public Vector2f() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.w = 1.0f;
	}
	public Vector2f( Vector2f v ) {
		this.x = v.x;
		this.y = v.y;
		this.w = 1.0f;
	}
	public Vector2f( float x, float y ) {
		this.x = x;
		this.y = y;
		this.w = 1.0f;
	}
	public Vector2f( float x, float y, float w ) {
		this.x = x;
		this.y = y;
		this.w = w; //!?!
	}
}