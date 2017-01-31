
import java.util.Scanner;
import com.google.java.contract.*;

/**
 * Tarkoitus mallintaa reseptidata olioina.
 * 
 * @author Miika Peltotalo
 * 
 */
@Invariant("resepti != null")
public class ReseptiGenerator {
	final static Resepti resepti = new Resepti();

	/**
	 * @param args
	 *            : ei ole
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sy�t� reseptin rivi muodossa \"m��r�, yksikk�, ainesosan nimi\", ");
		System.out.println("Huomioi, ett� sy�tettyjen ainesten annoskooksi oletetaan 4");
		System.out.println("Sy�t� 0 lopettaaksesi");
		while (sc.hasNextLine()) {
			String rivi = sc.nextLine();
			if (rivi.equals("0")) {
				break;
			}
			resepti.lisaa(rivi);
		}
		sc.close();
		resepti.kerroAnnoskoolla(6);
		resepti.tulosta();

	}

}
