package ds.queue;

public class Queue {
	
	private int maxSize; // Initializes the set number of slots
	
	private long[] queueArray; //slots to maintain the data
	
	private int front; //this will be the index position for the element in the front
	
	private int rear; // rear element index in back
	
	private int nItems; // counter to maintain the number of items in the queue
	
	
	public Queue(int size) {
		
		this.maxSize = size;
		this.queueArray = new long[size];
		front = 0; //index position of the first slot in the array
		rear = -1; // there is not item in the array to be considered as the last item
		nItems = 0; // we dont have elements in the array yet
		
		
	}
	
	public void insert(long j) {
		
		
		//this code will overwritewhat is at the 0th position
		/*if(rear == maxSize -1) {
			rear = -1;
		}
		*/
		
		if(isFull()) {
			System.out.println("Queue is already full.");
		}
		else {
		rear++;
		queueArray[rear] = j;
		nItems++;
		}
		
	}
	
	
	//remove from front of queue
	public long remove() {
		long temp = queueArray[front];
		front++;
		if(front == maxSize) {
			front = 0;  //make index 0 again to use entire array
		}
		nItems--;
		return temp;
	}
	
	public long peak() {
		return queueArray[front];
	}
	
	public boolean isEmpty() {
		return(nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	
	public void view() {
		System.out.print("[ ");
		for(int i=0; i<queueArray.length; i++) {
			System.out.print(queueArray[i] + " ");
		}
		System.out.print(" ]");
	}
}

---------------------------------------------------------------------------------------------------------------------
package ds.queue;

public class App {

	public static void main(String[] args) {
		
		Queue myQueue = new Queue(5);
		myQueue.insert(100);
		myQueue.insert(1000);
		myQueue.insert(14);
		myQueue.insert(12);
		myQueue.insert(44);
		myQueue.insert(75);
		myQueue.view();
		

	}

}
