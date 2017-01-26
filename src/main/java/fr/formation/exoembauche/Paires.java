package fr.formation.exoembauche;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Paires {

	public static void main(final String[] args) {
		String suite = "";
		final Random rand = new Random();
		for (int i = 0; i < 2; i++) {
			suite += Math.abs(rand.nextInt());
		}
		System.out.println("suite de chiffres : " + suite);
		System.out.println(
				"Nombre de paires total : " + Paires.solutionNormale(suite));
	}

	@SuppressWarnings("unused")
	private static long solutionAvecApiStream(final String suite) {
		final List<String> list = Arrays.asList(suite.split(""));
		final Map<Integer, Long> sortedList = list.stream()
				.mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.groupingBy(Function.identity(),
						Collectors.counting()));
		return sortedList.values().stream().mapToLong((value) -> value)
				.map((nbPaires) -> nbPaires / 2).sum();
	}

	private static long solutionNormale(final String suite) {
		final List<String> list = Arrays.asList(suite.split(""));
		Collections.sort(list);
		long total = 0;
		int prec = -1;
		for (final String str : list) {
			final int i = Integer.parseInt(str);
			if (prec < 0 || i != prec) {
				prec = i;
			} else {
				++total;
				prec = -1;
			}
		}
		return total;
	}
}
