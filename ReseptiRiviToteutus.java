import java.io.PrintStream;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

/**
 * Vastuualueena yksi reseptin rivi. Luokka pitää huolta yhden reseptirivin
 * muuttamisesta olion tietotyypeiksi.
 * 
 * @author Miika Peltotalo
 *
 */
@Invariant("maara != null || tyyppi != null || kuvaus != null")
public class ReseptiRiviToteutus implements ReseptiRivi {
	private Maara maara;
	private String tyyppi;
	private String kuvaus;

	ReseptiRiviToteutus() {
		//
	}

	/**
	 * 
	 * @param maara
	 *            : ainesosan määrä
	 * @param tyyppi
	 *            : ainesosan määrän tyyppi, eli esim. kpl, tlk, rkl jne.
	 * @param kuvaus
	 *            : lisätietoa ainesosasta esim. nimi
	 */
	@Requires({ "maara != null", "!maara.isEmpty()", "tyyppi != null", "!tyyppi.isEmpty()", "kuvaus != null",
			"!kuvaus.isEmpty()" })
	@Ensures({ "this.maara != null", "this.tyyppi != null", "this.kuvaus != null" })
	ReseptiRiviToteutus(String maara, String tyyppi, String kuvaus) {
		this.maara = new MaaraToteutus(maara);
		this.tyyppi = tyyppi;
		this.kuvaus = kuvaus;
	}

	/**
	 * Tulostaa yksittäisen rivin.
	 * 
	 * @param ulostulo
	 */
	@Override
	public void tulosta(PrintStream ulostulo) {
		ulostulo.println(maara.toString() + " " + tyyppi + ", " + kuvaus);
	}

	/**
	 * Muuttaa merkkijonon olion attribuuteiksi.
	 * 
	 * @param rivi
	 */
	@Override
	@Requires({ "rivi != null", "!rivi.equals(\"\")" })
	@Ensures({ "maara != null", "kuvaus != null" })
	public void parse(String rivi) {
		if (rivi.contains(",")) {
			String[] palat = rivi.split(",");
			String[] palat2 = palat[0].split(" ");
			maara = new MaaraToteutus(palat2[0]);
			tyyppi = palat2[1];
			kuvaus = palat[1];
		}
		String[] palat = rivi.split(" ", 2);
		maara = new MaaraToteutus(palat[0]);
		kuvaus = palat[1];

	}

	/*
	 * Kertoo reseptin ainemäärät haluttua annoskokoa vastaavaksi.
	 * 
	 * @param kerroin
	 */
	@Override
	@Requires("kerroin > 0")
	public void kerroAnnoskoolla(int kerroin) {
		double lopullinen = kerroin * 0.25;
		maara.kerroAnnoskoolla(lopullinen);

	}

}