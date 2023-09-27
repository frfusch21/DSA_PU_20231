public class LinkedListQueue {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public LinkedListQueue() {
        this.front = this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Integer deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public int getSize() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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
    }
}
