public class VigenereCipher {

    // Method to encode a plaintext using Vigenere cipher
    public static String encode(String plaintext, String key) {
        // If the key is empty, return the original plaintext
        if (key.isEmpty()) {
            return plaintext;
        }

        StringBuilder encodedText = new StringBuilder(); // Instantiate a StringBuilder

        for (int i = 0, j = 0; i < plaintext.length(); i++) { // Loop through the input text & key
            char c = plaintext.charAt(i); // Set char c as the index of the input plaintext string
            char keyChar = key.charAt(j % key.length()); // Check if the key is in a valid unicode & lowercase

            int encodedValue = ((c + keyChar - 2 * 'a') % 26) + 'a'; // Set and check char as a valid unicode value
            encodedText.append((char) encodedValue); // Append the unicoded value to the StringBuilder
            j++; // Increment the index of the key within the loop
        }
        return encodedText.toString(); // Return using the string conversion function
    }

    // Method to decode an encoded text using Vigenere cipher
    public static String decode(String encodedText, String key) {
        StringBuilder decodedText = new StringBuilder(); // Instantiate a StringBuilder

        for (int i = 0, j = 0; i < encodedText.length(); i++) {
            char c = encodedText.charAt(i);
            char keyChar = key.charAt(j % key.length());

            int decodedValue = ((c - keyChar + 26) % 26) + 'a'; // Change calculation to set and check char for a decoded unicode value
            decodedText.append((char) decodedValue);
            j++;
        }
        return decodedText.toString();
    }

    // Method to validate input arguments
    public static boolean validateInput(String[] args) {
        if (args.length != 3) { // Checking for correct number of arguments
            System.out.println("Invalid input. Please use a correct number of args.");
            return false;
        }

        String instruction = args[0];

        if (!instruction.equals("encode") && !instruction.equals("decode")) { // Checking for correct instructions
            System.out.println("Invalid input. Please Use encode/decode.");
            return false;
        }

        return true;
    }

    // Method to process input based on the instruction
    public static void processInput(String instruction, String text, String key) {
        if (instruction.equals("encode")) {
            String encodedText = encode(text, key);
            System.out.println("Encoded Text: " + encodedText); // Process the input and return the encoded text
        } else {
            String decodedText = decode(text, key);
            System.out.println("Decoded Text: " + decodedText); // Process the input and return the decoded text
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        if (!validateInput(args)) {
            return;
        }

        String instruction = args[0]; // Initialize String args
        String text = args[1];
        String key = args[2];

        processInput(instruction, text, key); // Call processInput with initialized String args
    }
}
