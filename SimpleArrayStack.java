public class SimpleArrayStack {
    private static final int MAXSIZE = 4; //Array needs declaration of MaxSize
    private int top; //Declare the top stack
    private int[] array;

    //Contructor to build the stack
    public SimpleArrayStack() {
        this.top = -1; //This means the stack is empty
        this.array = new int[MAXSIZE]; //Declare thr array that will be pushed
    }

    public boolean isEmpty() {
        return top == -1;
    } //If this stack is empty

    public boolean isFull() {
        return top == MAXSIZE - 1;
    } //If the stack is full

    //Declare if data is pushed (Check condition if it's full or not)
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push.");
            return;
        }
        array[++top] = item; //Stack is not full, insert data.
    }

    //Operation to take out data
    public int pop() {
        //Check if stack is empty
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        return array[top--]; //Return current top data
    }

    //Taking a look at the top most data in the stack
    public int peek() {
        //You cannot peek if the stack is empty
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return array[top]; //Return current top data
    }

    public static void main(String[] args) {
        SimpleArrayStack stack = new SimpleArrayStack();
        System.out.println("Is Stack Full? : " + stack.isFull());
        System.out.println("Is Stack Empty? : " + stack.isEmpty());
        //Try: Using pop when empty, using push when full
        //Try: Push and pop in turns
        stack.pop();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.pop();
        stack.push(50);
        System.out.println("Top element : " + stack.peek());
        System.out.println("Pop element : " + stack.pop());
        stack.pop();
    }
}
