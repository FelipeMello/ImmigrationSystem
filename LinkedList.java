package immigrationSystem;

// This class has the structure and methods to create a linked list with the values from the
// class Person. 
@SuppressWarnings("hiding")
public class LinkedList<E> {
	private Node first;
	private Node last;
	private int nodeCount;

	// Initialisation of the LinkedList class.
	public LinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}
	public void add(immigrationSystem.E person) {
		
		//if first is equal null that means the list is empty
		if (first == null) {
			//update the first and last to the new Node;
			first = new Node(person);
			last = first;
		}
		// If the list is not empty
		else {
			//Create a new node
			Node newNode = new Node(person);
			//get the last node and point to the new node
			last.setNextNode(newNode);
			//update the last to be the new node
			last = newNode;
		}
		//update the number of nodes +1
		nodeCount++;
	}

	// This method will add an item at a give position to a given index in the linkedList
	public void add(int position, immigrationSystem.E person) {
		
		//if nodeCount +1 is less than the index given
		if (size() < position) {
			throw new IllegalStateException("The list is smaller than the position required");
		}
		
		
		Node currentNode = first;
		
		//if i  is less than the index position and current node is not equal to null  
		for (int i = 1; i < position  && currentNode != null; i++) {
			currentNode = currentNode.getNextNode(); //update the current node to the nextNode link
		}
		
		Node newNode = new Node(person);//create a new node for the item 
		
		//get the next node of the current node
		Node nextNode = currentNode.getNextNode();
		//set the new next node to the nextNode
		newNode.setNextNode(nextNode);
		//set the current next node to the new node
		currentNode.setNextNode(newNode);
		//Increment the nodeCount by 1 
		nodeCount++;
	}

	// This method adds to the First.
	public void addFirst(immigrationSystem.E person) {
		if (first == null) {
			first = new Node(person);
			last = first;
		} else {
			Node oldFirst = first; //get the current  first node
			Node newNode = new Node(person); // create a new node for the new item
			
			first = newNode; //update the first node to the newNode
			newNode.nextNode = oldFirst;//update the next node of the new node to be the oldFirst node
			nodeCount ++; //update the count by 1.
			
		}
		nodeCount++;
	}

	//This methods add an item into the midle of the list
	public E addToTheMiddleOfList(immigrationSystem.E person) {
		if (first == null) {
			first = new Node(person);
			last = first;
		}
		
		Node currentNode = first;
		
		//Loop trough the list till the current position is
		//less or equal to the size of the linked list divided by 2 
		for (int i = 1; i <= size() / 2 && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}//find the middle
		
		
		Node newNode = new Node(person); //create new node for the item
		Node nextNode = currentNode.getNextNode();// set next node to the next link of current node
		
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
		return null;
	}

	// This method checks the position of a person by comparing first name and
	// last name.
	public int checkPositionByName(String fn, String ln) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (((immigrationSystem.E) currentNode.getNodeItem()).getFirstName().equals(fn)
					&& ((immigrationSystem.E) currentNode.getNodeItem()).getLastName().equals(ln)) {
				return i + 1;
			}
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}

	// This method checks the position of a person by comparing The unique ID
	// number.
	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	public int checkPositionById(int id) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (((immigrationSystem.E) currentNode.getNodeItem()).getId() == id) {
				return i + 1;
			}
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}

	// This method updates the information of a person without change there
	// position in the list.
	public E updatePersonById(int id, String fn, String ln, String doa, String pn) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (((immigrationSystem.E) currentNode.getNodeItem()).getId() == id) {
				((immigrationSystem.E) currentNode.getNodeItem()).setFirstName(fn);
				((immigrationSystem.E) currentNode.getNodeItem()).setLastName(ln);
				((immigrationSystem.E) currentNode.getNodeItem()).setDateOfArrival(doa);
				((immigrationSystem.E) currentNode.getNodeItem()).setPassportNumber(pn);
			}

			currentNode = currentNode.getNextNode();
		}
		return null;
	}

	public void removeFirstPosition() {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		first = first.getNextNode();
		currentNode.nextNode = null;
		nodeCount--;
	}

	// This method removes all the information of a person by the unique ID
	// number.
	public E removePersonById(int id) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		Node prevNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
			if (((immigrationSystem.E) currentNode.getNodeItem()).getId() == id) {
				prevNode.setNextNode(currentNode.getNextNode());
				nodeCount--;
			}
		}
		return null;
	}

	// This method removes all the information of a number of people from the
	// end of the list.
	public E removeNfromTheEndOfTheList(int n) {
		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}
		Node currentNode = first;
		for (int i = 0; i < size(); i++) {
			currentNode = currentNode.getNextNode();
		}
		nodeCount = nodeCount - n;
		return null;
	}

	// This method gets the information from the nodeItem in the class Node to
	// print the full list
	// to the screen.
	public void printList() {

		if (size() > 0) {
			System.out.printf("%45s", "Full List");
			System.out.println();
			System.out.printf("%-4s %-14s %-29s %-20s %-20s", "ID", "First Name", "Last name", "Date of Arrival",
					"Passport Number");
			System.out.println("\n");
			Node currentNode = first;
			for (int i = 0; i < size() && currentNode != null; i++) {
				System.out.println(currentNode.nodeItem);
				currentNode = currentNode.getNextNode();
			}
		}

		if (first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}

	}

	// This method is called every time another method needs to get the full
	// size of the list.
	public int size() {
		return nodeCount;
	}

	// This class gets the objects from the class Person to be passed to the
	// LinkedList class.
	// It contains, get and sets to get from the first object to the last object
	// in the class Person.
	private class Node {
		private Node nextNode;
		private immigrationSystem.E nodeItem;

		public Node(immigrationSystem.E person) {
			this.nextNode = null;
			this.nodeItem = person;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getNextNode() {
			return nextNode;
		}

		@SuppressWarnings("unchecked")
		public E getNodeItem() {
			return (E) nodeItem;
		}
	}
}