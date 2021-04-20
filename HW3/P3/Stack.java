// BWOTSHEWCHB

/**
 * A Class to hold information about the Stack
 */
class Stack {
	// Fields
	private int size ;
	private int topIndex ;
	private int[] stack ;
	// Constructor
	/**
	 * Constructor Method - Creates Stack Object
	 *
	 * @param size Size of the stack
	 */
	public Stack(int size) {
		topIndex = -1 ;
		this.size = size ;
		stack = new int[size] ;
	}
	// Methods
	/**
	 * Checks if Stack is Empty
	 *
	 * @return True if topIndex is -1 and False if topIndex is not -1
	 */
	public boolean isEmpty() {
		return (topIndex == -1) ;
	}
	/**
	 * Checks if Stack is Full
	 *
	 * @return True if topIndex is size - 1 and False if topIndex is not size - 1
	 */
	public boolean isFull() {
		return (topIndex == size - 1) ;
	}
	/**
	 * Throws val into the stack
	 *
	 * @param val Value to be added to the stack
	 */
	public void push(int val) {
		if ( isFull() )
			return ;
		stack[++ topIndex] = val ;
	}
	/**
	 * Removes the top element from the stack
	 */
	public void pop() {
		if ( isEmpty() )
			return ;
		topIndex -- ;
	}
	/**
	 * Returns the element at the top of the stack
	 *
	 * @return value of the element at the top of the stack
	 */
	public int peek() {
		return stack[topIndex] ;
	}
}

