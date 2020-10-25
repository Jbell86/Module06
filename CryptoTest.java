public class CryptoTest {

    public static void main(String[] args) throws Exception {
        // What's going on in the two lines below?
        // Explain with a comment.
        // I've not handled the error in which the args[] array is null.
        // So, if you don't call the program correctly at the command line, you'll get an error.
        // Try to handle this in some way.
  
        String inFile = args[0];
    	String outFile = args[1];    			    
    	
    	CryptoEngine cryptoEngine = new CryptoEngine(inFile, outFile);
    	cryptoEngine.encrypt();
    	cryptoEngine.decrypt();
    }
}