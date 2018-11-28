package hello;

public class Reversing {
	
	public String reverse(String in, String out) {
        return (in.isEmpty()) ? out :
            (in.charAt(0) == ' ')
            ? out + ' ' + reverse(in.substring(1), "")
            : reverse(in.substring(1), in.charAt(0) + out);
    }

}


