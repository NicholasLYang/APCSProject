import java.util.*;

public class LetterVal {
    private Map<char,int> LValues = new HashMap<char,int>();
    private String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public LetterVal() {
	for(int i=0; i<alpha.length(); i++) {
	    LValues.put(alpha[i], 1);
	}
    }

    public int getVal(char l) {
	return LValues.get(l);
    }



}
