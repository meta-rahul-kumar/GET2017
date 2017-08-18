package DefaultNamespace;

import java.util.Scanner;

public class getTempCelcius {
	
	public static void getTemp(float temperature) {
		TempServiceLocator tempServiceLocator = new TempServiceLocator();
		tempServiceLocator.setTempEndpointAddress("http://localhost:8080/Server/services/Temp");
		try {
			Temp temp = tempServiceLocator.getTemp();
			System.out.println(temp.convertFahrenheitToCelsius(temperature));
		}catch(Exception e) {
			
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Temprature in farenhite");
		float temp = 0;
		temp = sc.nextInt();
		getTemp(temp);
	}
}
