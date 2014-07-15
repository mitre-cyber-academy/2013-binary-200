import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class OverratedSolver {
    public static void main(String[] args) {
        String currentKey = new String();
        long startTime = System.currentTimeMillis();
        String goodstring = "3d38629f056c942d561b63dbe8e94653"; // MCA-8EC28E12
        long increment = 2382364672L; // The manifest tells you an approximate location of the flag.
        System.out.println("Running...Please wait.");
        while(!encrypt(currentKey).equals(goodstring))
        {
            currentKey = Long.toHexString(increment);
            currentKey = "MCA-" + fixLength(currentKey).toUpperCase();
            increment++;
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Found key " + currentKey + " in " + totalTime  / 1000 + " seconds.");
    }
    public static String encrypt(String input){
        String res = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(input.getBytes());
            byte[] md5 = algorithm.digest();
            String tmp = "";
            for (int i = 0; i < md5.length; i++) {
                tmp = (Integer.toHexString(0xFF & md5[i]));
                if (tmp.length() == 1) {
                    res += "0" + tmp;
                } else {
                    res += tmp;
                }
            }
        } catch (NoSuchAlgorithmException ex) {}
        return res;
    }
    public static String fixLength(String input) {
        while(input.length() != 8 && input.length() < 9) // length of every key
        {
            input = 0 + input;
        }
        return input;
    }
}