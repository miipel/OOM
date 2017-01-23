import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.java.contract.*;

/**
 * Tarkoitus mallintaa reseptidata olioina.
 * @author Miika Peltotalo
 *	
 */
public class ReseptiGenerator {

	/**
	 * @param args ei ole
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Resepti resepti = new Resepti();
		System.out.println("Syötä reseptin rivi muodossa \"määrä, yksikkö, ainesosan nimi\", ");
		System.out.println("Huomioi, että syötettyjen ainesten annoskooksi oletetaan 4");
		System.out.println("Syötä 0 lopettaaksesi");
		System.out.println("Syötä 1 kertoaksesi annoskoon");
		while (sc.hasNextLine()) {
			String rivi = sc.nextLine();
			if (rivi.equals("0")) {
				break;
			}
			resepti.lisaa(rivi);
		}
		sc.close();
		resepti.kerroAnnoskoolla(5);
		resepti.tulosta();

	}

	/**
	 * Pitää yllä listaa ReseptiRivi alkioista ja
	 * suorittaa alkioille pyydetyt operaatiot. 
	 * @author Miika
	 *
	 */
	public static class Resepti {
		ArrayList<ReseptiRivi> alkiot = new ArrayList<>();

		Resepti() {
			//
		}

		public void lisaa(String rivi) {
			rivi = rivi.trim();
			ReseptiRivi rr = new ReseptiRivi();
			rr.parse(rivi);
			alkiot.add(rr);
		}

		public void tulosta() {
			for (ReseptiRivi reseptiRivi : alkiot) {
				reseptiRivi.tulosta(System.out);
			}
		}

		public void kerroAnnoskoolla(int kerroin) {
			for (ReseptiRivi reseptiRivi : alkiot) {
				reseptiRivi.kerroAnnoskoolla(kerroin);
			}
		}

	}

	/**
	 * Vastuualueena yksi reseptin rivi.
	 * Luokka pitää huolta yhden reseptirivin muuttamisesta olion
	 * tietotyypeiksi.
	 * 
	 *
	 */
	public static class ReseptiRivi {
		Maara maara;
		String tyyppi;
		String kuvaus;

		ReseptiRivi() {
			//
		}

		ReseptiRivi(String maara, String tyyppi, String kuvaus) {
			this.maara = new Maara(maara);
			this.tyyppi = tyyppi;
			this.kuvaus = kuvaus;
		}

		/**
		 * Tulostaa yksittäisen rivin.
		 * @param ulostulo
		 */
		public void tulosta(PrintStream ulostulo) {
			ulostulo.println(maara.toString() + " " + tyyppi + ", " + kuvaus);
		}

		/**
		 * Muuttaa merkkijonon olion attribuuteiksi.
		 * @param rivi
		 */
		public void parse(String rivi) {
			if (rivi.contains(",")) {
				String[] palat = rivi.split(",");
				String[] palat2 = palat[0].split(" ");
				maara = new Maara(palat2[0]);
				tyyppi = palat2[1];
				kuvaus = palat[1];
			}
			String[] palat = rivi.split(" ", 2);
			maara = new Maara(palat[0]);
			kuvaus = palat[1];

		}

		/**
		 * Annoskoon muuttaminen. 
		 * @param kerroin
		 */
		public void kerroAnnoskoolla(int kerroin) {
			double lopullinen = kerroin * 0.25;
			maara.kerroAnnoskoolla(lopullinen);;
		}

	}

	/**
	 * ReseptiRivin tietotyyppi, joka voi olla luku,
	 * vaihteluvälillinen luku tai epämääräinen määrä.
	 * 
	 *
	 */
	public static class Maara {
		double maara;
		double vaihteleva1;
		double vaihteleva2;
		String epamaarainen;
		
		Maara(double luku) {
			this.maara = luku;
		}

		Maara(String epamaarainen) {
			if (epamaarainen.contains("-")) {
				String[] palat = epamaarainen.split("-");
				vaihteleva1 = Double.parseDouble(palat[0]);
				vaihteleva2 = Double.parseDouble(palat[1]);								
			}
			this.epamaarainen = epamaarainen;
		}
		
		/**
		 * Kertoo olion attribuutit parametrina tulevalla kertoimella.
		 * Käytetään annoskoon muuttamiseen. 
		 * @param kerroin
		 */
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
			if (maara != 0) return maara+"";
			if (vaihteleva1 != 0 && vaihteleva2 != 0) 
				return vaihteleva1+"-"+vaihteleva2;
			return epamaarainen;
		}
		
		

	}

}
