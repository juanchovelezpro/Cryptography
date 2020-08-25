import java.util.Arrays;

/**
 * Vigenere Cipher code.
 * 
 * @author velez
 *
 */

public class VigenereCipher {

	public static char[][] vigenereSquare = new char[26][26];

	public VigenereCipher() {

		buildVigenereSquare();

	}

	public void buildVigenereSquare() {

		CeasarCipher ceasar = new CeasarCipher();

		for (int i = 0; i < vigenereSquare.length; i++) {

			char[] abcShifted = ceasar.shiftingAlphabetRight(i);

			for (int j = 0; j < vigenereSquare[0].length; j++) {

				vigenereSquare[i][j] = abcShifted[j];

			}

		}

	}

	public char[][] pairKeyWordWithMessage(String message, String keyWord) {

		int length = message.length();
		char[][] fixed = new char[2][length];

		for (int i = 0; i < length; i++) {

			fixed[0][i] = message.charAt(i);

		}

		for (int j = 0, key = 0; j < length; j++, key++) {

			if (key == keyWord.length())
				key = 0;

			if (message.charAt(j) != ' ') {
				fixed[1][j] = keyWord.charAt(key);
			} else {
				fixed[1][j] = ' ';
				key--;
			}

		}

		System.out.println(Arrays.toString(fixed[0]));
		System.out.println(Arrays.toString(fixed[1]));

		return fixed;

	}

	public String encrypt(String message, String keyWord) {

		String encrypted = "";
		char[] alphabet = CeasarCipher.alphabet;
		char[][] messageWithKeyword = pairKeyWordWithMessage(message, keyWord);
		int length = message.length();

		for (int i = 0; i < length; i++) {

			if (messageWithKeyword[0][i] != ' ') {
				char x = messageWithKeyword[0][i];
				char y = messageWithKeyword[1][i];

				int xIndex = Arrays.binarySearch(alphabet, x);
				int yIndex = Arrays.binarySearch(alphabet, y);

				encrypted += vigenereSquare[xIndex][yIndex];
			} else {

				encrypted += " ";

			}
		}

		return encrypted;

	}

	public static void main(String[] args) {

		VigenereCipher vigenere = new VigenereCipher();

		System.out.println(vigenere.encrypt("HOLA ESTE ES UN MENSAJE DE PRUEBA", "CRACK"));

	}

}
