package streets.utilidad;
public class Matrix3x3f {
	private float[][] m = new float[ 3 ][ 3 ];
	public Matrix3x3f() {
	}
	public Matrix3x3f( float[][] m ) {
		setMatrix( m );
	}
	public Matrix3x3f mul( Matrix3x3f m1 ) {
		return new Matrix3x3f( new float[][] {
			{
				this.m[ 0 ][ 0 ] * m1.m[ 0 ][ 0 ] // ******
				+ this.m[ 0 ][ 1 ] * m1.m[ 1 ][ 0 ] // M[0,0]
				+ this.m[ 0 ][ 2 ] * m1.m[ 2 ][ 0 ], // ******
				this.m[ 0 ][ 0 ] * m1.m[ 0 ][ 1 ] // ******
				+ this.m[ 0 ][ 1 ] * m1.m[ 1 ][ 1 ] // M[0,1]
				+ this.m[ 0 ][ 2 ] * m1.m[ 2 ][ 1 ], // ******
				this.m[ 0 ][ 0 ] * m1.m[ 0 ][ 2 ] // ******
				+ this.m[ 0 ][ 1 ] * m1.m[ 1 ][ 2 ] // M[0,2]
				+ this.m[ 0 ][ 2 ] * m1.m[ 2 ][ 2 ]
			},// ******
			{
				this.m[ 1 ][ 0 ] * m1.m[ 0 ][ 0 ] // ******
				+ this.m[ 1 ][ 1 ] * m1.m[ 1 ][ 0 ] // M[1,0]
				+ this.m[ 1 ][ 2 ] * m1.m[ 2 ][ 0 ], // ******
				this.m[ 1 ][ 0 ] * m1.m[ 0 ][ 1 ] // ******
				+ this.m[ 1 ][ 1 ] * m1.m[ 1 ][ 1 ] // M[1,1]
				+ this.m[ 1 ][ 2 ] * m1.m[ 2 ][ 1 ], // ******
				this.m[ 1 ][ 0 ] * m1.m[ 0 ][ 2 ] // ******
				+ this.m[ 1 ][ 1 ] * m1.m[ 1 ][ 2 ] // M[1,2]
				+ this.m[ 1 ][ 2 ] * m1.m[ 2 ][ 2 ]
			},// ******
			{
				this.m[ 2 ][ 0 ] * m1.m[ 0 ][ 0 ] // ******
				+ this.m[ 2 ][ 1 ] * m1.m[ 1 ][ 0 ] // M[2,0]
				+ this.m[ 2 ][ 2 ] * m1.m[ 2 ][ 0 ], // ******
				this.m[ 2 ][ 0 ] * m1.m[ 0 ][ 1 ] // ******
				+ this.m[ 2 ][ 1 ] * m1.m[ 1 ][ 1 ] // M[2,1]
				+ this.m[ 2 ][ 2 ] * m1.m[ 2 ][ 1 ], // ******
				this.m[ 2 ][ 0 ] * m1.m[ 0 ][ 2 ] // ******
				+ this.m[ 2 ][ 1 ] * m1.m[ 1 ][ 2 ] // M[2,2]
				+ this.m[ 2 ][ 2 ] * m1.m[ 2 ][ 2 ]
			} // ******
		});
	}
	public void setMatrix( float[][] m ) {
		this.m = m;
	}
	public static Matrix3x3f translate( float x, float y ) {
		return new Matrix3x3f( new float[][] {
			{ 1.0f, 0.0f, 0.0f },
			{ 0.0f, 1.0f, 0.0f },
			{ x, y, 1.0f }
		});
	}
	public static Matrix3x3f scale( float x, float y ) {
		return new Matrix3x3f( new float[][] {
			{ x, 0.0f, 0.0f },
			{ 0.0f, y, 0.0f },
			{ 0.0f, 0.0f, 1.0f }
		});
	}
	public Vector2f mul( Vector2f vec ) {
		return new Vector2f(
		           vec.x * this.m[ 0 ][ 0 ] //
		           + vec.y * this.m[ 1 ][ 0 ] // V.x
		           + vec.w * this.m[ 2 ][ 0 ],//
		           vec.x * this.m[ 0 ][ 1 ] //
		           + vec.y * this.m[ 1 ][ 1 ] // V.y
		           + vec.w * this.m[ 2 ][ 1 ],//
		           vec.x * this.m[ 0 ][ 2 ] //
		           + vec.y * this.m[ 1 ][ 2 ] // V.w
		           + vec.w * this.m[ 2 ][ 2 ] //
		       );
	}
}