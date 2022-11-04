package streets.simulacion;
import streets.hilos.*;
import streets.utilidad.*;
import streets.objetos.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class Simulacion extends JFrame implements Runnable {
	public BufferStrategy bs;
	public volatile boolean ejecucion;
	public Thread entidad;
	public Canvas canvas;
	public Color colorDeFondo = Color.WHITE;
	public Color colorDelBorde = Color.LIGHT_GRAY;
	public Font fuente = new Font( "Courier New", Font.PLAIN, 14 );
	public String titulo = "PCYP";
	public float escalaDelBordeVentana = 0.8f;
	public int anchoVentana = 800;
	public int largoVentana = 600;
	public float anchoDelMundo = 2.0f;
	public float largoDelMundo = 2.0f;
	public long reposo = 10L;
	public boolean appMantenerRatio = false;

	public Semaforo semaforo_norte14sur_a_sanClaudio;
	public Semaforo semaforo_norte14sur_a_sanClaudioCU;
	public Semaforo semaforo_norte14sur_a_sur14sur;
	public Direccion norte14sur_a_sanClaudio;
	public Direccion norte14sur_a_sanClaudioCU;
	public Direccion norte14sur_a_sur14sur;

	public Semaforo semaforo_sur14sur_a_norte14sur;
	public Semaforo semaforo_sur14sur_a_sanClaudio;
	public Semaforo semaforo_sur14sur_a_sanClaudioCU;
	public Direccion sur14sur_a_norte14sur;
	public Direccion sur14sur_a_sanClaudio;
	public Direccion sur14sur_a_sanClaudioCU;


	public Semaforo semaforo_sanClaudio_a_sur14sur;
	public Semaforo semaforo_sanClaudio_a_norte14sur;
	public Direccion sanClaudio_a_sur14sur;
	public Direccion sanClaudio_a_norte14sur;


	public Simulacion() {

	}

	public void inicializar() {
		int estadoInicial = 0;
		titulo = "Simulacion";
		anchoVentana = 800;
		largoVentana = 600;
		semaforo_norte14sur_a_sanClaudio = new Semaforo(new Vector2f(-0.1439299f, 0.5459099f), 2);
		semaforo_norte14sur_a_sanClaudioCU = new Semaforo(new Vector2f(-0.17897367f, 0.58931553f), 2);
		semaforo_sanClaudio_a_sur14sur = new Semaforo(new Vector2f(-0.01627034f, 0.1519199f), 2);
		semaforo_sanClaudio_a_norte14sur = new Semaforo(new Vector2f(0.026282907f, 0.20534223f), 2);
		
		semaforo_norte14sur_a_sur14sur = new Semaforo(new Vector2f(-0.24405503f, 0.6126878f), 0);
		semaforo_sur14sur_a_norte14sur = new Semaforo(new Vector2f(-0.34668332f, 0.04841405f), 0);
		semaforo_sur14sur_a_sanClaudio = new Semaforo(new Vector2f(-0.2640801f, -0.08848071f), 0);
		semaforo_sur14sur_a_sanClaudioCU = new Semaforo(new Vector2f(-0.25907385f, -0.14190316f), 0);

		norte14sur_a_sanClaudio = new Direccion( new Vector2f[] {
		            new Vector2f(0.15644562f, 0.9966611f),
		            //vector que indica la ubicacion de su semaforo
		            new Vector2f(-0.1439299f, 0.5459099f),
		            new Vector2f(-0.19148934f, 0.39899832f),
		            new Vector2f(-0.19899875f, 0.30884808f),
		            new Vector2f(-0.19899875f, 0.22871453f),
		            new Vector2f(-0.18397999f, 0.1519199f),
		            new Vector2f(-0.13642049f, 0.041736245f),
		            new Vector2f(-0.098873556f, 0.0016694665f),
		            new Vector2f(0.99249065f, -0.6794658f)
		        }, semaforo_norte14sur_a_sanClaudio);
		
		norte14sur_a_sanClaudioCU = new Direccion(new Vector2f[] {
		            new Vector2f(0.08635795f, 0.9966611f),
		            new Vector2f(-0.17897367f, 0.58931553f),
		            new Vector2f(-0.20901126f, 0.53255427f),
		            new Vector2f(-0.23153943f, 0.48580968f),
		            new Vector2f(-0.24405503f, 0.42570955f),
		            new Vector2f(-0.26157695f, 0.32554257f),
		            new Vector2f(-0.25156444f, 0.25208682f),
		            new Vector2f(-0.23904878f, 0.15859771f),
		            new Vector2f(-0.22903627f, 0.115191996f),
		            new Vector2f(-0.1964956f, 0.04507518f),
		            new Vector2f(-0.16896117f, 0.0016694665f),
		            new Vector2f(-0.06883603f, -0.07846403f),
		            new Vector2f(0.08886111f, -0.18196988f),
		            new Vector2f(0.11639547f, -0.21535885f),
		            new Vector2f(0.12140179f, -0.2554257f),
		            new Vector2f(0.11138928f, -0.33555925f),
		            new Vector2f(0.06382978f, -0.4891485f),
		            new Vector2f(0.06883609f, -0.55592644f),
		            new Vector2f(0.091364264f, -0.5959933f),
		            new Vector2f(0.63704634f, -0.9899832f)
		        }, semaforo_norte14sur_a_sanClaudioCU);
		
		norte14sur_a_sur14sur = new Direccion(new Vector2f[] {
		                                          new Vector2f(0.026282907f, 0.9966611f),
		                                          new Vector2f(-0.24405503f, 0.6126878f),
		                                          new Vector2f(-0.99499375f, -0.4390651f)
		                                      }, semaforo_norte14sur_a_sur14sur);

		
		sur14sur_a_norte14sur = new Direccion(new Vector2f[] {
		                                          new Vector2f(-0.98748434f, -0.89649415f),
		                                          //semaforo
		                                          new Vector2f(-0.34668332f, 0.04841405f),
		                                          new Vector2f(0.2941177f, 1.0f)
		                                      }, semaforo_sur14sur_a_norte14sur);

		
		sur14sur_a_sanClaudio = new Direccion(new Vector2f[] {
		                                          new Vector2f(-0.98748434f, -0.9799665f),
		                                          new Vector2f(-0.40175217f, -0.1452421f),
		                                          new Vector2f(-0.34167707f, -0.10851419f),
		                                          //semaforo
		                                          new Vector2f(-0.2640801f, -0.08848071f),
		                                          new Vector2f(-0.16395491f, -0.071786284f),
		                                          new Vector2f(-0.05632037f, -0.081802964f),
		                                          new Vector2f(0.99249065f, -0.7429048f)
		                                      }, semaforo_sur14sur_a_sanClaudio);

		
		sur14sur_a_sanClaudioCU = new Direccion(new Vector2f[] {
		                                            new Vector2f(-0.9324155f, -0.9866444f),
		                                            new Vector2f(-0.3266583f, -0.17529213f),
		                                            //semaforo
		                                            new Vector2f(-0.25907385f, -0.14190316f),
		                                            new Vector2f(-0.18648309f, -0.12520862f),
		                                            new Vector2f(-0.10387981f, -0.1352253f),
		                                            new Vector2f(0.091364264f, -0.2554257f),
		                                            new Vector2f(0.11639547f, -0.3055091f),
		                                            new Vector2f(0.06382978f, -0.4891485f),
		                                            new Vector2f(0.07384229f, -0.55592644f),
		                                            new Vector2f(0.091364264f, -0.5959933f),
		                                            new Vector2f(0.63704634f, -0.9899832f)
		                                        }, semaforo_sur14sur_a_sanClaudioCU);
		
		sanClaudio_a_sur14sur = new Direccion(new Vector2f[] {
		                                          new Vector2f(0.9949938f, -0.48580968f),
		                                          //vector que indica la ubicacion de su semaforo
		                                          new Vector2f(-0.01627034f, 0.1519199f),
		                                          new Vector2f(-0.16145182f, 0.25208682f),
		                                          new Vector2f(-0.25156444f, 0.2754591f),
		                                          new Vector2f(-0.3266583f, 0.2754591f),
		                                          new Vector2f(-0.4192741f, 0.22537565f),
		                                          new Vector2f(-0.9924906f, -0.5759599f)
		                                      }, semaforo_sanClaudio_a_sur14sur);

		
		sanClaudio_a_norte14sur = new Direccion(new Vector2f[] {
		                                            new Vector2f(0.99749696f, -0.38564265f),
		                                            //vector que indica la ubicacion de su semaforo
		                                            new Vector2f(0.026282907f, 0.20534223f),
		                                            new Vector2f(-0.008760929f, 0.25876462f),
		                                            new Vector2f(-0.021276593f, 0.345576f),
		                                            new Vector2f(-0.013767183f, 0.40233725f),
		                                            new Vector2f(0.36921155f, 0.9933222f)
		                                        }, semaforo_sanClaudio_a_norte14sur);

		new Interruptor(norte14sur_a_sanClaudio, norte14sur_a_sanClaudioCU, norte14sur_a_sur14sur,
		                sur14sur_a_sanClaudio, sur14sur_a_sanClaudioCU, sur14sur_a_norte14sur,
		                sanClaudio_a_sur14sur, sanClaudio_a_norte14sur);
		new Transito(norte14sur_a_sanClaudio);
		new Transito(norte14sur_a_sanClaudioCU);
		new Transito(norte14sur_a_sur14sur);
		new Transito(sur14sur_a_norte14sur);
		new Transito(sur14sur_a_sanClaudio);
		new Transito(sur14sur_a_sanClaudioCU);
		new Transito(sanClaudio_a_sur14sur);
		new Transito(sanClaudio_a_norte14sur);

	}
	public void renderizar( Graphics g ) {
		Matrix3x3f view = obtenerTransformacionViewport();
		FabricaEdificios.dibujarEdificios(g, view);
		norte14sur_a_sanClaudio.pintar(g, view);
		norte14sur_a_sanClaudioCU.pintar(g, view);
		norte14sur_a_sur14sur.pintar(g, view);
		sur14sur_a_norte14sur.pintar(g, view);
		sur14sur_a_sanClaudio.pintar(g, view);
		sur14sur_a_sanClaudioCU.pintar(g, view);
		sanClaudio_a_sur14sur.pintar(g, view);
		sanClaudio_a_norte14sur.pintar(g, view);
	}
		
	public void crearYMostrarGUI() {
		canvas = new Canvas();
		canvas.setBackground( colorDeFondo );
		canvas.setIgnoreRepaint( true );
		getContentPane().add( canvas );
		setLocationByPlatform( true );
		if ( appMantenerRatio ) {
			getContentPane().setBackground( colorDelBorde );
			setSize( anchoVentana, largoVentana );
			setLayout( null );
			getContentPane().addComponentListener( new ComponentAdapter() {
				public void componentResized( ComponentEvent e ) {
					onComponentResized( e );
				}
			});
		} else {
			canvas.setSize( anchoVentana, largoVentana );
			pack();
		}
		setTitle( titulo );
		setVisible( true );
		canvas.createBufferStrategy( 2 );
		bs = canvas.getBufferStrategy();
		canvas.requestFocus();

		entidad = new Thread( this );
		entidad.start();

	}
	public void onComponentResized( ComponentEvent e ) {
		Dimension tamanio = getContentPane().getSize();
		int vw = (int)(tamanio.width * escalaDelBordeVentana);
		int vh = (int)(tamanio.height * escalaDelBordeVentana);
		int vx = (tamanio.width - vw) / 2;
		int vy = (tamanio.height - vh) / 2;
		int newW = vw;
		int newH = (int)(vw * largoDelMundo / anchoDelMundo);
		if ( newH > vh ) {
			newW = (int)(vh * anchoDelMundo / largoDelMundo);
			newH = vh;
		}
		vx += (vw - newW) / 2;
		vy += (vh - newH) / 2;
		canvas.setLocation( vx, vy );
		canvas.setSize( newW, newH );
	}
	public Matrix3x3f obtenerTransformacionViewport() {
		float screenWidth = canvas.getWidth() - 1;
		float screenHeight = canvas.getHeight() - 1;
		float sx = screenWidth / anchoDelMundo;
		float sy = -screenHeight / largoDelMundo;
		Matrix3x3f viewport = Matrix3x3f.scale( sx, sy );
		float tx = screenWidth / 2.0f;
		float ty = screenHeight / 2.0f;
		viewport = viewport.mul( Matrix3x3f.translate( tx, ty ) );
		return viewport;
	}
	public void run() {
		ejecucion = true;
		inicializar(); 
		double nsPerFrame;
		while ( ejecucion ) {
			cicloDinamicoDeDibujado();
		}
	}
	private void cicloDinamicoDeDibujado() {
		renderizadoDelMarco();
		sleep( reposo );
	}
	private void renderizadoDelMarco() {
		do {
			do {
				Graphics g = null;
				try {
					g = bs.getDrawGraphics();
					g.clearRect( 0, 0, getWidth(), getHeight() );
					renderizar( g );
				} finally {
					if ( g != null ) {
						g.dispose();
					}
				}
			} while ( bs.contentsRestored() );
			bs.show();
		} while ( bs.contentsLost() );
	}
	private void sleep( long sleep ) {
		try {
			Thread.sleep( sleep );
		} catch ( InterruptedException ex ) { }
	}
	public void ventanaAlCerrar() {
		try {
			ejecucion = false;
			entidad.join();
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.exit( 0 );
	}
	public static void ejecutarAplicacionDeRenderizado( final Simulacion app ) {
		app.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				app.ventanaAlCerrar();
			}
		});
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				app.crearYMostrarGUI();
			}
		});
	}

	public static void main( String[] args ) {
		ejecutarAplicacionDeRenderizado( new Simulacion() );
	}

}