import java.io.PrintStream;

/**
 * Vastuualueena yksi reseptin rivi. Luokka pit‰‰ huolta yhden reseptirivin
 * muuttamisesta olion tietotyypeiksi.
 * 
 * @author Miika Peltotalo
 *
 */
public interface ReseptiRivi {

	/**
	 * Tulostaa yksitt‰isen rivin.
	 * 
	 * @param ulostulo
	 */
	void tulosta(PrintStream ulostulo);

	/**
	 * Muuttaa merkkijonon olion attribuuteiksi.
	 * 
	 * @param rivi
	 */
	void parse(String rivi);

	/**
	 * Annoskoon muuttaminen.
	 * 
	 * @param kerroin
	 */
	void kerroAnnoskoolla(int kerroin);

}