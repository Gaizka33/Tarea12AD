package ej1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner abielto = new Scanner(System.in);
		boolean handler = true;
		Menu m = new Menu();

		while (handler) {
			m.mostrarMenu();
			int valor = abielto.nextInt();
			if (valor != 11) {
				m.elegir(valor);
			} else {
				handler = false;
			}

		}

	}

}
