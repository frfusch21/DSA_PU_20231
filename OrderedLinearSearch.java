public class OrderedLinearSearch{

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 7;

        int result = orderedLinearSearch(arr, target);
        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    // OrderedLinearSearch function
    private static int orderedLinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            } else if (arr[i] > target) {
                return -1;
            }
        }
        return -1;
    }
}
