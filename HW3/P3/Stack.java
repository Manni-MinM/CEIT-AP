// BWOTSHEWCHB

class Stack {
	// Fields
	private int size ;
	private int topIndex ;
	private int[] stack ;
	// Constructor
	public Stack(int size) {
		topIndex = -1 ;
		this.size = size ;
		stack = new int[size] ;
	}
	// Methods
	public boolean isEmpty() {
		return (topIndex == -1) ;
	}
	public boolean isFull() {
		return (topIndex == size - 1) ;
	}
	public void push(int val) {
		if ( isFull() )
			return ;
		stack[++ topIndex] = val ;
	}
	public void pop() {
		if ( isEmpty() )
			return ;
		topIndex -- ;
	}
	public int peek() {
		return stack[topIndex] ;
	}
}

