import java.util.*;

public class LetterVal {
    private Map<char,int> LValues = new HashMap<char,int>();
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public LetterVal() {
	for(int i=0; i<alphabet.length(); i++) {
	    LValues.put(alphabet[i], 1);
	}
    }

    public int getVal(char l) {
	return LValues.get(l);
    }
}
