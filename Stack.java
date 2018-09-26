package ds.stack;

public class Stack {

	private int maxSize;
	private char[] stackArray;
	private int top;
	
	
	public Stack(int size) {
		maxSize = size;
		this.stackArray = new char[maxSize];
		this.top = -1; //first element then goes to 0th index
	}
	
	public void push(char j) {
		if(isFull()) {
			System.out.println("Stack is already full");
		}else {
			top++;
			stackArray[top]= j;
		}
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("Stack is already empty");
			return '0';
		}
		else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}		
	}
	
	public char peak() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return(maxSize-1 == top);
	}
	
}

----------------------------------------------------------------------------------------------------------------------

package ds.stack;

public class App {

	public static void main(String[] args) {
		
		
		Stack theStack = new Stack(10);
		/*theStack.push(20);
		theStack.push(40);
		theStack.push(60);
		theStack.push(80); //LIFO
*/		
		
		
		
		
		/*while(!theStack.isEmpty()) {
			char value = theStack.pop();
			System.out.println(value);
		}*/
		
		
		
		System.out.println(reverseString("HELLO"));
		
		
		
	}
	
	public static String reverseString(String str) {
		int stackSize = str.length(); //max stack size
		Stack theStack = new Stack(stackSize); //we make stack
		for(int j=0; j< str.length(); j++) {
			char ch = str.charAt(j); //getting char from input string
			theStack.push(ch);
			
		}
		String result = "";
		while(!theStack.isEmpty()) {
			char ch = theStack.pop();
			result += ch;
		}
		
		return result;
	}

}
