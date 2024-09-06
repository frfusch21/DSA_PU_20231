#include <iostream>
#include <stdexcept>
#include <vector>

using namespace std;

double findHighestTemperature(const vector<double>& temperatures) {
    if (temperatures.empty()) {
        throw invalid_argument("The list of temperatures is empty.");
    }

    double highestTemp = temperatures[0]; 

    for (double temp : temperatures) {
        if (temp > highestTemp) {
            highestTemp = temp; 
        }
    }

    return highestTemp;
}

int main() {
    vector<double> temperatureData = {72.5, 75.3, 71.8, 79.1, 76.0, 81.2, 77.5};
    // First test case: Highest is 81.2
    // Second test case: list is empty

    try {
        double highestTemperature = findHighestTemperature(temperatureData);
        cout << "The highest temperature recorded today is: " 
             << highestTemperature << " degrees Fahrenheit." << endl;
    } catch (const invalid_argument& e) {
        cout << e.what() << endl;
    }

    return 0;
}
