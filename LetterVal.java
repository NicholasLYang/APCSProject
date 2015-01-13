import java.util.*;
import java.io.*;

public class LetterVal {
    private Map<Character, Integer> LValues = new HashMap<Character, Integer>();
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public LetterVal() {
	for(int i=0; i<alphabet.length(); i++) {
	    LValues.put(alphabet.charAt(i), 1);
	}
	LValues.put('D',2);
	LValues.put('G',2);
	LValues.put('B',3);
	LValues.put('C',3);
	LValues.put('M',3);
	LValues.put('P',3);
	LValues.put('F',4);
	LValues.put('H',4);
	LValues.put('V',4);
	LValues.put('W',4);
	LValues.put('Y',4);
	LValues.put('K',5);
	LValues.put('J',8);
	LValues.put('X',8);
	LValues.put('Q',10);
	LValues.put('Z',10);
    }

    public int getVal(char l) {
	return LValues.get(l);
    }
}
