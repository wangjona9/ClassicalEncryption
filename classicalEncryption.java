public class classicalEncryption {
  
    public static String encode(String plaintext, int key) {
        StringBuilder encoded = new StringBuilder();
   
        plaintext = plaintext.toLowerCase();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                c = (char)((c - 'a' + key + 26) % 26 + 'a');
            }
       
            encoded.append(c);
        }
   
        return encoded.toString();
    }
 
 
 
 
    public static void main(String[] args) {
        System.out.println("hello world");
        }
    }
 
 
 