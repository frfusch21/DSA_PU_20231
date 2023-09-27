import java.util.Scanner;
class ListNode { //Declaration of Linked List
    int value; //We can change this to String for to-do list

    ListNode next; //Pointer Next
    ListNode prev; // Pointer Previous, For doubly linked list

    ListNode(int value) { //Waiting for user input to fill the list
            this.value = value;
            this.next = null;
            this.prev = null;
    }
}

class SinglyLinkedList {
    ListNode head;

    SinglyLinkedList() {
        this.head = null;
    } //Set head pointer to null

    void insertAtFront(int value) { //Inserting value at the front of the linked list
        ListNode newNode = new ListNode(value);
        newNode.next = head; //Updating Next pointer of new node to current head.
        head = newNode; //Updating head to be pointing at the new node.
    }

    void insertAtEnd(int value) { //Inserting value at the end of the linked list
        ListNode newNode = new ListNode(value);
        if (head == null) { //List is empty and add newNode as the head.
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) { //To check if the last node or tail (The tail pointer is null)
            current = current.next; // as long as the pointer is not null, then keep traversing
        }
        current.next = newNode; //This means last pointer is set to point to newNode
    }

    //Create function that can insert at random (Middle)

    void deleteNode(int value) {
        if (head == null) { //Check if list is empty, then return nothing or error
            return;
        }
        if (head.value == value) { //if you delete the first node then head will be the next node
            head = head.next;
            return;
        }
        ListNode current = head;
        while (current.next != null) { //To check if last node or tail
            if (current.next.value == value) { //If it is not tail then keep traversing
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    void display() {
        ListNode current = head;
        while (current != null) { //If this is not tail keep traversing and display the values
            System.out.print(current.value + " -> "); //Use 1-Directional arrow for singly
            current = current.next;
        }
        System.out.println("null"); //If list empty returns null
    }
}

class DoublyLinkedList {
    ListNode head;

    DoublyLinkedList() {
        this.head = null;
    } //If linked list is empty set head pointer to null

    void insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head; //Doubly linked list requires 2 pointers
        newNode.prev = null; //The head previous pointer is null
        if (head != null) { //Check if head pointer is not null (empty)
            head.prev = newNode; //Update head previous pointer to become newNode
        }
        head = newNode; //Head is the newNode
    }

    void insertAtEnd(int value) { //Insert values at the end
        ListNode newNode = new ListNode(value);
        if (head == null) {  //Check if head is empty (list is empty) then head becomes newNode
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) { //As long as next pointer is not null (not tail)
            current = current.next; //Keep traversing
        }
        current.next = newNode; //Set the next pointer of current to newNode
        newNode.prev = current; //Set the newNode previous pointer to current
    }

    //Create function to insert in the middle of the doubly linked list

    void deleteNode(int value) {
        if (head == null) {
            return;
        }
        if (head.value == value) {
            head = head.next;
            head.prev = null; //Change the previous pointer as well
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                }
                return;
            }
            current = current.next;
        }
    }

    void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " <-> "); //Use 2-Directional arrow for doubly linked list
            current = current.next;
        }
        System.out.println("null");
    }
}

class CircularLinkedList {
    ListNode head;

    CircularLinkedList() {
        this.head = null;
    }

    void insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            newNode.next = newNode; // Circular reference to itself
            head = newNode;
            return;
        }
        newNode.next = head;
        ListNode current = head;
        while (current.next != head) { //Because there is no Null pointer, it refers back to head
            current = current.next; //As long as it isn't head, keep traversing.
        }
        current.next = newNode;
        head = newNode; //Because it inserts to front, the newNode will automatically become head.
    }

    void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            newNode.next = newNode; // Circular reference to itself
            head = newNode;
            return;
        }
        newNode.next = head;
        ListNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
    }

    void deleteNode(int value) {
        if (head == null) {
            return;
        }

        if (head.value == value) {
            ListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            if (head == head.next) {
                head = null;
            } else {
                head = head.next;
                current.next = head;
            }
            return;
        }
        ListNode current = head;
        while (current.next != head) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }
        ListNode current = head;
        do {
            System.out.print(current.value + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println(head.value); // To indicate the end of the circular list
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList singlyList = null;
        DoublyLinkedList doublyList = null;
        CircularLinkedList circularList = null;

        System.out.println("Choose the type of linked list:");
        System.out.println("1. Singly Linked List");
        System.out.println("2. Doubly Linked List");
        System.out.println("3. Circular Linked List");
        System.out.print("Enter your choice (1/2/3): ");

        int choice = scanner.nextInt();

        switch (choice) { //Use switch case to use the proper linked list
            case 1:
                singlyList = new SinglyLinkedList();
                break;
            case 2:
                doublyList = new DoublyLinkedList();
                break;
            case 3:
                circularList = new CircularLinkedList();
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        while (true) {
            System.out.println("\nTo-Do List Operations:");
            System.out.println("1. Add a node");
            System.out.println("2. Delete a node");
            System.out.println("3. View lists");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter the node to add: ");
                    int taskToAdd = scanner.nextInt();
                    if (choice == 1) {
                        singlyList.insertAtEnd(taskToAdd);
                    } else if (choice == 2) {
                        doublyList.insertAtFront(taskToAdd);
                    } else if (choice == 3) {
                        circularList.insertAtFront(taskToAdd);
                    }
                    break;
                case 2:
                    System.out.print("Enter the node to delete: ");
                    int taskToDelete = scanner.nextInt();
                    if (choice == 1) {
                        singlyList.deleteNode(taskToDelete);
                    } else if (choice == 2) {
                        doublyList.deleteNode(taskToDelete);
                    } else if (choice == 3) {
                        circularList.deleteNode(taskToDelete);
                    }
                    break;
                case 3:
                    System.out.println("Current list:");
                    if (choice == 1) {
                        singlyList.display();
                    } else if (choice == 2) {
                        doublyList.display();
                    } else if (choice == 3) {
                        circularList.display();
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
