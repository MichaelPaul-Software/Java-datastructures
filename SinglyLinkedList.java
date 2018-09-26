package ds.singlylinkedlist;

public class SinglyLinkedList {
	
	private Node first;
	
	
	public SinglyLinkedList() {
		
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	//used to insert at beginning of the list
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		first = newNode;
	}
	
	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
		return temp;
	}
	
	
	public void displayList() {
		System.out.println("List (first --> last) ");
		Node current = first;
		
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	public void insertLast(int data) {
		Node current = first;
		
		while(current.next != null) {
			current = current.next; //loop until current.next is not null
		}
		Node newNode = new Node();
		newNode.data = data;
		current.next = newNode;
	}
}

---------------------------------------------------------------------------------------------------------------
package ds.singlylinkedlist;

public class Node {
	
	public int data;
	public Node next;
	
	
	public void displayNode() {
		System.out.println("{ " + data + " } ");
	}

}


---------------------------------------------------------------------------------------------------------------

package ds.singlylinkedlist;

public class App {

	public static void main(String[] args) {
	
		SinglyLinkedList myList = new SinglyLinkedList();
		
		myList.insertFirst(100);
		myList.insertFirst(50);
		myList.insertFirst(99);
		myList.insertFirst(88);
		myList.insertLast(9999);
		
		myList.displayList();

	}

}
