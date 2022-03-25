/**
 * This class is a subclass of Letter and extends the functionality.
 * Instead of relying on a single char to represent the content of 
 * a Letter object, objects of this class will use a String instance
 * variable and will further introduce the concept of being related
 * to other ExtendedLetter objects. This class adds more features to
 * broaden the notion of a letter that will be used in the game.
 * @author Jordan Buckindale
 * @Student #251246279
 * @Date Feb 28th 2022 
 */


public class ExtendedLetter extends Letter {
    
	// initializes the private variables.
    private String content;
    private int family;
    private boolean related;
    private static final int SINGLETON = -1;

    /**
     * Constructor method that initializes the 
     * instance variables of the super class, 
     * then initializes other related variables.
     * @param s represents String variable.
     */
    public ExtendedLetter(String s) {
    	
        //initialize instance variable of the superclass  
    	super('c');
        this.content = s;
        this.related = false;
        this.family = SINGLETON;
    }
    
    /**
     * Overloaded Constructor method that initializes the 
     * instance variables of the super class, 
     * then initializes other related variables.
     * @param s represents String variable.
     * @param fam represents a Int variable.
     */
    public ExtendedLetter(String s, int fam) {
    	
        //initialize instance variable of the superclass
    	super('c');
    	this.content = s;
        this.related = false;
        this.family = fam;
    }
    
    /**
     * method that sets evaluates if other is instance of class
     *  then assigns / returns correct boolean values to be returned. 
     */
    public boolean equals(Object other) {
    	
    	// checks to see if other is instance of extended letter.
        if(other instanceof ExtendedLetter) {                                               // added instance of to check class type
			if(this.family == ((ExtendedLetter)other).family) {
				this.related = true;
			}
			if(this.content.equals(((ExtendedLetter)other).content)) {
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
     * An overridden method that gives a String representation 
     * of this ExtendedLetter object. If this ExtendedLetter object 
     * is unused (its label instance variable has value UNUSED) 
     * and its instance variable related has value true, return 
     * the string “.C.” where C is equal to this.content.
     */
    public String toString() {
        
     if((this.isUnused()) && (related == true)) {  
    	 
    	 // return string with appropriate decorators.
         return "." + content + ".";
     }
     else {
    	// return string with appropriate decorators.
         return this.decorator() + content + this.decorator();
     }
     
    }
    
    /**
     * Creates an array letters of Letter objects of the same size 
     * as the size of the array content received as parameter. This 
     * array letters will be returned by the method after storing values.
     * @param content
     * @param codes
     * @return
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {
        
    	// creates an array letters.
        Letter[] letters = new Letter[content.length];
        
        // iterates through array of objects and sets an extended letter object with appropriate parameters depending on if codes is null or not.
        for(int i = 0; i < content.length; i++){
            if(codes == null){
                letters[i] = new ExtendedLetter(content[i]);
            }
            else{
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        
        // returns array.
        return letters;

    }   
}