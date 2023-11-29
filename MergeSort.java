public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftHalf = new int[n1];
        int[] rightHalf = new int[n2];

        System.arraycopy(arr, left, leftHalf, 0, n1);
        System.arraycopy(arr, middle + 1, rightHalf, 0, n2);

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
