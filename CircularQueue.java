public class CircularQueue {
    private int[] queue; //Declare Array
    private int front; //Declare the Front Queue
    private int rear; //Declare the rear Queue
    private int size; //Declare the size
    private final int capacity; //Declare capacity (To check for maximum, limit the queue)

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = -1; //Declare empty circular queue (-1)
        this.size = 0; //Declare Size of the Queue is 0
    }

    public boolean isEmpty() {
        return size == 0; //Check if it's empty by the size.
    }

    public boolean isFull() {
        return size == capacity; //Check if it's full (Capacity maximum then it's full)
    }

    public int getSize() {
        return size; //To get the size of the circular queue
    }

    public void enQueue(int item) {
        //Check if queue is full (At max Capacity)
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        //Check if queue is empty, if it is set front to 0
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity; //If it's not empty then rear be (rear +1) % capacity
        queue[rear] = item; //Insert the value to the queue based on rear index
        size++; //Increment size of the queue
    }

    public int deQueue() {
        //Check for empty queue
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int item = queue[front];//Check front of the queue assign it in variable item
        if (front == rear) { //Check if front == rear (For empty queue)
            front = rear = -1; //Create condition for empty queue
        } else {
            front = (front + 1) % capacity; //front will be (front + 1) % capacity
        }
        size--; //Decrement size after dequeueing
        return item;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int index = front;
        while (index != rear) { //Loop that also check if front does not equal to rear (empty)
            System.out.print(queue[index] + " ");
            index = (index + 1) % capacity; //Get the index to (index + 1) % capacity
        }
        System.out.println(queue[rear]); //Print the rear queue data
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5); //Object declare capacity as 5
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println("Queue Size : " + queue.getSize());
        queue.display();
        queue.deQueue(); //Dequeued 1 value
        queue.display();
        queue.enQueue(6); //EnQueue value of 6
        queue.display();
        queue.enQueue(7); //EnQueue value of 7
    }
}
