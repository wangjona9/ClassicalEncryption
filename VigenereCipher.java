/**
 * An implementation of the Vigenere Cipher. Implements the command line for user input.
 *
 * @author Jonathan Wang
 * September 2023
 */
public class VigenereCipher {

  public static String cipher(String plaintext, String key, boolean isEncoding) {
    StringBuilder codedText = new StringBuilder(); // Instantiate a StringBuilder

    for (int i = 0, j = 0; i < plaintext.length(); i++) { // Loop through result
      char c = plaintext.charAt(i); // Set char c as the index of the input plaintext string
      char keyChar = (key.isEmpty()) ? 'a' : key.charAt(j % key.length()); // Check if the key is in a valid
                                                                             // unicode & lowercase, and not empty

      int modifier = isEncoding ? 1 : -1; // Boolean check to adjust calculation (positive for encode, negative for
                                          // decode)
      int transformedValue = ((((c - 'a') + modifier * (keyChar - 'a')) + 26) % 26) + 'a'; // Set and check char
                                                                                           // as a valid unicode
                                                                                           // value

      codedText.append((char) transformedValue); // Append the unicoded value to the StringBuilder
      j++; // Increment the index of the key within the loop
    }

    return codedText.toString(); // Return using the string conversion function
  }

  public static String encode(String plaintext, String key) {
    return cipher(plaintext, key, true);
  } // Encode

  public static String decode(String encodedText, String key) {
    return cipher(encodedText, key, false);
  } // Decode

  public static boolean validateInput(String[] args) {
    if (args.length != 3) {
      System.out.println("Invalid input. Please use a correct number of args.");
      return false;
    } // Check for an invalid number of args

    String instruction = args[0];

    if (!instruction.equals("encode") && !instruction.equals("decode")) {
      System.out.println("Invalid input. Please Use encode/decode.");
      return false;
    } // Check for an incorrect instruction call

    return true;
  }

  public static void processInput(String instruction, String text, String key) {
    if (instruction.equals("encode")) { // Print result to string for encode instruction
      String encodedText = encode(text, key);
      System.out.println("Encoded Text: " + encodedText);
    } else {
      String decodedText = decode(text, key); // Print result to string for decode instruction
      System.out.println("Decoded Text: " + decodedText);
    }
  }

  public static void main(String[] args) {
    if (!validateInput(args)) {
      return;
    }

    String instruction = args[0];
    String text = args[1];
    String key = args[2];

    processInput(instruction, text, key);
  }
}
