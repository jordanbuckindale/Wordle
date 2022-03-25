/**
 *  This class represents a single letter that will be used in the game. 
 *  Each game letter also has an accompanying integer label which indicates 
 *  whether it is used, unused, or correct with respect to the mystery word. 
 * @author Jordan Buckindale
 * @Student #251246279
 * @Date Feb 28th 2022
 */


public class Letter {

	
	//Private instance variables.
	private char letter; 
	private int label;
	private int UNSET, UNUSED, USED, CORRECT;
	
	
	/**
	 * Constructor method that initializes label to UNSET and sets the value of instance variable letter to parameter c.
	 * @param c is the letter being evaluated.
	 */
	public Letter(char c) {
		
		// initializes label to UNSET and sets the value of instance variable letter to parameter c.
		this.letter = c;
		this.label = this.UNSET;	
	}
	
	/**
	 *  This method checks whether otherObject is of the class Letter, and if not the value false
	 *  is returned. If otherObject is of the class Letter, then the “letter” attributes of 
	 *  otherObject and this object are compared. If they are the same the value true is returned, otherwise false is returned.
	 */
	public boolean equals(Object otherObject) {
		
		if(otherObject instanceof Letter) {
			if (this.letter == ((Letter)otherObject).letter) {
				return true;
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
	}
	
	/**
	 * Decorator method attributes a symbol value to the letter character to notify user if the character is used, unused or correct.
	 * @return string of a symbol that symbolizes the attribute of the letter +, -, ! depending on if it is used, unused or correct.
	 */
	public String decorator() {
		
		if(this.label == this.USED) {
			return "+";
		}
		if(this.label == this.UNUSED) {
			return "-";
		}
		if(this.label == this.CORRECT) {
			return "!";
		}
		else {
			return " ";
		}
	}
	
	/**
	 * Overridden method that gives a representation of letter & label which uses the helper method decorator.
	 * @return the evaluated letter in between appropriate symbols.
	 */
	public String toString() {
		
		// returns a string statement.
		return (this.decorator() + this.letter + this.decorator());
	}
	
		
	// used to change the value of attribute “label” to UNUSED.
	public void setUnused() {
		this.label = this.UNUSED;
	}
	
	// used to change the value of attribute “label” to USED.
	public void setUsed() {
		this.label = this.USED;
	}
	
	// used to change the value of attribute “label” to CORRECT.
	public void setCorrect() {
		this.label = this.CORRECT;
	}
	
	// returns true if the attribute “label” is set to UNUSED, otherwise returns false.
	public boolean isUnused() {
		
		if(this.label == UNUSED) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Produces an array of objects of the class Letter from the string s given as
	 * parameter. For each character in s a Letter object is created and stored in 
	 * the array. The Letter objects are stored in the array in the same order in 
	 * which the corresponding characters appear in s.
	 * @param s is the string that will be converted to character types in an array.
	 * @return an array of character types.
	 */
	public static Letter[] fromString(String s) {
		
		Letter[] arrayOfLetters = new Letter[s.length()];
		
		for(int i = 0; i <s.length(); i++) {
			// sets letter at index as char c.
			char c = s.charAt(i);
			// creates new object and adds to array.
			arrayOfLetters[i] = new Letter(c);
		}
		// returns array.
		return arrayOfLetters;
		
	}
	
}
