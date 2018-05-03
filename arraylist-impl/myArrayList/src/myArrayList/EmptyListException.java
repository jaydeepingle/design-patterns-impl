package myArrayList;

public class EmptyListException extends Exception {
	/**
	 * EmptyListException
	 */
	private static final long serialVersionUID = 1L;

	public EmptyListException(String message) {
        super(message);
    }
}
