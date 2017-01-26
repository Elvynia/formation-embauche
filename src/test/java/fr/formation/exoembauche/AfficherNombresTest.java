package fr.formation.exoembauche;

import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AfficherNombresTest {

	private static String result;

	@AfterClass
	public static void destroy() {
		// Similaire à la surcharge de la méthode tearDown().
	}

	@BeforeClass
	public static void init() {
		// Similaire à la surcharge de la méthode setUp().
		AfficherNombresTest.result = AfficherNombres.generateString();
	}

	@Test
	public void checkAlwaysSame() {
		// Vérifier que deux éxécutions donnent exactement le même résultat.
		Assert.assertTrue(AfficherNombres.generateString()
				.equals(AfficherNombresTest.result));
	}

	@Test
	public void checkFeezBuzz() {
		// Vérifier que la chaîne contient bien les mots "feez" et "buzz".
		Assert.assertThat(AfficherNombresTest.result,
				CoreMatchers.both(CoreMatchers.containsString("feez"))
						.and(CoreMatchers.containsString("buzz")));
	}

	@Test
	public void checkValues() {
		// Vérifier que le début commence par '1 2 buzz '.
		Assert.assertThat(AfficherNombresTest.result,
				CoreMatchers.startsWith("1 2 buzz "));
	}
}
