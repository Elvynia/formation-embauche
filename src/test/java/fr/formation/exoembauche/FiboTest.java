package fr.formation.exoembauche;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import junit.framework.TestCase;

/**
 * Classe de tests unitaires de l'algorithme de résolution de la suite de
 * Fibonacci.
 *
 * @author hb-asus
 *
 */
public class FiboTest extends TestCase {

	private Map<Integer, Long> values;

	@Override
	protected void setUp() throws Exception {
		this.values = new HashMap<>();
		this.values.put(1, 1L);
		this.values.put(2, 1L);
		this.values.put(3, 2L);
		this.values.put(7, 13L);
		this.values.put(9, 34L);
		this.values.put(14, 377L);
		this.values.put(25, 75025L);
	}

	@Override
	protected void tearDown() throws Exception {
		// Aucune ressource à libérer pour le moment.
	}

	public void testFiboValues() {
		// Assertion avec une boucle en mode récursif.
		for (final Integer key : this.values.keySet()) {
			Assert.assertEquals(this.values.get(key),
					Fibo.calculate(key, true));
		}
	}
}
