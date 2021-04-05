// BWOTSHEWCHB

import java.util.Scanner ;

class Node {
	// Fields
	private int value ;
	private Node next ;
	private Node prev ;
	// Constructor
	public Node(int value , Node next , Node prev) {
		this.value = value ;
		this.next = next ;
		this.prev = prev ;
	}
	// Getters
	public int getValue() {
		return value ;
	}
	public Node getNext() {
		return next ;
	}
	public Node getPrev() {
		return prev ;
	}
	// Setters
	public void setValue(int value) {
		this.value = value ;
	}
	public void setNext(Node next) {
		this.next = next ;
	}
	public void setPrev(Node prev) {
		this.prev = prev ;
	}
}
class LinkedList {
	// Fields
	private int length ;
	private Node head ;
	private Node tail ;
	// Constructor
	public LinkedList() {
		length = 0 ;
		head = null ;
		tail = null ;
	}
	// Methods
	public void print() {
		Node cur = head ;
		while ( cur != null ) {
			System.out.printf("%d " , cur.getValue()) ;
			cur = cur.getNext() ;
		}
		System.out.println() ;
	}
	public void add(int value) {
		Node cur ;
		if ( length == 0 ) {
			cur = new Node(value , null , null) ;
			head = cur ;
		}
		else {
			cur = new Node(value , null , tail) ;
			tail.setNext(cur) ;
		}
		tail = cur ;
		length += 1 ;
	}
	public void addFirst(int value) {
		Node cur ;
		if ( length == 0 ) {
			cur = new Node(value , null , null) ;
			tail = cur ;
		}
		else {
			cur = new Node(value , head , null) ;
			head.setPrev(cur) ;
		}
		head = cur ;
		length += 1 ;
	}
	public void contains(int value) {
		int index = 0 ;
		boolean found = false ;
		Node cur = head ;
		while ( cur != null ) {
			if ( cur.getValue() == value ) {
				found = true ;
				break ;
			}
			index ++ ;
			cur = cur.getNext() ;
		}
		if ( found )
			System.out.println(index) ;
		else
			System.out.println(-1) ;
	}
	public void removeIndex(int index) {
		if ( index >= 0 && index < length ) {
			if ( length == 1 ) {
				head = null ;
				tail = null ;
			}
			else if ( index == 0 ) {
				head.getNext().setPrev(null) ;
				head = head.getNext() ;
			}
			else if ( index == length - 1 ) {
				tail.getPrev().setNext(null) ;
				tail = tail.getPrev() ;
			}
			else {
				int it = 0 ;
				Node cur = head ;
				while ( cur != null ) {
					if ( it == index )
						break ;
					it ++ ;
					cur = cur.getNext() ;	
				}
				cur.getNext().setPrev(cur.getPrev()) ;
				cur.getPrev().setNext(cur.getNext()) ;
				cur = null ;
			}
			length -= 1 ;
		}
	}
	void findMiddle() {
		if ( length == 0 )
			System.out.println(-1) ;
		else {
			int it = 0 ;
			Node cur = head ;
			while ( cur != null ) {
				if ( it == (length - 1) / 2 )
					break ;
				it ++ ;
				cur = cur.getNext() ;
			}
			System.out.println(cur.getValue()) ;
		}
	}
	void removeMiddle() {
		removeIndex((length - 1) / 2) ;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		LinkedList linkedList = new LinkedList() ;
		String condition = "" ;
		while ( true ) {
			String line = input.nextLine() ;
			String[] lineSplit = line.split(" ") ;
			if ( lineSplit[0].equals("add") )
				linkedList.add(Integer.parseInt(lineSplit[1])) ;
			else if ( lineSplit[0].equals("addFirst") )
				linkedList.addFirst(Integer.parseInt(lineSplit[1])) ;
			else if ( lineSplit[0].equals("findMiddle") )
				linkedList.findMiddle() ;
			else if ( lineSplit[0].equals("removeMiddle") )
				linkedList.removeMiddle() ;
			else if ( lineSplit[0].equals("print") )
				linkedList.print() ;
			else if ( lineSplit[0].equals("contains") )
				linkedList.contains(Integer.parseInt(lineSplit[1])) ;
			else if ( lineSplit[0].equals("removeIndex") )
				linkedList.removeIndex(Integer.parseInt(lineSplit[1])) ;
			else if ( lineSplit[0].equals("finish") )
				break ;
		}
	}
}
