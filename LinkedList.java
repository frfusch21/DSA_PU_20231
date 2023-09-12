import java.util.Scanner;
class ListNode {
    int value;

    ListNode next;
    ListNode prev; // For doubly linked list

    ListNode(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
    }
}

class SinglyLinkedList {
    ListNode head;

    SinglyLinkedList() {
        this.head = null;
    }

    void insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    void deleteNode(int value) {
        if (head == null) {
            return;
        }
        if (head.value == value) {
            head = head.next;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class DoublyLinkedList {
    ListNode head;

    DoublyLinkedList() {
        this.head = null;
    }

    void insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    void deleteNode(int value) {
        if (head == null) {
            return;
        }
        if (head.value == value) {
            head = head.next;
            head.prev = null;
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
            System.out.print(current.value + " <-> ");
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
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        head = newNode;
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

        switch (choice) {
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
                        singlyList.insertAtFront(taskToAdd);
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
