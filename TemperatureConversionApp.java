import java.util.Scanner;

// TemperatureConverter class encapsulates the conversion logic
class TemperatureConverter {
    private double temperature;

    public TemperatureConverter(double temperature) {
        this.temperature = temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double convertToFahrenheit() {
        return (temperature * 9 / 5) + 32;
    }

    public double convertToCelsius() {
        return (temperature - 32) * 5 / 9;
    }
}

public class TemperatureConversionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperatureValue = scanner.nextDouble();

        TemperatureConverter converter = new TemperatureConverter(temperatureValue);

        System.out.println("Choose conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println(converter.convertToFahrenheit() + " °F");
                break;
            case 2:
                System.out.println(converter.convertToCelsius() + " °C");
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
