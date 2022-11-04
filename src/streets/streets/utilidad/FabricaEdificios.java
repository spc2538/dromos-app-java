package streets.utilidad;
import java.awt.*;
public class FabricaEdificios{
	public static void rellenarPoligono( Graphics2D g, Vector2f[] poligono, Matrix3x3f view){
		Vector2f P;
		Polygon p = new Polygon();
		for ( Vector2f v : poligono ) {
			P = view.mul( v );
			p.addPoint( (int)P.x, (int)P.y );
		}
		g.fill( p );
	}
	public static void dibujarEdificios(Graphics g, Matrix3x3f view) {
		g.setColor(new Color(136, 138, 133));
		Vector2f[] v = new Vector2f[] {
		    new Vector2f(-0.99687254f, -0.36528492f),
		    new Vector2f(-0.02580136f, 1.0f),
		    new Vector2f(0.21344805f, 1.0f),
		    new Vector2f(-0.11336982f, 0.5051814f),
		    new Vector2f(-0.09304142f, 0.5051814f),
		    new Vector2f(0.23221266f, 1.0f),
		    new Vector2f(0.44957006f, 1.0f),
		    new Vector2f(0.074276805f, 0.33937824f),
		    new Vector2f(0.074276805f, 0.30569953f),
		    new Vector2f(0.08522284f, 0.28238344f),
		    new Vector2f(0.09773266f, 0.26683939f),
		    new Vector2f(0.99843633f, -0.3031088f),
		    new Vector2f(0.99843633f, -0.5673574f),
		    new Vector2f(-0.053948402f, 0.09326428f),
		    new Vector2f(-0.07271302f, 0.06735754f),
		    new Vector2f(0.99843633f, -0.61139894f),
		    new Vector2f(0.99843633f, -0.94559586f),
		    new Vector2f(0.19781077f, -0.39119172f),
		    new Vector2f(0.16028154f, -0.4818653f),
		    new Vector2f(0.1618452f, -0.50777197f),
		    new Vector2f(0.16497266f, -0.52072537f),
		    new Vector2f(0.1759187f, -0.5388601f),
		    new Vector2f(0.83424556f, -1.0f),
		    new Vector2f(0.48397183f, -0.9974092f),
		    new Vector2f(-0.032056272f, -0.62953365f),
		    new Vector2f(-0.03987491f, -0.6088083f),
		    new Vector2f(-0.04769349f, -0.5932642f),
		    new Vector2f(-0.052384675f, -0.5751295f),
		    new Vector2f(-0.058639526f, -0.5440414f),
		    new Vector2f(-0.058639526f, -0.51554406f),
		    new Vector2f(-0.052384675f, -0.4559585f),
		    new Vector2f(0.01798284f, -0.29274607f),
		    new Vector2f(-0.12744331f, -0.19948184f),
		    new Vector2f(-0.16810006f, -0.19430053f),
		    new Vector2f(-0.19624704f, -0.19430053f),
		    new Vector2f(-0.23690385f, -0.19430053f),
		    new Vector2f(-0.26661456f, -0.2150259f),
		    new Vector2f(-0.31352615f, -0.25129533f),
		    new Vector2f(-0.86551994f, -0.9922279f),
		    new Vector2f(-0.99687254f, -0.99481857f),
		    new Vector2f(-0.99687254f, -0.8212435f),
		    new Vector2f(-0.32447225f, 0.16321248f),
		    new Vector2f(-0.336982f, 0.18134719f),
		    new Vector2f(-0.9921814f, -0.7720207f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
		v = new Vector2f[] {
		    new Vector2f(-0.26157695f, 0.07512522f),
		    new Vector2f(-0.204005f, 0.03505844f),
		    new Vector2f(-0.21401751f, 0.015025079f),
		    new Vector2f(-0.22653317f, 0.0016694665f),
		    new Vector2f(-0.25156444f, -0.018363953f),
		    new Vector2f(-0.27909887f, -0.028380632f),
		    new Vector2f(-0.30413014f, -0.028380632f),
		    new Vector2f(-0.3241552f, -0.021702766f),
		    new Vector2f(-0.33416772f, -0.021702766f),
		};
		rellenarPoligono((Graphics2D)g, v, view);




		g.setColor(new Color(255, 236, 136));
		v = new Vector2f[] {
		    new Vector2f(-0.9784483f, 0.9734121f),
		    new Vector2f(-0.09051722f, 0.9793205f),
		    new Vector2f(-0.08620691f, 0.9734121f),
		    new Vector2f(-0.9784483f, -0.28212702f),
		    new Vector2f(-0.98275864f, 0.98818314f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
		v = new Vector2f[] {
		    new Vector2f(0.12390494f, 0.35559267f),
		    new Vector2f(0.12390494f, 0.33889818f),
		    new Vector2f(0.1314143f, 0.3155259f),
		    new Vector2f(0.14392996f, 0.30217028f),
		    new Vector2f(0.5093868f, 0.07846415f),
		    new Vector2f(0.53692114f, 0.07512522f),
		    new Vector2f(0.55694616f, 0.0918197f),
		    new Vector2f(0.57947433f, 0.11853093f),
		    new Vector2f(0.7847309f, 0.5158598f),
		    new Vector2f(0.8022529f, 0.5592655f),
		    new Vector2f(0.8022529f, 0.5826377f),
		    new Vector2f(0.79974973f, 0.60601f),
		    new Vector2f(0.7897372f, 0.6360601f),
		    new Vector2f(0.44180226f, 0.84974957f),
		    new Vector2f(0.42177725f, 0.8530885f),
		    new Vector2f(0.40175223f, 0.8430718f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
		v = new Vector2f[] {
		    new Vector2f(-0.82478094f, -0.9766277f),
		    new Vector2f(-0.64205253f, -0.73622704f),
		    new Vector2f(-0.31414264f, -0.9732888f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
		v = new Vector2f[] {
		    new Vector2f(0.6871089f, -0.028380632f),
		    new Vector2f(0.6245307f, 0.015025079f),
		    new Vector2f(0.612015f, 0.03505844f),
		    new Vector2f(0.609512f, 0.061769664f),
		    new Vector2f(0.609512f, 0.09515864f),
		    new Vector2f(0.8423029f, 0.54257095f),
		    new Vector2f(0.85732174f, 0.56594324f),
		    new Vector2f(0.8748436f, 0.57929885f),
		    new Vector2f(0.8948686f, 0.5859766f),
		    new Vector2f(0.99749696f, 0.5225376f),
		    new Vector2f(1.0f, -0.21535885f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
		v = new Vector2f[] {
		    new Vector2f(0.45431793f, 0.8998331f),
		    new Vector2f(0.99749696f, 0.5759599f),
		    new Vector2f(1.0f, 0.9933222f),
		    new Vector2f(0.50438046f, 0.9966611f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
		v = new Vector2f[] {
		    new Vector2f(0.21151447f, -0.43572617f),
		    new Vector2f(0.99749696f, -0.9732888f),
		    new Vector2f(0.84981227f, -0.9732888f),
		    new Vector2f(0.20650816f, -0.5158597f),
		    new Vector2f(0.1939925f, -0.49916518f),
		    new Vector2f(0.1939925f, -0.46911514f),
		};
		rellenarPoligono((Graphics2D)g, v, view);



		////

		v = new Vector2f[] {
		    new Vector2f(-0.6020025f, -0.70283806f),
		    new Vector2f(-0.2966208f, -0.27879798f),
		    new Vector2f(-0.23534012f, -0.23056996f),
		    new Vector2f(-0.19155592f, -0.22020721f),
		    new Vector2f(-0.14464426f, -0.22538853f),
		    new Vector2f(-0.0054730177f, -0.31088078f),
		    new Vector2f(-0.06333071f, -0.4430052f),
		    new Vector2f(-0.074276745f, -0.48445594f),
		    new Vector2f(-0.074276745f, -0.53367877f),
		    new Vector2f(-0.066458166f, -0.59067357f),
		    new Vector2f(-0.060203254f, -0.62176156f),
		    new Vector2f(-0.046129763f, -0.6528497f),
		    new Vector2f(-0.252541f, -0.9689119f),
		};
		rellenarPoligono((Graphics2D)g, v, view);

		//
		v = new Vector2f[] {
		    new Vector2f(-0.22403002f, -0.96994984f),
		    new Vector2f(-0.02377969f, -0.6694491f),
		    new Vector2f(0.106382966f, -0.78964937f),
		    new Vector2f(-0.02377969f, -0.96994984f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
		v = new Vector2f[] {
		    new Vector2f(0.13892365f, -0.8163606f),
		    new Vector2f(0.38423026f, -0.9732888f),
		    new Vector2f(0.0312891f, -0.96994984f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
		g.setColor(Color.WHITE);
		v = new Vector2f[] {
		    new Vector2f(-0.342723f, -0.02439022f),
		    new Vector2f(-0.2832551f, 0.062330604f),
		    new Vector2f(-0.23943663f, 0.018970191f),
		    new Vector2f(-0.24569643f, -0.002710104f),
		    new Vector2f(-0.26760566f, -0.02439022f),
		    new Vector2f(-0.30829424f, -0.040650368f),
		    new Vector2f(-0.3333333f, -0.040650368f),
		};
		rellenarPoligono((Graphics2D)g, v, view);
	}
}