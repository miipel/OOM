/**
 * ReseptiRivin tietotyyppi, joka voi olla luku, vaihteluvälillinen luku tai
 * epämääräinen määrä.
 * 
 * @author Miika Peltotalo
 *
 */
public interface Maara {

	/**
	 * Kertoo olion attribuutit parametrina tulevalla kertoimella. Käytetään
	 * annoskoon muuttamiseen.
	 * 
	 * @param kerroin
	 */
	void kerroAnnoskoolla(double kerroin);

	/**
	 * Muuntaa Maara-olion merkkijonoksi
	 */
	String toString();

}