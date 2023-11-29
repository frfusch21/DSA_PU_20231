public class MergeSort_BinarySearch {
        public static void main(String[] args) {
            int[] arr = {12, 11, 13, 7, 6, 5};
            System.out.println("Original array:");
            printArray(arr);

            //Recursive function for MergeSort
            mergeSort(arr, 0, arr.length - 1);

            System.out.println("\nSorted array:");
            printArray(arr);

            int target = 13;
            int result = binarySearch(arr, target);
            if (result == -1) {
                System.out.println("Element not present in the array");
            } else {
                System.out.println("Element found at index: " + result);
            }
        }

        private static void printArray(int[] arr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        public static void mergeSort(int[] arr, int left, int right) {
            //Left: start of each subarray or array given
            //Right: Length of each subarray or array given
            //Checking if the position is already at the end, if not then proceed
            if (left < right) {
                //to divide between the array or subarray
                int middle = (left + right) / 2;

                //Recursive function to keep solving the problem
                mergeSort(arr, left, middle);
                mergeSort(arr, middle + 1, right);

                //Merge it again into one, do necessary sorting if needed.
                merge(arr, left, middle, right);
            }
        }

        private static void merge(int[] arr, int left, int middle, int right) {
            //Sizes of the subarrays that needs to be merged
            int n1 = middle - left + 1;
            int n2 = right - middle;

            //Combine this using new variable (Temporary)
            int[] leftHalf = new int[n1];
            int[] rightHalf = new int[n2];

            //Copy the temporary arrays
            System.arraycopy(arr, left, leftHalf, 0, n1);
            System.arraycopy(arr, middle + 1, rightHalf, 0, n2);

            //Initial indexes for first and second subarray
            int i = 0, j = 0;

            //Initial index of the merged subarray into array
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

            //Copy temp array if available
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

        public static int binarySearch(int[] arr, int target){
            //Beginning
            int low = 0;
            //End of the element
            int high = arr.length - 1;

            //Loop if low is less than equal to high
            while (low <= high){
                int mid = low + (high - low) / 2;
                //Check if target is in mid, lower or high (Target will usually be on mid)
                if(arr[mid] == target){
                    return mid; //Target
                } else if (arr[mid] < target) {
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return -1; //Target is not in the array
        }

}