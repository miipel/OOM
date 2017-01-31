import java.util.ArrayList;
import com.google.java.contract.*;

/**
 * Pitää yllä listaa ReseptiRivi alkioista ja suorittaa alkioille pyydetyt
 * operaatiot.
 * 
 * @author Miika Peltotalo
 *
 */
@Invariant("alkiot.size() >= 1")
public class ReseptiToteutus implements Resepti {
	private ArrayList<ReseptiRiviToteutus> alkiot = new ArrayList<>();

	ReseptiToteutus() {
		//
	}

	/*
	 * Lisää yhden rivin muokattuna reseptiin.
	 * 
	 * @param rivi
	 */
	@Override
	@Requires({ "rivi != null", "!rivi.equals(\"\")" })
	@Ensures("result == true")
	public void lisaa(String rivi) {
		rivi = rivi.trim();
		ReseptiRiviToteutus rr = new ReseptiRiviToteutus();
		rr.parse(rivi);
		alkiot.add(rr);
		;
	}

	/**
	 * Tulostaa kaikki reseptirivit, mitä on syötetty.
	 */
	@Override
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
	 *            : määrä, jolla halutaa kertoa ainesosien lukumäärä.
	 */
	@Override
	@Requires("kerroin > 0")
	public void kerroAnnoskoolla(int kerroin) {
		for (ReseptiRivi reseptiRivi : alkiot) {
			reseptiRivi.kerroAnnoskoolla(kerroin);
		}
	}

}