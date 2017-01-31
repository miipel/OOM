import java.util.ArrayList;
import com.google.java.contract.*;

/**
 * Pit�� yll� listaa ReseptiRivi alkioista ja suorittaa alkioille pyydetyt
 * operaatiot.
 * 
 * @author Miika Peltotalo
 *
 */
@Invariant("alkiot.size() >= 1")
public class Resepti {
	private ArrayList<ReseptiRivi> alkiot = new ArrayList<>();

	Resepti() {
		//
	}

	/**
	 * 
	 * @param rivi
	 */
	@Requires({ "rivi != null", "!rivi.equals(\"\")" })
	@Ensures("result == true")
	public void lisaa(String rivi) {
		rivi = rivi.trim();
		ReseptiRivi rr = new ReseptiRivi();
		rr.parse(rivi);
		alkiot.add(rr);
		;
	}

	/**
	 * Tulostaa kaikki reseptirivit, mit� on sy�tetty.
	 */
	@Requires("alkiot != null")
	public void tulosta() {
		for (ReseptiRivi reseptiRivi : alkiot) {
			reseptiRivi.tulosta(System.out);
		}

	}

	/**
	 * Kutsuu aliluokan metodia jokaiselle reseptiRiville.
	 * 
	 * @param kerroin
	 *            : m��r�, jolla halutaa kertoa ainesosien lukum��r�.
	 */
	@Requires("kerroin > 0")
	public void kerroAnnoskoolla(int kerroin) {
		for (ReseptiRivi reseptiRivi : alkiot) {
			reseptiRivi.kerroAnnoskoolla(kerroin);
		}
	}

}