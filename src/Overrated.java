import java.util.Scanner;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class Overrated {
    public static void main(String[] args) {
    	String currentKey = new String();
    	String goodstring = "3d38629f056c942d561b63dbe8e94653";
    	Scanner scanIn = new Scanner(System.in);
    	while(!encrypt(currentKey).equals(goodstring))
    	{
        	System.out.print("Please enter the correct flag to continue: ");
       		currentKey = scanIn.nextLine();
       	}
        System.out.println("Good job!");
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
}