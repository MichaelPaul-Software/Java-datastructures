package ds.hashtable;

public class HashTable {
	
	String [] hashArray;
	int arraySize; //slots available
	int size = 0; //counter for number of elements in the hash table
	
	//constructor makes sure array size is prime
	public HashTable(int noOfSlots) {
		if(isPrime(noOfSlots)) {
			hashArray = new String[noOfSlots];
			arraySize = noOfSlots;
		} else {
			int primeCount = getNextPrime(noOfSlots);
			hashArray = new String[primeCount];
			arraySize = primeCount;
			
			System.out.println("Hash table size given " + noOfSlots + " is not a prime number.");
			System.out.println("Hash table size changed to: " + primeCount);
		}	
	}
	
	private boolean isPrime(int num) {
		for(int i =2; i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private int getNextPrime(int minNumber) {
		for(int i = minNumber; true; i++) {
			if(isPrime(i)) {
				return i;
			}
		}
	}
	
	//returns preferred index position
	private int hashFunc1(String word) {
		int hashVal = word.hashCode();
		hashVal = hashVal % arraySize;
		if(hashVal < 0) {
			hashVal += arraySize;
		}
		
		return hashVal; // ideal index position wed like to insert or search in
	}
	
	//returns step size > 0
	private int hashFunc2(String word) {
		int hashVal = word.hashCode();
		hashVal %= arraySize; // hashVal = hashVal % arraySize
		
		if(hashVal <0) {
			hashVal += arraySize;
		}
		
		//use a prime number less than array size
		return 3 - hashVal % 3;
		
	}
	
	public void insert(String word) {
		int hashVal = hashFunc1(word);
		int stepSize =hashFunc2(word);
		
		while(hashArray[hashVal] != null) {
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		
		hashArray[hashVal] = word;
		
		System.out.println("inserted word: " + word);
		size++;
	}
	
	public String find(String word) {
		int hashVal = hashFunc1(word);
		int stepSize =hashFunc2(word);
		
		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].equals(word)) {
				return hashArray[hashVal];
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		
		return hashArray[hashVal];
	}
}
-----------------------------------------------------------------------------------------------------------------
package ds.hashtable;

public class App {

	public static void main(String[] args) {
		
		HashTable table = new HashTable(19);
		
		table.insert("Apple");
		table.insert("Hello");
		table.insert("Feeling");
		table.insert("Water");
		table.insert("Africa");
		table.insert("Speed");
		table.insert("Phone");
		table.insert("September");
		table.insert("Michael");
		table.insert("Milk");
		table.insert("Huge");
		table.insert("Dogs");
		
		System.out.println(".......FIND ELEMENTS.......");
		System.out.println(table.find("Apple"));
		System.out.println(table.find("Zebra"));
		System.out.println(table.find("Feeling"));
		System.out.println(table.find("Water"));
		System.out.println(table.find("Africa"));
		System.out.println(table.find("Feeling"));

	}

}
