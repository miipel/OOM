/**
 * Pit‰‰ yll‰ listaa ReseptiRivi alkioista ja suorittaa alkioille pyydetyt
 * operaatiot.
 * 
 * @author Miika Peltotalo
 *
 */
public interface Resepti {

	/**
	 * Lis‰‰ yhden rivin muokattuna reseptiin.
	 * @param rivi
	 */
	void lisaa(String rivi);

	/**
	 * Tulostaa kaikki reseptirivit, mit‰ on syˆtetty.
	 */
	void tulosta();

	/**
	 * Kutsuu aliluokan metodia jokaiselle reseptiRiville.
	 * 
	 * @param kerroin
	 *            : m‰‰r‰, jolla halutaa kertoa ainesosien lukum‰‰r‰.
	 */
	void kerroAnnoskoolla(int kerroin);

}