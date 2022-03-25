/**
 * This class is a central repository for information
 * about a WordLL game: It stores a mystery word and
 * all word guesses tried so far. It keeps a history 
 * of the past word guesses in a linked structure.
 * @author Jordan Buckindale
 * @Student #251246279
 * @Date Feb 28th 2022
 */

public class WordLL {
	
	// initializes private variables.
	private Word mysteryWord;
	private LinearNode<Word> history;
	
	/**
	 * Initializes an empty history and sets the 
	 * mysteryWord attribute to the parameter mystery.
	 * @param mystery is the mystery word.
	 */
	public WordLL(Word mystery) {
		
		// initalizes variables.
		this.history = new LinearNode<Word>();
		this.mysteryWord = mystery;
	}
	
	
	/**
	 * Takes a Word as an argument to test against 
	 * this games’ mystery word and updates the label
	 * of all the letters contained within Word guess 
	 * (using labelWord) and adds Word guess to the 
	 * front the of history.
	 * @param guess is the word that will be tested against the games mystery word.
	 * @return returns true if the word represented by guess is identical to the word represented by mysteryWord, otherwise returns false.
	 */
	public boolean tryWord(Word guess) {
		
		// initializes node for guess word.
		LinearNode<Word> newNode = new LinearNode<Word>(guess);
		// sets new node pointer to the head of the history's next node.
		newNode.setNext(this.history.getNext());
		// sets history to front of list.
		this.history.setNext(newNode);
		

		// return true if the word in guess is identical to the mysteryWord, false otherwise.
		return guess.labelWord(this.mysteryWord);
	}
	
	/**
	 * Creates a String representation of the past guesses
	 *  with the most recent guess first.  
	 * @return returns a list of the history of guesses.
	 */
	
	public String toString() {
		
		// set a empty string variable for history.
		String hist = "";
		
		// initialize new node.
		LinearNode<Word> current = history;
		
		// checks to make sure next node is not empty..
		while(current.getNext() != null) {
			// adds element of node to string with new line character.
			hist += current.getNext().getElement().toString() + "\n";
			// gets next node.
			current = current.getNext();
		}
		// returns a list of the history of guesses.
		return hist;
	}
	
}