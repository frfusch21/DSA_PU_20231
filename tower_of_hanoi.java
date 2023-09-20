public class tower_of_hanoi {
    // Recursive function to solve the Towers of Hanoi problem
    public static void towersOfHanoi(int n, String source, String auxiliary, String destination) {
        if (n == 1) {
            // Base case: Move the smallest disk from source to destination
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        } else {
            // Move n-1 disks from source to auxiliary using destination as auxiliary
            towersOfHanoi(n - 1, source, destination, auxiliary);

            // Move the nth disk from source to destination
            System.out.println("Move disk " + n + " from " + source + " to " + destination);

            // Move n-1 disks from auxiliary to destination using source as auxiliary
            towersOfHanoi(n - 1, auxiliary, source, destination);
        }
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        towersOfHanoi(numberOfDisks, "S", "A", "D");
    }
}
