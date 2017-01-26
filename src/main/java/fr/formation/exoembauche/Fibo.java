package fr.formation.exoembauche;

import java.util.Scanner;

public class Fibo {

	public static Long calculate(final long n, final boolean recursive) {
		if (recursive) {
			return Fibo.recursive_calculate(n);
		} else {
			return Fibo.iterative_calculate(n);
		}
	}

	private static long iterative_calculate(final long n) {
		long it = 1;
		long n1 = 0;
		long n2 = 1;
		while (it < n) {
			final long tmp = n2;
			n2 = n1 + n2;
			n1 = tmp;
			++it;
		}
		return n2;
	}

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		String input = null;
		System.out.println("Pour terminer le programme, saisir 'exit' ou 'q'.");
		do {
			System.out.println("Veuillez saisir un nombre : ");
			input = scanner.nextLine();
			try {
				final long n = Long.parseLong(input);
				if (n > 0) {

					// Appeler la méthode de calcul de la suite et afficher le
					// résultat.
					System.out.println("Résultat de la suite de Fibonacci : "
							+ Fibo.calculate(n,
									args.length > 0 ? true : false));
				} else {
					System.err.println(
							"Le nombre saisi doit être positif et supérieur à 0");
				}
			} catch (final NumberFormatException e) {
				if ("exit".equals(input) || "q".equals(input)) {
					exit = true;
				} else {
					System.err.println(
							"Erreur, veuillez saisir un nombre entier positif.");
				}
			}
		} while (!exit);
		scanner.close();
	}

	private static long recursive_calculate(final long n) {
		if (n <= 1) {
			return n;
		}
		return Fibo.recursive_calculate(n - 2)
				+ Fibo.recursive_calculate(n - 1);
	}
}
