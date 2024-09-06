#include <iostream>
#include <vector>

using namespace std;

int PhoneSearch(vector<int>& list, int target) {
    int left = 0;                      
    int right = list.size() - 1;        

    while (left <= right) {
        int mid = left + (right - left) / 2;  
        if (list[mid] == target) {
            return mid; 
        }
        else if (list[mid] < target) {
            left = mid + 1; 
        }
        else {
            right = mid - 1; 
        }
    }

    return -1; 
}

int main() {
    vector<int> list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
    int target;

    cout << "Enter the target number to search: ";
    cin >> target;

    int result = PhoneSearch(list, target);

    if (result != -1) {
        cout << "Target found at index: " << result << endl;
    } else {
        cout << "Target not found in the list." << endl;
    }

    return 0;
}
