import java.util.*;
import java.io.*;

public class LetterVal {
    private Map<Character, Integer> LValues = new HashMap<Character, Integer>();
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public LetterVal() {
	for(int i=0; i<alphabet.length(); i++) {
	    LValues.put(alphabet.charAt(i), 1);
	}
    }

    public int getVal(char l) {
	return LValues.get(l);
    }
}
