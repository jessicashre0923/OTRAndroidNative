package androidSharedClasses;

import org.testng.annotations.Test;

import java.util.Base64;


public class Encrypt {

    public void Encode(String encrypt) {
    	String originalString = "WellNowWellNow";
    	originalString = encrypt;
    	
        Base64.Encoder encoder = Base64.getEncoder();
      
        String encodedString = encoder.encodeToString(originalString.getBytes());

        System.out.println("Encrypted Value :: " + encodedString);


        Decrypt.Decrypt(encodedString); // run this to test encrypt is working if needed
    }

    public static class Decrypt {

        public static void Decrypt(String decrypt) {
            String encodedString = decrypt;
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(encodedString);

           System.out.println("Decrypted Value :: " + new String(bytes)); // uncomment this if you are not sure it is working
            // otherwise just use the sting in the ares needed text box etc
        }


    }
}
