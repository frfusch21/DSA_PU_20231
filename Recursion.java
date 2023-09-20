public class Recursion{
    public static int RecursiveFactorial(int n){
        //Base Case
        if(n == 0){
            return 1;
        //Recursive case
        } else{
            //Return Result of this recursive code and the next one
            return n * RecursiveFactorial(n-1);
        }
    }

    public static int IterativeFactorial(int n){
        int result = 1;
        for(int i = 2; i <= n; i++){
            result *= i; //result = result * i
        }
        return result;
    }

    public static void main(String[] args){
        int number = 15; //Factorial of 5 or 10
        int result = RecursiveFactorial(number);
//        int result = IterativeFactorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}