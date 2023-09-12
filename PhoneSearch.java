public class PhoneSearch {
    public static int binarySearch(int[] list, int target){
        int left = 0;
        int right = list.length - 1;

        while(left <= right){
            int mid = left + (right - left) /2;

            if(list[mid] == target){
                return mid;
            }else if(list[mid] < target){
                left = mid + 1; //Move to the right half
            }else{
                right = mid - 1; //Move to the left half
            }
        }
        return -1; //Target not found
    }

    public static void main(String[] args){
        int[] sortedPhoneNumbers = {2,4,6,8,10,12,14,16};
        int targetPhoneNumber = 10;
        //First test case use 10 => Found
        //Second test case use 18 => Not found

        int result = binarySearch(sortedPhoneNumbers,targetPhoneNumber);

        if (result != -1){
            System.out.println("Phone Number " + targetPhoneNumber
            + " found at index " + result);
        }else{
            System.out.println("Phone number "+ targetPhoneNumber +
            " is not found");
        }
    }

}
