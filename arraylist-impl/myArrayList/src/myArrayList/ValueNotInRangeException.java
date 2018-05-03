package myArrayList;

public class ValueNotInRangeException extends Exception {
	/**
	 * ValueNotInRangeExcpetion
	 */
	private static final long serialVersionUID = 1L;

	public ValueNotInRangeException(String message) {
        super(message);
    }
}
