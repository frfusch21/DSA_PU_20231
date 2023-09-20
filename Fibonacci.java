public class Fibonacci {
    public static  int fibonacci(int n){
        //First base case
        if(n == 0){
            return 0;
        //Second base case
        }else if (n == 1){
            return 1;
        }else{
            //Recursive Case
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args){
        int n = 12; //Test 4 and 12
        int result = fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is " + result);
    }
}