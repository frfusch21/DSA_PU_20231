#include <iostream>

using namespace std;

class Recursion {
public:
    static int RecursiveFactorial(int n) {
        // Base case
        if (n == 0) {
            return 1;
        } else {
            // Recursive case
            return n * RecursiveFactorial(n - 1);
        }
    }

    static int IterativeFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
};

int main() {
    int number = 15; 
    int result = Recursion::RecursiveFactorial(number);
    cout << "Factorial of " << number << " is " << result << endl;

    return 0;
}
