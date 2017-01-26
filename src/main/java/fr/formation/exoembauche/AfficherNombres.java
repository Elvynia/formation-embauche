package fr.formation.exoembauche;

/**
 * Afficher les nombres de 1 � 100. Et tu devras afficher � buzz � pour les
 * multiples de 3 et afficher � feez � pour les multiples de 5 et � buzz feez �
 * pour les multiples de 3 et de 5.
 *
 * @author hb-asus
 *
 */
public class AfficherNombres {

	public static String generateString() {
		final StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 100; ++i) {
			String toPrint = "";
			if (i % 3 == 0) {
				toPrint += "buzz ";
			}
			if (i % 5 == 0) {
				toPrint += "feez ";
			}
			sb.append(toPrint.isEmpty() ? i + " " : toPrint);
		}
		return sb.toString();
	}

	public static void main(final String[] args) {
		System.out.println(AfficherNombres.generateString());
	}
}
