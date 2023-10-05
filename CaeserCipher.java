/**
 * An implementation of the Caesar
 * Cipher. Implements the command line
 * for user input.
 * 
 * @author Jonathan Wang
 * September 2023
 */
public class CaesarCipher {

    public static String encode(String plaintext, int key) {
        char[] charArray = plaintext.toCharArray(); // Instantiate new charArray

        for (int i = 0; i < charArray.length; i++) { // Loop through charArray
            char c = charArray[i]; // Set char as index of charArray
            char encodedChar = (char) ((c - 'a' + key) % 26 + 'a'); // Convert c to unicode
            charArray[i] = encodedChar; // set the unicoded char as the index value in charArray
        }

        return new String(charArray); // Return the ciphered charArray
    }

    public static String decode(String plaintext, int key) {
        return encode(plaintext, 26 - key); // Call encode function with unicode to represent decode
    }

    public static boolean validateInput(String instruction, String input) {
        if (!instruction.equals("encode") && !instruction.equals("decode")) { // Output error for invalid Instruction
            System.err.println("Invalid instruction. Please use encode/decode");
            return false;
        }

        return true;
    }

    public static void processInput(String instruction, String input) {
        for (int key = 0; key < 26; key++) { // Loop through and print every key value
            String result = instruction.equals("encode") ? encode(input, key) : decode(input, key);
            System.out.println("Key " + key + ": " + result);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) { // Checking for whitespaces
            System.err.println("Invalid input. Please use a correct number of args.");
            System.exit(2);
        }

        String instruction = args[0];
        String input = args[1];

        if (validateInput(instruction, input)) {
            processInput(instruction, input); // Call functions to validate and proccess user input
        }
    }
}
