import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

/**
 * ReseptiRivin tietotyyppi, joka voi olla luku, vaihteluvälillinen luku tai
 * epämääräinen määrä.
 * 
 * @author Miika Peltotalo
 *
 */
@Invariant("maara != null || vaihteleva1 != null || vaihteleva2 != null || epamaarainen != null")
public class MaaraToteutus implements Maara {
	private double maara;
	private double vaihteleva1;
	private double vaihteleva2;
	private String epamaarainen;

	/**
	 * Constructor
	 * 
	 * @param luku
	 *            : Ainesosan lukumäärä
	 */
	@Requires("luku > 0")
	MaaraToteutus(double luku) {
		this.maara = luku;
	}

	/**
	 * Constructor
	 * 
	 * @param epamaarainen
	 *            : Merkkijono josta on tarkoitus erotella tiedot
	 *            attribuutteihin.
	 */
	@Requires({ "epamaarainen != null", "!epamaarainen.equals(\"\")" })
	@Ensures("result == true")
	MaaraToteutus(String epamaarainen) {
		if (epamaarainen.contains("-")) {
			String[] palat = epamaarainen.split("-");
			vaihteleva1 = Double.parseDouble(palat[0]);
			vaihteleva2 = Double.parseDouble(palat[1]);
		}
		this.epamaarainen = epamaarainen;
	}

	/**
	 * Kertoo olion attribuutit parametrina tulevalla kertoimella. Käytetään
	 * annoskoon muuttamiseen.
	 * 
	 * @param kerroin
	 */
	@Override
	@Requires("kerroin > 0")
	public void kerroAnnoskoolla(double kerroin) {
		maara = maara * kerroin;
		vaihteleva1 = vaihteleva1 * kerroin;
		vaihteleva2 = vaihteleva2 * kerroin;
	}

	/**
	 * Muuntaa Maara-olion merkkijonoksi
	 */
	@Override
	public String toString() {
		if (maara != 0)
			return maara + "";
		if (vaihteleva1 != 0 && vaihteleva2 != 0)
			return vaihteleva1 + "-" + vaihteleva2;
		return epamaarainen;
	}

}