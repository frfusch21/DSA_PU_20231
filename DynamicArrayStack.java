import java.util.ArrayList;

public class DynamicArrayStack {
    private int top;
    private ArrayList<Integer> array;

    public DynamicArrayStack() {
        this.top = -1;
        this.array = new ArrayList<>();
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return isEmpty() ? 0 : array.size();
    }

    public void push(int item) {
        array.add(item);
        top++;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        int item = array.get(top);
        array.remove(top);
        top--;
        return item;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
        return array.get(top);
    }

    public static void main(String[] args) {
        DynamicArrayStack stack = new DynamicArrayStack();

        System.out.println("Is Stack Empty? : " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        System.out.println("Stack Size : " + stack.getSize());
        System.out.println("Top element : " + stack.peek());
        System.out.println("Pop element : " + stack.pop());
        System.out.println("Is Stack Empty? : " + stack.isEmpty());
        System.out.println("Stack Size : " + stack.getSize());
        stack.pop();
    }
}
