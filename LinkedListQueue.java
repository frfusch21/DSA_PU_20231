public class LinkedListQueue {
    private static class Node {
        int data;
        Node next; //Next Node for each data

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front; //Declare pointer front
    private Node rear; //Declare pointer Rear

    public LinkedListQueue() {
        this.front = this.rear = null; //Declare empty queue
    }

    public boolean isEmpty() {
        return front == null; //Check if queue is empty
    }

    //Insert from the end
    public void enQueue(int item) {
        Node newNode = new Node(item);  //Declare the newNode
        if (isEmpty()) { //If it's empty queue then newNode become front and rear
            front = rear = newNode;
        } else {
            rear.next = newNode; //insert at the end (rear)
            rear = newNode;
        }
    }

    //Delete from the beginning
    public Integer deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        int data = front.data; //Get the data from the front of the queue
        front = front.next; //Change pointer of the front to the next node
        if (front == null) { //Check if front is null then rear also null return empty queue
            rear = null;
        }
        return data;
    }

    public int getSize() {
        int count = 0; //using count to check how much node available
        Node current = front; //Assign front of the node to current
        while (current != null) { //Loop if current is not null (Not empty)
            count++; //Increment Count until the end of the list
            current = current.next; //Traverse to the next node until the end
        }
        return count; //Return how many are the nodes on the list
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        // Test the queue functionality
        System.out.println("Is Queue Empty? : " + queue.isEmpty());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println("Queue Size : " + queue.getSize());
        System.out.println("Dequeue element : " + queue.deQueue());
        System.out.println("Is Queue Empty? : " + queue.isEmpty());
        System.out.println("Queue Size : " + queue.getSize());
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
    }
}
