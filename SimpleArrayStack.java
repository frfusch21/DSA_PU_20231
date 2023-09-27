public class SimpleArrayStack {
    private static final int MAXSIZE = 4;
    private int top;
    private int[] array;

    public SimpleArrayStack() {
        this.top = -1;
        this.array = new int[MAXSIZE];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAXSIZE - 1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push.");
            return;
        }
        array[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return array[top];
    }

    public static void main(String[] args) {
        SimpleArrayStack stack = new SimpleArrayStack();

        System.out.println("Is Stack Empty? : " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Top element : " + stack.peek());
        System.out.println("Pop element : " + stack.pop());
        System.out.println("Is Stack Empty? : " + stack.isEmpty());
        stack.pop();
    }
}
