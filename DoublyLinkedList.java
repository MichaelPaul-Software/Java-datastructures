package ds.doublylinkedlist;

public class DoublyLinkedList {
	
	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			last = newNode; // if empty, last will refer to the new node being created
		} else {
			first.previous = newNode;
		}
		
		newNode.next = first; // the new nodes next field will point to the old first
		this.first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;// assigning old last to new node
			newNode.previous = last; // the old last will be the new nodes previous
		}
		
		last = newNode; // the linkedlist last field should point to the new node
	}
	
	//assume non-empty list
	public Node deleteFirst() {
		Node temp = first;
		if(first.next == null) { //only one item in the list
			last = null;
		} else {
			first.next.previous = null;
		}
		
		first = first.next; //we are assigning the reference of the node folowing the old first node to the first field in the linked list object 
		return temp; //return the deleted old first node
	}
	
	//assume a non-empty list
	public Node deleteLast() {
		Node temp = last;
		
		if(first.next == null) { //only one item in the list
			first = null;
		}
		else {
			last.previous.next = null;// LL object last point to last object, .previous in last element points to object element before it, then .next refers to the next item is null which means the next item was deleted
		}
		
		last = last.previous; 
		return temp;
	}
	
	//assume a non-empty list
	public boolean insertAfter(int key, int data) { //key is node were looking fors data
		
		Node current = first; //we start from beginning of list
		while(current.data != key) { //loop to look for node with key matching thatnodes data
			current = current.next;
			if(current.next == null) {
				return false;
			}
		}
		Node newNode = new Node();
		newNode.data = data;
		
		if(current == last) {
			current.next = null;
			last = newNode;
		}
		else {
			newNode.next = current.next; // new nodes next field should point to the node ahead of current
			current.next.previous = newNode; //the node ahead of current, its previous field should point to the new node
		}
		
			newNode.previous = current; // the new node we inserted, its previous field should refer to the current node
			current.next = newNode;
			return true;
	}
	
	//assume a non empty list
	public Node deleteKey(int key) {
		Node current = first;// start from beginning
		while(current.data != key) { 
			current = current.next;
			if(current == null) {  
				return null;
			}
		}
		
		if (current == first) {
			first = current.next;
		} else {	
		current.previous.next = current.next;
		}
		
		if(current == last) {
			last = current.previous;
		}
		else {
			current.next.previous = current.previous;
		}
		
		return current;
	}
	
	
	public void displayForward() {
		
		System.out.println("list from first to last");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		
	}
	
public void displayBackward() {
		
		System.out.println("list from last to first");
		Node current = last;
		while(current != null) {
			current.displayNode();
			current = current.previous;
		}
		
	}

}


-----------------------------------------------------------------------------------------------------------------------------


