/**
 * ReseptiRivin tietotyyppi, joka voi olla luku, vaihteluv‰lillinen luku tai
 * ep‰m‰‰r‰inen m‰‰r‰.
 * 
 * @author Miika Peltotalo
 *
 */
public interface Maara {

	/**
	 * Kertoo olion attribuutit parametrina tulevalla kertoimella. K‰ytet‰‰n
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