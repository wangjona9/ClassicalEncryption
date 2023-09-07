public class VigenereCipher {

  public static String encode(String plaintext, String key) {
    StringBuilder encodedText = new StringBuilder();

    for (int i = 0, j = 0; i < plaintext.length(); i++) {
      char c = plaintext.charAt(i);
      char keyChar = key.charAt(j % key.length());

      int encodedValue = ((c + keyChar - 2 * 'a') % 26) + 'a';
      encodedText.append((char) encodedValue);
      j++;
    }
    return encodedText.toString();
  }

  public static String decode(String encodedText, String key) {
    StringBuilder decodedText = new StringBuilder();

    for (int i = 0, j = 0; i < encodedText.length(); i++) {
      char c = encodedText.charAt(i);
      char keyChar = key.charAt(j % key.length());

      int decodedValue = ((c - keyChar + 26) % 26) + 'a';
      decodedText.append((char) decodedValue);
      j++;
    }
    return decodedText.toString();
  }

  public static boolean validateInput(String[] args) {
    if (args.length != 3) {
      System.out.println("Invalid input. Please use a correct number of args.");
      return false;
    }

    String instruction = args[0];

    if (!instruction.equals("encode") && !instruction.equals("decode")) {
      System.out.println("Invalid input. Please Use encode/decode.");
      return false;
    }

    return true;
  }

  public static void processInput(String instruction, String text, String key) {
    if (instruction.equals("encode")) {
      String encodedText = encode(text, key);
      System.out.println("Encoded Text: " + encodedText);
    } else {
      String decodedText = decode(text, key);
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
