import java.util.Arrays;

/**
 * Ceasar Cipher code.
 * 
 * @author velez
 *
 */

public class CeasarCipher {

	public static final char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public char[] shiftingAlphabetLeft(int times) {

		char[] shifted = new char[alphabet.length];

		for (int i = times, j = 0; i < shifted.length; i++, j++) {

			shifted[i] = alphabet[j];

		}

		for (int i = alphabet.length - times, j = 0; j < times; i++, j++) {

			shifted[j] = alphabet[i];

		}

		return shifted;

	}

	public char[] shiftingAlphabetRight(int times) {

		char[] shifted = new char[alphabet.length];

		for (int i = shifted.length - times, j = 0; i < shifted.length; i++, j++) {
			shifted[i] = alphabet[j];
		}

		for (int i = times, j = 0; i < shifted.length; i++, j++) {
			shifted[j] = alphabet[i];
		}

		return shifted;

	}

	public String encrypt(String message, int timesToShift, boolean side) {

		String encrypted = "";
		char[] keys = null;

		if (side)
			keys = shiftingAlphabetRight(timesToShift);
		else
			keys = shiftingAlphabetLeft(timesToShift);

		for (int i = 0; i < message.length(); i++) {

			char character = message.charAt(i);

			if (character != ' ')
				encrypted += keys[Arrays.binarySearch(alphabet, Character.toUpperCase(character))];
			else
				encrypted += ' ';

		}

		return encrypted;

	}

	public static void main(String[] args) {

		CeasarCipher cipher = new CeasarCipher();

		System.out.println(cipher.encrypt("HOLA ESTE ES UN MENSAJE DE PRUEBA", 5, true));

	}

}
