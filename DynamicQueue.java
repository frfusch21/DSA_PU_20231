import java.util.ArrayList;

public class DynamicQueue {
    private ArrayList<Integer> queue; // Dynamic array to hold the elements
    private int front; // Pointer to the front of the queue
    private int rear; // Pointer to the rear of the queue

    public DynamicQueue() {
        this.queue = new ArrayList<>();
        this.front = this.rear = -1; // Initializing pointers to -1, indicating the queue is empty
    }

    public boolean isEmpty() {
        return front == -1; // The queue is empty if front is -1
    }

    public int getSize() {
        if (isEmpty()) return 0; // If the queue is empty, its size is 0
        return rear - front + 1; // Calculate the size by taking the difference between rear and front pointers and adding 1
    }

    public void enQueue(int item) {
        if (isEmpty()) {
            front = rear = 0; // If the queue is empty, initialize front and rear pointers to 0
        } else {
            rear++; // If the queue is not empty, increment rear pointer to accommodate the new element
        }
        queue.add(item); // Append the item to the dynamic array
    }

    public Integer deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return a value indicating an error
        }
        int item = queue.get(front); // Fetch the item from the front of the queue
        if (front == rear) {
            front = rear = -1; // If there is only one item in the queue, reset the front and rear pointers after dequeue
        } else {
            front++; // If there is more than one item, increment the front pointer after dequeue
        }
        return item;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = front; i <= rear; i++) { // Print all the items in the queue, from front to rear
            System.out.print(queue.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();
        // Test the queue functionality
        System.out.println("Is Queue Empty? : " + queue.isEmpty());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        System.out.println("Queue Size : " + queue.getSize());
        queue.display();
        System.out.println("Dequeue element : " + queue.deQueue());
        queue.display();
        queue.deQueue();
        queue.display();
        queue.deQueue(); // trying to dequeue from an empty queue to show error message
        queue.deQueue();
    }
}
