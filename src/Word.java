/**
 *  This class represents a word in the game that is comprised of
 *  any number of letters. Each letter is represented by a Letter
 *  object. The Letter objects are stored in a linked list formed
 *  by objects of the class LinearNode. Each node in the linked
 *  list stores an object of the class Letter.
 * @author Jordan Buckindale
 * @Student #251246279
 * @Date Feb 28th 2022
 */

public class Word {

	// sets instance variable.
	private LinearNode<Letter> firstLetter;
	
	
	/**
	 * Initializes the Word object so the Letter objects in array “letters” is stored within its linked structure.
	 * @param letters are the letters that will be evaluated. 
	 */
	public Word(Letter[] letters) {
		
		firstLetter = new LinearNode<Letter>();
		LinearNode<Letter> current = firstLetter;
		
		
		for(int i = 0; i <letters.length; i++) {
			// sets letter in node.
			current.setElement(letters[i]);
			// sets new next node.
			LinearNode<Letter> next = new LinearNode<Letter>();
			// sets current node pointer to next node 			
			current.setNext(next);
			// goes to next node to manipulate.
			current = next;
		}
		// sets node pointer to null to end list.
		current.setNext(null);
	}
	
	/** 
	 * 	Creates a String of the form: “Word: L1 L2 L3 ... Lk”, where each Li is the string
		produced by invoking the toSting method on each Letter object of this Word.
	 */
	public String toString() {
		
		// set string variable.
		String s = "Word: ";
		
		// set current to first node in linked list.
		LinearNode<Letter> current = firstLetter;
		
		// creates string with each letter of word with appropriate decorator.
		while(current.getNext() != null) {
			s += current.toString();
			s += " ";
			current.getNext();
		}
		// returns string.
		return s;
		
	}
	
	/**
	 * Takes a mystery word as a parameter and updates each of Letters’ “label”
	 * attribute contained in this Word object with respect to the mystery word.
	 * returns true if this word is identical in content to the mystery word.
	 * @param mystery object that will be used to evaluate guess word. 
	 * @return Boolean value. (true / false)
	 */
	public boolean labelWord(Word mystery) {
		
		// initializes nodes. 
		LinearNode<Letter> current = firstLetter;
		LinearNode<Letter> other = mystery.firstLetter;
					
		// checks to see if linked list is at end. counter ensures that positions of letters are in same spot.
		while((current.getNext() != null) && (other.getNext() != null)) {
					
			// check to see if the nodes contain the same letters.
			if (current.getElement().equals(other.getElement())) {
				
				// sets decorator if letter is correct.
				current.getElement().setCorrect();
			}
				
			else {
				
				//  creates new temporary node for mystery word.
				LinearNode<Letter> temp = mystery.firstLetter;
				
				
				// cycles through mystery word and compares each letter to current letter. 
				while (temp.getNext() != null ) {
					
					// checks to see if letters are the same.
					if (current.getElement().equals(temp.getElement())) {
						
						// sets decorator if letter is Used.
						current.getElement().setUsed();
						}
					else {
						// if letters are not the same, set to unused.
						current.getElement().setUnused();
						}
					
					// cycle to next letter in mystery word.
					temp = temp.getNext();
						
				}
			}
			
			// cycles through letters in guess word.
			current = current.getNext();
			
		}
		// checks to see if the guess word and mystery word are the same and if they are the same length. (guess word: 'he' - mystery word: 'hello')
		if((this.equals(mystery)) && (checkLength(mystery) == true)) {
			// if the guess word and mystery word are equal and same length, return true.
			return true;
		} else {
			// if the guess word and mystery word are not equal, return false.
			return false;
		}
	}
	
	
	/**
	 *  Private helper method that will take in the word and check
	 *  to see if the guess word is a 100% match with the mystery word. 
	 *  Will be used by the label word method to give each letter
	 *  the appropriate decorator. 
	 * @param other as mystery word.
	 * @return status (true / false)
	 */
	private boolean equals(Word other) {
		
		
		// sets boolean variable to catch whether this word and other word are equal.
		boolean status = false;
		
		// initializes nodes. 
		LinearNode<Letter> currentWord = firstLetter;
		LinearNode<Letter> otherWord = other.firstLetter;
			
		// iterates through nodes and compares whether they are equal or not.
		while(currentWord.getNext()!= null && otherWord.getNext()!= null) {
			
			// checks to see if node elements are equal.
			if(currentWord.getElement()==otherWord.getElement()) {
				
				// status stays true while elements (letters) are the same.
				status = true;
				
				// gets next letter node of current linked list.
				currentWord.getNext();
				// gets next letter node of other linked list.
				otherWord.getNext();
				
			}
			else; {
				status = false;
				break;
			}
		}
		
		// returns value.
		return status;		
	}
	
	/**
	 * Private method to see if the mystery word and guess word are the same length. will be implemented in label word method.
	 * @param ot is the mystery word.
	 * @return true or false whether they are same length.
	 */
	private boolean checkLength(Word ot) {
		LinearNode<Letter> current = firstLetter;
		LinearNode<Letter> other= ot.firstLetter;
		
		// counter variables.
		int count = 0;
		int count1 = 0;
		
		// checks to see how many nodes are in guess word.
		while (current.getNext() != null) {
			count ++;
			current = current.getNext();
		}
		// checks to see how many nodes are in the mystery word.
		while (other.getNext() != null) {
			count1 ++;
			other = other.getNext();
		}
		
		// compares the count of mystery word and guess word and returns appropriate value.
		if (count == count1) {
			// returns true, if true.
			return true;
		}
		else {
			// returns false, if false.
			return false;
		}
	}

}
