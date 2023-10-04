import java.util.ArrayList;

public class DynamicArrayStack {
    private int top; //Declare top of the stack
    private ArrayList<Integer> array; //Declare Dynamic array

    public DynamicArrayStack() {
        this.top = -1; //This meaning stack is empty
        this.array = new ArrayList<>(); //The content of the stack (Array)
    }

    public boolean isEmpty() {
        return top == -1;
    } //Check if empty (-1 is empty)

    public int getSize() {
        return isEmpty() ? 0 : array.size();
    } //Check how many data inside the stack

    public void push(int item) { //Push to stack (Do not need to check isFull)
        array.add(item);
        top++; //Keep incrementing
    }

    public Integer pop() {
        //Check if it's empty or not
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        int item = array.get(top); //To get the data on the most top
        array.remove(top); //Remove the data
        top--; //Decrement for the current top
        return item;
    }

    public Integer peek() {
        //Cannot peek if stack is empty
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
        return array.get(top); //Return the most top of data
    }

    public static void main(String[] args) {
        DynamicArrayStack stack = new DynamicArrayStack(); //Object Dynamic Array
        System.out.println("Is Stack Empty? : " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        stack.pop();
        System.out.println("Stack Size : " + stack.getSize());
        System.out.println("Top element : " + stack.peek());
//        System.out.println("Pop element : " + stack.pop());
        System.out.println("Is Stack Empty? : " + stack.isEmpty());
        System.out.println("Stack Size : " + stack.getSize());
        stack.pop();
    }
}
