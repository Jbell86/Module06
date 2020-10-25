//All of these are imported because tools from each package
//are used in the code.
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.crypto.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptoEngine {
  // What is the function of these four variables?
  // Comment above each one with your answer.
  // this is the key used
  KeyGenerator keyGen;
  // this is the string of the encrypted and decrypted text
  String encFile, decFile;
  // this is the secret key to decrypt
  SecretKey secKey;
  // this is the cipher used to encrypt
  Cipher aesCipher;

  CryptoEngine(String inFile, String outFile) throws NoSuchAlgorithmException, NoSuchPaddingException {
    encFile = inFile;
    decFile = outFile;

    keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(128);
    secKey = keyGen.generateKey();
    aesCipher = Cipher.getInstance("AES");
  }

  public void encrypt() throws InvalidKeyException, IOException {
    byte[] byteText = "Include your plaintext to be encrypted here".getBytes();

    aesCipher.init(Cipher.ENCRYPT_MODE, secKey);

    byte[] byteCipherText = null;

    try {
      byteCipherText = aesCipher.doFinal(byteText);
    } catch (IllegalBlockSizeException | BadPaddingException e) {
      e.printStackTrace();
    }
    Files.write(Paths.get(encFile), byteCipherText);
  }


  //this is the method used to decrypt the encrypted file
  public void decrypt() throws IOException, InvalidKeyException {
    // assign "Files.readAllBytes(Paths.get(encFile))" to the cipherText array (fill
    // in the blank)
    // This is taking the encrypted data to add
    // to the byte arryay to decrypt it

    byte[] cipherText = "Files.readAllBytes(Paths.get(encFile))".getBytes();

    // call aesCipher.init as in the encrypt method, but this time, you will use
    // DECRYPT_MODE!
    aesCipher.init(Cipher.DECRYPT_MODE, secKey);

    // declare and initialize a byte array just like in the encrypt method, but this
    // time, call it bytePlainText
    byte[] bytePlainText = null;
    // I have commented out this try-catch block to make your code compilable, but
    // you'll need to decomment it after filling in the code
    try {
      bytePlainText = aesCipher.doFinal(cipherText);
    } catch (IllegalBlockSizeException | BadPaddingException e) {
      e.printStackTrace();
    }
    Files.write(Paths.get(decFile), bytePlainText);
    // Write your output to a file, similar to the Files.write method in the encrypt
    // method (but be careful to use the correct byteArray and file)
    // _________________________________________________
  }

}