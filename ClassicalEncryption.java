public class ClassicalEncryption {

    public static String encode(String plaintext, int key) {
        char[] charArray = plaintext.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            char encodedChar = (char) ((c - 'a' + key) % 26 + 'a');
            charArray[i] = encodedChar;
        }

        return new String(charArray);
    }

    public static String decode(String plaintext, int key) {
        return encode(plaintext, 26 - key);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid input. Please use a correct number of args.");
            System.exit(2);
        }

        String instruction = args[0];
        String input = args[1];

        if (!instruction.equals("encode") && !instruction.equals("decode")) {
            System.err.println("Invalid instruction. Please use encode/decode");
            System.exit(1);
        }

        if (!input.matches("[a-z]+")) {
            System.err.println("Invalid input string. Please contain only lowercase characters.");
            System.exit(1);
        }

        for (int key = 0; key < 26; key++) {
            String result = instruction.equals("encode") ? encode(input, key) : decode(input, key);
            System.out.println("Key " + key + ": " + result);
        }
    }
}
