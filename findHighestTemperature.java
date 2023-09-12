public class findHighestTemperature {
    public static double findHighestTemperature(double[] temperatures) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("The list of temperatures is empty.");
        }

        double highestTemp = temperatures[0]; // Initialize to the first temperature

        for (double temp : temperatures) {
            if (temp > highestTemp) {
                highestTemp = temp; // Update if a higher temperature is found
            }
        }

        return highestTemp;
    }

    public static void main(String[] args) {
        double[] temperatureData = {72.5, 75.3, 71.8, 79.1, 76.0, 81.2, 77.5};
        //First test Highest is 81.2
        // Second test case list is empty
        try {
            double highestTemperature = findHighestTemperature(temperatureData);
            System.out.println("The highest temperature recorded today is: "
                    + highestTemperature + " degrees Fahrenheit.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Handle the case when the list is empty
        }
    }
}
